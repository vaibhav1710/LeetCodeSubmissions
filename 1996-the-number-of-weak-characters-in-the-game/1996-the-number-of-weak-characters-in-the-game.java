class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
       Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
        
        int dp[] = new int[properties.length];
        int count = 0;
        int max = properties[0][1];
        for(int i=0;i<properties.length;i++){
            if(max > properties[i][1]){
            count++;
             }
            else if(max<properties[i][1]){
                max = properties[i][1];
            }
        }
            return count;
            
        
    }
}