


package turingmachinet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {   
        
        TuringMachine t = new TuringMachine();
        
        Reader r = new Reader();
        r.readArchive("input.txt");
        r.passToTuringMachine(t);

        TuringMachineGraph g = new TuringMachineGraph(t);
    }
    
    
}
