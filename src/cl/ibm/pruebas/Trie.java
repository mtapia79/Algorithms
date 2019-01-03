package cl.ibm.pruebas;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public static void main(String args[]){
        Trie t = new Trie();
        String text = "abc";
        t.insertTrie(text);
        text = "ab";
        System.out.println("found:" + t.searchTrie(text));
        text = "ab";
        System.out.println("deleted:" + t.delete(text));
        
        System.out.println("found after deleted:" + t.searchTrie(text));
    }
    
    public static void insertTrie(String lista) {
        TrieNode current = root;  
        for(char c: lista.toCharArray()) {
            TrieNode node = current.children.get(c);
            if(node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.isEndWord = true;
    }
    
    public boolean searchTrie(String text) {
        
        TrieNode current = root;  
        
        for(int i= 0; i<text.length() ; i++) {
            char c = text.charAt(i);
            TrieNode node = current.children.get(c);
            
            if(node == null) {
                return false;
            }
            
            current = node;
        }
        
        return current.isEndWord;
    }
    
    public boolean delete(String text) {
        return deleteTrie(root, text , 0);
    }
    public boolean deleteTrie( TrieNode current, String text, int index) {
        
        if(index == text.length()) {
            if(!current.isEndWord) {
                return false;
            }
            current.isEndWord = false;
            return current.children.size() == 0;
        }
        
        char c = text.charAt(index);
        TrieNode node = current.children.get(c);
        
        if(node == null) {
            return false;
        }
        
        boolean shoulrBeDeleted = deleteTrie(node, text, index +1);
        
        if(shoulrBeDeleted) {
            current.children.remove(c);
            return current.children.size() == 0;
        }
        
        return false;
    }
}

class TrieNode{
    Map<Character,TrieNode> children;
    boolean isEndWord;
    
    public TrieNode()
    {
        children = new  HashMap<>();
        isEndWord = false;
    }
    
    public Map<Character,TrieNode> getChildren() {
        return children;
    }
    
    public void setChildren(Map<Character,TrieNode> child) {
        children = child;
    }
    
    public void setIsEndWord() {
        isEndWord = true;
    }
    
    public boolean getIsEndWord() {
        return isEndWord; 
    }
}
