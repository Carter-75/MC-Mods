/*
 * Decompiled with CFR 0.152.
 */
package org.joml;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PolygonsIntersection {
    private static final ByStartComparator byStartComparator = new ByStartComparator();
    private static final ByEndComparator byEndComparator = new ByEndComparator();
    protected final float[] verticesXY;
    private float minX;
    private float minY;
    private float maxX;
    private float maxY;
    private float centerX;
    private float centerY;
    private float radiusSquared;
    private IntervalTreeNode tree;

    public PolygonsIntersection(float[] verticesXY, int[] polygons, int count2) {
        this.verticesXY = verticesXY;
        this.preprocess(count2, polygons);
    }

    private IntervalTreeNode buildNode(List intervals, float center) {
        ArrayList<Interval> left = null;
        ArrayList<Interval> right = null;
        ArrayList<Interval> byStart = null;
        ArrayList<Interval> byEnd = null;
        float leftMin = 1.0E38f;
        float leftMax = -1.0E38f;
        float rightMin = 1.0E38f;
        float rightMax = -1.0E38f;
        float thisMin = 1.0E38f;
        float thisMax = -1.0E38f;
        for (int i2 = 0; i2 < intervals.size(); ++i2) {
            Interval ival = (Interval)intervals.get(i2);
            if (ival.start < center && ival.end < center) {
                if (left == null) {
                    left = new ArrayList<Interval>();
                }
                left.add(ival);
                leftMin = leftMin < ival.start ? leftMin : ival.start;
                leftMax = leftMax > ival.end ? leftMax : ival.end;
                continue;
            }
            if (ival.start > center && ival.end > center) {
                if (right == null) {
                    right = new ArrayList<Interval>();
                }
                right.add(ival);
                rightMin = rightMin < ival.start ? rightMin : ival.start;
                rightMax = rightMax > ival.end ? rightMax : ival.end;
                continue;
            }
            if (byStart == null || byEnd == null) {
                byStart = new ArrayList<Interval>();
                byEnd = new ArrayList<Interval>();
            }
            thisMin = ival.start < thisMin ? ival.start : thisMin;
            thisMax = ival.end > thisMax ? ival.end : thisMax;
            byStart.add(ival);
            byEnd.add(ival);
        }
        if (byStart != null) {
            Collections.sort(byStart, byStartComparator);
            Collections.sort(byEnd, byEndComparator);
        }
        IntervalTreeNode tree = new IntervalTreeNode();
        tree.byBeginning = byStart;
        tree.byEnding = byEnd;
        tree.center = center;
        if (left != null) {
            tree.left = this.buildNode(left, (leftMin + leftMax) / 2.0f);
            tree.left.childrenMinMax = leftMax;
        }
        if (right != null) {
            tree.right = this.buildNode(right, (rightMin + rightMax) / 2.0f);
            tree.right.childrenMinMax = rightMin;
        }
        return tree;
    }

    private void preprocess(int count2, int[] polygons) {
        Interval ival;
        float yj;
        float xi;
        float yi;
        int j2 = 0;
        this.minY = 1.0E38f;
        this.minX = 1.0E38f;
        this.maxY = -1.0E38f;
        this.maxX = -1.0E38f;
        ArrayList<Interval> intervals = new ArrayList<Interval>(count2);
        int first2 = 0;
        int currPoly = 0;
        int i2 = 1;
        while (i2 < count2) {
            if (polygons != null && polygons.length > currPoly && polygons[currPoly] == i2) {
                float prevy = this.verticesXY[2 * (i2 - 1) + 1];
                float firsty = this.verticesXY[2 * first2 + 1];
                Interval ival2 = new Interval();
                ival2.start = prevy < firsty ? prevy : firsty;
                ival2.end = firsty > prevy ? firsty : prevy;
                ival2.i = i2 - 1;
                ival2.j = first2;
                ival2.polyIndex = currPoly++;
                intervals.add(ival2);
                first2 = i2++;
                j2 = i2 - 1;
            }
            yi = this.verticesXY[2 * i2 + 1];
            xi = this.verticesXY[2 * i2 + 0];
            yj = this.verticesXY[2 * j2 + 1];
            this.minX = xi < this.minX ? xi : this.minX;
            this.minY = yi < this.minY ? yi : this.minY;
            this.maxX = xi > this.maxX ? xi : this.maxX;
            this.maxY = yi > this.maxY ? yi : this.maxY;
            ival = new Interval();
            ival.start = yi < yj ? yi : yj;
            ival.end = yj > yi ? yj : yi;
            ival.i = i2;
            ival.j = j2;
            ival.polyIndex = currPoly;
            intervals.add(ival);
            j2 = i2++;
        }
        yi = this.verticesXY[2 * (i2 - 1) + 1];
        xi = this.verticesXY[2 * (i2 - 1) + 0];
        yj = this.verticesXY[2 * first2 + 1];
        this.minX = xi < this.minX ? xi : this.minX;
        this.minY = yi < this.minY ? yi : this.minY;
        this.maxX = xi > this.maxX ? xi : this.maxX;
        this.maxY = yi > this.maxY ? yi : this.maxY;
        ival = new Interval();
        ival.start = yi < yj ? yi : yj;
        ival.end = yj > yi ? yj : yi;
        ival.i = i2 - 1;
        ival.j = first2;
        ival.polyIndex = currPoly;
        intervals.add(ival);
        this.centerX = (this.maxX + this.minX) * 0.5f;
        this.centerY = (this.maxY + this.minY) * 0.5f;
        float dx = this.maxX - this.centerX;
        float dy = this.maxY - this.centerY;
        this.radiusSquared = dx * dx + dy * dy;
        this.tree = this.buildNode(intervals, this.centerY);
    }

    public boolean testPoint(float x, float y) {
        return this.testPoint(x, y, null);
    }

    public boolean testPoint(float x, float y, BitSet inPolys) {
        float dx = x - this.centerX;
        float dy = y - this.centerY;
        if (inPolys != null) {
            inPolys.clear();
        }
        if (dx * dx + dy * dy > this.radiusSquared) {
            return false;
        }
        if (this.maxX < x || this.maxY < y || this.minX > x || this.minY > y) {
            return false;
        }
        boolean res = this.tree.traverse(this.verticesXY, x, y, false, inPolys);
        return res;
    }

    static class IntervalTreeNode {
        float center;
        float childrenMinMax;
        IntervalTreeNode left;
        IntervalTreeNode right;
        List byBeginning;
        List byEnding;

        IntervalTreeNode() {
        }

        static boolean computeEvenOdd(float[] verticesXY, Interval ival, float x, float y, boolean evenOdd, BitSet inPolys) {
            float xDist;
            boolean newEvenOdd = evenOdd;
            int i2 = ival.i;
            int j2 = ival.j;
            float yi = verticesXY[2 * i2 + 1];
            float yj = verticesXY[2 * j2 + 1];
            float xi = verticesXY[2 * i2 + 0];
            float xj = verticesXY[2 * j2 + 0];
            if ((yi < y && yj >= y || yj < y && yi >= y) && (xi <= x || xj <= x) && (newEvenOdd ^= (xDist = xi + (y - yi) / (yj - yi) * (xj - xi) - x) < 0.0f) != evenOdd && inPolys != null) {
                inPolys.flip(ival.polyIndex);
            }
            return newEvenOdd;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        boolean traverse(float[] verticesXY, float x, float y, boolean evenOdd, BitSet inPolys) {
            boolean newEvenOdd = evenOdd;
            if (y == this.center && this.byBeginning != null) {
                int size = this.byBeginning.size();
                for (int b2 = 0; b2 < size; ++b2) {
                    Interval ival = (Interval)this.byBeginning.get(b2);
                    newEvenOdd = IntervalTreeNode.computeEvenOdd(verticesXY, ival, x, y, newEvenOdd, inPolys);
                }
                return newEvenOdd;
            } else if (y < this.center) {
                if (this.left != null && this.left.childrenMinMax >= y) {
                    newEvenOdd = this.left.traverse(verticesXY, x, y, newEvenOdd, inPolys);
                }
                if (this.byBeginning == null) return newEvenOdd;
                int size = this.byBeginning.size();
                for (int b3 = 0; b3 < size; ++b3) {
                    Interval ival = (Interval)this.byBeginning.get(b3);
                    if (ival.start > y) return newEvenOdd;
                    newEvenOdd = IntervalTreeNode.computeEvenOdd(verticesXY, ival, x, y, newEvenOdd, inPolys);
                }
                return newEvenOdd;
            } else {
                if (!(y > this.center)) return newEvenOdd;
                if (this.right != null && this.right.childrenMinMax <= y) {
                    newEvenOdd = this.right.traverse(verticesXY, x, y, newEvenOdd, inPolys);
                }
                if (this.byEnding == null) return newEvenOdd;
                int size = this.byEnding.size();
                for (int b4 = 0; b4 < size; ++b4) {
                    Interval ival = (Interval)this.byEnding.get(b4);
                    if (ival.end < y) return newEvenOdd;
                    newEvenOdd = IntervalTreeNode.computeEvenOdd(verticesXY, ival, x, y, newEvenOdd, inPolys);
                }
            }
            return newEvenOdd;
        }
    }

    static class Interval {
        float start;
        float end;
        int i;
        int j;
        int polyIndex;

        Interval() {
        }
    }

    static class ByEndComparator
    implements Comparator {
        ByEndComparator() {
        }

        public int compare(Object o1, Object o2) {
            Interval i1 = (Interval)o1;
            Interval i2 = (Interval)o2;
            return Float.compare(i2.end, i1.end);
        }
    }

    static class ByStartComparator
    implements Comparator {
        ByStartComparator() {
        }

        public int compare(Object o1, Object o2) {
            Interval i1 = (Interval)o1;
            Interval i2 = (Interval)o2;
            return Float.compare(i1.start, i2.start);
        }
    }
}

