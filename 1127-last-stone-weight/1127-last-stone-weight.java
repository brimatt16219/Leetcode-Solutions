class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            pq.offer(s);
        }
        System.out.println(pq);

        while (pq.size() > 1) {
            int heaviest = pq.poll();
            int second = pq.poll();

            if (heaviest > second) {
                pq.offer(heaviest - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}