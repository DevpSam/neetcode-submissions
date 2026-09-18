import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int time = 0;

    // Fixed return type signature here to match the driver code
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid.add(new ArrayList<>());
        }
        
        // Build the adjacency list
        for (List<Integer> conn : connections) {
            int u = conn.get(0);
            int v = conn.get(1);
            grid.get(u).add(v);
            grid.get(v).add(u);
        }
        
        int[] visited = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, Integer.MAX_VALUE);
        Arrays.fill(low, Integer.MAX_VALUE);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        // Start DFS from node 0
        dfs(0, -1, grid, visited, disc, low, ans);
        
        return ans;
    }

    private void dfs(int node, int parent, List<List<Integer>> grid, int[] visited, int[] disc, int[] low, List<List<Integer>> ans) {
        visited[node] = 1;
        time++;
        disc[node] = time;
        low[node] = time;
        
        for (int neighbor : grid.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, node, grid, visited, disc, low, ans);
                
                // Check if the subtree rooted with neighbor has a connection to one of the ancestors of node
                low[node] = Math.min(low[node], low[neighbor]);
                
                // If the lowest vertex reachable from neighbor is below node in DFS tree, then u-v is a bridge
                if (low[neighbor] > disc[node]) {
                    ans.add(Arrays.asList(node, neighbor));
                }
            } else if (neighbor != parent) {
                low[node] = Math.min(low[node], disc[neighbor]);
            }
        }
    }
}