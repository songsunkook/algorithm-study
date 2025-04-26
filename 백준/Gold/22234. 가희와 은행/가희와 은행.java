import java.io.*;
import java.util.*;

/**
 * 손님은 필요한 시간만큼 상담이 끝나면 대기열을 탈출한다.
 * 손님은 상담이 끝났을 때 필요한 시간이 남아있으면 대기열 맨 뒤로 다시 간다.
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 손님 수
        int T = Integer.parseInt(st.nextToken()); // 단일 처리 최대 단위 시간
        int W = Integer.parseInt(st.nextToken()); // 은행 운영 시간
        Queue<Customer> q = new LinkedList<>(); // 손님 총 대기열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            q.offer(new Customer(p, t, 0));
        }
        int m = Integer.parseInt(br.readLine());
        List<Customer> moreArr = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            moreArr.add(new Customer(p, t, c));
        }
        Collections.sort(moreArr, (a, b) -> Integer.compare(a.c, b.c));
        Queue<Customer> more = new LinkedList<>(moreArr); // 시간이 지남에 따라 들어오는 손님들

        Customer needOffer = null;
        for (int time = 0; time < W;) {
            // 새로 들어온 손님 추가
            while (!more.isEmpty() && more.peek().c <= time) {
                q.offer(more.poll());
            }

            if (needOffer != null) {
                q.offer(needOffer);
            }

            // 아무도 없으면 종료(도달하지 않음)
            if (q.isEmpty()) {
                throw new IllegalArgumentException();
            }

            // 기존 손님 맨뒤로 이동 or 탈출
            var cur = q.poll();
            int interviewTime = 0;
            if (cur.t > T) {
                // 맨 뒤로 이동
                cur.t -= T;
                needOffer = cur;
                interviewTime = T;
            } else {
                // 탈출
                interviewTime = cur.t;
                needOffer = null;
            }

            // 현재 손님 출력
            for (int wr = 1; wr <= interviewTime; wr++) {
                if (time + wr > W) {
                    break;
                }
                bw.write(cur.p + "\n");
            }
            time += interviewTime;
        }

        bw.close();
        br.close();
    }

    static class Customer {
        int p; // id. 출력 대상
        int t; // 남은 상담 필요 시간
        int c; // 도착 시간

        Customer(int pp, int tt, int cc) {
            p = pp;
            t = tt;
            c = cc;
        }

        @Override
        public String toString() {
            return String.format("{id:%d, t:%d, c:%d}", p, t, c);
        }
    }
}
