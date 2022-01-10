class Solution {
    public String addBinary(String a, String b) {
      int xy = a.length()-1;
        int yx = b.length()-1;
        int carry=0;
        String ans="";
        while( xy>=0 || yx>=0 || carry!=0){
            int ax=0;
            int an=0;
            int bx = 0;
            if(xy>=0 && xy<a.length()){
                ax =Integer.parseInt(a.substring(xy,xy+1));
            }
            if(yx>=0 && yx<b.length()){
                bx = Integer.parseInt(b.substring(yx,yx+1));
            }
            an = ax+bx;
            an += carry;
            if(an==3){
                ans= "1"+ans;
                carry = 1;
            }else if(an==2){
                carry = 1;
                ans = "0"+ans;
            }else if(an==1){
                carry =0 ;
                ans = "1"+ans;
            }else{
                carry=0;
                ans = "0"+ans;
            }
          xy--;
            yx--;
            
        }
        // StringBuffer sbrr = new StringBuffer(ans);
        // // To reverse the string
        // sbrr.reverse();
        // String ss= ans;
        return ans;
    }
}