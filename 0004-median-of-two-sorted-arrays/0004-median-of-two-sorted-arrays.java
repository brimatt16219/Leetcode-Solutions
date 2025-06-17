class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList();
        
        for (int i = 0; i < nums1.length; i++)
        {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++)
        {
            list.add(nums2[i]);
        }
        
        Collections.sort(list);
        int total = nums1.length + nums2.length;
        boolean isOdd = total % 2 == 1;
        if (isOdd) 
        {
            return (list.get(total / 2));
        }
        else
        {
            return (list.get(total / 2) + list.get(total / 2 - 1)) / 2.0;
        }
    }
}