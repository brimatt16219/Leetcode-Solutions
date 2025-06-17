class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> hset = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++){
            // Searches hashset. if present, it contains duplicate...
            if (hset.contains(nums[i])){
                return true;
            }
            // if not present it will update hashset...
            hset.add(nums[i]);
        }
        // Otherwise return false...
        return false;
    }
}