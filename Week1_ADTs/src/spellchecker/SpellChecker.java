/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellchecker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class SpellChecker {
    private Trie dictionary;
    
    public SpellChecker(String dictionaryFilename){
        this.dictionary = new Trie();
        
        try(BufferedReader br = new BufferedReader(new FileReader(dictionaryFilename))){
            //This may vary depending on the words are organized int file
            //In this case, all the words are on a single line
            String wordsLine = br.readLine();
            String[] words = wordsLine.split(" ");
            
            for(String word : words){
                dictionary.add(word);
            }
            br.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public Trie getDictionary(){
        return this.dictionary;
    }
    
    public void checkSpelling(String inputFilename){
        String outputFilename = "List of incorrectly spelt words";
        try (PrintWriter outputFile = new PrintWriter(outputFilename)) {
            BufferedReader br = new BufferedReader(new FileReader(inputFilename));
            String wordsLine = br.readLine();
            String[] words = wordsLine.split(" ");
            
            for(String word : words){
                if(!this.getDictionary().contains(word)){
                    outputFile.print(word + "\n");
                }
            }
            br.close();
            outputFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main (String[] args){
        System.out.println("Welcome to the spell checker app");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter dictionary file name");
        String dictionaryFilename = sc.nextLine();
        SpellChecker spellChecker = new SpellChecker(dictionaryFilename);
        
        System.out.println("Enter input file name");
        String inputFilename = sc.nextLine();
        
        spellChecker.checkSpelling(inputFilename);
        
        System.out.println("File with incorrectly spelt word has been created");

    }
}
