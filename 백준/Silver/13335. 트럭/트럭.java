import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cur = 0;
        int time = 1;
        int nowL = 0;
        Queue<T> q = new LinkedList<>();
        while (arr.length > cur || !q.isEmpty()) {
            if (!q.isEmpty() && time - q.peek().initTime >= w) {
                nowL -= q.poll().l;
            }
            if (arr.length > cur) {
                if (arr[cur] + nowL <= l) {
                    q.offer(new T(arr[cur], time));
                    nowL += arr[cur];
                    cur++;
                }
            }
            time++;
        }
        bw.write(time - 1 + "");

        bw.close();
        br.close();
    }

    static class T {
        int l;
        int initTime;

        T(int l, int initTime) {
            this.l = l;
            this.initTime = initTime;
        }
    }
}