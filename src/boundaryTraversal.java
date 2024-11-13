
public class boundaryTraversal {
    Node root;
    public static void main(String args[])
    {
        boundaryTraversal tree = new boundaryTraversal();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
    }

    private void printBoundary(Node root) {

        if (root == null )
            return;

        System.out.print(root.data+" ");

        printLeftBoundary(root.left);
       printleaves(root.left);
       printleaves(root.right);
      printrightBoundary(root.right);

    }

    private void printrightBoundary(Node node) {
        if(node == null)
            return;

        if(node.right != null)
        {
          printrightBoundary(node.right);
          System.out.print(node.data+" ");
        }
        else if(node.left != null)
        {
            printrightBoundary(node.left);
            System.out.print(node.data+" ");
        }

    }

    private void printleaves(Node node) {
        if(node == null)
            return;
        printleaves(node.left);
        if(node.left == null && node.right == null)
            System.out.print(node.data+" ");
        printleaves(node.right);
    }

    private void printLeftBoundary(Node node) {

        if(node == null)
            return;

        if(node.left != null) {
            System.out.print(node.data+" " );
            printLeftBoundary(node.left);
        }
        else if(node.right != null)
        {
            System.out.print(node.data+" ");
            printLeftBoundary(node.right);
        }
    }
}
