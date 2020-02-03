import java.io.IOException;

// Klasse zum erstellen eines Graphen aus der input.txt
public class GraphFactory 
{
	static String[][] fetchedInputLines;
	
	public static Graph createGraph() throws IOException
	{
		fetchedInputLines = InputDataParser.getFetchedInputData();
		
		Graph graph = new Graph(getHighestNodeIndex()+1);
        
        for(String[] line: fetchedInputLines)
        {
       	 	graph.addEdge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
        
        return graph;
	}
	
	public static int getHighestNodeIndex()
	{
		 int highest_edge_index = 0;
	        
	     for(String[] line: fetchedInputLines)
	     {
	       	 if(highest_edge_index < Integer.parseInt(line[0]))
	       		 highest_edge_index = Integer.parseInt(line[0]);
	       	 
	       	 if(highest_edge_index < Integer.parseInt(line[1]))
	       		 highest_edge_index = Integer.parseInt(line[1]);
	     }
	     
	     return highest_edge_index;
	}

}
