package com.neco4j.graph;

/**
 * Edge interface 
 * @author Necati Kartal
 */
public interface IEdge {

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
	 * Gets the next edge
	 * @return nextEdge
	 */
	Edge getNextEdge();

	/**
	 * Sets the next edge
	 * @param nextEdge
	 */
	void setNextEdge(Edge nextEdge);
}