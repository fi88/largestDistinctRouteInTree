package my.application.test;

import java.util.HashSet;
import java.util.Set;

public class LargestDistinctRouteInTree {

    static class Tree {
        public int x;
        public Tree l;
        public Tree r;

        public Tree(int v, Tree left, Tree right) {
            this.x = v;
            this.l = left;
            this.r = right;
        }
    }

    public static void main(String... args) {
        Tree t1 = new Tree(1, null, null);
        Tree t2 = new Tree(2, null, null);
        Tree t1a = new Tree(6, null, null);
        Tree t1b = new Tree(1, null, null);
        Tree t4 = new Tree(4, null, null);

        t1.r = t2;
        t2.l = t1a;
        t2.r = t1b;
        t1b.l = t4;
        System.out.println(largestDistinctRouteInTree(t1));
    }

    private static int largestDistinctRouteInTree(Tree T) {
        int[] max = new int[] {0};
        traverseTree(T, new HashSet<Integer>(), 0, max);
        return max[0];
    }

    private static void traverseTree(Tree T, Set<Integer> current, int currentRoute, int[] maxRoute) {
        if (!current.contains(T.x)) {
            current.add(T.x);
            if (T.l != null) {
                traverseTree(T.l, current, currentRoute + 1, maxRoute);
            }
            if (T.r != null) {
                traverseTree(T.r, current, currentRoute + 1, maxRoute);
            }
            current.remove(T.x);
            if (currentRoute + 1 > maxRoute[0]) maxRoute[0] = currentRoute + 1;
        } else {
            if (currentRoute > maxRoute[0]) maxRoute[0] = currentRoute;
        }
    }
}
