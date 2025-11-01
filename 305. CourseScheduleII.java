

class Solution {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int u = pair[1]; 
            int v = pair[0];
            adj.get(u).add(v);
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 6: Check if topological sort is possible (i.e., no cycle)
        if (result.size() != n) {
            return new ArrayList<>(); // Cycle detected, no valid ordering
        }

        return result;
    }
}
