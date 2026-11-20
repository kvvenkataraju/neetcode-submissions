class PrefixTree {
    Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
       Node current=root;
       for(char ch:word.toCharArray()){
        current.children.putIfAbsent(ch,new Node());
        current = current.children.get(ch);
       }
       current.isEndOfWord=true;

    }

    public boolean search(String word) {
            Node current=root;
             for(char ch:word.toCharArray()){
                current=current.children.get(ch);
                if(current == null){
                    return false;
                }
             }
             return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node current=root;
             for(char ch:prefix.toCharArray()){
                current=current.children.get(ch);
                if(current == null){
                    return false;
                }
             }
             return true;
    }
}
class Node{
    Map<Character,Node> children = new HashMap<>();
    boolean isEndOfWord = false;
}