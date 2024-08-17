import java.io.*;
import java.util.*;

public class debug {
    static Node[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test = 1; test <= 11; test++) {
            int N = Integer.parseInt(br.readLine());
            trees = new Node[N + 1];
            for (int i = 1; i <= N; i++) {
                String[] input = br.readLine().split(" ");
                // 2번째가 연산자면 3,4번째 존재
                Node aa = new Node(input[1]);
                trees[i] = aa;
                if (isOperator(input[1])) {
                    trees[i].left = input[2];
                    trees[i].right = input[3];
                }
            }
            
            postorder(1);
            System.out.println(trees[1].value);
            
            for (Node t : trees) {
                if (t == null) {
                    continue;
                }
//                System.out.print(t.value + " ");
            }
            System.out.println();
            System.out.println("-------end-------");
        }
    }
    
    static class Node {
        String left;
        String right;
        String value;
        
        Node() {}
        
        Node(String value) {
            this.value = value;
        }
    }
    
    static boolean isOperator(String s) {
        return s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/");
    }

    public static void postorder(int root) {
        if (trees.length < root || trees[root].left == null || trees[root].right == null) {
            return; 
        }
//        System.out.println(root);
        postorder(Integer.parseInt(trees[root].left));
        postorder(Integer.parseInt(trees[root].right));
        if (!isOperator(trees[root].value)) {
            return;
        }
        
        int left = Integer.parseInt(trees[Integer.parseInt(trees[root].left)].value);
        int right = Integer.parseInt(trees[Integer.parseInt(trees[root].right)].value);
//        int right = Integer.parseInt(trees[root * 2 + 1].value);
        if (trees[root].value.equals("+")) {
            trees[root].value = Integer.toString(left + right);
        } else if (trees[root].value.equals("-")) {
            trees[root].value = Integer.toString(left - right);
        } else if (trees[root].value.equals("*")) {
            trees[root].value = Integer.toString(left * right);
        } else {
            trees[root].value = Integer.toString(left / right);
        }
    }
}