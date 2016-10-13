package session1.chapter2;

import java.io.*;

/**
 * Created by dasom on 2016-10-13.
 */
public class Tree {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("SamsungSoftwareAbilityTest\\input_data\\TreeInputData.txt"));
        String inputData = bufferedReader.readLine();
        String[] inputDatas = inputData.split(" ");

        BinaryTree binaryTree = new BinaryTree();

        for (int i = 0; i < inputDatas.length - 1; i += 2) {
            Node parent = binaryTree.getNode(inputDatas[i]);
            if(parent == null){
                parent = new Node(inputDatas[i]);
            }

            Node child = binaryTree.getNode(inputDatas[i+1]);
            if(child == null){
                child = new Node(inputDatas[i+1]);
            }

            binaryTree.insertNode(parent, child);
        }

        System.out.println("<<<<결과>>>>");
        binaryTree.preOrder();

    }

}

class Node {
    String data;
    Node leftChild;
    Node rightChild;

    public Node(String data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinaryTree {
    private Node head;

    public void insertNode(Node parent, Node child) {
        if (head == null) {
            head = parent;
        }

        if (parent.leftChild == null) {
            parent.leftChild = child;
        } else if (parent.rightChild == null) {
            parent.rightChild = child;
        }
    }

    public Node getNode(String data) {
        return findNodeWithPreOrder(head, data);
    }

    private Node findNodeWithPreOrder(Node node, String data) {
        Node result = null;

        if (node == null)
            return null;
        else {
            if (data.equals(node.data)) {
                return node;
            }
        }

        if((result = findNodeWithPreOrder(node.leftChild, data)) != null){
            return result;
        }else if((result = findNodeWithPreOrder(node.rightChild, data)) != null){
            return result;
        }

        return result;
    }

    public void preOrder() {
        preOrder(head, 0);
    }

    public void preOrder(Node parent, int level) {
        // 방문
        if (parent == null)
            return;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<level; i++){
            sb.append("-");
        }
        System.out.println(sb.toString()+parent.data);

        // 왼쪽순회
        preOrder(parent.leftChild, level+1);
        // 오른쪽순회
        preOrder(parent.rightChild, level+1);
    }
}