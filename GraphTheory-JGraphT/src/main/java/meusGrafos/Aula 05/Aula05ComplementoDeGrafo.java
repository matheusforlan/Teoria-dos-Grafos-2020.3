package meusGrafos;

import org.jgrapht.Graph;
import org.jgrapht.generate.ComplementGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.SupplierUtil;

import util.DefaultVertex;
import util.ImportUtil;
import util.PrintUtil;
import util.RelationshipEdge;
import util.VertexEdgeUtil;

public class Aula05ComplementoDeGrafo {
	
	public static void main(String[] args) {
		
		Graph<DefaultVertex, DefaultEdge> cycle5Graph = new SimpleGraph<> (VertexEdgeUtil.createDefaultVertexSupplier(),
				SupplierUtil.createDefaultEdgeSupplier(),false);
		
		ImportUtil.importDefaultGraphGML(cycle5Graph, "./src/main/java/graphs/cycle5.gml");
		
		PrintUtil.printGraph(cycle5Graph);
		
		ComplementGraphGenerator<DefaultVertex, DefaultEdge> complementCycle5 = new ComplementGraphGenerator<>(cycle5Graph);
		
		complementCycle5.generateGraph(cycle5Graph);
		
		PrintUtil.printGraph(cycle5Graph);
		
		
		Graph<DefaultVertex, DefaultEdge> k5Graph = new SimpleGraph<> (VertexEdgeUtil.createDefaultVertexSupplier(),
				SupplierUtil.createDefaultEdgeSupplier(),false);
		
		ImportUtil.importDefaultGraphGML(k5Graph, "./src/main/java/graphs/K5.gml");
		
		PrintUtil.printGraph(k5Graph);
		
		ComplementGraphGenerator<DefaultVertex, DefaultEdge> complementK5 = new ComplementGraphGenerator<>(k5Graph);
		
		complementK5.generateGraph(k5Graph);
		PrintUtil.printGraph(k5Graph);
		
		 
	}
}
