package meusGrafos;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.SupplierUtil;

import util.DefaultVertex;
import util.ImportUtil;
import util.PrintUtil;
import util.RelationshipEdge;
import util.VertexEdgeUtil;

public class Aula03ImportandoCuboGML {
	
	public static void main(String[] args) {
		
		Graph<DefaultVertex, RelationshipEdge> graphCubo = 
				new Pseudograph<DefaultVertex, RelationshipEdge>(
						VertexEdgeUtil.createDefaultVertexSupplier(), 
						VertexEdgeUtil.createRelationshipEdgeSupplier(), false);
		
		ImportUtil.importGraphGML(graphCubo, "./src/main/java/graphs/cubo.gml");

		PrintUtil.printGraph(graphCubo);

		
		
	}

}
