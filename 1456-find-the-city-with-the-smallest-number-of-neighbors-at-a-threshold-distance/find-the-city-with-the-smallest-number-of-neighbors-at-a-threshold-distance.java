class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[105][105];
        int INF = 1000000000;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = INF;
            }
        }

        // edges.length replaces edgesSize in Java
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        int city = -1;
        int minCount = INF;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold)
                    count++;
            }

            if (count <= minCount) {
                minCount = count;
                city = i;
            }
        }

        return city;
    }
}
