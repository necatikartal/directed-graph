package com.neco4j.graph;

/**
 * Graph interface
 * @author Necati Kartal
 */
public interface IGraph {

	/**
	 * Add a vertex to the graph
	 * @param vertexValue
	 * @param vertexCapacity
	 */
	void addVertex(String vertexValue, int vertexCapacity);

	/**
	 * Find the vertex from the graph
	 * @param vertexValue
	 * @return vertex
	 */
	Vertex findVertex(String vertexValue);

	/**
	 * Remove the vertex from the graph
	 * @param vertexValue
	 * @return true/false
	 */
	Boolean removeVertex(String vertexValue);

	/**
	 * Add an edge to the graph
	 * @param vertexValue
	 * @param edgeValue
	 */
	void addEdge(String vertexValue, String edgeValue);

	/**
	 * Remove the edge from the graph
	 * @param vertexValue
	 * @param edgeValue
	 */
	void removeEdge(String vertexValue, String edgeValue);

	/**
	 * Print the graph
	 */
	void printGraph();

	/**
	 * Gets out degree of the vertex
	 * @param vertexValue
	 * @return outDegree
	 */
	int outDegree(String vertexValue);

	/**
	 * Gets in degree of the vertex
	 * @param vertexValue
	 * @return inDegree
	 */
	int inDegree(String vertextValue);

	/**
	 * Set all vertices' visited property to false
	 */
	void setVerticesNotVisited();

	/**
	 * Gets the vertex counts
	 * @return vertexCount
	 */
	int vertexCount();

	/**
	 * Gets the adjacency between vertex1 and vertex2
	 * @param vertex1
	 * @param vertex2
	 * @return true/false
	 */
	Boolean isAdjacent(String vertex1, String vertex2);
		
	/**
	 * Depth first search(DFS) on the graph
	 * @param vertexValue
	 */
	void DFS(String vertexValue);
	
	/**
	 * Breadth first search(BFS) on the graph
	 * @param vertexValue
	 */
	void BFS(String vertexValue);
}