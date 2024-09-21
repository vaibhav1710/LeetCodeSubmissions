class Solution {
    public void nextPermutation(int[] arr) {
       /*
        1 2 3 4 5
        1 2 3 5 4
        
        1 2 4 3 5
                        
        1 2 4 5 3
        
        1 2 5 3 4
       */
        
        int ind = -1;
        int n = arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind = i;
                break;
            }
        }
      //  System.out.println(ind);
        if(ind==-1){
            Arrays.sort(arr);
        }else{
        
        int max = Integer.MAX_VALUE;
        int j = -1;
        for(int i = ind+1;i<n;i++){
            if(arr[i]>arr[ind]){
                if(arr[i]<=max){
                    max = arr[i];
                    j = i;
                }
            }
        }
        //System.out.println(j);
        int v = arr[j];
        arr[j] = arr[ind];
        arr[ind] = v;
        
         int i = ind+1;
         j = n-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        
        }
        
        
    }
}