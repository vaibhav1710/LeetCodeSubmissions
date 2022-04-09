class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Pair> al = new ArrayList<>();
        for(int v:hm.keySet()){
            al.add(new Pair(v,hm.get(v)));
        }
        Collections.sort(al,Collections.reverseOrder());
        int a[] = new int[k];
        int i=0;
        while(k-->0){
            a[i] = al.get(i).a;
            i++;
        }
        return a;
    }
    
    public class Pair implements Comparable<Pair>{
        int a;
        int b;
        Pair(int a, int b ){
            this.a=a;
            this.b=b;
        }
        public int compareTo(Pair o){
            return this.b - o.b;
        }
    }
}