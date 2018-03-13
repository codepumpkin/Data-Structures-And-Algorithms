package com.codepumpkin.algorithms.graphs;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * You can read more about Graph Search – Depth First Search at 
 * http://codepumpkin.com/graph-search-depth-first-search/
 * 
 * @author codepumpkin.com
 *
 */
public class GraphDFS {
		private int v;
		private LinkedList<Integer> adj[];

		/**
		 * We initialize the Graph with number of vertices v in the graph
		 */
		public GraphDFS(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}

		/**
		 * This method will add an edge between node u and w.
		 */
		void addEdge(int u, int w) {
			adj[u].add(w);
		}

		void dfsUtil(int v, boolean visited[]) {
			visited[v] = true;
			int n;
			Iterator<Integer> itr = adj[v].iterator();
			while (itr.hasNext()) {
				n = itr.next();
				if (!visited[n]) {
					dfsUtil(n, visited);
				}
			}
		}

		GraphDFS getTranspose() {
			GraphDFS g = new GraphDFS(v);

			for (int i = 0; i < v; i++) {
				Iterator<Integer> itr = adj[i].iterator();
				while (itr.hasNext()) {
					g.adj[itr.next()].add(i);
				}
			}
			return g;
		}
	}
