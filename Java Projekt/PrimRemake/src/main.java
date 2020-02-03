import java.io.*;
import java.util.*;

public class main 
{
	
	public static void main (String[] args) throws IOException
	{
		//InputDataGenerator.generateInputDataImproved(100, 1000, 500);
		
		// Erzeuge den Graph aus der input.txt und erzeuge den MST mit dem alten und dem verbesserten Algorithmus
		Graph rawInputData = GraphFactory.createGraph();
		System.out.println("Old Algorithm");
		long start = System.currentTimeMillis();
		Graph result = OldMstBuilder.DoThePrim(rawInputData,0);
		long end = System.currentTimeMillis() - start;
		System.out.println("DOTHEPRIM   Old: ");
		System.out.println("VERTEX: " + (rawInputData.getSize()-1)+ " | EDGES: " + rawInputData.getAmountofEdges() + " | TIME: " + Long.toString(end));
		
		System.out.println();
		
		System.out.println("Improved Algorithm");
		start = System.currentTimeMillis();
		result = ImprovedMstBuilder.DoThePrim(rawInputData,0);
		end = System.currentTimeMillis() - start;
		System.out.println("DOTHEPRIM   Improved: ");
		System.out.println("VERTEX: " + (rawInputData.getSize()-1)+ " | EDGES: " + rawInputData.getAmountofEdges() + " | TIME: " + Long.toString(end));
		
		System.out.println();
		
		System.out.println(result);
	}
	
}