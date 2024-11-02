import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int N, M, edgeCnt;
    private static PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o1.dist, o2.dist));
    private static int[][] arr;
    private static int[] parent;

    static class Edge {
        int from;
        int to;
        double dist;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
            this.dist = calcDist(from, to);
        }

        private double calcDist(int from, int to) {
            return Math.sqrt(Math.pow(arr[from][0] - arr[to][0], 2) + Math.pow(arr[from][1] - arr[to][1], 2));
        }

        @Override
        public String toString() {
            return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", dist=" + dist +
                '}';
        }
    }

    public static void main(String[] args) throws Exception  {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][2];
        parent = new int[N + 1];
        edgeCnt = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
            edgeCnt++;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                pq.offer(new Edge(i, j));
            }
        }
		System.out.println(String.format("%.2f", solve()));
    }

    private static double solve() {
        double sum = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int a = find(edge.from);
            int b = find(edge.to);
            double dist = edge.dist;
            if (a != b) {
                union(a, b);
                sum += dist;
                edgeCnt++;
            }
            if (edgeCnt == N - 1) {
                break;
            }
        }
        return sum;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[Math.max(a, b)] = Math.min(a, b);
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

}