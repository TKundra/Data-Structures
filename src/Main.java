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

class Main {

    public static void main(String[] args){

    }

}
