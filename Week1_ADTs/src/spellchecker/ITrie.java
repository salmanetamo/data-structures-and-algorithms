/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellchecker;

/**
 *
 * @author Student
 */
public interface ITrie {
    boolean add(String word);
    boolean remove(String word);
    boolean contains(String word);
}
