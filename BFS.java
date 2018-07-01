import java.util.*;

public class BFS {
    private int v;
    private HashMap<Integer, List<Integer>> adj;

    public BFS(int v) {
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

    void BFS(int s) {
        boolean[] visited = new boolean[this.v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> iter = adj.get(s).listIterator();
            while (iter.hasNext()) {
                int n = iter.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS b = new BFS(4);
        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(1, 2);
        b.addEdge(2, 0);
        b.addEdge(2, 3);
        b.addEdge(3, 3);

        b.BFS(2);

    }
}
