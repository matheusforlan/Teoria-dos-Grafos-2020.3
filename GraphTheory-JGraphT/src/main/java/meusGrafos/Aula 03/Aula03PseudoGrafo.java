package meusGrafos;

import org.jgrapht.Graph;
import org.jgrapht.graph.Pseudograph;
import util.RelationshipEdge;

public class Aula03PseudoGrafo {
	
	public static void main(String[] args) {
		
		Graph<String, RelationshipEdge> graph = new Pseudograph<String, RelationshipEdge> (RelationshipEdge.class);
		
		graph.addVertex("a");
		graph.addVertex("b");
		graph.addVertex("c");
		graph.addVertex("d");
		graph.addVertex("e");
		
		graph.addEdge("a", "b", new RelationshipEdge("ab"));
		graph.addEdge("a", "d", new RelationshipEdge("ad"));
		graph.addEdge("b", "c", new RelationshipEdge("bc"));
		graph.addEdge("a", "a", new RelationshipEdge("aa"));
		graph.addEdge("b", "d", new RelationshipEdge("bd"));
		graph.addEdge("c", "d", new RelationshipEdge("cd1"));
		graph.addEdge("c", "d", new RelationshipEdge("cd2"));
		
		System.out.println(graph.edgeSet());
		System.out.println(graph.vertexSet());
		
		System.out.println(graph.degreeOf("a"));
		System.out.println(graph.edgesOf("a"));
		
	}

}
