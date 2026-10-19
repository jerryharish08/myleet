import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPoints = 1;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0;
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Handle identical points
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                // Reduce the fraction (dy / dx) by dividing by their GCD
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // Normalize the signs so that lines going in opposite directions match
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = Math.abs(dy); // Vertical line
                } else if (dy == 0) {
                    dx = Math.abs(dx); // Horizontal line
                }

                String slopeKey = dy + "/" + dx;
                slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slopeKey));
            }

            // Total points on line with current point i = max slope count + duplicates + current point itself (1)
            maxPoints = Math.max(maxPoints, localMax + duplicate + 1);
        }

        return maxPoints;
    }

    // Helper method to compute the greatest common divisor using Euclidean algorithm
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}