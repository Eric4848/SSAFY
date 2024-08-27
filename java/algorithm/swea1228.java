import java.util.*;
import java.io.*;

//class Node {
//	String data;
//	Node next;
//}
//
//class SinglyLinkedList {
//	Node head;
//	int size = 0;
//	
//	SinglyLinkedList() {
//		head = new Node();
//	}
//	
//	void insertData(int i, String data) {
//		Node curr = head;
//		for(int d = 0; d < i; d++) {
//			curr = curr.next;
//		}
//		Node newNode = new Node();
//		newNode.data = data;
//		newNode.next = curr.next;
//		curr.next = newNode;
//		size++;
//	}
//	
//	void printAns() {
//		Node curr = head.next;
//		for(int i = 0; i < 10; i++) {
//			System.out.print(curr.data + " ");
//			curr = curr.next;
//		}
//		System.out.println();
//	}
//}

public class swea1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1; tc <= 10; tc++) {
			SinglyLinkedList list = new SinglyLinkedList();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list.insertData(i, st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				String order = st.nextToken();
				if (order.equals("I")) {
					int start = Integer.parseInt(st.nextToken());
					int length = Integer.parseInt(st.nextToken());
					for(int k = 0; k < length; k++) {
						list.insertData(start + k, st.nextToken());
					}
				}
			}
			System.out.print("#" + tc + " ");
			list.printAns();
		}
	}
}