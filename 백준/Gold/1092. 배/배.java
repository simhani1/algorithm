import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int N, M;
    private static int maxLimit = 0, maxWeight = 0;
    private static int[] limit;
    private static List<Integer> weight = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        limit = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
            maxLimit = Math.max(maxLimit, limit[i]);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int w = Integer.parseInt(st.nextToken());
            maxWeight = Math.max(maxWeight, w);
            weight.add(w);
        }
        if (maxLimit < maxWeight) {
            System.out.println(-1);
            return;
        }
        Arrays.sort(limit);
        weight.sort((o1, o2) -> Integer.compare(o1, o2) * -1);
        System.out.println(solve());
    }

    private static int solve() {
        int time = 0;
        while (!weight.isEmpty()) {
            for (int i = N - 1; i >= 0; i--) {
                int l = limit[i];
                for (int j = 0; j < weight.size(); j++) {
                    if (l >= weight.get(j)) {
                        weight.remove(j);
                        break;
                    }
                }
            }
            time++;
        }
        return time;
    }

}