class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int ind = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            Arrays.sort(arr);
        }else{
        int min = Integer.MAX_VALUE;
        int ind1=-1;  
        for(int i=n-1;i>ind;i--){
            if(arr[i]>arr[ind] && arr[i]<min){
                min = arr[i];
                ind1=i;
            }
        }

        int temp = arr[ind1];
        arr[ind1] = arr[ind];
        arr[ind] = temp;


        int i=ind+1;
        int j=n-1;
    while(i<j){
         temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}
  }
}