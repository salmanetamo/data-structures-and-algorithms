/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellchecker;


import java.util.HashMap;
/**
 *
 * @author Student
 */
public class Node {
    private HashMap<Character, Node> children;
    private String text;
    private boolean isWord;
    
    public Node(){
        this.children = new HashMap<Character, Node>();
        this.text = "";
        this.isWord =  false;
    }
    
    public Node(String text){
        this.children = new HashMap<Character, Node>();
        this.text = text;
        this.isWord =  false;
    }

    /**
     * @return the children
     */
    public HashMap<Character, Node> getChildren() {
        return children;
    }


    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @return the isWord
     */
    public boolean isWord() {
        return isWord;
    }

    /**
     * @param isWord the isWord to set
     */
    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
    
    @Override
    public String toString(){
        return this.text;
    }
    
}
