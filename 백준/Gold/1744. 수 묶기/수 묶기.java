import java.io.*;
import java.util.*;

/**
 * 절대값이 큰수끼리 묶는다.
 * 양수도, 음수도.
 * 
 * 음수는 양수와 묶지 않는다.
 * 
 * 0은 묶지 않는다.(음수가 하나남았을 때는 묶는다)
 * 1은 묶지 않는다.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int zero = 0;
        int one = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 1) {
                max.offer(a);
            } else if (a < 0) {
                min.offer(a);
            } else if (a == 0) {
                zero++;
            } else {
                one++;
            }
        }

        long sum = 0;
        while (min.size() > 1) {
            int a = min.poll();
            int b = min.poll();
            sum += a * b;
        }
        while (max.size() > 1) {
            int a = max.poll();
            int b = max.poll();
            sum += a * b;
        }
        if (!max.isEmpty()) {
            sum += max.poll();
        }
        if (!min.isEmpty()) {
            if (zero == 0) {
                sum += min.poll();
            }
        }
        sum += one;

        bw.write(sum + "");
        bw.close();
        br.close();
    }
}