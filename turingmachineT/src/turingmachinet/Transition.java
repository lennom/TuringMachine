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
public class Transition {

    public String st1;
    public ArrayList<Character> arg1;
    public String st2;
    public ArrayList<Character> arg2;
    public ArrayList<Character> direction;
    
    Transition()
    {
        st1 = "";
        st2 = "";
        arg1 = new ArrayList<Character>();
        arg2 = new ArrayList<Character>();
        direction = new ArrayList<Character>();
    }
    
}

