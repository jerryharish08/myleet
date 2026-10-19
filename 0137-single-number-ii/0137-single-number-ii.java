class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // Update ones: keep bits that appear once, remove bits that are now in twos
            ones = (ones ^ num) & ~twos;

            // Update twos: keep bits that appear twice, remove bits that are now in ones
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }

}