
package turingmachinet;

import org.jgrapht.*;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 *
 * @author Vitor
 */
public class TuringMachineGraph {

    TuringMachine tm;
    DirectedGraph<String, DefaultEdge> g;
    String currentState;

    TuringMachineGraph(TuringMachine t) {

        tm = t;
        currentState = "";
        g = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

        for(int i = 0; i < tm.states.size(); i++) {
            g.addVertex(t.states.get(i));
        }

        for(int i = 0; i < tm.transitionFunction.size(); i++) {
            for(int j = 0; j < tm.transitionFunction.get(i).tFunction.size(); j++) {
                g.addEdge(tm.transitionFunction.get(i).tFunction.get(j).st1, tm.transitionFunction.get(i).tFunction.get(j).st2);
                System.out.println("New edge: " + tm.transitionFunction.get(i).tFunction.get(j).st1 + " -> " + tm.transitionFunction.get(i).tFunction.get(j).st2);
            }
        }
    }

    public void testInput(String in) {

        currentState = tm.initialState;
        /*for(int i = 0; i < in.length(); i++) {
            char head = in.charAt(i); // Caractede no cabeçote
            for(int j = 0; j < tm.transitionFunction.get(i).tFunction.size(); j++) {
                if(head == tm.transitionFunction.get(i).tFunction.get(j).arg1) {
                    currentState = tm.transitionFunction.get(i).tFunction.get(j).st2;
                }
                else {
                    break;
                }
            }

        }*/
        if(currentState.equals(tm.acceptanceState)) {
            System.out.println("Entrada aceita!");

        } else {
            System.out.println("Entrada rejeitada!");
        }

    }

}
