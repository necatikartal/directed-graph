package com.neco4j.graph;

/**
 * A graph that implements graph interface
 * @author Necati Kartal
 */
public class Graph implements IGraph {

	public Vertex vertexHead;

	/**
	 * Add a vertex to the graph
	 * @param vertexValue
	 * @param vertexCapacity
	 */
	@Override
	public void addVertex(String vertexValue, int vertexCapacity) {
		if (vertexHead == null)
			vertexHead = new Vertex(vertexValue, vertexCapacity);
		else {
			Vertex iterator = vertexHead;
			while (iterator.getNextVertex() != null) {
				iterator = iterator.getNextVertex();
			}
			iterator.setNextVertex(new Vertex(vertexValue, vertexCapacity));
		}
	}

	/**
	 * Find the vertex from the graph
	 * @param vertexValue
	 * @return vertex
	 */
	@Override
	public Vertex findVertex(String vertexValue) {
		Vertex iterator = vertexHead;
		while (iterator != null) {
			if (vertexValue.compareTo(iterator.getVertexValue()) == 0)
				return iterator;
			iterator = iterator.getNextVertex();
		}
		return null;
	}

	/**
	 * Remove the vertex from the graph
	 * @param vertexValue
	 * @return true/false
	 */
	@Override
	public Boolean removeVertex(String vertexValue) {
		Vertex iterator = vertexHead;
		if (vertexValue.compareTo(iterator.getVertexValue()) == 0) {
			Edge e = iterator.getNextEdge();
			while (e != null) {
				removeEdge(iterator.getVertexValue(), e.getVertexValue());
				removeEdge(e.getVertexValue(), iterator.getVertexValue());
				e = e.getNextEdge();
			}
			vertexHead = iterator.getNextVertex();
			return true;
		}

		while (iterator.getNextVertex() != null) {
			if (vertexValue.compareTo(iterator.getNextVertex().getVertexValue()) == 0) {
				Edge e = iterator.getNextVertex().getNextEdge();
				while (e != null) {
					removeEdge(iterator.getNextVertex().getVertexValue(), e.getVertexValue());
					removeEdge(e.getVertexValue(), iterator.getNextVertex().getVertexValue());
					e = e.getNextEdge();
				}
				if (iterator.getNextVertex() != null)
					iterator.setNextVertex(iterator.getNextVertex().getNextVertex());
				else
					iterator.setNextVertex(null);
				return true;
			}
			iterator = iterator.getNextVertex();
		}
		return null;
	}

	/**
	 * Add an edge to the graph
	 * @param vertexValue
	 * @param edgeValue
	 */
	@Override
	public void addEdge(String vertexValue, String edgeValue) {
		Vertex v = findVertex(vertexValue);
		if (v == null)
			return;
		if (v.getNextEdge() == null)
			v.setNextEdge(new Edge(edgeValue));
		else {
			Edge iterator = v.getNextEdge();
			while (iterator.getNextEdge() != null)
				iterator = iterator.getNextEdge();
			iterator.setNextEdge(new Edge(edgeValue));
		}

	}

	/**
	 * Remove the edge from the graph
	 * @param vertexValue
	 * @param edgeValue
	 */
	@Override
	public void removeEdge(String vertexValue, String edgeValue) {
		
		Vertex v = findVertex(vertexValue);
		if (v == null)
			return;
		if (v.getNextEdge() == null)
			return;
		else {
			Edge iterator = v.getNextEdge();
			if (edgeValue.compareTo(iterator.getVertexValue()) == 0) {
				v.setNextEdge(v.getNextEdge().getNextEdge());
				return;
			}
			while (iterator.getNextEdge() != null) {
				if (edgeValue.compareTo(iterator.getNextEdge().getVertexValue()) == 0) {
					if (iterator.getNextEdge() != null)
						iterator.setNextEdge(iterator.getNextEdge().getNextEdge());
					else
						iterator.setNextEdge(null);
					return;
				}
				iterator = iterator.getNextEdge();
			}
		}
	}

	/**
	 * Print the graph
	 */
	@Override
	public void printGraph() {
		Vertex iteratorVertex = vertexHead;
		while (iteratorVertex != null) {
			System.out.printf("Vertex: %4s Size: %3s Neighbors: ",
					iteratorVertex.getVertexValue(), iteratorVertex.getVertexCapacity());

			Edge iteratorEdge = iteratorVertex.getNextEdge();
			while (iteratorEdge != null) {
				System.out.print("->" + iteratorEdge.getVertexValue() + ",");
				iteratorEdge = iteratorEdge.getNextEdge();
			}
			System.out.println();

			iteratorVertex = iteratorVertex.getNextVertex();
		}
	}

	/**
	 * Gets out degree of the vertex
	 * @param vertexValue
	 * @return outDegree
	 */
	@Override
	public int outDegree(String vertexValue) {
		Vertex v = findVertex(vertexValue);
		if (v != null) {
			Edge e = v.getNextEdge();
			int ec = 0;
			while (e != null) {
				ec++;
				e = e.getNextEdge();
			}
			return ec;
		}
		return -1;
	}

	/**
	 * Gets in degree of the vertex
	 * @param vertexValue
	 * @return inDegree
	 */
	@Override
	public int inDegree(String vertexValue) {
		Vertex iteratorVertex = vertexHead;
		int ec = 0;
		while (iteratorVertex != null) {
			Edge iteratorEdge = iteratorVertex.getNextEdge();
			while (iteratorEdge != null) {
				if (vertexValue.compareTo(iteratorEdge.getVertexValue()) == 0)
					ec++;
				iteratorEdge = iteratorEdge.getNextEdge();
			}
			iteratorVertex = iteratorVertex.getNextVertex();
		}
		return ec;
	}

	/**
	 * Set all vertices' visited property to false
	 */
	@Override
	public void setVerticesNotVisited() {
		Vertex iterator = vertexHead;
		while (iterator != null) {
			iterator.setVisited(false);
			iterator = iterator.getNextVertex();
		}
	}

	/**
	 * Gets the vertex counts
	 * @return vertexCount
	 */
	@Override
	public int vertexCount() {
		int count = 0;
		Vertex iterator = vertexHead;
		while (iterator != null) {
			iterator = iterator.getNextVertex();
			count++;
		}
		return count;
	}

	/**
	 * Gets the adjacency between vertex1 and vertex2
	 * @param vertex1
	 * @param vertex2
	 * @return true/false
	 */
	@Override
	public Boolean isAdjacent(String vertex1, String vertex2) {
		Vertex v1 = findVertex(vertex1);
		Vertex v2 = findVertex(vertex2);
		if (v1 == null || v2 == null)
			return false;
		Edge e = v1.getNextEdge();
		while (e != null) {
			if (e.getVertexValue().compareTo(v2.getVertexValue()) == 0)
				return true;
			e = e.getNextEdge();
		}
		return false;
	}
	
	/**
	 * Depth first search(DFS) on the graph
	 * @param vertexValue
	 */
	@Override
	public void DFS(String vertexValue) {
		setVerticesNotVisited();
		Stack<Vertex> stck = new Stack<Vertex>();
		Vertex start = findVertex(vertexValue);
		if (start != null) {
			stck.Push(start);
			while (stck.Count() > 0) {
				Vertex v = stck.Pop();
				if (!v.getVisited())
					System.out.print(v.getVertexValue() + ", ");
				v.setVisited(true);
				Edge edges = v.getNextEdge();
				while (edges != null) {
					Vertex v2 = findVertex(edges.getVertexValue());
					if (!v2.getVisited()) {
						stck.Push(v2);
					}
					edges = edges.getNextEdge();
				}
			}
			System.out.println();
		}
	}

	/**
	 * Breadth first search(BFS) on the graph
	 * @param vertexValue
	 */
	@Override
	public void BFS(String vertexValue) {
		setVerticesNotVisited();
		Queue<Vertex> queue = new Queue<Vertex>();
		Vertex start = findVertex(vertexValue);
		if (start != null) {
			queue.Enqueue(start);
			while (queue.getCount() > 0) {
				Vertex v = queue.Dequeue();
				if (!v.getVisited())
					System.out.print(v.getVertexValue() + ", ");
				v.setVisited(true);
				Edge edges = v.getNextEdge();
				while (edges != null) {
					Vertex v2 = findVertex(edges.getVertexValue());
					if (!v2.getVisited()) {
						queue.Enqueue(v2);
					}
					edges = edges.getNextEdge();
				}
			}
			System.out.println();
		}
	}
}