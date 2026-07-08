/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.databind.util.internal;

import com.fasterxml.jackson.databind.util.internal.Linked;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class LinkedDeque<E extends Linked<E>>
extends AbstractCollection<E>
implements Deque<E> {
    E first;
    E last;

    LinkedDeque() {
    }

    void linkFirst(E e2) {
        E f2 = this.first;
        this.first = e2;
        if (f2 == null) {
            this.last = e2;
        } else {
            f2.setPrevious(e2);
            e2.setNext(f2);
        }
    }

    void linkLast(E e2) {
        E l2 = this.last;
        this.last = e2;
        if (l2 == null) {
            this.first = e2;
        } else {
            l2.setNext(e2);
            e2.setPrevious(l2);
        }
    }

    E unlinkFirst() {
        E f2 = this.first;
        Object next = f2.getNext();
        f2.setNext(null);
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.setPrevious(null);
        }
        return f2;
    }

    E unlinkLast() {
        E l2 = this.last;
        Object prev2 = l2.getPrevious();
        l2.setPrevious(null);
        this.last = prev2;
        if (prev2 == null) {
            this.first = null;
        } else {
            prev2.setNext(null);
        }
        return l2;
    }

    void unlink(E e2) {
        Object prev2 = e2.getPrevious();
        Object next = e2.getNext();
        if (prev2 == null) {
            this.first = next;
        } else {
            prev2.setNext(next);
            e2.setPrevious(null);
        }
        if (next == null) {
            this.last = prev2;
        } else {
            next.setPrevious(prev2);
            e2.setNext(null);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    void checkNotEmpty() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (Object e2 = this.first; e2 != null; e2 = e2.getNext()) {
            ++size;
        }
        return size;
    }

    @Override
    public void clear() {
        Object e2 = this.first;
        while (e2 != null) {
            Object next = e2.getNext();
            e2.setPrevious(null);
            e2.setNext(null);
            e2 = next;
        }
        this.last = null;
        this.first = null;
    }

    @Override
    public boolean contains(Object o) {
        return o instanceof Linked && this.contains((Linked)o);
    }

    boolean contains(Linked<?> e2) {
        return e2.getPrevious() != null || e2.getNext() != null || e2 == this.first;
    }

    public void moveToFront(E e2) {
        if (e2 != this.first) {
            this.unlink(e2);
            this.linkFirst(e2);
        }
    }

    public void moveToBack(E e2) {
        if (e2 != this.last) {
            this.unlink(e2);
            this.linkLast(e2);
        }
    }

    @Override
    public E peek() {
        return (E)this.peekFirst();
    }

    @Override
    public E peekFirst() {
        return this.first;
    }

    @Override
    public E peekLast() {
        return this.last;
    }

    @Override
    public E getFirst() {
        this.checkNotEmpty();
        return (E)this.peekFirst();
    }

    @Override
    public E getLast() {
        this.checkNotEmpty();
        return (E)this.peekLast();
    }

    @Override
    public E element() {
        return (E)this.getFirst();
    }

    @Override
    public boolean offer(E e2) {
        return this.offerLast(e2);
    }

    @Override
    public boolean offerFirst(E e2) {
        if (this.contains((Linked<?>)e2)) {
            return false;
        }
        this.linkFirst(e2);
        return true;
    }

    @Override
    public boolean offerLast(E e2) {
        if (this.contains((Linked<?>)e2)) {
            return false;
        }
        this.linkLast(e2);
        return true;
    }

    @Override
    public boolean add(E e2) {
        return this.offerLast(e2);
    }

    @Override
    public void addFirst(E e2) {
        if (!this.offerFirst(e2)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void addLast(E e2) {
        if (!this.offerLast(e2)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public E poll() {
        return (E)this.pollFirst();
    }

    @Override
    public E pollFirst() {
        return this.isEmpty() ? null : (E)this.unlinkFirst();
    }

    @Override
    public E pollLast() {
        return this.isEmpty() ? null : (E)this.unlinkLast();
    }

    @Override
    public E remove() {
        return (E)this.removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        return o instanceof Linked && this.remove((E)((Linked)o));
    }

    @Override
    boolean remove(E e2) {
        if (this.contains((Linked<?>)e2)) {
            this.unlink(e2);
            return true;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        this.checkNotEmpty();
        return (E)this.pollFirst();
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return this.remove(o);
    }

    @Override
    public E removeLast() {
        this.checkNotEmpty();
        return (E)this.pollLast();
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return this.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c2) {
        boolean modified = false;
        for (Object o : c2) {
            modified |= this.remove(o);
        }
        return modified;
    }

    @Override
    public void push(E e2) {
        this.addFirst(e2);
    }

    @Override
    public E pop() {
        return (E)this.removeFirst();
    }

    @Override
    public Iterator<E> iterator() {
        return new AbstractLinkedIterator((Linked)this.first){

            @Override
            E computeNext() {
                return this.cursor.getNext();
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new AbstractLinkedIterator((Linked)this.last){

            @Override
            E computeNext() {
                return this.cursor.getPrevious();
            }
        };
    }

    static abstract class AbstractLinkedIterator
    implements Iterator<E> {
        E cursor;
        final /* synthetic */ LinkedDeque this$0;

        AbstractLinkedIterator(E start) {
            this.this$0 = this$0;
            this.cursor = start;
        }

        @Override
        public boolean hasNext() {
            return this.cursor != null;
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Object e2 = this.cursor;
            this.cursor = this.computeNext();
            return e2;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        abstract E computeNext();
    }
}

