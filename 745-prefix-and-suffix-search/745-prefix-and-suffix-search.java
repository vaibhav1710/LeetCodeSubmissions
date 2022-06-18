class WordFilter {
private String[] words;
private Map<String,Set<String>> presuf;
private Map<String,Integer> index;
public WordFilter(String[] words) {
    this.words = words;
    presuf = new HashMap<>();
    index = new HashMap<>();
    insertWords();
}
public void insertWords(){
    for(int i=0;i<words.length;i++){
        index.put(words[i],i);
        Set<String> subpre = new HashSet<>();
        Set<String> subsuf = new HashSet<>();
        for(int l=0;l<words[i].length();l++){
            subpre.add(words[i].substring(0,l+1));
            
        }
        for(int j=words[i].length()-1;j>=0;j--){
                subsuf.add(words[i].substring(j,words[i].length()));
        }
        for(String l : subpre){
            for(String j : subsuf){
                String key = l+"-"+j;
                Set<String> temp = presuf.getOrDefault(key,new HashSet<>());
                temp.add(words[i]);
                presuf.put(key,temp);
            }
        }
    }
    
}

public int f(String prefix, String suffix) {
    if(prefix.length()==0 || suffix.length()==0){
        return -1;
    }
    
    String key = prefix+"-"+suffix;
    int ansIn = -1;
    Set<String> lis = presuf.get(key);
    if(lis==null){
        return -1;
    }
    for(String i : lis){
        if(ansIn<index.get(i)){
            ansIn = index.get(i);
        }
    }
    return ansIn;
    
}
}

/**

Your WordFilter object will be instantiated and called as such:
WordFilter obj = new WordFilter(words);
int param_1 = obj.f(prefix,suffix);
*/