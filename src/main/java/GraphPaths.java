import java.util.*;

public class GraphPaths {

	public ArrayList<GNode> walkGraph(GNode start)
	{
		//Perform a DFS
		
		ArrayList<GNode> visited = new ArrayList<GNode>();
		
		if(start == null)
			return visited;
		
		Stack<GNode> stack = new Stack<GNode>();
		
		stack.push(start);
		visited.add(start);
		
		while(!stack.isEmpty())
		{
			GNode node = stack.peek();
			GNode[] children = node.getChildren();
			GNode nextChild = null;
			
			for(int i=0 ; i < children.length; i++)
			{
				if(!visited.contains(children[i]))
						{
					        nextChild =  children[i];
					        stack.push(nextChild);
					        visited.add(nextChild);
					        break;
						}
			}
			
			if(nextChild == null) 
		       stack.pop();
			
		}
		
		
		return visited;
	}
	
	public List<ArrayList<GNode>> paths(GNode start)
	{
		//Perform a DFS

		Set<GNode> visited = new HashSet<GNode>();
		List<ArrayList<GNode>> result = new ArrayList<ArrayList<GNode>>();
         	
		if(start == null) return result;
		
		Stack<GNode> stack = new Stack<GNode>();
		
		stack.push(start);
		visited.add(start);
		
		while(!stack.isEmpty())
		{
			GNode node = stack.peek();
			GNode[] children = node.getChildren();
			GNode nextChild = null;
			
			//this indicates a leaf node(end of path) in case of a acyclic graph
			if(children.length ==0)
			{
			 	result.add(new ArrayList<GNode>(stack));
			}
			else
			{
			  for(int i=0 ; i < children.length; i++)
			   {
				if(!visited.contains(children[i]))
						{
					        nextChild =  children[i];
					        stack.push(nextChild);
					        visited.add(nextChild);
					        break;
						}
			   }
			}
			
			if(nextChild == null) 
		       stack.pop();
			
		}
		
		
		return result;
	}
}
