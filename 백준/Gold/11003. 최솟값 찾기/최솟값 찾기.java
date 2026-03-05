import java.io.*;
import java.util.*;

/**
 * D(i) = A(i-L+1) ~ A(i)
 * D(i) = 길이가 L인 슬라이딩 윈도우 내부의 최소값
 * i가 음수인 경우는 무시한다.
 * 범위 5백만은 최소값을 O(n)에 꺼낼 수 있어야 한다.
 * 덱에서 이전 인덱스일수록 이후에 비해 작은 값을 가지도록 강제하면 O(n)에 정렬을 구현할 수 있다.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int l = -s + 1, r = 0;
        int min = a[0];
        int[] d = new int[n];
        Deque<N> dq = new LinkedList<>();
        dq.addFirst(new N(0, a[0]));
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst().idx < l) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && dq.peekLast().num > a[i]) {
                dq.removeLast();
            }
            dq.addLast(new N(i, a[i]));
            d[i] = dq.peekFirst().num;
            l++;
            r++;
        }

        for (int i = 0; i < n; i++) {
            bw.write(d[i] + " ");
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