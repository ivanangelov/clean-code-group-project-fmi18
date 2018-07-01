import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DFS {
    private int v;
    private HashMap<Integer, List<Integer>> adj;

    public DFS(int v) {
        this.v = v;
        this.adj = new HashMap<>();
    }
    public void addEdge(int v, int w){
        if(!adj.containsKey(v)){
            List<Integer> l = new ArrayList<>();
            l.add(w);
            adj.put(v, l);
        }else{
            adj.get(v).add(w);
        }
    }

    private void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> iter = adj.get(s).listIterator();
        while(iter.hasNext()){
            int n = iter.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int s) {
        boolean[] visited = new boolean[this.v];
        DFSUtil(s, visited);
    }

    public static void main(String[] args) {
        DFS b = new DFS(4);
        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(1, 2);
        b.addEdge(2, 0);
        b.addEdge(2, 3);
        b.addEdge(3, 3);

        b.DFS(2);

    }
}
