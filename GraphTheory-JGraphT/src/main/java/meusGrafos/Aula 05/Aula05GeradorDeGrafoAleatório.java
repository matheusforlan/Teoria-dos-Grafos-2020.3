package meusGrafos;

import java.util.Scanner;

import org.jgrapht.Graph;
import org.jgrapht.generate.RandomRegularGraphGenerator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.SupplierUtil;

import util.DefaultVertex;
import util.ExportUtil;
import util.PrintUtil;
import util.VertexEdgeUtil;

public class Aula05GeradorDeGrafoAleatório {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Integer vertices = sc.nextInt();
		Integer grau = sc.nextInt();
		
		Graph<DefaultVertex, DefaultEdge> graph = 
				new SimpleGraph<>(
						VertexEdgeUtil.createDefaultVertexSupplier(), 
						SupplierUtil.createDefaultEdgeSupplier(), false);
		
		RandomRegularGraphGenerator<DefaultVertex, DefaultEdge> gerador = new RandomRegularGraphGenerator<>(vertices,grau);
		
		gerador.generateGraph(graph);
		
		PrintUtil.printGraph(graph);
		
		ExportUtil.exportDefaultGML(graph, "./src/main/java/graphs/3-regular-Forlan.gml");
		
		
	}
}
