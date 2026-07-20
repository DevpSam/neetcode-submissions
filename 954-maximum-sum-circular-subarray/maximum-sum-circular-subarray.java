class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int minSum = nums[0];
        int totalmin = 0;
        int totalmax = 0;
        int maxSum = nums[0];
        for(int i = 0; i<nums.length; i++){
            sum+= nums[i];//sum
            totalmax=Math.max(totalmax+nums[i], nums[i]);
            maxSum = Math.max(maxSum, totalmax);//maxSum
            totalmin = Math.min(totalmin+nums[i],nums[i]);
            minSum = Math.min(minSum,totalmin);//minSum
        } 
        if (maxSum < 0) {
            return maxSum;
        }
        else{
            return Math.max(maxSum,sum-minSum);
        }
        }

    }
