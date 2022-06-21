class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int a[] = heights;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int i=1;i<heights.length;i++){
            if(a[i]>a[i-1]){
                sum += a[i]-a[i-1];
                pq.add(a[i]-a[i-1]);
                if(sum>bricks){
                    if(ladders>0){
                    int v = pq.remove();
                    sum -= v;
                    ladders--;  
                }else{
                    return i-1;
                }
            }
        }
    }
        return heights.length-1;
    }
}