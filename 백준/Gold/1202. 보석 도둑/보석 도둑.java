import java.io.*;
import java.util.*;

class Main {

    static int n, k;
    static PriorityQueue<D> dia;
    static D[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dia = new PriorityQueue<>((a, b) -> Integer.compare(b.v, a.v));
        arr = new D[n + k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new D(a, b);
        }
        for (int i = n; i < n + k; i++) {
            arr[i] = new D(Integer.parseInt(br.readLine()), -1);
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.w, b.w));

        long price = 0;
        for (int i = 0; i < n + k; i++) {
            if (arr[i].v != -1)
                dia.offer(arr[i]);
            else {
                if (dia.isEmpty())
                    continue;
                price += dia.poll().v;
            }
        }
        bw.write(price + "");
        bw.close();
        br.close();
    }

    static class D {
        int w;
        int v;

        D(int ww, int vv) {
            w = ww;
            v = vv;
        }
    }
}