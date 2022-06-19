class Solution {
public List<List<String>> suggestedProducts(String[] products, String searchWord) {
Arrays.sort(products);
List<List<String>> suggestions=new ArrayList<>();
String key="";
for(int i=0;i<searchWord.length();i++)
{
if(i<searchWord.length()-1)
key=searchWord.substring(0,i+1);
else
key=searchWord;
List word=new ArrayList<>();
for(int j=0;j<products.length;j++)
{
if(products[j].startsWith(key)&&word.size()<3)
{
word.add(products[j]);
}
}
suggestions.add(word);

    }
    return suggestions;
}
}