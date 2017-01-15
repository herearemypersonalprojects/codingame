import java.util.HashSet;
import java.util.Set;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class AmazonBST
{
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public Node(Node node) {
            this.value = node.value;
            left = node.left;
            right = node.right;
        }

        public void setValue(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public void setLeft(Node node) {
            left = node;
        }
        public Node getLeft() {
            return left;
        }


        public void setRight(Node node) {
            right = node;
        }
        public Node getRight() {
            return right;
        }
    }

    static class Tree {
            Node top;
            Node current;

            public Tree(int[] values, int n) {
                for (int i = 0; i < n; i++) {
                    Node node = new Node(values[i]);
                    current = top;
                    insert(node);
                }
            }

            private void insert(Node node) {
                if (top == null) {
                    top = new Node(node);
                    current = top;
                } else {
                    while (true) {
                        if (node.getValue() < current.getValue()) {
                            if (current.getLeft() == null) {
                                current.setLeft(new Node(node));
                                break;
                            } else
                                current = current.getLeft();
                        } else {
                            if (current.getRight() == null) {
                                current.setRight(new Node(node));
                                break;
                            } else
                                current = current.getRight();
                        }
                    }
                }
            }

        private Node findNode(int value, Node branch, Set<Integer> s) {
            if (branch == null) {
                return null;
            }

            if (branch.getValue() == value) {
                s.add(value);
                return branch;
            }
            s.add(branch.getValue());
            if (value < branch.getValue()) {
                return findNode(value, branch.getLeft(), s);
            } else {
                return findNode(value, branch.getRight(), s);
            }

        }

        public int findDistance(int value1, int value2) {
            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();

            Node node1 = findNode(value1, top, s1);
            Node node2 = findNode(value2, top, s2);

            if (node1 == null || node2 == null) return -1;

            s1.retainAll(s2);

            return s1.size();
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int bstDistance()
    {
        int[] values;

        values = new int[] {5, 6, 3, 1, 2, 4};

        int n = 6;

        int node1 = 2;
        int node2 = 4;

        // WRITE YOUR CODE HERE
        Tree tree = new Tree(values, n);
        return tree.findDistance(node1, node2);

    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        System.out.print(bstDistance());
    }
}