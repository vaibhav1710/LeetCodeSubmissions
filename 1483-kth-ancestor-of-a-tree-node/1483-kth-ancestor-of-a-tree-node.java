class TreeAncestor {
    int maxbit;
    int v[][] ;
    
    public TreeAncestor(int n, int[] parent) {
        maxbit=0;
       while((1<<maxbit)<=n){
           maxbit++;
       }
        maxbit++;
       // depth = new int[n];
        v = new int[maxbit+1][n];
        v[0] = parent;
       for(int i=1;i<maxbit;i++){
           for(int j=0;j<n;j++){
               int u2j = v[i-1][j];
               if(u2j==-1){
                   v[i][j] = -1;
               }else{
                   v[i][j] = v[i-1][u2j];
               }
           }
       }
       
    }
    
    public int getKthAncestor(int node, int k) {
      
       
        for(int i=0;i<maxbit;i++){
            if((k & (1<<i)) > 0){
                Integer val = v[i][node];
                if(val==-1) return -1;
                node=val;
            }
        }
        return node;
}
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */