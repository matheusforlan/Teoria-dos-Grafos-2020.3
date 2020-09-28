package meusGrafos;

import java.util.Scanner;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.YenKShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.util.SupplierUtil;

import util.DefaultVertex;
import util.ImportUtil;
import util.VertexEdgeUtil;

public class Aula05RedeDeAmigos {
	
	public static void main(String[] args) {
		
		Graph<DefaultVertex, DefaultEdge> graph = 
				new SimpleGraph <> (VertexEdgeUtil.createDefaultVertexSupplier(), 
						            SupplierUtil.createDefaultEdgeSupplier(), false);
		
		ImportUtil.importGraphCSV(graph, "./src/main/java/graphs/amigos.csv",
				 CSVFormat.EDGE_LIST);
		
		System.out.println("Vertices: " + graph.vertexSet());
		System.out.println("Arestas: " + graph.edgeSet());
		
		Scanner sc = new Scanner(System.in);
		String nome1 = sc.nextLine();
		String nome2 = sc.nextLine();
		
		DefaultVertex verticeNome1 = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), nome1);
		DefaultVertex verticeNome2 = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), nome2);
		
		if( (verticeNome1 == null) && (verticeNome2 == null)) {
			System.out.println(nome1 + " e " + nome2 + " não fazem parte da rede");
		} 
		 else if((verticeNome1 == null)) {
			System.out.println(nome1 + " não faz parte da rede");
		} 
		 else if((verticeNome2 == null)) {
			 System.out.println(nome2 + " não faz parte da rede");
		}
		
		 else {
			 
			 DefaultEdge e = graph.getEdge(verticeNome1, verticeNome2);
			 if( e != null) {  
				 System.out.println(nome1 + " e "+ nome2 +" são amigos diretos" );
			 }
			 
			 ConnectivityInspector conectividade = new ConnectivityInspector(graph);
			 
			 if(!(conectividade.pathExists(verticeNome1, verticeNome2))){  // se não existe caminho entre os 2 vértices
				 System.out.println("Não é possível se conhecerem");
			 }
			 else {
				 
				 Set <DefaultVertex> V = graph.vertexSet();
				 YenKShortestPath <DefaultVertex, DefaultEdge> yenk = 
						new YenKShortestPath <> (graph);
				DefaultVertex v1 = VertexEdgeUtil.getVertexfromLabel(V, nome1);
				DefaultVertex v2 = VertexEdgeUtil.getVertexfromLabel(V, nome2);
				System.out.println("Podem se conhecer através dessas conexões: " + yenk.getPaths(v1, v2, 1));
				 
			 }
			 
			  
		 }
		
		
		
		
	}
}
