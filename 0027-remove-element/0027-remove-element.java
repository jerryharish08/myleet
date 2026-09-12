class Solution {
        public int removeElement(int[] nums, int val) {
                int k = 0; // Pointer for the position of non-val elements

                        for (int i = 0; i < nums.length; i++) {
                                    // Keep elements that are not equal to val
                                                if (nums[i] != val) {
                                                                nums[k] = nums[i];
                                                                                k++;
                                                                                            }
                                                                                                    }

                                                                                                            return k;
                                                                                                                }
                                                                                                                
}