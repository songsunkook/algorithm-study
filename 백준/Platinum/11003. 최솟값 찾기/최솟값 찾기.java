import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Node> q = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            while (!q.isEmpty() && q.peekLast().n >= A[r]) {
                q.pollLast();
            }
            q.offerLast(new Node(A[r], r));
            while (q.peekFirst().i < r - L + 1) {
                q.pollFirst();
            }
            bw.write(q.peekFirst().n + " ");
        }

        bw.close();
        br.close();
    }

    static class Node {
        int n;
        int i;

        Node(int nn, int ii) {
            n = nn;
            i = ii;
        }
    }
}