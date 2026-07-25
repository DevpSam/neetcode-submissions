class Solution {
    public int maxProduct(int n) {
        int largest = 0;
        int secondLargest = 0;
        
        // Extract digits from right to left
        while (n > 0) {
            int currentDigit = n % 10;
            
            if (currentDigit > largest) {
                // Shift previous largest to second largest
                secondLargest = largest;
                largest = currentDigit;
            } else if (currentDigit > secondLargest) {
                // Update only second largest
                secondLargest = currentDigit;
            }
            
            // Remove the processed digit
            n /= 10;
        }
        
        return largest * secondLargest;
    }
}