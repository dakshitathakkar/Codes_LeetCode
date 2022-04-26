// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends


class Solution
{
    static PriorityQueue<Integer> minH = new PriorityQueue<>();
    static PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        if(maxH.isEmpty() || maxH.peek() >= x){
            maxH.add(x);
        }
        else{
            minH.add(x);
        }
        if(maxH.size() > minH.size()+1){
            minH.add(maxH.poll());
        }
        else if(minH.size() > maxH.size()){
            maxH.add(minH.poll());
        }
        // add your code here
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(minH.size()==maxH.size()){
            return (minH.peek() + maxH.peek())/2.0;
        }
        return maxH.peek();
        // add your code here
    }
    
}