class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int minVal = nums[0];
        int maxVal = nums[0];
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        if (minVal == maxVal) {
            return 0;
        }

        int n = nums.length;
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketCount = (maxVal - minVal) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] bucketHasVal = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Place numbers into buckets
        for (int num : nums) {
            int idx = (num - minVal) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            bucketHasVal[idx] = true;
        }

        // Scan buckets to find the maximum gap
        int maxGap = 0;
        int prevMax = minVal;

        for (int i = 0; i < bucketCount; i++) {
            if (!bucketHasVal[i]) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

}