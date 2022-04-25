class MedianFinder {
    PriorityQueue<Integer> minH = new PriorityQueue<>();
    PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
    
    public void addNum(int num) {
        if(maxH.isEmpty() || maxH.peek() >= num){
            maxH.add(num);
        }
        else
            minH.add(num);
        
        if(maxH.size()>minH.size()+1)
            minH.add(maxH.poll());
        else if(maxH.size() < minH.size())
            maxH.add(minH.poll());
    }
    
    public double findMedian() {
       if (maxH.size() == minH.size())
		return (maxH.peek() + minH.peek()) / 2.0;
	else
		return maxH.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */