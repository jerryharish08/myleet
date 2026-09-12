import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
            // If string length is odd, it cannot be balanced
                    if (s.length() % 2 != 0) {
                                return false;
                                        }

                                                Deque<Character> stack = new ArrayDeque<>();

                                                        for (char c : s.toCharArray()) {
                                                                    // Push expected closing brackets onto the stack when an opening bracket is seen
                                                                                if (c == '(') {
                                                                                                stack.push(')');
                                                                                                            } else if (c == '{') {
                                                                                                                            stack.push('}');
                                                                                                                                        } else if (c == '[') {
                                                                                                                                                        stack.push(']');
                                                                                                                                                                    } 
                                                                                                                                                                                // If it's a closing bracket, check if it matches the expected bracket at the top
                                                                                                                                                                                            else if (stack.isEmpty() || stack.pop() != c) {
                                                                                                                                                                                                            return false;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                        // Returns true if all opening brackets were properly closed
                                                                                                                                                                                                                                                return stack.isEmpty();
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    }