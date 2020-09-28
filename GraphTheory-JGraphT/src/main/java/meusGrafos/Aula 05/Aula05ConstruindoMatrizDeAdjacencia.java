package meusGrafos;

import java.util.Iterator;

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

public class Aula05ConstruindoMatrizDeAdjacencia {

	public static void main(String[] args) {
		
		Graph<DefaultVertex,RelationshipEdge> pseudoGraph = 
				new Pseudograph<DefaultVertex, RelationshipEdge> (
						VertexEdgeUtil.createDefaultVertexSupplier(), 
						VertexEdgeUtil.createRelationshipEdgeSupplier(), false);
		
		
		ImportUtil.importGraphGML(pseudoGraph, "./src/main/java/graphs/pseudograph-Aula02.gml");
		
		Graph<DefaultVertex, DefaultEdge> simpleGraph = new SimpleGraph<> (VertexEdgeUtil.createDefaultVertexSupplier(),
				SupplierUtil.createDefaultEdgeSupplier(),false);
		
		ImportUtil.importDefaultGraphGML(simpleGraph, "./src/main/java/graphs/cycle5.gml");
		
		PrintUtil.printGraph(pseudoGraph);
		
		Iterator<DefaultVertex> it1 = pseudoGraph.vertexSet().iterator();
		
		System.out.print("    ");
		while(it1.hasNext()) {
			
			DefaultVertex v1 = it1.next();
			
			System.out.print(v1.toString()+ "  ");
		}
		
		Iterator<DefaultVertex> it2 = pseudoGraph.vertexSet().iterator();
		System.out.println("\n");
		
		while(it2.hasNext()) {
			DefaultVertex v2 = it2.next();
			
			System.out.print(v2.toString() );
			
			Iterator<DefaultVertex> it3 = pseudoGraph.vertexSet().iterator();
			
			System.out.print("   ");
			while(it3.hasNext()) {
				DefaultVertex v3 = it3.next();
				
				if(v2.equals(v3)) {
					
					System.out.print((pseudoGraph.getAllEdges(v2, v3).size() *2) + "  ");
					
				} else {
				
				System.out.print(pseudoGraph.getAllEdges(v2, v3).size() + "  ");
				}
				
				
			}
			
			System.out.println("\n");
			
		}
		
		
		
		
		PrintUtil.printGraph(simpleGraph);
		
		Iterator<DefaultVertex> it4 = simpleGraph.vertexSet().iterator();
		
		System.out.print("    ");
		while(it4.hasNext()) {
			DefaultVertex v4 = it4.next();
			
			System.out.print(v4.toString()+ "  ");
		}
		
		Iterator<DefaultVertex> it5 = simpleGraph.vertexSet().iterator();
		System.out.println("\n");
		
		while(it5.hasNext()) {
			DefaultVertex v5 = it5.next();
			
			System.out.print(v5.toString() );
			
			Iterator<DefaultVertex> it6 = simpleGraph.vertexSet().iterator();
			
			System.out.print("   ");
			
			while(it6.hasNext()) {
				DefaultVertex v6 = it6.next();
				
				System.out.print(simpleGraph.getAllEdges(v5, v6).size() + "  ");
				
				
			}
			
			System.out.println("\n");
			
		}
		
	}
}
