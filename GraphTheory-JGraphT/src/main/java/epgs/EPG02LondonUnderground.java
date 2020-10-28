// Teoria dos Grafos - UFCG

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.util.Pair;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.GraphWalk;
import org.jgrapht.graph.WeightedMultigraph;

import util.DefaultVertex;
import util.ImportUtil;
import util.RelationshipWeightedEdge;
import util.VertexEdgeUtil;

import org.jgrapht.GraphTests;


import org.jgrapht.alg.shortestpath.YenKShortestPath;
import org.jgrapht.alg.shortestpath.YenShortestPathIterator;

public class EPG02LondonUnderground {
	
	//private static final String NL = System.getProperty("line.separator");
	private static final String sep = System.getProperty("file.separator");
	// path do folder onde os grafos a serem carregados estão armazenados
	private static final String graphpathname = "graphs" + sep;
	private static final String datapathname = "datasets" + sep;
	
	Graph<DefaultVertex, RelationshipWeightedEdge> graph;
	Set <DefaultVertex> V;
	GraphPath <DefaultVertex, RelationshipWeightedEdge> emptyPath;	
	HashMap <String, DefaultVertex> attractions; 
	Set <RelationshipWeightedEdge> E;

	///////////////////////////////////////
	// Constructor
	public EPG02LondonUnderground () {
		graph = new WeightedMultigraph <> (VertexEdgeUtil.createDefaultVertexSupplier(), 
	            VertexEdgeUtil.createRelationshipWeightedEdgeSupplier());
		// Data from http://markdunne.github.io/2016/04/10/The-London-Tube-as-a-Graph/
		ImportUtil.importGraphMultipleCSV(graph, 
				graphpathname + "london.stations.csv","id","name",
				graphpathname + "london.connections.csv","station1", "station2", "time", false, true);
		V = graph.vertexSet();
		E = graph.edgeSet();
		emptyPath = new GraphWalk <> (graph,new ArrayList <DefaultVertex> (), 0.0);	
		readAttractions();
	}
	
	public void readAttractions () {
        String csvFile = datapathname + "london-attractions.csv";
        String line = "";
        String cvsSplitBy = ",";  
        attractions = new HashMap <> ();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] aline = line.split(cvsSplitBy);
                attractions.put(aline[0], VertexEdgeUtil.getVertexfromLabel(V, aline[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		Iterator <String> it = attractions.keySet().iterator();
        while (it.hasNext()) {
        	String n = it.next();
        	if (attractions.get(n) == null) {
        		System.out.println(n + "," + attractions.get(n));
        	}
        }
        
	}
	
	///////////////////////////////////////
	// get methods
	public Graph<DefaultVertex, RelationshipWeightedEdge> getGraph () {
		return graph;
	}
	
	public DefaultVertex getStation (String attraction) {
		return attractions.get(attraction);
	}
	
	public Set<String> getLines (GraphPath <DefaultVertex, RelationshipWeightedEdge> path) {
		Set<String> lines = new HashSet <> ();
		Iterator <RelationshipWeightedEdge> it = path.getEdgeList().iterator();
		while (it.hasNext()) {
			RelationshipWeightedEdge e = it.next();
			lines.add(e.getAtt("line").toString());
		}
		return lines;
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	// Métodos do EPG01 utilizados nos testes desta classe. Acrescente seu código
	
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
	
	/////////////////////////////////////////////////
	// Métodos a serem implementados no EPG02
	// Tempo Total Estimado de um Trajeto
	public double  estimatedTime (GraphPath <DefaultVertex, RelationshipWeightedEdge> p, double t) {
    
    double time = 0.0;
       
    List<RelationshipWeightedEdge>  edgeList = p.getEdgeList();

    for (RelationshipWeightedEdge e : edgeList){

      time += Double.parseDouble(e.getAtt("time").toString());
      
    }

    List<Pair<String,RelationshipWeightedEdge>> list = changeofLines(p);
    
    if (t > 0 ) {
    time += (list.size() * t);
    }

		return time;
	}
	
	// Menor Trajeto considerando Tempo Total Estimado
	public GraphPath <DefaultVertex, RelationshipWeightedEdge> shortestEstimatedPath 
				(String source, String sink, double t, int maxAttempts){
		
    
     GraphPath<DefaultVertex, RelationshipWeightedEdge> result = emptyPath;
     
	     DefaultVertex vsource = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(),source);
	
	    DefaultVertex vsink = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), sink);
	    
	    if(vsource != null) {
	
	      YenShortestPathIterator yenI = new YenShortestPathIterator(this.graph, vsource,vsink);
	      int attempts = 0;
	    
	
	      double lowestTime = 100000.0;
	
	      while(yenI.hasNext() && attempts < maxAttempts) {
	        GraphPath<DefaultVertex, RelationshipWeightedEdge> path = yenI.next();
	
	        double time = estimatedTime(path,t);
	     
	        if (time < lowestTime) {
	          lowestTime = time;
	          result = path;
	        }
	        attempts++;
	      }
	
	    }
	    
	    return result;
	
	
		}
		
	// Menor Rota de uma Estação para Atrações Turísticas
	public GraphPath <DefaultVertex, RelationshipWeightedEdge> bestRoute (String originStation, List<String> atts) {
		
    DefaultVertex vsource = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), originStation);

    GraphPath<DefaultVertex, RelationshipWeightedEdge> result = emptyPath;
    GraphPath<DefaultVertex, RelationshipWeightedEdge> temp = emptyPath;
    
    // peso final do caminho. Será usado no final.
    double weight = 0.0;
    
    // casos como o teste 1 , estação de origem válida mas lista de Atrações vazia
    
    if ((vsource != null) && ( atts.equals(new ArrayList())) ){
       
       return shortestPath(originStation, originStation);
    
    }
    // casos como teste  4 e 5 , lista de Atrações inválida
    
    if (!attractions.keySet().containsAll(atts)) {
      return emptyPath;
    }

    
    
    // caso comum
    for (int i = 0 ; i <= atts.size(); i++) {
      
      //caminho até  ultima atração
      if ( i < atts.size()) {
        
        DefaultVertex v = getStation(atts.get(i));

        // primeiro caminho até a primeira atração.
        if (result == emptyPath) {
        
        result = shortestPath(vsource.getLabel(), v.getLabel());
        
        //acumulador do peso do caminho final.
        weight = result.getWeight();

        //demais caminhos até a ultima atração.
        } else {
        
          temp = shortestPath(vsource.getLabel(), v.getLabel());
          // caso o vertice não exista em vertexList, é adicionado.
          if ( !result.getVertexList().contains(v)) {
            
            result.getVertexList().add(v);
          }
          //adicionando as arestas a edgeList
          result.getEdgeList().addAll(temp.getEdgeList());
          //acumulador do peso do caminho final.
          weight += temp.getWeight();
        
        }

        // ultima estação se torna primeira no proximo caminho
        vsource = v;
      
      //caminho da ultima atração até aestação de origem;
      } else {
        
        DefaultVertex v = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), originStation);

        temp = shortestPath(vsource.getLabel(), originStation);

        result.getEdgeList().addAll(temp.getEdgeList());

        weight += temp.getWeight();

        

      }
    }

    // construindo um caminho válido com as informações de result e weight
    result = new GraphWalk(graph, vsource,vsource, result.getVertexList(), result.getEdgeList(), weight);
       
    return result;


	}
	
	// Trechos em Destaque
	public List <RelationshipWeightedEdge> findSections (List <String> stations){
		// Adicione aqui sua implementação
	    List<RelationshipWeightedEdge> arestasDasEstacoesAdjacentes = new ArrayList<>();
	
	    for (int i = 0 ; i < stations.size(); i++) {
	       DefaultVertex v = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(), stations.get(i));
	
	      if(v != null){
	         Set<RelationshipWeightedEdge> arestasAdjacentes = graph.outgoingEdgesOf(v);
	
	         arestasDasEstacoesAdjacentes.addAll(arestasAdjacentes);
	      }       
	     }
	  
	    return arestasDasEstacoesAdjacentes;
		}
		
		public boolean serviceDisruption (List <String> stations) {
	    Set<DefaultVertex> subGraphVertexSet = new HashSet<>(graph.vertexSet());
	
	    for (String station : stations){
	      DefaultVertex v = VertexEdgeUtil.getVertexfromLabel(graph.vertexSet(),station);
	      subGraphVertexSet.remove(v);
	    }
	
	    AsSubgraph<DefaultVertex, RelationshipWeightedEdge> inducedSubgraph = new AsSubgraph<>(graph, subGraphVertexSet);
	
	    if(GraphTests.isConnected(inducedSubgraph)) {
	      return false;
	    } else {
	      return true;
	    }
	
	
		}
}
