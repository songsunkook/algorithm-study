import java.io.*;
import java.util.*;

class Main {
    static Map<String, String> p;
    static Map<String, Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            p = new HashMap<>();
            count = new HashMap<>();
            for (int f = 0; f < F; f++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!p.containsKey(a)) {
                    p.put(a, a);
                    count.put(a, 1);
                }
                if (!p.containsKey(b)) {
                    p.put(b, b);
                    count.put(b, 1);
                }
                if (!a.equals(b))
                    union(a, b);
                bw.write(count.get(find(a)) + "\n");
            }
        }

        bw.close();
        br.close();
    }

    static void union(String a, String b) {
        String pa = find(a);
        String pb = find(b);
        p.put(pa, pb);
        if (pa != pb)
            count.put(pb, count.get(pb) + count.get(pa));
    }

    static String find(String a) {
        String pa = p.get(a);
        if (!pa.equals(a))
            p.put(a, find(pa));
        return p.get(a);
    }
}