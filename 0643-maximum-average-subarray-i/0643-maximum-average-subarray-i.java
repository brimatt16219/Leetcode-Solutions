class Solution {
    public double findMaxAverage(int[] nums, int k) {

        if (nums.length == 1)
            return nums[0];

        double max = 0;
        double avg = 0;
        for (int i = 0; i < k; i++) {
            avg += (double) nums[i] / k;
        }
        max = avg;
        for (int i = 1; i < nums.length - k + 1; i++) {
            double front = nums[i + k - 1];
            double back = nums[i - 1];
            // System.out.println("avg is: " + avg + " adding " + front + " removing " + back);
            // remove start, add end
            avg += front / k - back / k;
            if (max < avg)
                max = avg;
        }
        return max;
    }
}