/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.utils;

import backported.updates.foundation.nightconfig.core.utils.TransformingIterator;
import backported.updates.foundation.nightconfig.core.utils.TransformingSpliterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TransformingCollection<InternalV, ExternalV>
implements Collection<ExternalV> {
    private final Function<? super InternalV, ? extends ExternalV> readTransformation;
    private final Function<? super ExternalV, ? extends InternalV> writeTransformation;
    private final Function<Object, Object> searchTransformation;
    private final Collection<InternalV> internalCollection;

    public TransformingCollection(Collection<InternalV> internalCollection, Function<? super InternalV, ? extends ExternalV> readTransformation, Function<? super ExternalV, ? extends InternalV> writeTransformation, Function<Object, Object> searchTransformation) {
        this.internalCollection = internalCollection;
        this.readTransformation = readTransformation;
        this.writeTransformation = writeTransformation;
        this.searchTransformation = searchTransformation;
    }

    @Override
    public int size() {
        return this.internalCollection.size();
    }

    @Override
    public boolean isEmpty() {
        return this.internalCollection.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.internalCollection.contains(this.searchTransformation.apply(o));
    }

    @Override
    public Iterator<ExternalV> iterator() {
        return new TransformingIterator<InternalV, ExternalV>(this.internalCollection.iterator(), this.readTransformation);
    }

    @Override
    public Object[] toArray() {
        Object[] array = this.internalCollection.toArray();
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.readTransformation.apply(array[i]);
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] array = this.internalCollection.toArray(a);
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.readTransformation.apply(array[i]);
        }
        return array;
    }

    @Override
    public boolean add(ExternalV value) {
        return this.internalCollection.add(this.writeTransformation.apply(value));
    }

    @Override
    public boolean remove(Object o) {
        return this.internalCollection.remove(this.searchTransformation.apply(o));
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.internalCollection.containsAll(new TransformingCollection<Object, Object>(c, this.searchTransformation, o -> o, this.searchTransformation));
    }

    @Override
    public boolean addAll(Collection<? extends ExternalV> c) {
        return this.internalCollection.addAll(new TransformingCollection<ExternalV, InternalV>(c, this.writeTransformation, this.readTransformation, this.searchTransformation));
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.internalCollection.removeAll(new TransformingCollection<Object, Object>(c, this.searchTransformation, o -> o, this.searchTransformation));
    }

    @Override
    public boolean removeIf(Predicate<? super ExternalV> filter) {
        return this.internalCollection.removeIf(internalV -> filter.test(this.readTransformation.apply(internalV)));
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.internalCollection.retainAll(new TransformingCollection<Object, Object>(c, this.searchTransformation, o -> o, this.searchTransformation));
    }

    @Override
    public void clear() {
        this.internalCollection.clear();
    }

    @Override
    public Spliterator<ExternalV> spliterator() {
        return new TransformingSpliterator<InternalV, ExternalV>(this.internalCollection.spliterator(), this.readTransformation, this.writeTransformation);
    }

    @Override
    public Stream<ExternalV> stream() {
        return this.internalCollection.stream().map(this.readTransformation);
    }

    @Override
    public Stream<ExternalV> parallelStream() {
        return this.internalCollection.parallelStream().map(this.readTransformation);
    }

    @Override
    public void forEach(Consumer<? super ExternalV> action) {
        this.internalCollection.forEach(internalV -> action.accept(this.readTransformation.apply(internalV)));
    }
}

