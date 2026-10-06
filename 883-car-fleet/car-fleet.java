import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int n = pos.length;
        if (n == 0) return 0;
        
        // Combine position and speed into a 2D array
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; ++i) {
            cars[i][0] = pos[i];
            cars[i][1] = speed[i];
        }
        
        // Sort cars by position in descending order
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        int res = 0; 
        double cur = 0;
        
        // Iterate through the sorted cars
        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            
            // If this car takes strictly longer to reach the target than the current fleet,
            // it becomes the head of a new fleet.
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        
        return res;
    }
}