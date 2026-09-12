class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i = 0; i< n; i++){
            if(colors[i] != 0){
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;

            while(!queue.isEmpty()){
                int curr = queue.poll();

                for(int neighbour : graph[curr]){
                    if(colors[neighbour] == colors[curr]){
                        return false;
                    }
                    if(colors[neighbour] == 0){
                        colors[neighbour] = -colors[curr];
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return true;
    }
}