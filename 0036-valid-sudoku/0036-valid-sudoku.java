import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
            // Use a set to track seen values across rows, columns, and 3x3 boxes
                    Set<String> seen = new HashSet<>();

                            for (int r = 0; r < 9; r++) {
                                        for (int c = 0; c < 9; c++) {
                                                        char val = board[r][c];

                                                                        if (val != '.') {
                                                                                            // Unique string representations for each digit's row, column, and box position
                                                                                                                String rowKey = val + " in row " + r;
                                                                                                                                    String colKey = val + " in col " + c;
                                                                                                                                                        String boxKey = val + " in box " + (r / 3) + "-" + (c / 3);

                                                                                                                                                                            // If any key already exists in the set, a duplicate exists
                                                                                                                                                                                                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                                                                                                                                                                                                                        return false;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                        return true;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            }