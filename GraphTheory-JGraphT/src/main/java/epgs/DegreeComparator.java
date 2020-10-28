package epgs;


import java.util.Comparator;

import org.jgrapht.Graph;


import util.DefaultVertex;
import util.RelationshipWeightedEdge;

public class DegreeComparator implements Comparator<DefaultVertex> {
	 
	Graph<DefaultVertex,RelationshipWeightedEdge> graph;
	public DegreeComparator(Graph<DefaultVertex, RelationshipWeightedEdge> graph) {
		this.graph = graph;
	}
	@Override
	public int compare(DefaultVertex arg0, DefaultVertex arg1) {
		
		if (graph.degreeOf(arg0) != graph.degreeOf(arg1)) {
			return graph.degreeOf(arg0) - graph.degreeOf(arg1);
		} else {
			return (arg0.getLabel().compareTo(arg1.getLabel())) * -1;
		}
		
	}

}
