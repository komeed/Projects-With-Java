import java.util.HashMap;
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if(children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();

            if(i == word.length() - 1) {
                node.setLeaf(true);
            }
        }
    }

    public int search(String word) {
        HashMap<Character, TrieNode> children = root.getChildren();

        TrieNode node = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            } else {
                node = null;
                break;
            }
        }
        if(node!=null){
            if(node.isLeaf()){
                return 1;
            }
            return 2;
        }
        else{
            return 0;
        }
    }
}