
// User function Template for Java

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        // Start BFS from node 0
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsTraversal.add(node);

            // Visit neighbors in given order
            for (int neighbor : adj.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return bfsTraversal;
    }
}
