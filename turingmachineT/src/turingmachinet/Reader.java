/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turingmachinet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Leonardo
 */
public class Reader {
        public String alfabeto;
        public String alfabetoFita;
        public String estados;
        public String transicoes;
    
        Reader() {}
        
        void readArchive(String at) throws IOException{
            BufferedReader input = null;  
            try {  
                input = new BufferedReader( new FileReader(at));  
            } catch (FileNotFoundException e) {  
                System.err.print(e);  
            }  
            alfabetoFita = input.readLine();
            alfabetoFita = alfabetoFita.substring(7);
            alfabeto = input.readLine();
            alfabeto = alfabeto.substring(7); 
            estados = input.readLine();
            estados = estados.substring(3);
            transicoes = input.readLine();
            transicoes = transicoes.substring(5);
        }
        
        void passToTuringMachine(TuringMachine t)
        {          
            for(int i = 0 ; i < alfabeto.length() ; i += 2){
                t.alphabet.add(alfabeto.charAt(i));
            }
            
            for(int i = 0 ; i < alfabetoFita.length() ; i += 2){
                t.tapeAlphabet.add(alfabetoFita.charAt(i));
            }
            
            String auxState = estados;
            String tauxState = "";
            int res = auxState.indexOf(',');
            while (res != -1)
            {
                tauxState =auxState.substring(0,res);
                t.states.add(tauxState);
                auxState = auxState.substring(res+1);
                res = auxState.indexOf(',');
            }
            t.states.add(auxState);           
            t.initialState = t.states.get(0);
            t.acceptanceState = t.states.get(t.states.size()-1);
           
            auxState = transicoes;
            tauxState = "";           
            int resmt;
            res = auxState.indexOf("), (");
            while (res != -1)
            {
                //peguei a string
                tauxState =auxState.substring(0,res+1);
                
                //pegar o tausstate e desmembrar
                resmt = tauxState.indexOf(");(");
                
                if(resmt == -1){ // se nao tiver fitas múltiplas
                    ArrayTransition pt = new ArrayTransition();
                    Transition tt = new Transition();
                    tt.st1 = tauxState.substring(1,tauxState.indexOf(','));
                    tauxState = tauxState.substring(tauxState.indexOf(',')+1);
                    tt.arg1 = tauxState.charAt(0);
                    tauxState = tauxState.substring(tauxState.indexOf("=(")+1);
                    tt.st2 = tauxState.substring(1,tauxState.indexOf(','));
                    tauxState = tauxState.substring(tauxState.indexOf(',')+1);
                    tt.arg2 = tauxState.charAt(0);
                    tauxState = tauxState.substring(tauxState.indexOf(",")+1);
                    tt.direction = tauxState.charAt(0);
                    //System.out.println(tt.st1+","+tt.arg1+"="+tt.st2+","+tt.arg2+","+tt.direction); 
                    
                    pt.tFunction.add(tt);
                    
                    t.transitionFunction.add(pt);     
                
                }else { // se tiver fitas múltiplas
        
                }     
                auxState = auxState.substring(res+3);
                res = auxState.indexOf("), (");
            }
            tauxState =auxState;
            ArrayTransition pt = new ArrayTransition();
            Transition tt = new Transition();
            tt.st1 = tauxState.substring(1,tauxState.indexOf(','));
            tauxState = tauxState.substring(tauxState.indexOf(',')+1);
            tt.arg1 = tauxState.charAt(0);
            tauxState = tauxState.substring(tauxState.indexOf("=(")+1);
            tt.st2 = tauxState.substring(1,tauxState.indexOf(','));
            tauxState = tauxState.substring(tauxState.indexOf(',')+1);
            tt.arg2 = tauxState.charAt(0);
            tauxState = tauxState.substring(tauxState.indexOf(",")+1);
            tt.direction = tauxState.charAt(0);
            //System.out.println(tt.st1+","+tt.arg1+"="+tt.st2+","+tt.arg2+","+tt.direction);          
            pt.tFunction.add(tt);
                    
            t.transitionFunction.add(pt);  
            
            for(int i = 0; i < t.transitionFunction.size(); i ++)
            {
                for(int j = 0; j < t.transitionFunction.get(i).tFunction.size(); j++)
                {
                    System.out.print(t.transitionFunction.get(i).tFunction.get(j).st1+","+
                            t.transitionFunction.get(i).tFunction.get(j).arg1+"="+
                            t.transitionFunction.get(i).tFunction.get(j).st2+","+
                            t.transitionFunction.get(i).tFunction.get(j).arg2+","+
                            t.transitionFunction.get(i).tFunction.get(j).direction+"|"); 
                }
                System.out.println();
            }
            
            
            
            //System.out.println(auxState);
/*
            //std::cout << (char)229 << ":";
            System.out.print((char)229 + ":");
            //std::cout << std::endl;
            System.out.println();
            for(int i = 0; i < mT.transitionFunction.size() ; i ++) {
            //std::cout << mT.transitionFunction[i].st1 << "," << mT.transitionFunction[i].arg1 << "->" << mT.transitionFunction[i].st2
            //<< "," << mT.transitionFunction[i].arg2 << "," << mT.transitionFunction[i].direction << std::endl;
            System.out.println(mT.transitionFunction.get(i).st1 + "," + mT.transitionFunction.get(i).arg1 + "->"
            + mT.transitionFunction.get(i).st2 + "," + mT.transitionFunction.get(i).arg2 + "," + mT.transitionFunction.get(i).direction);
            }
            //
            mT.initialState = mT.states.get(0);
            //std::cout << "estado inciail:" << mT._initialState << std::endl;
            System.out.println("Estado inicial: " + mT.initialState);
            mT.acceptanceState = mT.states.get(mT.states.size() - 2);
            //std::cout << "estado de aceitacao:" << mT._acceptanceState << std::endl;
            System.out.println("Estado de aceitacao: " + mT.acceptanceState);
            mT.rejectionState = mT.states.get(mT.states.size()-1);
            //std::cout << "estado de rejeicao:" << mT._rejectionState << std::endl;
            System.out.println("Estado de rejeicao: " + mT.rejectionState);
             */          
        }
    
}
