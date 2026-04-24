class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        // Build degree arrays
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            
            outdegree[a]++;
            indegree[b]++;
        }

        // Find the judge
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}