/*
    BAEKJOON 1158번 요세푸스 문제
    https://www.acmicpc.net/problem/1158
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LL list = new LL();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> result = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        while (list.size > 0) {
            for (int i = 0; i < K; i++) {
                list.next();
            }
            result.add(list.remove());
        }
        list.next();
        System.out.print("<" + result.get(0));
        for (int i = 1; i < result.size(); i++) {
            System.out.print(String.format(", %d", result.get(i)));
        }
        System.out.print(">");
    }

    public static class LL {
        public Node head;
        public Node last;
        public int size;
        public Node cursor;

        public LL() {
            head = new Node(-1);
            last = head;
            cursor = head;
            size = 0;
        }

        public void add(int data) {
            Node n = new Node(data);
            n.prev = cursor;
            n.next = cursor.next;
            if (cursor != last) {
                cursor.next.prev = n;
            } else {
                last = n;
            }
            cursor.next = n;
            cursor = n;
            size++;
        }

        public int remove() {
            int ret = cursor.data;
            if (cursor != head) {
                cursor.prev.next = cursor.next;
                if (cursor == last) {
                    last = cursor.prev;
                } else {
                    cursor.next.prev = cursor.prev;
                }
                cursor = cursor.prev;
            }
            size--;
            return ret;
        }

        public void next() {
            if (cursor == last) {
                cursor = head.next;
            } else {
                cursor = cursor.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node cur = head.next;
            while (cur != null) {
                sb.append(cur.data);
                cur = cur.next;
            }
            return sb.toString();
        }

        public static class Node {
            public int data;
            public Node prev = null;
            public Node next = null;

            public Node(int data) {
                this.data = data;
            }
        }
    }
}
