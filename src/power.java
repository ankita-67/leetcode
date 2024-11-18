public class power {
    public static void main(String[] args)
    {
        float x = 10;
        int y = 15;

        // Function call
        System.out.printf("%f", myPow(x, y));
    }

        public static double myPow(double x, int n) {
            // If power n is non-negative, calculate power using helper method
            if (n >= 0) {
                return quickPow(x, n);
            } else {
                // If power n is negative, calculate the inverse of the power
                return 1 / quickPow(x, -(long) n);
            }
        }

        private static double quickPow(double base, long exponent) {
            double result = 1; // Initialize result to neutral element for multiplication

            // Loop through all bits of the exponent
            while (exponent > 0) {
                // If the current bit is set, multiply the result by the base
                if ((exponent & 1) == 1) {
                    result *= base;
                }
                // Square the base for the next bit in the exponent
                base *= base;
                // Shift exponent to the right to process the next bit
                exponent >>= 1;
                System.out.print("exponent: "+exponent);
            }

            // Return the final result of base raised to the exponent
            return result;
        }

}
