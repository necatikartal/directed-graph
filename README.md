# Directed-Graph
Simple directed graph which has depth first and breadth first search algorithms. 

####How a directed graph works:
<p align="center">
	<img alt="Directed Graph" src="/Resources/directedgraph.png">
</p>
=================

####Simple Test:

######Code:
```java
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
  gr.addEdge("3", "2");
  gr.addEdge("4", "1");
  gr.addEdge("4", "2");
        
  // print the graph
  gr.printGraph();
        
  // DFS by using vertex 4
  gr.DFS("4");
        
  // BSF by using vertex 2
  gr.BFS("2");
}
```

######Output:
```
Vertex:    1 Size:  40 Neighbors: ->2,->3,
Vertex:    2 Size:  70 Neighbors: 
Vertex:    3 Size: 100 Neighbors: ->2,
Vertex:    4 Size:  10 Neighbors: ->1,->2,
DFS(4) = 4, 2, 1, 3, 
BFS(2) = 2, 
```
