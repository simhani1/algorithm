import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int N, K;
    private static int[] arr;
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception  {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[K + 1];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < K; i++) {
            int num = arr[i];
            if (set.contains(num)) {
                continue;
            }
            if (set.size() < N) {
                set.add(num);
                continue;
            }
            int target = -1;
            int maxIdx = -1;
            for (int usedNum : set) {
                /* 전기용품별 제일 먼저 사용되는 순간 갱신 */
                int tmpIdx = -1;
                for (int j = i + 1; j < K; j++) {
                    if (usedNum == arr[j]) {
                        tmpIdx = j;
                        break;
                    }
                }
                /* 아예 사용되지 않는 전기용품 발견 */
                if (tmpIdx == -1) {
                    target = usedNum;
                    break;
                }
                /* 제일 늦게 사용되는 전기용품 종류 갱신 */
                if (tmpIdx > maxIdx) {
                    maxIdx = tmpIdx;
                    target = usedNum;
                }
            }
            set.remove(target);
            set.add(num);
            ans++;
        }
        System.out.println(ans);
    }

}