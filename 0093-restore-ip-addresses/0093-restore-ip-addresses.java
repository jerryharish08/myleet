import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // Base case: 4 segments completed
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        // Try segments of length 1, 2, and 3
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) {
                break;
            }

            String segment = s.substring(start, start + len);

            // Leading zero check
            if (segment.startsWith("0") && segment.length() > 1) {
                break;
            }

            // Numeric value check
            int val = Integer.parseInt(segment);
            if (val > 255) {
                break;
            }

            current.add(segment);
            backtrack(s, start + len, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}