class Solution {
    
    class P implements Comparable<P>{
        int d;
        int ld;
       P(int d,int ld){
            this.d=d;
            this.ld=ld;
        }
        public int compareTo(P o){    
            return this.ld -o.ld ;
        }
    }
    
    class Pair implements Comparable<Pair>{
        int d;
        int ld;
        Pair(int d,int ld){
            this.d=d;
            this.ld=ld;
        }
        public int compareTo(Pair o){    
            return o.d-this.d;
        }
    }
    
    public int scheduleCourse(int[][] courses) {
         
      PriorityQueue<P> q = new PriorityQueue<>();
        for(int i=0;i<courses.length;i++){
            q.add(new P(courses[i][0],courses[i][1]));
        }
         int curr = 0;
        int count = 0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        while(q.size()!=0){
            P r = q.poll();
            if(r.d + curr <= r.ld){
                curr += r.d;
                count++;
                pq.add(new Pair(r.d,r.ld));
            }else if(pq.size()!=0 && pq.peek().d > r.d){
                Pair rem = pq.poll();
                curr += (r.d - rem.d);
                pq.add(new Pair(r.d,r.ld));   
            } 
        }
       
        return count;
    }
}