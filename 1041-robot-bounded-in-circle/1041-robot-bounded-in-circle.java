class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir = 0;
        int x = 0;
        int y = 0;
        for(int i=0;i<instructions.length();i++){
            if(instructions.charAt(i)=='G'){
                if(dir==0) y++;
                else if(dir==1) x++;
                else if(dir==2) y--;
                else x--;
            }else if(instructions.charAt(i)=='L') dir = (dir+1)%4;
            else dir = (dir+3)%4;
        }
        
        if(x==0 && y==0) return true;
        else if(dir > 0) return true;
        return false;
    }
}