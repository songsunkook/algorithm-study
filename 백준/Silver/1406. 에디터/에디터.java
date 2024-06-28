/*
    BAEKJOON 1406번 에디터
    https://www.acmicpc.net/problem/1406
    
    복습 필요
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        LL list = new LL();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String param1 = st.nextToken();
            switch (param1) {
                case "P":
                    char param2 = st.nextToken().charAt(0);
                    list.add(param2);
                    break;
                case "L":
                    list.moveLeft();
                    break;
                case "D":
                    list.moveRight();
                    break;
                case "B":
                    list.remove();
                    break;
            }
        }
        System.out.print(list);
    }

    public static class LL {
        public Node head;
        public Node last;
        public int size;
        public Node cursor;

        public LL() {
            head = new Node((char)-1);
            last = head;
            cursor = head;
            size = 0;
        }

        public void add(char data) {
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
        }

        public void remove() {
            if (cursor != head) {
                cursor.prev.next = cursor.next;
                if (cursor == last) {
                    last = cursor.prev;
                } else {
                    cursor.next.prev = cursor.prev;
                }
                cursor = cursor.prev;
            }
        }

        public void moveLeft() {
            if (cursor != head) {
                cursor = cursor.prev;
            }
        }

        public void moveRight() {
            if (cursor != last) {
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
            public char data;
            public Node prev = null;
            public Node next = null;

            public Node(char data) {
                this.data = data;
            }
        }
    }
}
