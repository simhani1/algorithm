import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final int INF = 201;
    private static int N, M;
    private static int[][] arr = new int[INF][];
    private static int[] managers = new int[INF];
    private static boolean[] visited = new boolean[INF];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            arr[i] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (dfs(i)) {
                ans++;
            }
            Arrays.fill(visited, false);
        }
        System.out.println(ans);
    }

    private static boolean dfs(int person) {
        for (int i = 0; i < arr[person].length; i++) {
            int task = arr[person][i];
            if (visited[task]) {
                continue;
            }
            visited[task] = true;
            if (managers[task] == 0 || dfs(managers[task])) {
                managers[task] = person;
                return true;
            }
        }
        return false;
    }

}