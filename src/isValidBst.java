class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}


public class isValidBst {
        // Function to check if the binary tree
        // is a BST using Morris Traversal
        static boolean isBST(Node root) {
            Node curr = root;
            Node pre;
            int prevValue = Integer.MIN_VALUE;

            while (curr != null) {


                if (curr.left == null) {
                    System.out.println("inside first if cureent right "+curr.right.data);
                    System.out.println("inside first if cureent "+curr.data);
                    // Process curr node
                    if (curr.data <= prevValue) {

                        // Not in ascending order
                        return false;
                    }
                    prevValue = curr.data;

                    curr = curr.right;


                } else {


                    pre = curr.left;

                    while (pre.right != null && pre.right != curr) {
                        pre = pre.right;
                    }

                    if (pre.right == null) {

                        // Create a temporary thread to the curr node
                        pre.right = curr;

                        curr = curr.left;

                    } else {
                        System.out.println("inside first if pre ");
                        // Remove the temporary thread
                        pre.right = null;

                        // Process the curr node
                        if (curr.data <= prevValue) {

                            // Not in ascending order
                            return false;
                        }
                        prevValue = curr.data;
                        curr = curr.right;
                    }
                }
                System.out.println("WHILE LOOP ");
            }

            return true;
        }

        public static void main(String[] args) {

            // Create a sample binary tree
            //      4
            //    /   \
            //   2     5
            //  / \
            // 1   3

            Node root = new Node(4);
            root.left = new Node(2);
            root.right = new Node(5);
            root.left.left = new Node(1);
            root.left.right = new Node(3);

            if (isBST(root)) {
                System.out.println("True");
            }
            else {
                System.out.println("False");
            }
        }
    }

