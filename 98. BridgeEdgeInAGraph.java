
class Solution {
    private int time = 0;
    private boolean isBridgeEdge = false;

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Initialize helper arrays
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        // Step 3: DFS traversal from all unvisited nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, disc, low, parent, adj, c, d);
            }
        }

        return isBridgeEdge;
    }

    private void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent,
                     List<List<Integer>> adj, int c, int d) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                parent[v] = u;
                dfs(v, visited, disc, low, parent, adj, c, d);

                // Update low[u]
                low[u] = Math.min(low[u], low[v]);

                // Check bridge condition
                if (low[v] > disc[u]) {
                    // check if this bridge is the edge (c, d) or (d, c)
                    if ((u == c && v == d) || (u == d && v == c)) {
                        isBridgeEdge = true;
                    }
                }

            } else if (v != parent[u]) {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
