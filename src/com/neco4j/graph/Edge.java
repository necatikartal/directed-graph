package com.neco4j.graph;

/**
 * Edge class that implements edge interface
 * @author Necati Kartal
 */
public class Edge implements IEdge {

	private String vertexValue;
	private Edge nextEdge;

	/**
	 * No-argument edge constructor
	 * @param vertexValue
	 */
	public Edge(String vertexValue) {
		setVertexValue(vertexValue);
		setNextEdge(null);
	}

	/**
	 * Gets the vertex value
	 * @return vertexValue
	 */
	@Override
	public String getVertexValue() {
		return vertexValue;
	}

	/**
	 * Sets the vertex value
	 * @param vertexValue
	 */
	@Override
	public void setVertexValue(String vertexValue) {
		this.vertexValue = vertexValue;
	}

	/**
	 * Gets the next edge
	 * @return nextEdge
	 */
	@Override
	public Edge getNextEdge() {
		return nextEdge;
	}

	/**
	 * Sets the next edge
	 * @param nextEdge
	 */
	@Override
	public void setNextEdge(Edge nextEdge) {
		this.nextEdge = nextEdge;
	}
}