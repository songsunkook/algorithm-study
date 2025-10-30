import java.io.*;
import java.util.*;

/**
 * class N {idx, num} 정의
 * n, L 입력
 * for(i=0 ~ n){
 * next 입력
 * while(!q.isEmpty() && q.peekLast() >= next)
 * q.pollLast()
 * q.offerLast(new N(i, next))
 * 
 * // 윈도우 사이즈 체크
 * if (i - q.peekFirst() > L)
 * q.pollFirst();
 * q.peekFirst().num 출력
 * }
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<N> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            while (!q.isEmpty() && q.peekLast().num >= next) {
                q.pollLast();
            }
            q.offerLast(new N(i, next));

            if (i - q.peekFirst().idx >= L) {
                q.pollFirst();
            }
            bw.write(q.peekFirst().num + " ");
        }

        bw.close();
        br.close();
    }

    static class N {
        int idx;
        int num;

        N(int i, int n) {
            idx = i;
            num = n;
        }
    }
}