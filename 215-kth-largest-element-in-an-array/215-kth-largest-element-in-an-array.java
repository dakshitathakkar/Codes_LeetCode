class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            PQ.add(nums[i]);
            if(PQ.size()>k)
                PQ.poll();
        }
        return PQ.peek();
    }
}