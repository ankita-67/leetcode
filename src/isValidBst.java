public class isValidBst {
        // Function to check if the binary tree
        // is a BST using Morris Traversal
        static boolean isBST(Node root) {
            Node curr = root;
            Node pre;
            int prevValue = Integer.MIN_VALUE;

            while (curr != null) {


                if (curr.left == null) {
                    System.out.println("inside current.data is null"+curr.data+"   "+Integer.MIN_VALUE );
                    if (curr.data < prevValue) {

                        // Not in ascending order
                        return false;
                    }
                    prevValue = curr.data;
                    System.out.println("inside current.left is null"+prevValue);
                    curr = curr.right;
                    System.out.println("inside current update after null"+curr.data);


                } else {


                    pre = curr.left;
              System.out.println(pre.data);
                    while (pre.right != null && pre.right != curr) {
                        pre = pre.right;
                    }

                    if (pre.right == null) {

                        // Create a temporary thread to the curr node
                        pre.right = curr;
                        System.out.println("inside pre is null"+pre.data);
                        curr = curr.left;

                        System.out.println("inside current  is updated to"+curr.data);
                    } else {

                        // Remove the temporary thread
                        pre.right = null;
System.out.print("current "+curr.data+" ");
                        // Process the curr node
                        if (curr.data <= prevValue) {

                            // Not in ascending order
                            return false;
                        }
                        prevValue = curr.data;
                        curr = curr.right;
                    }
                }

            }

            return true;
        }

        public static void main(String[] args) {

            // Create a sample binary tree
            //      5
            //    /   \
            //  1     4
           //        /  \
            //      3    6

            Node root = new Node(-2147483648);
//            root.left = new Node(1);
//            root.right = new Node(4);
//            root.right.left = new Node(3);
//            root.right.right = new Node(6);

            if (isBST(root)) {
                System.out.println("True");
            }
            else {
                System.out.println("False");
            }
        }
    }

