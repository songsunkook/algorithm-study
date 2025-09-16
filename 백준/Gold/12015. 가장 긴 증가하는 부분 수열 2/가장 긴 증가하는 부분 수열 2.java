import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        List<Integer> lis = new ArrayList<>();
        lis.add(0);
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            int l = 0, r = lis.size();
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (lis.get(mid) < arr[i])
                    l = mid;
                else
                    r = mid;
            }
            if (r == lis.size())
                lis.add(arr[i]);
            else
                if (lis.get(r) > arr[i]) {
                    lis.set(r, arr[i]);
                }
        }
        bw.write(lis.size() - 1 + "");
        bw.close();
        br.close();
    }
}