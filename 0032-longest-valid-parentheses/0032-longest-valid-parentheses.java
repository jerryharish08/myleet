import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestValidParentheses(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
                    // Push -1 as the initial boundary index
                            stack.push(-1);
                                    int maxLength = 0;

                                            for (int i = 0; i < s.length(); i++) {
                                                        if (s.charAt(i) == '(') {
                                                                        // Push index of open parenthesis
                                                                                        stack.push(i);
                                                                                                    } else {
                                                                                                                    // Pop the last matching '(' index or boundary
                                                                                                                                    stack.pop();

                                                                                                                                                    if (stack.isEmpty()) {
                                                                                                                                                                        // If stack becomes empty, set current index as new boundary
                                                                                                                                                                                            stack.push(i);
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                // Calculate current valid substring length
                                                                                                                                                                                                                                                    maxLength = Math.max(maxLength, i - stack.peek());
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                return maxLength;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    }