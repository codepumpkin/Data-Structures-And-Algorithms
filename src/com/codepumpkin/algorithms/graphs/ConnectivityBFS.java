package com.codepumpkin.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * You can read more about Graph Search – Breadth First Search at 
 * http://codepumpkin.com/graph-bfs/
 * 
 * @author codepumpkin.com
 *
 */
public class ConnectivityBFS {

	private Queue<Integer> queue ;
	public ConnectivityBFS() {
		queue = new LinkedList<Integer>();
	}

	public static void main(String[] args) {
		int numberOfNodes, source;
		try(Scanner sc = new Scanner(System.in) ){
			System.out.println("Enter number of Nodes in the graph");
			numberOfNodes = sc.nextInt();
			int adjacencyMatrix[][] = new int[numberOfNodes+1][numberOfNodes+1];
			
			for(int i=1; i<=numberOfNodes;i++){
				for(int j=1; j<=numberOfNodes;j++){
					adjacencyMatrix[i][j] = sc.nextInt();
				}
			}
			
			System.out.println("Enter the source of the graph");
			source = sc.nextInt();
			
			ConnectivityBFS unidirectedConnectivityDFS = new ConnectivityBFS();
			System.out.println(unidirectedConnectivityDFS.bfs(adjacencyMatrix,source));
				
		}
		

	}

	private boolean bfs(int[][] adjacencyMatrix, int source) {
		int numberOfNodes = adjacencyMatrix[source].length-1;
		int visited[] = new int[numberOfNodes+1];
		int top =   source;
		visited[source] =1;
		queue.add(source);
		boolean connected = true;
		while(!queue.isEmpty()){
			top = queue.remove();
			if(visited[top] == 0){
				visited[top] = 1;
			}
			for(int i=1; i<numberOfNodes+1;i++){
				if(adjacencyMatrix[top][i] == 1 && visited[i] == 0){
					queue.add(i);
					visited[i] =1;
				}
			}
		}
		
		for(int i=1; i<visited.length;i++){
			if(visited[i] == 0){
				connected = false;
			}
		}
		return connected;
	}

}

