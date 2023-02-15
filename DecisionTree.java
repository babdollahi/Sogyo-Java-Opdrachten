import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class  DecisionTree 
{
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException 
	{
        //Definening variables
        int idInt;

        //Difening lists
		ArrayList<String> lines = new ArrayList<String>();
        List<Integer> listNodeId = new ArrayList<Integer>();

        //Difening maps
		Map<Integer, String> node = new HashMap<Integer, String>();
		Map<String, String> left = new HashMap<String, String>();
		Map<String, String> right = new HashMap<String, String>();
		Map<String, String> leaf = new HashMap<String, String>();

        //Reading the file
		Scanner s = new Scanner(new File("/home/banafsheh/Learning/Java/decision-tree-data.txt")).useDelimiter(Pattern.compile("(\\n)"));

		// Read the file line by line 
		while(s.hasNextLine())
		{
			String infix = s.next();
			lines.add(infix.trim());
		}
		
		for (int i = 0; i < lines.size();i++) 
	      { 	
			String str = lines.get(i);

			//If the line ends with ?, this line is a node line, extract node id and question
			if (String.valueOf(str.charAt(str.length() - 1)).equals("?"))
			{
				idInt = Character.getNumericValue(str.charAt(1));
                listNodeId.add(idInt);
				String questionNode = str.split(",")[1];
				node.put(idInt, questionNode.trim());
			}
            //If the line ends with Nee, this line is a left edge line, extract ids
			else if (str.endsWith("Nee"))
			{
				String whatConnectedLeft = str.split(",")[0];
				String leftEdge = str.split(",")[1];
				left.put(whatConnectedLeft.trim(), leftEdge.trim());
			}
            //If the line ends with Ja, this line is a left edge line, extract ids
			else if (str.endsWith("Ja"))
			{
				String whatConnectedRight = str.split(",")[0];
				String rightEdge = str.split(",")[1];
				right.put(whatConnectedRight.trim(), rightEdge.trim());
			}
			else 
            //If not a bove, this line is a leaf, extract leaf id and its value
			{
				String leafId = str.split(",")[0];
				String leafValue = str.split(",")[1];
				leaf.put(leafId.trim(), leafValue.trim());

			}

		}   

        //Sort node ids to start from the root
        Collections.sort(listNodeId);
        //Printing the tree
        for (int i = 0; i < listNodeId.size(); i++) 
        {
            System.out.println("*************** Start Node **************");
            String nodeId = "N" + String.valueOf(listNodeId.get(i));
            System.out.println("Node ID : " + nodeId);
            System.out.println("Node question : " + node.get(listNodeId.get(i)));
            System.out.println("Node left child ID : " + left.get(nodeId));
            System.out.println("Leaf at left: " + leaf.get(right.get(nodeId)));
            System.out.println("Node right child ID : " + right.get(nodeId));
            System.out.println("Leaf at right: " + leaf.get(left.get(nodeId)));
            System.out.println("*************** End Node ****************");
        }
    }
}

