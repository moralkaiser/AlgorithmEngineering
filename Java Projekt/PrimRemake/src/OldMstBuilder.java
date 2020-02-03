
import java.util.*;

class OldMstBuilder
{

    public static Graph DoThePrim(Graph input_graph)
    {
        return DoThePrim(input_graph, 0);
    }

    public static Graph DoThePrim(Graph input_graph, int root)
    {
    	// Wenn kein Startknoten ausgewählt wurde, so wähle den 1.Knoten des Graphen, Index 0
        if (root > input_graph.getSize() - 1)
        {
            root = 0;
        }
        // Graph der zurückgegeben wird (MST)
        Graph output_graph = new Graph(input_graph.getSize());
        // Liste mit bereits zum MST hinzugefügten Knoten
        List<Integer> usedNodes = new LinkedList<Integer>();
        
        usedNodes.add(root);
        
        // Liste mit allen Möglichen Kanten des MST (Warteschlange)
        List<int[]> possibleEdges = new LinkedList<int[]>();
        
        // Sortierte Liste der Kanten entsprechend sortiert nach Gewicht
        List<int[]> sortedEdges;

        // Ist der MST schon zusammenhängend = vollständig?
        while (!output_graph.isGraphConnected())
        {
        	// Formatiere die Warteschlange
            possibleEdges.clear();
            
            // Durchlaufe alle bereits zum MST hinzugefügten Knoten ...
            for (Integer node : usedNodes)
            {
            	// ... betrachte jeweils deren Kanten ...
                for (Edge e : input_graph.getEdges(node))
                {
                	// Falls sich der Zielknoten der betrachteten Kante nicht schon im MST befindet...
                    if (!usedNodes.contains(e.getVertex()))
                    {
                    	// Lege ein Temporäres Datenformat an (Startknoten,Endknoten,Gewicht)
                        int[] newEdge =
                        {
                            node, e.getVertex(), e.getWeight()
                        };
                        // Füge dieses Datenformat zur Warteschlange
                        possibleEdges.add(newEdge);
                    }
                }
            }
            
            // Hole Kante mit kleinstem Gewicht aus Warteschlange
            sortedEdges = getLowestEdge(possibleEdges);

            usedNodes.add(sortedEdges.get(0)[1]);
            // Füge die Kante zum MST
            output_graph.addEdge(sortedEdges.get(0)[0], sortedEdges.get(0)[1], sortedEdges.get(0)[2]);
            output_graph.addEdge(sortedEdges.get(0)[1], sortedEdges.get(0)[0], sortedEdges.get(0)[2]);

        }

        return output_graph;
    }

    public static List<int[]> getLowestEdge(List<int[]> edgeList)
    {
        List<int[]> sortedEdges = new LinkedList<int[]>();
        int lowest_wheight = Integer.MAX_VALUE;
        int lowest_wheight_index = Integer.MAX_VALUE;
        int counter = 0;

        for (int i[] : edgeList)
        {
            if (lowest_wheight > i[2])
            {
                lowest_wheight = i[2];
                lowest_wheight_index = counter;
            }

            counter++;
        }

        sortedEdges.add(edgeList.get(lowest_wheight_index));;
        return sortedEdges;
    }
    
    public static Graph logTime(Graph g_in)
    {
        long start = System.currentTimeMillis();
            Graph returnGraph = DoThePrim(g_in,0);
	long end = System.currentTimeMillis() - start;
	System.out.println("DOTHEPRIM_Old: ");
	System.out.println("VERTEX: " + (g_in.getSize()-1)+ " | EDGES: " + g_in.getAmountofEdges() + " | TIME: " + Long.toString(end));
        
        return returnGraph;
    }
}
