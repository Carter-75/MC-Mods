/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.utils;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;

public final class TransformingIterator<InternalV, ExternalV>
implements Iterator<ExternalV> {
    private final Function<? super InternalV, ? extends ExternalV> readTransformation;
    private final Iterator<InternalV> internalIterator;

    public TransformingIterator(Iterator<InternalV> internalIterator, Function<? super InternalV, ? extends ExternalV> readTransformation) {
        this.readTransformation = readTransformation;
        this.internalIterator = internalIterator;
    }

    @Override
    public boolean hasNext() {
        return this.internalIterator.hasNext();
    }

    @Override
    public ExternalV next() {
        return this.readTransformation.apply(this.internalIterator.next());
    }

    @Override
    public void remove() {
        this.internalIterator.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super ExternalV> action) {
        this.internalIterator.forEachRemaining(internalV -> action.accept(this.readTransformation.apply(internalV)));
    }
}

