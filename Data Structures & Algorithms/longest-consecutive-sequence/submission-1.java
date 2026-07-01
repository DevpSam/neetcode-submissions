class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        
        int longest = 0;
        for (int i : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(i - 1)) {
                int currentNum = i;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        
        // Return outside the loop after checking all elements
        return longest; 
    }
}