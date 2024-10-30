import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int N;
    private static int bit;
    private static char[] quack = {'q', 'u', 'a', 'c', 'k'};
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        char[] arr = br.readLine().toCharArray();
        N = arr.length;
        visited = new boolean[N];
        if (N % 5 != 0) {
            System.out.println(-1);
        } else {
            System.out.println(solve(arr));
        }
    }

    private static int solve(char[] arr) {
        char lastChar = '!';
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            int idx = 0;
            for (int j = i; j < N; j++) {
                if (arr[j] == quack[idx] && !visited[j]) {
                    visited[j] = true;
                    lastChar = arr[j];
                    idx = (idx + 1) % 5;
                }
            }
            if (lastChar == '!' || lastChar != 'k') {
                return -1;
            }
            cnt++;
        }
        return cnt;
    }

}