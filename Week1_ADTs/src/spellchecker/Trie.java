/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellchecker;


import java.util.Map;
import java.util.Set;
/**
 *Reference: https://examples.javacodegeeks.com/core-java/trie-tutorial-java/
 * @author Student
 */
public class Trie implements ITrie {
    private Node root;
    private int size;
    
    public Trie(){
        this.root = new Node();
        this.size = 0;
    }
    @Override
    public boolean add(String word) {
        Node trie = root;
        if (trie == null || word == null){
            return false;
        }
        char[] chars = word.toCharArray();
        int counter = 0;
        while (counter < chars.length) {
            Set childs = trie.getChildren().keySet();
            if (!childs.contains(chars[counter])) {
                insertChar(trie, chars[counter]);
                if (counter == chars.length - 1) {
                    getChild(trie, chars[counter]).setIsWord(true);
                    size++;
                    return true;
                }
            }
            trie = getChild(trie, chars[counter]);
            if (trie.getText().equals(word) && !trie.isWord()) {
                trie.setIsWord(true);
                size++;
                return true;
            }
            counter++;
        }
        return false;

    }

    @Override
    public boolean remove(String word) {
        return findNode(root, word);
    }

    @Override
    public boolean contains(String word) {
        Map<Character, Node> children = this.root.getChildren();
        Node trieNode = null;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                trieNode = children.get(c);
                children = trieNode.getChildren();
            } else {
                return false;
            }
        }
        return true;
        
    }
    
    private Node getChild(Node trie, Character c) {
        return trie.getChildren().get(c);
    }
 
    private Node insertChar(Node trie, Character c) {
        if (trie.getChildren().containsKey(c)) {
            return null;
        }
 
        Node next = new Node(trie.getText() + c.toString());
        trie.getChildren().put(c, next);
        return next;
    }

    private boolean findNode(Node trie, String s){
    Map<Character, Node> children = root.getChildren();
 
        Node parent = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (children.containsKey(c)) {
                parent = trie;
                trie = children.get(c);
                children = trie.getChildren();
                if (trie.getText().equals(s)) {
 
                    parent.getChildren().remove(c);
                    trie = null;
                    return true;
                }
            }
        }
        return false;
    }
    
}
