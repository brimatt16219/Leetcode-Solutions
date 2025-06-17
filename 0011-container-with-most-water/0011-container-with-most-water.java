class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int area;
        while (left < right)
        {
            area = Math.abs(right - left) * Math.min(height[left], height[right]);
            if (area > max) max = area;
            if (height[left] < height[right])
                left ++;
            else
                right --;
        }
        return max;
    }
}