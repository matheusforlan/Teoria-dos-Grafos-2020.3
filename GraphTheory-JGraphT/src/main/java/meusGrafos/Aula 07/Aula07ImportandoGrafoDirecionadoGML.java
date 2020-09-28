package meusGrafos;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;

import util.DefaultVertex;
import util.ImportUtil;
import util.PrintUtil;
import util.RelationshipDirectedEdge;
import util.VertexEdgeUtil;

public class Aula07ImportandoGrafoDirecionadoGML {
	
	private static final String sep = System.getProperty("file.separator");
	// path do folder onde os grafos a serem carregados estão armazenados
	private static final String graphpathname = "." + sep + "src" + sep + "main" + sep +"java" + sep + "graphs" + sep;
	
	
	public static void main(String[] args) {
		
		DefaultDirectedGraph<DefaultVertex,RelationshipDirectedEdge> graph =
				new DefaultDirectedGraph<>(
				VertexEdgeUtil.createDefaultVertexSupplier(),
				VertexEdgeUtil.createRelationshipDirectedEdgeSupplier(),false);
		
		 ImportUtil.importDirectedGraphGML(graph , "./src/main/java/graphs/" + "strongly3.gml");    		
	       PrintUtil.printGraph(graph);
	       
	      
	       graph.vertexSet().stream().forEach(v -> { 
	        	System.out.println("Vértice " + v);
	        	System.out.print("Grau de Entrada: " + graph.inDegreeOf(v) + "|");      // grau de entrada
	        	System.out.print("Grau de Saída: " + graph.outDegreeOf(v) + "|");              // grau de saída
	        	System.out.print("Arcos onde é a cabeça: " + graph.incomingEdgesOf(v) + "|");    // arcos em que  é cabeça
	        	System.out.print("Arcos onde é a cauda: " + graph.outgoingEdgesOf(v) + "|");       // arcons em que é cauda
	        	System.out.print("Vizinhos de entrada: " + Graphs.predecessorListOf(graph,v) + "|");  // vizinhos de entrada
	        	System.out.println("Vizinhos de saída: " + Graphs.successorListOf(graph,v));         // vizinhos de saída
	       });
	       
		
		
		
	}

}
