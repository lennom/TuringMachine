/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmachinet;

import java.util.ArrayList;
/**
 *
 * @author Leonardo
 */
public class TuringMachine {
    
    public ArrayList<String> states;
    public ArrayList<Character> alphabet;
    public ArrayList<Character> tapeAlphabet;
    public ArrayList<ArrayTransition> transitionFunction;
    public String initialState;
    public String acceptanceState;
    
    TuringMachine() {
        
        alphabet = new ArrayList<Character>();
        tapeAlphabet = new ArrayList<Character>();
        states = new ArrayList<String>();
        transitionFunction = new ArrayList<ArrayTransition>();
        
    }

}