package meusGrafos;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphTests;
import org.jgrapht.alg.partition.BipartitePartitioning;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Pseudograph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.SupplierUtil;



import util.DefaultVertex;
import util.ImportUtil;
import util.PrintUtil;
import util.RelationshipEdge;
import util.VertexEdgeUtil;

public class Aula05TestandoBiparticoes {
	
	
	public static void main(String[] args) {
		
		
		Graph<DefaultVertex, DefaultEdge> graphTwoCycles = 
				new SimpleGraph<>(
						VertexEdgeUtil.createDefaultVertexSupplier(), 
						SupplierUtil.createDefaultEdgeSupplier(), false);
		
		ImportUtil.importDefaultGraphGML(graphTwoCycles, "./src/main/java/graphs/twocycles.gml");
		PrintUtil.printGraph(graphTwoCycles);
		
		if(GraphTests.isBipartite(graphTwoCycles)) {
			verificaBiparticao(graphTwoCycles);
		}else {
			System.out.println("Não é bipartido");
		}
		
		System.out.println("-----------------------------");
		
		Graph<DefaultVertex, DefaultEdge> graphCycleNotSymple = 
				new SimpleGraph<>(
						VertexEdgeUtil.createDefaultVertexSupplier(), 
						SupplierUtil.createDefaultEdgeSupplier(), false);
		
		ImportUtil.importDefaultGraphGML(graphCycleNotSymple, "./src/main/java/graphs/cyclenotsymple.gml");
		PrintUtil.printGraph(graphCycleNotSymple);
		
		if(GraphTests.isBipartite(graphCycleNotSymple)) {
			verificaBiparticao(graphCycleNotSymple);
		}else {
			System.out.println("Não é bipartido");
		}
		
		System.out.println("-----------------------------");
		
		Graph<DefaultVertex, DefaultEdge> graphSimplePath5 = 
				new SimpleGraph<>(
						VertexEdgeUtil.createDefaultVertexSupplier(), 
						SupplierUtil.createDefaultEdgeSupplier(), false);
		
		ImportUtil.importDefaultGraphGML(graphSimplePath5, "./src/main/java/graphs/simplepath5.gml");
		PrintUtil.printGraph(graphSimplePath5);
		
		if(GraphTests.isBipartite(graphSimplePath5)) {
			verificaBiparticao(graphSimplePath5);
		}else {
			System.out.println("Não é bipartido");
		}
		
		System.out.println("-----------------------------");
		
		Graph<DefaultVertex, DefaultEdge> graphThreeCycles = 
				new SimpleGraph<>(
						VertexEdgeUtil.createDefaultVertexSupplier(), 
						SupplierUtil.createDefaultEdgeSupplier(), false);
		
		ImportUtil.importDefaultGraphGML(graphThreeCycles, "./src/main/java/graphs/threecycles.gml");
		
		PrintUtil.printGraph(graphThreeCycles);
		
		if(GraphTests.isBipartite(graphThreeCycles)) {
			verificaBiparticao(graphThreeCycles);
		}else {
			System.out.println("Não é bipartido");
		}
		
		System.out.println("-----------------------------");
		
		Graph<DefaultVertex, DefaultEdge> graphK3Mais1 = 
				new SimpleGraph<>(
						VertexEdgeUtil.createDefaultVertexSupplier(), 
						SupplierUtil.createDefaultEdgeSupplier(), false);
		
		ImportUtil.importDefaultGraphGML(graphK3Mais1, "./src/main/java/graphs/K3+1.gml");
		
		PrintUtil.printGraph(graphK3Mais1);
		
		if(GraphTests.isBipartite(graphK3Mais1)) {
			verificaBiparticao(graphK3Mais1);
		}else {
			System.out.println("Não é bipartido");
		}
		
		System.out.println("-----------------------------");
		
		
		
		
	}
	
	
	public static void verificaBiparticao(Graph<DefaultVertex, DefaultEdge> graph) {
		
		BipartitePartitioning<DefaultVertex,DefaultEdge> bp = new BipartitePartitioning<> (graph);
		
		 List <Set<DefaultVertex>> ps = bp.getPartitioning().getPartitions();
		
		 System.out.println(ps);
	}

}
