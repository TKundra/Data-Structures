//class Tree {
//
//    static class Node {
//        int key;
//        Node left, right;
//        Node(int key){
//            this.key = key;
//        }
//    }
//    Node root;
//
//    Node insert(Node node, int key){
//        if (node == null){
//            node = new Node(key);
//            return node;
//        }
//        else if (key < node.key)
//            node.left = insert(node.left, key);
//        else if (key > node.key)
//            node.right = insert(node.right, key);
//        return node;
//    }
//    void insert(int key){
//        root = insert(root, key);
//    }
//
//    Node delete(Node node, int key){
//        if (node == null)
//            return root;
//        else if (key < node.key)
//            node.left = delete(node.left, key);
//        else if (key > node.key)
//            node.right = delete(node.right, key);
//        else {
//            if (node.left == null && node.right == null)
//                return null;
//            else if (node.left == null)
//                return node.right;
//            else if (node.right == null)
//                return node.left;
//
//            node.key = minValue(node.right);
//            node.right = delete(node.right, key);
//
//        }
//        return node;
//    }
//    int minValue(Node node){
//        int key = node.key;
//        while (node.left!=null){
//            key = node.left.key;
//            node = node.left;
//        }
//        return key;
//    }
//    void delete(int key){
//        root = delete(root, key);
//    }
//
//    public static void main(String[] args) {
//        Tree tree = new Tree();
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//    }
//
//}

class Tree {

    static class Node {
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    int height(Node node){
        if (node == null) {
            return 0;
        }
        return (1+Math.max(height(node.left), height(node.right)));
    }

    int diameter(Node node){
        if (node == null)
            return 0;
        int left_height = height(node.left);
        int right_height = height(node.right);
        int left_diameter = diameter(node.left);
        int right_diameter = diameter(node.right);
        return Math.max(
                left_height+right_height+1,
                Math.max(left_diameter, right_diameter)
        );
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(Math.abs(6-7));
        System.out.println(Math.abs(8 -7));
    }

}

class Main {

    static class Node {
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    static class NodeInfo {
        int min, max, size, ans;
        boolean isBST;
        NodeInfo(){}
        NodeInfo(int min, int max, int size, int ans, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.ans = ans;
            this.isBST = isBST;
        }
        static int MIN = Integer.MIN_VALUE;
        static int MAX = Integer.MAX_VALUE;

        NodeInfo largestBST(Node node){
            if (node == null)
                return new NodeInfo(MIN, MAX, 0, 0, true);
            if (node.left == null && node.right == null)
                return new NodeInfo(node.key, node.key, 1, 1, true);

            NodeInfo leftNode = largestBST(node.left);
            NodeInfo rightNode = largestBST(node.right);

            NodeInfo returnInfo = new NodeInfo();
            returnInfo.size = 1+ leftNode.size + rightNode.size;

            if (leftNode.isBST && rightNode.isBST && leftNode.max<node.key && rightNode.min > node.key){
                returnInfo.min = Math.min(Math.min(leftNode.min, rightNode.min), node.key);
                returnInfo.max = Math.max(Math.min(leftNode.max, rightNode.max), node.key);
                returnInfo.ans = returnInfo.size;
                returnInfo.isBST = true;
                return returnInfo;
            }

            returnInfo.ans = Math.max(leftNode.ans, rightNode.ans);
            returnInfo.isBST = false;
            return returnInfo;

        }

    }

    public static void main(String[] args){

    }

}
































