import java.util.*;

class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];

        // Initialize parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Union all edges
        for (int[] edge : edges) {
            union(parent, edge[0], edge[1]);
        }

        // Check if both belong to same component
        return find(parent, source) == find(parent, destination);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // path compression
        }
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, find(parent, y));
    }
}