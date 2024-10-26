import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int T, N;
    private static int[] arr, ansArr;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            ansArr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            list.clear();
            for (int i = 1; i <= N; i++) {
                list.add(i);
            }
            boolean flag = true;
            for (int i = N - 1; i >= 0; i--) {
                int idx = arr[i];
                if (idx >= list.size()) {
                    sb.append("IMPOSSIBLE").append("\n");
                    flag = false;
                    break;
                }
                ansArr[i] = list.get(idx);
                list.remove(idx);
            }
            if (flag) {
                for (int i = 0; i < N; i++) {
                    sb.append(ansArr[i]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

}