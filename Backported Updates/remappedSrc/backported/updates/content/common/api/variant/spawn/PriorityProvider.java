/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.DataFixUtils
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_156
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.api.variant.spawn;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.class_156;
import net.minecraft.class_5819;

public interface PriorityProvider<Context, Condition extends SelectorCondition<Context>> {
    public List<Selector<Context, Condition>> selectors();

    public static <C, T> Stream<T> select(Stream<T> stream, Function<T, PriorityProvider<C, ?>> function, C context) {
        ArrayList list = new ArrayList();
        stream.forEach(object -> {
            PriorityProvider provider = (PriorityProvider)function.apply(object);
            for (Selector selector : provider.selectors()) {
                list.add(new UnpackedEntry(object, selector.priority(), (SelectorCondition)DataFixUtils.orElseGet(selector.condition(), SelectorCondition::alwaysTrue)));
            }
        });
        list.sort(UnpackedEntry.HIGHEST_PRIORITY_FIRST);
        Iterator iterator = list.iterator();
        int priority = Integer.MIN_VALUE;
        while (iterator.hasNext()) {
            UnpackedEntry entry = (UnpackedEntry)iterator.next();
            if (entry.priority < priority) {
                iterator.remove();
                continue;
            }
            if (entry.condition.test(context)) {
                priority = entry.priority;
                continue;
            }
            iterator.remove();
        }
        return list.stream().map(UnpackedEntry::entry);
    }

    public static <C, T> Optional<T> pick(Stream<T> stream, Function<T, PriorityProvider<C, ?>> function, class_5819 random, C context) {
        List<T> list = PriorityProvider.select(stream, function, context).toList();
        return class_156.method_40083(list, (class_5819)random);
    }

    public static <Context, Condition extends SelectorCondition<Context>> List<Selector<Context, Condition>> single(Condition condition, int priority) {
        return List.of(new Selector(condition, priority));
    }

    public static <Context, Condition extends SelectorCondition<Context>> List<Selector<Context, Condition>> alwaysTrue(int priority) {
        return List.of(new Selector(priority));
    }

    public record UnpackedEntry<C, T>(T entry, int priority, SelectorCondition<C> condition) {
        public static final Comparator<UnpackedEntry<?, ?>> HIGHEST_PRIORITY_FIRST = Comparator.comparingInt(UnpackedEntry::priority).reversed();
    }

    public static interface SelectorCondition<C>
    extends Predicate<C> {
        public static <C> SelectorCondition<C> alwaysTrue() {
            return context -> true;
        }
    }

    public record Selector<Context, Condition extends SelectorCondition<Context>>(Optional<Condition> condition, int priority) {
        public Selector(Condition condition, int priority) {
            this(Optional.of(condition), priority);
        }

        public Selector(int priority) {
            this(Optional.empty(), priority);
        }

        public static <Context, Condition extends SelectorCondition<Context>> Codec<Selector<Context, Condition>> codec(Codec<Condition> codec) {
            return RecordCodecBuilder.create(instance -> instance.group((App)codec.optionalFieldOf("condition").forGetter(Selector::condition), (App)Codec.INT.fieldOf("priority").forGetter(Selector::priority)).apply((Applicative)instance, Selector::new));
        }
    }
}

