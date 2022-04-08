class KthLargest {

    public PriorityQueue<Integer> q;
    public int k;    
    
    
    public KthLargest(int k, int[] nums) {
     this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : nums)
                add(n);
        
    }
    
    
    public int add(int val) {
        q.add(val);
        pop();
        return q.peek();    
    }
    
    public void pop(){
        while(q.size()>k){
            q.remove();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */