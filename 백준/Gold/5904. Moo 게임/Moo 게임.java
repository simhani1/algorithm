import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dfs(N, 0, 0);
    }

    private static void dfs(int n, int k, int prevLen) {
        int nowLen = 2 * prevLen + k + 3;
        if (n <= prevLen) {
            dfs(n, 0, 0);
        } else if (prevLen + 1 <= n && n <= prevLen + k + 3) {
            if (n == prevLen + 1) {
                System.out.println("m");
                return;
            } else {
                System.out.println("o");
                return;
            }
        } else if (prevLen + k + 4 <= n && n <= nowLen) {
            dfs(n - (prevLen + k + 3), 0, 0);
        } else {
            dfs(n, k + 1, nowLen);
        }
    }

}