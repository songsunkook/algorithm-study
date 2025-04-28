import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Pair[] seq = new Pair[5 * n];
        Pair[][] arr = new Pair[n][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                var sp = st.nextToken().split("-");
                arr[i][j] = new Pair(sp[0], Integer.parseInt(sp[1]));
                seq[5 * i + j] = new Pair(sp[0], Integer.parseInt(sp[1]));
            }
        }

        // 큐 정렬
        Arrays.sort(seq, (a, b) -> {
            if (a.first.equals(b.first)) {
                return Integer.compare(a.last, b.last);
            }
            return a.first.compareTo(b.first);
        });

        bw.write(solve(seq, arr, n));

        bw.close();
        br.close();
    }

    static String solve(Pair[] seq, Pair[][] arr, int n) {
        Stack<Pair> wait = new Stack<>();
        // 스택과 큐 비교하면서 대기열 및 탈출 수행
        int seqIdx = 0;
        for (int curIdx = 0; curIdx < 5 * n; curIdx++) {
            int r = curIdx / 5;
            int c = curIdx % 5;

            // for (var a : wait)
            // System.out.print(a + ", ");
            // System.out.println();

            // arr의 요소가 나갈 순서라면 내보냄
            if (seq[seqIdx].equals(arr[r][c])) {
                seqIdx++;
            } else {
                // arr의 요소가 나갈 순서가 아니라면 대기열로 보냄
                wait.push(arr[r][c]);
            }

            // 대기열의 요소가 나갈 순서라면 내보냄
            while (!wait.isEmpty() && wait.peek().equals(seq[seqIdx])) {
                wait.pop();
                seqIdx++;
            }
        }

        return wait.isEmpty() ? "GOOD" : "BAD";
    }

    static class Pair {
        String first;
        int last;

        Pair(String f, int l) {
            first = f;
            last = l;
        }

        @Override
        public String toString() {
            return "{" + first + "-" + last + "}";
        }

        @Override
        public boolean equals(Object o) {
            Pair other = (Pair)o;
            return first.equals(other.first) && last == other.last;
        }
    }
}