import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses]; // 0,1,2

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(graph, state, i)) return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return true;  // cycle found
        if (state[node] == 2) return false; // already safe

        state[node] = 1; // visiting

        for (int neighbor : graph.get(node)) {
            if (dfs(graph, state, neighbor)) return true;
        }

        state[node] = 2; // done
        return false;
    }
}