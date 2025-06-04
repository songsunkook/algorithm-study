import java.io.*;
import java.util.*;

class Main {

    static int n, m;
    static Set<String> arr1, arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr1 = new HashSet<>();
        arr2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr1.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            arr2.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for (var a : arr1) {
            if (arr2.contains(a)) {
                result.add(a);
            }
        }
        Collections.sort(result);
        bw.write(result.size() + "\n");
        for (var a : result)
            bw.write(a + "\n");

        bw.close();
        br.close();
    }
}