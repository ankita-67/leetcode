import java.util.HashMap;

////Construct Tree from given Inorder and Preorder traversals
public class TreeFromInAndPreOrder {
    public static void main(String[] args) {
        int[] in = {3, 1, 4, 0, 5, 2};
        int[] pre = {0, 1, 3, 4, 2, 5};
        Node root = buildTree(in, pre);

        printPostorder(root);
    }

    private static Node buildTree(int[] in, int[] pre) {

      int n = in.length;
      int[] preValue = {0};
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<in.length;i++)
        {
            hm.put(in[i],i);
        }
return buildTreeRec(hm, pre, preValue,0, n-1);
    }

    private static Node buildTreeRec(HashMap<Integer, Integer> hm, int[] pre, int[] preValue, int s, int e) {

        if(s>e)
            return null;

Node root = new Node(pre[preValue[0]]);
preValue[0]++;
int index = hm.get(pre[preValue[0]-1]);

        root.left =buildTreeRec(hm, pre, preValue,s,index-1);
        root.right=   buildTreeRec(hm, pre, preValue,index+1,e);
        return root;
    }
    static void printPostorder(Node root) {
        if (root == null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }
}
