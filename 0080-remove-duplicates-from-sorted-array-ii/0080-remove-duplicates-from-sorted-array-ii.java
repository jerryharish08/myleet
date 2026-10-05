class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2; // First two elements are always valid
        for (int i = 2; i < nums.length; i++) {
            // Compare current element with the element placed 2 positions back
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

}