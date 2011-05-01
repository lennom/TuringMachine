/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmachinet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Vitor
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {   
        
        TuringMachine t = new TuringMachine();
        
        Reader r = new Reader();
        r.readArchive("input.txt");
        r.passToTuringMachine(t);
    }
    
    
}
