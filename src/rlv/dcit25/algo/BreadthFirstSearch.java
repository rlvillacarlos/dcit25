package rlv.dcit25.algo;

import rlv.dcit25.ds.ArrayList;
import rlv.dcit25.ds.LinkedList;
import rlv.dcit25.ds.LinkedListQueue;
import rlv.dcit25.ds.List;
import rlv.dcit25.ds.Queue;

/**
 *
 * @author Acer
 */
public class BreadthFirstSearch {

    public static List<Integer> getPath(List<Integer>[] graph, int s ,int t){
        int parent[] = new int[graph.length];
        
        for(int i = 0; i< parent.length; i++) {
            parent[i] = -1;
        }
        
        parent[s] = s;
        
        Queue<Integer> q = new LinkedListQueue<>();
        
        q.enqueue(s);
        
        while(!q.isEmpty()){
            int u = q.dequeue();
            
            for(int v:graph[u]){
                if(parent[v] == -1){
                    parent[v] = u;
                    q.enqueue(v);
                }
            }
        }
        
        List<Integer> path = new LinkedList<>();
        
        if(parent[t] != -1){
            int v = t;
            
            path.add(0,v);
            while(parent[v] != v){
                v = parent[v];
                path.add(0,v);
            };    
        }
        
        return path;
    }
    
    public static int getDistance(List<Integer>[] graph, int s ,int t){
        int distance[] = new int[graph.length];
        
        for(int i = 0; i< distance.length; i++) {
            distance[i] = -1;
        }
        
        distance[s] = 0;
        
        Queue<Integer> q = new LinkedListQueue<>();
        
        q.enqueue(s);
        
        while(!q.isEmpty()){
            int u = q.dequeue();
            
            for(int v:graph[u]){
                if(distance[v] == -1){
                    distance[v] = distance[u] + 1;
                    q.enqueue(v);
                }
            }
        }
        return distance[t];
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> graph[] = (List<Integer>[])new List[6];
        
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(1);
        graph[1].add(3);
        graph[2].add(0); graph[2].add(5);
        graph[3].add(0); graph[3].add(4);graph[3].add(5);
        graph[5].add(4);
        
        List<Integer> path = BreadthFirstSearch.getPath(graph, 2, 3);
        
        System.out.println(path);
        
        int distance = BreadthFirstSearch.getDistance(graph, 2, 3);
        
        System.out.println(distance);
    }
    
}
