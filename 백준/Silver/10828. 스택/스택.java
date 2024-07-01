import java.io.*;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        Stack stack = new Stack<>();
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("push"))
                stack.push(Integer.parseInt(st.nextToken()));
            if (command.equals("pop")) {
                if (!stack.empty())
                    bw.write(String.valueOf(stack.pop()) + '\n');
                else
                    bw.write("-1\n");
            }
            if (command.equals("size"))
                bw.write(Integer.toString(stack.size()) + '\n');
            if (command.equals("empty"))
                bw.write(Integer.toString(stack.empty() ? 1 : 0) + '\n');
            if (command.equals("top")) {
                if (!stack.empty())
                    bw.write(String.valueOf(stack.peek()) + '\n');
                else
                    bw.write("-1\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
