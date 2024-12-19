import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static final int INF = 1001;
    private static int T, N, M;
    private static int[][] arr;
    private static int[] owner;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[M + 1][N + 1];
            owner = new int[N + 1];
            visited = new boolean[N + 1];
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i] = new int[b - a + 1];
                for (int j = 0, k = a; j < b - a + 1; j++, k++) {
                    arr[i][j] = k;
                }
            }
            int ans = 0;
            for (int i = 1; i <= M; i++) {
                if (dfs(i)) {
                    ans++;
                }
                Arrays.fill(visited, false);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean dfs(int person) {
        for (int i = 0; i < arr[person].length; i++) {
            int book = arr[person][i];
            if (visited[book]) {
                continue;
            }
            visited[book] = true;
            if (owner[book] == 0 || dfs(owner[book])) {
                owner[book] = person;
                return true;
            }
        }
        return false;
    }

}