
// bottom View of Tree
import java.util.*;

public class A {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {


        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        ArrayList<Integer> result = bottomView(root);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    private static ArrayList<Integer> bottomView(Node root) {
        HashMap <Integer, Integer> hm = new HashMap<>();
        Queue<Map.Entry<Node,Integer>> q = new LinkedList<>();
        if(root == null) return new ArrayList<>();
        q.offer(new AbstractMap.SimpleEntry<>(root,0));
        int leftmost =0;
        while (!q.isEmpty())
        {
            Map.Entry<Node, Integer>  data =q.poll();
            Node curr = data.getKey();
            int index = data.getValue();
             leftmost = Math.min(index, leftmost);
             hm.put(index, curr.data);

             if(curr.left != null)
                 q.offer(new AbstractMap.SimpleEntry<>(curr.left,index -1));

             if(curr.right !=null)
                 q.offer(new AbstractMap.SimpleEntry<>(curr.right,index +1));


        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (hm.containsKey(leftmost))
        {
            ans.add(hm.get(leftmost++));
        }

        return ans;
    }
}