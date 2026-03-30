import java.io.*;
import java.util.*;

/**
 * 절대값이 큰 수끼리 곱해야 한다.
 * 음수를 감안해야 함. 음수는 음수끼리 곱해야 한다.
 * 정렬 이후, 양쪽 끝에서 둘씩 묶어서 더하면 마지막에는 0(중앙)에서 모일 것.
 * 엣지 케이스
 * - 0은 가장 작은 절댓값의 음수와 묶을 수 있지만 양수와 묶으면 안된다.
 * - 1은 묶지 않아야 한다.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 1) {
                plus.offer(a);
            } else if (a == 1) {
                sum += 1;
            } else {
                minus.offer(a);
            }
        }
        while (plus.size() > 1) {
            sum += plus.poll() * plus.poll();
        }
        if (!plus.isEmpty()) {
            sum += plus.poll();
        }
        while (minus.size() > 1) {
            sum += minus.poll() * minus.poll();
        }
        if (!minus.isEmpty()) {
            sum += minus.poll();
        }
        bw.write(sum + "");
        bw.close();
        br.close();
    }
}