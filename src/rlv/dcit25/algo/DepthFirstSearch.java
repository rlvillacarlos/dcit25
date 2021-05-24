package rlv.dcit25.algo;

import rlv.dcit25.ds.ArrayList;
import rlv.dcit25.ds.LinkedList;
import rlv.dcit25.ds.List;

/**
 *
 * @author Russel
 */
public class DepthFirstSearch {

    public static List<Integer> getPath(List<Integer>[] graph, int s ,int t){
        int parent[] = new int[graph.length];
        
        for(int i = 0; i< parent.length; i++) {
            parent[i] = -1;
        }
        
        parent[s] = s;
        
        dfs(graph, s, parent);
        
        List<Integer> path = new LinkedList<>();
        
        if(parent[t] != -1){
            int v = t;
            
            path.add(0,v);
            while(parent[v] != v){
                v = parent[v];
                path.add(0,v);
            }   
        }
        
        return path;
    }
    
    public static void dfs(List<Integer>[] graph, int u, int[] parent){
        for(int v:graph[u]){
            if(parent[v] == -1){
                parent[v] = u;
                dfs(graph, v, parent);
            }
        }
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
        
        List<Integer> path = DepthFirstSearch.getPath(graph, 2, 5);
        
        System.out.println(path);
    }
    
}
