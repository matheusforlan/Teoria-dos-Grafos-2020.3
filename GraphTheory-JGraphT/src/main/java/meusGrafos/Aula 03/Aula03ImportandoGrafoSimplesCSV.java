package meusGrafos;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.util.SupplierUtil;

import util.DefaultVertex;
import util.ImportUtil;
import util.VertexEdgeUtil;

public class Aula03ImportandoGrafoSimplesCSV {
	
	public static void main(String[] args) {
		
		Graph<DefaultVertex, DefaultEdge> graph = 
				new SimpleGraph <> (VertexEdgeUtil.createDefaultVertexSupplier(), 
						            SupplierUtil.createDefaultEdgeSupplier(), false);
		
		ImportUtil.importGraphCSV(graph, "./src/main/java/graphs/5-3regular.csv",
				 CSVFormat.MATRIX, false, false, true);
		
		
		System.out.println("Vertices: " + graph.vertexSet());
		System.out.println("Arestas: " + graph.edgeSet());
		
		
	}

}
