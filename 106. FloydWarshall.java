// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] < 1e8 && dist[k][j] < 1e8)
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        
    }
}
