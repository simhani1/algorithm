import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int N, L;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        for (int i = L; i <= 100; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                sum += j;
            }
            double a = (N - sum) / (double)i;
            if ((int)a == a && a >= 0) {
                for (int j = 0; j < i; j++) {
                    sb.append((int)a + j).append(" ");
                }
                System.out.println(sb);
                return;
            }
        }
        System.out.println(-1);
    }

}