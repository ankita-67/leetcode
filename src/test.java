import java.util.Arrays;

public class test {

    // Function to find the maximum number of coins that can be collected.
    static int maxCollectedCoins(char[][] matrix) {
        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 2D array to store cumulative coins in each cell
        int[][] dp = new int[rows][cols];

        // Calculate cumulative coins for each cell in the row
        for (int i = 0; i < rows; ++i) {
            int coinCount = 0;

            // Iterate from left to right in the row
            for (int j = 0; j < cols; ++j) {
                // Reset coinCount if an obstacle is encountered
                if (matrix[i][j] == '#') {
                    coinCount = 0;
                }
                // Increment coinCount if a coin is found
                else if (matrix[i][j] == 'C') {
                    ++coinCount;
                }
                // Update cumulative coins for the cell
                dp[i][j] += coinCount;
            }

            // Reset coinCount for the reverse iteration
            coinCount = 0;

            // Iterate from right to left in the row
            for (int j = cols - 1; j >= 0; --j) {
                // Reset coinCount if an obstacle is encountered
                if (matrix[i][j] == '#') {
                    coinCount = 0;
                }
                // Increment coinCount if a coin is found
                else if (matrix[i][j] == 'C') {
                    ++coinCount;
                }
                // Update cumulative coins for the cell
                dp[i][j] += coinCount;
            }
        }

        // Calculate cumulative coins for each cell in the column
        for (int j = 0; j < cols; ++j) {
            int coinCount = 0;

            // Iterate from top to bottom in the column
            for (int i = 0; i < rows; ++i) {
                // Reset coinCount if an obstacle is encountered
                if (matrix[i][j] == '#') {
                    coinCount = 0;
                }
                // Increment coinCount if a coin is found
                else if (matrix[i][j] == 'C') {
                    ++coinCount;
                }
                // Update cumulative coins for the cell
                dp[i][j] += coinCount;
            }

            // Reset coinCount for the reverse iteration
            coinCount = 0;

            // Iterate from bottom to top in the column
            for (int i = rows - 1; i >= 0; --i) {
                // Reset coinCount if an obstacle is encountered
                if (matrix[i][j] == '#') {
                    coinCount = 0;
                }
                // Increment coinCount if a coin is found
                else if (matrix[i][j] == 'C') {
                    ++coinCount;
                }
                // Update cumulative coins for the cell
                dp[i][j] += coinCount;
            }
        }

        // Find the maximum number of coins in an empty cell
        int maxCoins = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == '0') {
                    maxCoins = Math.max(maxCoins, dp[i][j]); // Update maxCoins if larger value is found
                }
            }
        }

        return maxCoins;
    }

    public static void main(String[] args) {
        // Create a 2D array representing the matrix
        char[][] matrix = {
                { '0', 'C', '0', '0' },
                { 'C', '0', '#', 'C' },
                { '0', 'C', '0', '0' }
        };

        // Call the maxCollectedCoins function with the provided matrix
        int result = maxCollectedCoins(matrix);

        // Output the result
        System.out.println("Max Collected Coins: " + result);
    }
}