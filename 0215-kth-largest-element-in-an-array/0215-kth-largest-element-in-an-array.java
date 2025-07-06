class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap of the k largest elements seen so far
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) {
            pq.offer(num);
            // If we have more than k, remove the smallest → keeps only k biggest
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // The root is the k-th largest
        return pq.peek();
    }
}