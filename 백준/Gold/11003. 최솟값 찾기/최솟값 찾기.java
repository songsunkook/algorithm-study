import java.io.*;
import java.util.*;

/**
 * 슬라이딩 윈도우
 * 숫자 하나가 윈도우에 들어오고 나갈 때마다 최소값을 구해야 한다.
 * 우선순위 큐 사용 시 O(log n)을 숫자 삽입/삭제마다 해야 한다.
 * 숫자는 총 500만 개. 1억을 초과한다.
 * 
 * O(n) 이내에 완료해야 한다.
 * 완전한 정렬을 할 필요는 없다. 필요한 값은 결국 특정 구간에서 가장 작은 값 뿐이다.
 * (idx, value)로 값을 관리한다.
 * 큐를 사용하며, cur를 1씩 올리며 front에서 cur > idx인 경우 제거한다.
 * back에는 수가 하나씩 들어올텐데, 이전 값보다 작은 value가 들어오면 이전 값을 지워버린다.
 * 최소값만 있으면 되니 불필요한 값이기 때문이다.
 * 앞의 값이 더 크면 제거함으로써 front node가 가장 작음을 보장할 수 있다.
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] ans = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = -size + 1, r = 0;
        Deque<N> dq = new LinkedList<>();
        while (r < n) {
            while (!dq.isEmpty() && dq.peekLast().val >= arr[r]) {
                dq.removeLast();
            }
            dq.addLast(new N(r, arr[r]));
            while (!dq.isEmpty() && dq.peekFirst().idx < l) {
                dq.removeFirst();
            }
            ans[r] = dq.peekFirst().val;
            l++;
            r++;
        }
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.close();
        br.close();
    }

    static class N {
        int idx;
        int val;

        N(int i, int v) {
            idx = i;
            val = v;
        }
    }
}