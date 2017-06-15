import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GraphPathsTest {

	GraphPaths gpObj;
	
	GNodeImp A,B,C,D,E,F,G,H,I,J;
	
	@Before
	public void setUp() throws Exception {
		
		gpObj = new GraphPaths();
		
		A = new GNodeImp("A");
		B = new GNodeImp("B");
		C = new GNodeImp("C");
		D = new GNodeImp("D");
		E = new GNodeImp("E");
		F = new GNodeImp("F");
		G = new GNodeImp("G");
		H = new GNodeImp("H");
		I = new GNodeImp("I");
		J = new GNodeImp("J");
		
		//build a graph from the nodes						
		A.setChildren(new GNode[]{B,C,D});
		B.setChildren(new GNode[]{E,F});
		C.setChildren(new GNode[]{G,H,I});
		D.setChildren(new GNode[]{J});			
	}

	@Test
	public void walkGraphMainTest() {
		
		List<GNode> expectedresult1 = new ArrayList<GNode>();
		expectedresult1.add(A);expectedresult1.add(B);expectedresult1.add(C);expectedresult1.add(D);
		expectedresult1.add(E);expectedresult1.add(F);expectedresult1.add(G);expectedresult1.add(H);
		expectedresult1.add(I);expectedresult1.add(J);
		
		List<GNode> actuallist = gpObj.walkGraph(A);
		
		//check the result size
		assertEquals(expectedresult1.size(), actuallist.size());
		
		// compare 2 lists
		actuallist.removeAll(expectedresult1);
		
		assertEquals(0, actuallist.size());
		
	}
	
	@Test
	public void walkGraphThreeNodeTest() { 
		//check for 3 node graph starting at B.
		List<GNode> actuallist = gpObj.walkGraph(B);
		List<GNode> expectedNodes = new ArrayList<GNode>();
		
		expectedNodes.add(B);
		expectedNodes.add(E);
		expectedNodes.add(F);
		
		//check the result size
		assertEquals(expectedNodes.size(), actuallist.size());
		
		//This is one way to compare 2 lists
		actuallist.removeAll(expectedNodes);
		
		assertEquals(0, actuallist.size());
		
	}

	@Test
	public void walkGraphTwoNodeTest() { 
		//check for 2 node graph starting at D.
		List<GNode> actuallist = gpObj.walkGraph(D);
		List<GNode> expectedNodes = new ArrayList<GNode>();
		
		expectedNodes.add(D);
		expectedNodes.add(J);
		
		//check the result size
		assertEquals(expectedNodes.size(), actuallist.size());
		
		//This is one way to compare 2 lists
		actuallist.removeAll(expectedNodes);
		
		assertEquals(0, actuallist.size());
		
	}
	
	@Test
	public void walkGraphOneNodeTest() { 
		//check for 1 node graph starting at J.
		List<GNode> actuallist = gpObj.walkGraph(J);
		
		//check the result size
		assertEquals(1, actuallist.size());
		
		assertEquals(J, actuallist.get(0));
		
	}
	
	@Test
	public void walkGraphNullTest() { 
		//Null input should return an empty list
		List<GNode> actuallist = gpObj.walkGraph(null);
		
		//check the result size
		assertEquals(0, actuallist.size());
		
	}
	
	@Test
	public void pathsMainTest() {
		
		List<List<GNode>> expectedList = new ArrayList<>();
		expectedList.add(Arrays.asList(A,B,E));
		expectedList.add(Arrays.asList(A,B,F));
		expectedList.add(Arrays.asList(A,C,G));
		expectedList.add(Arrays.asList(A,C,H));
		expectedList.add(Arrays.asList(A,C,I));
		expectedList.add(Arrays.asList(A,D,J));
		
		
		//Null input should return an empty list
		List<ArrayList<GNode>> actuallist = gpObj.paths(A);
		
		//check the result size
		assertEquals(expectedList.size(), actuallist.size());
				
		//This is one way to compare 2 lists
		actuallist.removeAll(expectedList);
				
		//check the result size
		assertEquals(0, actuallist.size());
		
	}
	
	@Test
	public void pathsThreeNodeTest() {
		
		List<List<GNode>> expectedList = new ArrayList<>();
		expectedList.add(Arrays.asList(B,E));
		expectedList.add(Arrays.asList(B,F));
		
		//Null input should return an empty list
		List<ArrayList<GNode>> actuallist = gpObj.paths(B);
		
		//check the result size
		assertEquals(expectedList.size(), actuallist.size());
				
		//This is one way to compare 2 lists
		actuallist.removeAll(expectedList);
				
		//check the result size
		assertEquals(0, actuallist.size());
		
	}
	
	@Test
	public void pathsTwoNodeTest() {
		
		List<List<GNode>> expectedList = new ArrayList<>();
		expectedList.add(Arrays.asList(D,J));
		
		//Null input should return an empty list
		List<ArrayList<GNode>> actuallist = gpObj.paths(D);
		
		//check the result size
		assertEquals(expectedList.size(), actuallist.size());
				
		//This is one way to compare 2 lists
		actuallist.removeAll(expectedList);
				
		//check the result size
		assertEquals(0, actuallist.size());
		
	}
	
	@Test
	//Assuming Graph with a Single Node returns itself
	public void pathsOneNodeTest() {
		
		List<List<GNode>> expectedList = new ArrayList<>();
		expectedList.add(Arrays.asList(J));
		
		//Null input should return an empty list
		List<ArrayList<GNode>> actuallist = gpObj.paths(J);
		
		//check the result size
		assertEquals(expectedList.size(), actuallist.size());
				
		//This is one way to compare 2 lists
		actuallist.removeAll(expectedList);
				
		//check the result size
		assertEquals(0, actuallist.size());
				
	}
	
	@Test
	public void pathsNullTest() {
		//Null input should return an empty list
		List<ArrayList<GNode>> actuallist = gpObj.paths(null);
		
		//check the result size
		assertEquals(0, actuallist.size());
		
	}
}
