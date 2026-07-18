class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowImpacted = false;
        boolean firstColImpacted = false;

        // 1. Check if the first row has any zeroes
        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == 0) {
                firstRowImpacted = true;
                break;
            }
        }

        // 2. Check if the first column has any zeroes
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) { // FIX: Changed 'col' to '0'
                firstColImpacted = true;
                break;
            }
        }

        // 3. Use the first row and column to mark zero rows and columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // 4. Zero out cells based on the markers in the first row/col
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // FIX: Spelled 'matrix' correctly and added '== 0' condition
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 5. Zero out the first row if it originally had a zero
        if (firstRowImpacted) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // 6. Zero out the first column if it originally had a zero
        if (firstColImpacted) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}