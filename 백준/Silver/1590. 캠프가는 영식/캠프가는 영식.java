import java.io.*;
import java.util.*;

class Main {
    
    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int interval = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            
            for(int j=0;j<count;j++) {
                arr.add(start + interval * j);
            }
        }
        Collections.sort(arr);

        int resultIdx = lowerBound(t);
        int result = 0;
        if (resultIdx == arr.size())
            result = -1;
        else
            result = arr.get(resultIdx) - t;
        bw.write(result + "");
        bw.close();
        br.close();
    }

    private static int lowerBound(int t) {
        int l = 0;
        int r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) < t)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}