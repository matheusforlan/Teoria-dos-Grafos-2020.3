package epgs;

//Teoria dos Grafos - UFCG
//JGraphT EX05


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.YenKShortestPath;
import org.jgrapht.alg.shortestpath.YenShortestPathIterator;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.GraphWalk;
import org.jgrapht.graph.WeightedMultigraph;

import util.DefaultVertex;
import util.ImportUtil;
import util.RelationshipWeightedEdge;
import util.VertexEdgeUtil;

public class EPG01LondonUnderground {
	
	Graph<DefaultVertex, RelationshipWeightedEdge> graph;
	GraphPath <DefaultVertex, RelationshipWeightedEdge> emptyPath;
	
	// Constructor
	public EPG01LondonUnderground () {
		graph = new WeightedMultigraph <> (VertexEdgeUtil.createDefaultVertexSupplier(), 
	            VertexEdgeUtil.createRelationshipWeightedEdgeSupplier());
		ImportUtil.importGraphMultipleCSV(graph, 
				"graphs/london.stations.csv","id","name",
				"graphs/london.connections.csv","station1", "station2", "time", false, true);
 emptyPath = new GraphWalk <> (graph,new ArrayList <DefaultVertex> (), 0.0);
 // Complemente este construtor se necessário
	}
	
	// get methods
	public Graph<DefaultVertex, RelationshipWeightedEdge> getGraph () {
		return graph;
	}

	// Estações Centrais
	public List <DefaultVertex> centralKStations (int k) {
		List <DefaultVertex> temp = new ArrayList<>(graph.vertexSet());
		List <DefaultVertex> result = new ArrayList<>();
		DegreeComparator comparator = new DegreeComparator(graph);
		Collections.sort(temp, comparator);
		Collections.reverse(temp);
		 for ( int i = 0 ; i < k ; i++) {
			 result.add(temp.get(i));
		 }
		
		 return result;
	}
	
	// Menor Trajeto de Trem entre duas Estações
	public GraphPath <DefaultVertex, RelationshipWeightedEdge> shortestPath (String source, String sink) {
 
	 DefaultVertex vsource = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), source);
	
	 DefaultVertex vsink = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), sink);
	
	 YenKShortestPath <DefaultVertex, RelationshipWeightedEdge> yenk = 
					new YenKShortestPath <> (graph);
	
	
			if (vsource == null || vsink == null){
	   return emptyPath;
	 } 
	
	 return yenk.getPaths(vsource, vsink, 1).get(0);
		}
	
	// Troca de Linhas em um Trajeto
	public List <Pair<String,RelationshipWeightedEdge>> changeofLines 
						(GraphPath <DefaultVertex, RelationshipWeightedEdge> path) {
	 List<RelationshipWeightedEdge>  edgeList = path.getEdgeList();
	
	 List<Pair<String, RelationshipWeightedEdge>> result = new ArrayList<>();
	 String previousLine = null;
	
	for (RelationshipWeightedEdge e : edgeList) {
	 String line = e.getAtt("line").toString();
	 if (line.equals(previousLine)) {
	   continue;
	 }
	 
	 Pair<String, RelationshipWeightedEdge> pair = new Pair<>(line,e);
	
	 result.add(pair);
	
	 previousLine = line;
	
	}
	
	 return result;
			
		}
	
	// Menor Trajeto entre duas Estações sem usar Trens de uma Linha
	public GraphPath <DefaultVertex, RelationshipWeightedEdge> shortestPathDropLine 
			(String line, String source, String sink, int maxsteps) {
     
	
	 DefaultVertex vsource = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), source);
	
	 DefaultVertex vsink = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), sink);
	
	 YenShortestPathIterator <DefaultVertex, RelationshipWeightedEdge> yenI = 
					new YenShortestPathIterator <> (graph, vsource,vsink);
	     int cont = 0;
	     
	     
	     GraphPath<DefaultVertex,RelationshipWeightedEdge> result = emptyPath;
	 
	
	    while (yenI.hasNext() &&  cont < maxsteps) {
	      boolean achou = true;
	      
	      GraphPath<DefaultVertex,RelationshipWeightedEdge> path = yenI.next();
	
	      for(RelationshipWeightedEdge e : path.getEdgeList()) {
	        if (e.getAtt("line").toString().equals(line)) {
	          achou = false;
	          break;
	        }
	         
	     
	      }
	      if (achou){
	        result = path;
	        break;
	      }
	      cont++;
	
	    } 
			
			return result;
		}
															
}


