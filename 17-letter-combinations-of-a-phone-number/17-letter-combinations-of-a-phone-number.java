class Solution {
    public List<String> letterCombinations(String digits) {
      
        String text[] = new String[10];
        text[0]="";
        text[1]="";
        text[2]="abc";
        text[3]="def";
        text[4]="ghi";
        text[5]="jkl";
        text[6]="mno";
        text[7]="pqrs";
        text[8]="tuv";
        text[9]="wxyz";
       ArrayList<String> al = new ArrayList<>();
         ArrayList<String> al1 = new ArrayList<>();
        
        for(int i=0;i<digits.length();i++){
            int v = digits.charAt(i)-'1'+1;
            String ss = text[v];
            if(i==0){
                for(int j=0;j<ss.length();j++){
                    String addi = ""+ss.charAt(j);
                    al.add(addi);
                    }
            }else{
                for(int j=0;j<ss.length();j++){
                    for(int l=0;l<al.size();l++){
                        al1.add(al.get(l)+""+ss.charAt(j));
                    }
                }
                
                al = new ArrayList(al1);
                al1 = new ArrayList<>();
            }
        }
        return al;
    }
}