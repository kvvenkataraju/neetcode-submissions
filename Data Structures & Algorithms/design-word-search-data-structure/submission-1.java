class WordDictionary {

    Node root;
    public WordDictionary() {
        root= new Node();
    }

    public void addWord(String word) {
        Node current= root;
        for(char ch : word.toCharArray()){
            current.children.putIfAbsent(ch,new Node());
            current = current.children.get(ch);
        }
        current.isEndOfWord=true;

    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }
    public boolean dfs(String word,int i,Node node){
        if(i==word.length()) return node.isEndOfWord; 
        char c = word.charAt(i);
        
        if(c == '.'){
            for(Character ch : node.children.keySet()){
                    Node child=node.children.get(ch);
                if(child !=null && dfs(word,i+1,child)){
                    return true;
                }
            }
            return false;
        }
        Node current = node.children.get(c);
         return current != null && dfs(word,i+1,current);
    }

}
class Node{
    Map<Character,Node> children= new HashMap<>();
    boolean isEndOfWord=false;
}