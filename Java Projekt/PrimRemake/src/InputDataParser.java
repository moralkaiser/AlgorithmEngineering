import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InputDataParser 
{
	static FileInputStream in = null;
	
	public static String[][] getFetchedInputData() throws IOException
	{
		 try 
		 {
	         in = new FileInputStream("input.txt");
	         
	         String rawWeightedEdgeGraphArrayString = convertStreamToString(in);
	        
	         return splitByTabs(splitByReturn(rawWeightedEdgeGraphArrayString));
	         
	     }finally 
		 {
	         if (in != null) 
	         {
	            in.close();
	         }
	      }
	}
	
	public static void TMPgetTheData() throws FileNotFoundException
	{
		FileInputStream in = new FileInputStream("output.txt");
		
		String output_line = convertStreamToString(in);
		
		String[] parts = output_line.split("[,]");
		
		System.out.println(output_line.length());
	}
	
	public static String convertStreamToString() throws FileNotFoundException
	{
		 in = new FileInputStream("input.txt");
         
		return convertStreamToString(in);
	}
	
	private static String convertStreamToString(InputStream in) 
	{
	    if (in == null) 
	    {
	        return "";
	    }

	    Scanner s = new Scanner(in);
	    s.useDelimiter("\\A");

	    String streamString = s.hasNext() ? s.next() : "";

	    s.close();

	    return streamString;
	}
	
	static String[] splitByReturn(String input_string)
	{
		List<String> stringlines = new LinkedList<String>();
		
		Scanner scanner = new Scanner(input_string);
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();

          stringlines.add(line);
          
        }
        scanner.close();
        
        String[] returnlines = new String[stringlines.size()];
        int index = 0;
        
        for(String line : stringlines)
        {
        	returnlines[index]= line;
        	index++;
        }
        
        return returnlines;
	}
	
	private static String[][] splitByTabs(String[] input_stringArray)
	{
		List<String[]> linesSeparatedByTabs = new LinkedList<String[]>();
		
		for(String line: input_stringArray)
	    {
	       	 String[] parts = line.split("[\t ]");
	       	 linesSeparatedByTabs.add(parts);
	    }
		
		String[][] returnArray = new String[linesSeparatedByTabs.size()][3];
		
		int indexLines = 0; 
		int indexTabs;
		
		 for(String[] line : linesSeparatedByTabs)
	     {
			indexTabs = 0;
	        for(String tab : line)
	        {
	        	returnArray[indexLines][indexTabs] = tab;
	        	indexTabs++;
	        }
	        
	        indexLines++;
	     }
		 
		 return returnArray;
	}
}
