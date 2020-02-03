import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class InputDataGenerator 
{
	public static void generateInputDataImproved(int edgespernode, int nodes, int maxweight) throws IOException
	{
		FileOutputStream out = new FileOutputStream("input.txt");
		
		List<Integer> usedNodeIndexes = new LinkedList<Integer>();
		try 
		{ 
	        for(int i = 0; i <= nodes; i++)
	 		{
	        	int edgesAmount = edgespernode;
	        	int index_while = 0;
	        	while(index_while <= edgesAmount)
	        	{
	        		if(!usedNodeIndexes.contains(i))
		 				usedNodeIndexes.add(i);
		 			
		 			int v = (int)(Math.floor(Math.random()*nodes));
		 			
		 			if(!usedNodeIndexes.contains(v))
		 				usedNodeIndexes.add(v);
		 			
		 			int w = (int)(Math.floor(Math.random()*maxweight))+1;
		 			out.write(("" + i + " " + v + " " + + w + "\n").getBytes());
		 			out.write(("" + v + " " + i + " " + + w + "\n").getBytes());
		 			
		 			index_while++;
	        	}
	 			
	 		}
	        
	        for(int i = 0; i <= nodes; i++)
	        {
	        	if(!usedNodeIndexes.contains(i))
	        	{
	        		System.out.println(i);
	        	}
	        }
	         
	     }finally 
		 {
	         if (out != null) 
	         {
	            out.close();
	         }
	     }
	}
	
}
