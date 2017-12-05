import java.util.*;
import java.io.*;

public class DFSTree 
{
	private static int total = 0;
	private static File file = new File("DFSOut");
	private static PrintWriter output = null;
	
	public static void DFSSearch(AdjacencyList<String> t)throws FileNotFoundException
	{
		/*for(Vertex<String> v : t)
			if(v.name.equals("Grand Forks"))
				DFS(v);//Get Luke to explain Iterators*/
		output = new PrintWriter(file);
		t.setFlagsTo(false);
		DFS(t.find("Grand Forks"));
			
		printD(t);
		printB(t);
	}
	
	public static void DFS(Vertex start)
	{
		Edge edge = start.edges;
		Vertex other;
		while(edge!=null)
		{
			if(edge.start==start)
			{
				other = edge.end;
			}
			else
			{
				other = edge.start;
			}
			if(!other.flag)//Touched or non touched
			{
				other.flag = true;
				edge.type = "D";
				total += edge.weight;
				//Print traversal order
				output.println(other.toString());
				DFS(other);
				//output.println(other);
				edge = edge.next;
			}
			else{
				edge.type = "B";
			}
		}
	}
	
	public static void printD(AdjacencyList<String> t)
	{
		output.println("\n\nDirected Edges");
		for(Vertex<String> v : t)
		{
			for(Edge e : v)
			{
				if(e.type.equals("D"))
					output.println(e.toString());
				else if(e.type.equals("untouched"))
					output.println("ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR");
			}
		}
	}
	
	public static void printB(AdjacencyList<String> t)
	{
		output.println("\n\nBack Edges");
		for(Vertex<String> v : t)
		{
			for(Edge e : v)
			{
				if(e.type.equals("B"))
					output.println(e.toString());
				else if(e.type.equals("untouched"))
					output.println("ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR");
			}
		}
	}
}
