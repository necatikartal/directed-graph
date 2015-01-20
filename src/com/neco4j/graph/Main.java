package com.neco4j.graph;

/**
 * Main class to test
 * @author Necati Kartal
 */
public class Main {

	/**
	 * Main function to test
	 */
	public static void main(String[] args) {
		
		// Do test here.
		
		// create graph
		Graph gr = new Graph();
		
		// add vertices
		gr.addVertex("1",40);
        gr.addVertex("2",70);
        gr.addVertex("3",100);
        gr.addVertex("4",10);
		
		// add edges
        gr.addEdge("1", "2"); 
        gr.addEdge("1", "3");      
        gr.addEdge("1", "4");
                
        gr.addEdge("2", "3");     
        gr.addEdge("2", "4");
        
        gr.addEdge("3", "1");
        gr.addEdge("3", "1");
        gr.addEdge("3", "1");
        
        gr.addEdge("4", "3");
        
        // print the graph
        gr.printGraph();
        
        // DFS by using vertex 4
        gr.DFS("4");
        
        // BSF by using vertex 2
        gr.BFS("2");
	}
}