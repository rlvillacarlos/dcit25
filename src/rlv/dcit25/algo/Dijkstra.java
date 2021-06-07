package rlv.dcit25.algo;

import rlv.dcit25.ds.ArrayList;
import rlv.dcit25.ds.LinkedList;
import rlv.dcit25.ds.List;
import rlv.dcit25.ds.UpdatableMinHeapPQ;
import rlv.dcit25.ds.UpdatableMinHeapPQ.MinHeapPQHandle;

/**
 *
 * @author Acer
 */
public class Dijkstra {

    public static List<Integer> getPath(List<Integer>[] graph, List<Float>[] weight, int s ,int t){
        int parent[] = new int[graph.length];
        Integer vertices[] = new Integer[graph.length];
        Float dist[] = new Float[graph.length];
        MinHeapPQHandle handles[] = new MinHeapPQHandle[graph.length];
        
        for(int i = 0; i< parent.length; i++) {
            parent[i] = -1;
            vertices[i] = i;
            dist[i] = (i == s ? 0f : Float.POSITIVE_INFINITY);
            handles[i] = new MinHeapPQHandle();
        }
        
        UpdatableMinHeapPQ<Integer, Float> pq = new UpdatableMinHeapPQ<>(vertices,dist,handles);
        
        parent[s] = s;
        
        while(!pq.isEmpty()){
            int u = pq.removeMin(); 
            
            for(int i = 0;i < graph[u].size(); i++){
                int v = graph[u].get(i);
                float d = dist[u] + weight[u].get(i);
                if(d < dist[v]){
                    parent[v] = u;
                    dist[v] = d;
                    pq.decreasePriority(handles[v], d);
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
    
    public static float getDistance(List<Integer>[] graph, List<Float>[] weight, int s ,int t){
        Integer vertices[] = new Integer[graph.length];
        Float dist[] = new Float[graph.length];
        MinHeapPQHandle handles[] = new MinHeapPQHandle[graph.length];
        
        for(int i = 0; i< dist.length; i++) {
            vertices[i] = i;
            dist[i] = (i == s ? 0f : Float.POSITIVE_INFINITY);
            handles[i] = new MinHeapPQHandle();
        }
        
        UpdatableMinHeapPQ<Integer, Float> pq = new UpdatableMinHeapPQ<>(vertices,dist,handles);
        
        dist[s] = 0f;
        pq.decreasePriority(handles[s], 0f);
        
        while(!pq.isEmpty()){
            int u = pq.removeMin(); 
            
            for(int i = 0;i < graph[u].size(); i++){
                int v = graph[u].get(i);
                float d = dist[u] + weight[u].get(i);
                MinHeapPQHandle h = handles[v];
                if(d < dist[v]){
                    dist[v] = d;
                    pq.decreasePriority(h, d);
                }
            }
        }
        return dist[t];
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> graph[] = (List<Integer>[])new List[8];
        List<Float> weights[] = (List<Float>[])new List[8];
        
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
            weights[i] = new ArrayList<>();
        }
        
        graph[0].add(1);graph[0].add(4);graph[0].add(5);
        graph[1].add(2);
        graph[2].add(3);
        graph[4].add(2); graph[4].add(7);
        graph[5].add(6);
        graph[6].add(7);
        graph[7].add(3);
        
        weights[0].add(12f);weights[0].add(10f);weights[0].add(10f);
        weights[1].add(6f);
        weights[2].add(5f);
        weights[4].add(11f); weights[4].add(11f);
        weights[5].add(9f);
        weights[6].add(16f);
        weights[7].add(9f);
        
        List<Integer> path = Dijkstra.getPath(graph, weights, 0, 3);
        
        System.out.println(path);
        
        float distance = Dijkstra.getDistance(graph,weights,0, 3);
        
        System.out.println(distance);
    }
    
}
