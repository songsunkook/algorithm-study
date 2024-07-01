/*
    BAEKJOON 5397번 키로거
    https://www.acmicpc.net/problem/5397
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            LL list = new LL();
            String line = br.readLine();
            for (char c : line.toCharArray()) {
                switch (c) {
                    case '-':
                        list.remove();
                        break;
                    case '<':
                        list.moveLeft();
                        break;
                    case '>':
                        list.moveRight();
                        break;
                    default:
                        list.add(c);
                }
            }
            System.out.println(list);
        }
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
