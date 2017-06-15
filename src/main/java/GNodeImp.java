import java.util.*;

public class GNodeImp implements GNode
{
	String name;
    GNode children[];
    
    GNodeImp(String name)
    {
    	this.name = name;
    	children = new GNode[0];
    }
    
    public void setChildren(GNode[] childArr)
    {
    	children = childArr;
    }

	public String getName() {
		return name;
	}

	public GNode[] getChildren() {   
		   return children;
	}
  
}
