class Solution {
    public int calPoints(String[] s) {
        
        ArrayList<Integer> al = new ArrayList<>();
        
        int j=0;
        for(int i=0;i<s.length;i++){
            if(s[i].equals("+")){
                int v = al.get(j-1);
                int v1 = al.get(j-2);
                al.add(v+v1);
                j++;
                
            }else if(s[i].equals("D")){
              
                int v = al.get(j-1);
                al.add(v*2);
                j++;
                
            }else if(s[i].equals("C")){
                
                al.remove(j-1);
                j--;
                
            }else{
                al.add(Integer.parseInt(s[i]));
                j++;
            }
        }
        
        int sum=0;
        for(int i=0;i<al.size();i++){
            sum += al.get(i);
        }
        
        return sum;
    }
}