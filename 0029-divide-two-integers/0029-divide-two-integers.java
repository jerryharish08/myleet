class Solution {
        public int divide(int dividend, int divisor) {
                // Special case: Integer overflow when Integer.MIN_VALUE / -1
                        if (dividend == Integer.MIN_VALUE && divisor == -1) {
                                    return Integer.MAX_VALUE;
                                            }

                                                    // Determine if the result should be negative
                                                            boolean isNegative = (dividend < 0) ^ (divisor < 0);

                                                                    // Convert both dividend and divisor to negative numbers to prevent overflow issues 
                                                                            // (Since Math.abs(Integer.MIN_VALUE) exceeds Integer.MAX_VALUE)
                                                                                    int absDividend = dividend < 0 ? dividend : -dividend;
                                                                                            int absDivisor = divisor < 0 ? divisor : -divisor;

                                                                                                    int quotient = 0;

                                                                                                            // Perform bitwise division using powers of 2
                                                                                                                    while (absDividend <= absDivisor) {
                                                                                                                                int tempDivisor = absDivisor;
                                                                                                                                            int multiple = 1;

                                                                                                                                                        // Double the divisor using bit shift until it exceeds absDividend or overflows
                                                                                                                                                                    while (tempDivisor >= Integer.MIN_VALUE >> 1 && absDividend <= (tempDivisor << 1)) {
                                                                                                                                                                                    tempDivisor <<= 1;
                                                                                                                                                                                                    multiple <<= 1;
                                                                                                                                                                                                                }

                                                                                                                                                                                                                            absDividend -= tempDivisor;
                                                                                                                                                                                                                                        quotient += multiple;
                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                        return isNegative ? -quotient : quotient;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            
}