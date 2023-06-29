package rlv.dcit25.algo;


import java.util.*;

/**
 *
 * @author Russel L. Villacarlos <rlvillacarlos@cvsu.edu.ph>
 */
public class BFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int digraphMatrix[][] = {
            {0,1,0,0,0,0},
            {0,0,0,1,0,0},
            {1,0,0,0,0,1},
            {1,0,0,0,1,1},
            {0,0,0,0,0,0},
            {0,0,0,0,1,0}
        };
        
        List<Integer> graphList[] = new List[6];
        for(int i = 0; i < graphList.length; i++){
            graphList[i] = new ArrayList<>();
        }
        
        graphList[0].add(1); graphList[0].add(2);
        graphList[0].add(3);
         
        graphList[1].add(0); graphList[1].add(3);
        
        graphList[2].add(0); graphList[2].add(5);
        
        graphList[3].add(0); graphList[3].add(1);
        graphList[3].add(4); graphList[3].add(5);
        
        graphList[4].add(3); graphList[4].add(5);
        
        graphList[5].add(2); graphList[5].add(3);
        graphList[5].add(4);
        
        System.out.println(isReachable(graphList, 3, 2));
        System.out.println(getPath(graphList, 2, 3));
        int dist[] = getDistance(graphList, 3);
        System.out.println(Arrays.toString(dist));
    }
    
    static boolean isReachable(List<Integer> graph[], int s, int t){
        int parent[] = bfs(graph, s);
        return  parent[t] != -1;
    }
    
    static List<Integer> getPath(List<Integer> graph[], int s, int t){
        int parent[] = bfs(graph, s);
        List<Integer> path = new LinkedList<>();
        
        if(parent[t] != -1){
            int cur = t;
            path.add(0,cur);
            int p = parent[cur];
            while (cur != s){
                cur = p;
                path.add(0,cur);
                p = parent[cur];
            }
        }
        return path;
    }
    
    static int[] bfs(List<Integer> graph[], int s){
        int parent[] = new int[graph.length];
        for(int i = 0; i< parent.length; i++){
            parent[i] = -1;
        }
        parent[s] = s;
        List<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int cur = queue.remove(0);
            for(int v: graph[cur]){
                if(parent[v] == -1){
                    parent[v] = cur;
                    queue.add(v);
                }
            }
        }
        return parent;
    }
    
    static int[] getDistance(List<Integer> graph[], int s){
        int dist[] = new int[graph.length];
        for(int i = 0; i< dist.length; i++){
            dist[i] = -1;
        }
        dist[s] = 0;
        List<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int cur = queue.remove(0);
            for(int v: graph[cur]){
                if(dist[v] == -1){
                    dist[v] = dist[cur] + 1;
                    queue.add(v);
                }
            }
        }
        return dist;
    }
}
