import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Initialize queue and count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spread = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] d : dirs) {
                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];

                    if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        queue.offer(new int[]{ni, nj});
                        fresh--;
                        spread = true;
                    }
                }
            }

            if (spread) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}