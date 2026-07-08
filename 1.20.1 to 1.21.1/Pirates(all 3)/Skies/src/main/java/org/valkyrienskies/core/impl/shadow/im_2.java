/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.im
 */
public final class im_2
implements Iterator<Node> {
    private final NodeList a;
    private int b = 0;

    public im_2(Node node) {
        if (node == null) {
            throw new NullPointerException("Node must not be null.");
        }
        this.a = node.getChildNodes();
    }

    public im_2(NodeList nodeList) {
        if (nodeList == null) {
            throw new NullPointerException("NodeList must not be null.");
        }
        this.a = nodeList;
    }

    @Override
    public final boolean hasNext() {
        return this.a != null && this.b < this.a.getLength();
    }

    private Node a() {
        if (this.a != null && this.b < this.a.getLength()) {
            return this.a.item(this.b++);
        }
        throw new NoSuchElementException("underlying nodeList has no more elements");
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("remove() method not supported for a NodeListIterator.");
    }

    @Override
    public final /* synthetic */ Object next() {
        im_2 im_22 = this;
        if (im_22.a != null && im_22.b < im_22.a.getLength()) {
            return im_22.a.item(im_22.b++);
        }
        throw new NoSuchElementException("underlying nodeList has no more elements");
    }
}

