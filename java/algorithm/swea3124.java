
import java.io.*;
import java.util.*;

class Edge {
    int s;
    int e;
    int weight;
    
    Edge(int s, int e, int weight){
        this.s = s;
        this.e = e;
        this.weight = weight;
    }
}

public class swea3124 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            parents = new int[V+1];
            for(int i = 1; i <= V; i++) {
                parents[i] = i;
            }
            List<Edge> list = new LinkedList<>();
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            list.sort((a, b) -> {return a.weight - b.weight;});
            for(int i = 0; i < list.size(); i++)
                System.out.println(list.get(i).weight);
            int N = 1;
            int idx = 0;
            while(N != V) {
                Edge now = list.get(idx++);
                
            }
        }
    }
    static int find(int n) {
        int parent = parents[n];
        if(parent != n)
            parent = find(parent);
        return parent;
    }
    
    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa < pb) parents[b] = pa;
        else parents[a] = pb;
    }
}