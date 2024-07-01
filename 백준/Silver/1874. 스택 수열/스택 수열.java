import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int topNumber = 0;
        boolean NO = false;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (true) {
                if (topNumber < arr[i]) {
                    topNumber++;
                    stack.push(topNumber);
                    answer.append("+\n");
                }
                if (topNumber == arr[i]) {
                    answer.append("-\n");
                    if (!pop(stack)) {
                        NO = true;
                    }
                    break;
                }
                if (topNumber > arr[i]) {
                    if (!stack.contains(arr[i])) {
                        NO = true;
                    }
                    answer.append("-\n");
                    if (!pop(stack)) {
                        NO = true;
                    }
                    break;
                }
            }
            if (NO) {
                break;
            }
        }
        if (NO) {
            bw.write("NO");
        } else {
            bw.write(answer.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean pop(Stack stack) {
        if (stack.isEmpty()) {
            return false;
        }
        stack.pop();
        return true;
    }
}
