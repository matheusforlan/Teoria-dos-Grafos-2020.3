package meusGrafos;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;
import org.jgrapht.graph.SimpleGraph;

import util.RelationshipEdge;

public class Aula03GrafoSimples {
	
	public static void main(String[] args) {
		
		
		Graph<String, DefaultEdge> graph = new SimpleGraph <String, DefaultEdge> (DefaultEdge.class);
		
		graph.addVertex("a");
		graph.addVertex("b");
		graph.addVertex("c");
		graph.addVertex("d");
		graph.addVertex("e");
		graph.addVertex("f");
		
		graph.addEdge("a", "b");
		graph.addEdge("b", "d");
		graph.addEdge("d", "f");
		graph.addEdge("e", "f");
		graph.addEdge("c", "e");
		graph.addEdge("c", "a");
		
		System.out.println(graph.edgeSet());
		System.out.println(graph.vertexSet());
		
		System.out.println(graph.degreeOf("a"));
		System.out.println(graph.edgesOf("a"));
							
	}

}
