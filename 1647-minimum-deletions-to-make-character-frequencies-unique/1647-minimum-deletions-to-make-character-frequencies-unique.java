class Solution {
   public int minDeletions(String s) {
      int[] arr = new int[26];
      for(int i=0;i<s.length();i++){
        arr[s.charAt(i)-'a']++;
      }
       List<Pair> list = new ArrayList<>();
      for(int i=0;i<26;i++){
        if(arr[i]!=0){
          char c = (char)(i+'a');
          list.add(new Pair(c, arr[i]));
        }
      }
      int count = 0;
      Collections.sort(list, (a,b)->b.freq-a.freq);
      Set<Integer> set = new HashSet<>();
      for(int i=0;i<list.size();i++){
        System.out.println(list.get(i).freq);
        int f = list.get(i).freq;
        while(set.contains(f)){
          if(f==0)break;
          f--;
          count++;
        }
        set.add(f);
  
      }
       return count;
    }
    
    public class Pair{
        char c;
        int freq;
        Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }
    
    
}