class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0) return 0;
        
        List<Double> al = new ArrayList<>();
        al.add((double) poured);
        
        for(int i = 0; i < query_row; i++) {
            List<Double> al1 = new ArrayList<>();
            
          
            al1.add(Math.max((al.get(0)-1)/2, 0.0));       
          
            for(int j = 1; j < al.size(); j++) {
                al1.add(Math.max((al.get(j-1)-1)/2, 0.0) + Math.max((al.get(j)-1)/2, 0.0));
            }
            
            al1.add(Math.max(al1.get(0), 0.0));
            
           
            al = new ArrayList<>(al1);
        }
        
        return Math.min(al.get(query_glass), 1);
    }
}
