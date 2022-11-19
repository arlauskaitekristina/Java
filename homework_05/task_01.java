package homework_05;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class task_01 {
    public static void main(String[]args){
        Node root = new Node(1);

        Node lev02 = new Node(2);
        Node lev03 = new Node(3);

        Node lev04 = new Node(4);
        Node lev05 = new Node(5);
        Node lev06 = new Node(6);

        Node lev07 = new Node(7);
        Node lev08 = new Node(8);
        Node lev09 = new Node(9);
        Node lev10 = new Node(11);
        Node lev11 = new Node(20);

        root.addDescendants(lev02);
        root.addDescendants(lev03);

        lev02.addDescendants(lev04);
        lev03.addDescendants(lev05);
        lev03.addDescendants(lev06);

        lev04.addDescendants(lev07);
        lev04.addDescendants(lev08);
        lev04.addDescendants(lev09);
        lev06.addDescendants(lev10);
        lev06.addDescendants(lev11);

        Tracer.TreeTracer(root);
        String coolRep = Printer.EnhancedPrinter(root);
        System.out.println();
        System.out.println(coolRep);
    }
}

class Node {
    private int value;
    ArrayList<Node> descendants = new ArrayList<>();
    public Node(int value) {
        this.value = value;
    }
    public void addDescendants (Node node) {
        descendants.add(node);
    }
    public int getValue() {
        return value;
    }
}

class Printer {
    static String EnhancedPrinter (Node root) {
        StringBuilder treeRepresentation = new StringBuilder(root.getValue() + "");
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node currentNode = nodes.poll();
            if (!currentNode.descendants.isEmpty()) {
                nodes.addAll(currentNode.descendants);
                int descendantsLast = currentNode.descendants.toArray().length - 1;
                StringBuilder descendantsRepresentation = new StringBuilder("(");
                for (Node descendant : currentNode.descendants) {
                    descendantsRepresentation.append(descendant.getValue());
                    if (currentNode.descendants.indexOf(descendant) != descendantsLast) {
                        descendantsRepresentation.append(",");
                    }
                }
                descendantsRepresentation.append(")");
                treeRepresentation.insert(
                        treeRepresentation.indexOf(String.valueOf(currentNode.getValue())) + 1,
                        descendantsRepresentation);
            }
        }
        return treeRepresentation.toString();
    }
}

class Tracer {
    static void TreeTracer(Node root) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node current_node = nodes.poll();
            System.out.print(current_node.getValue() + " ");
            nodes.addAll(current_node.descendants); 
        }
    }
}