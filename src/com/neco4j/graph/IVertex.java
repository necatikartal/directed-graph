package com.neco4j.graph;

/**
 * Vertex interface
 * @author Necati Kartal
 */
public interface IVertex {

	/**
	 * Gets the vertex value
	 * @return vertexValue
	 */
	String getVertexValue();

	/**
	 * Sets the vertex value
	 * @param vertexValue
	 */
	void setVertexValue(String vertexValue);

	/**
	 * Gets the next vertex
	 * @return nextVertex
	 */
	Vertex getNextVertex();

	/**
	 * Sets the next vertex
	 * @param nextVertex
	 */
	void setNextVertex(Vertex nextVertex);

	/**
	 * Gets the next edge
	 * @return nextEdge
	 */
	Edge getNextEdge();

	/**
	 * Sets the edge
	 * @param nextEdge
	 */
	void setNextEdge(Edge nextEdge);

	/**
	 * Gets the visited property of the vertex
	 * @return visited
	 */
	Boolean getVisited();

	/**
	 * Sets the visited property of the vertex
	 * @param visited
	 */
	void setVisited(Boolean visited);

	/**
	 * Gets the vertex capacity
	 * @return vertexCapacity
	 */
	int getVertexCapacity();

	/**
	 * Sets the vertex capacity
	 * @param vertexCapacity
	 */
	void setVertexCapacity(int vertexCapacity);
}