package lt.bt.task.node;

import java.util.List;

public class Node61 {

    public static void main(String[] args) {

        D61Node d = new D61Node("d");
        D61Node e = new D61Node("e");

        D61Node b = new D61Node("b");
        b.setChildL(d);
        b.setChildR(e);

        D61Node c = new D61Node("c");

        D61Node a = new D61Node("a");
        a.setChildL(b);
        a.setChildR(c);

        D61Node f = new D61Node("f");
        D61Node g = new D61Node("g");


        c.setChildL(f);
        c.setChildR(g);

        spausdinti(a);


    }

    public static void spausdinti(D61Node root) {
        D61Node rootL = root;
        D61Node rootR = root;

        print(root);

        for (;rootL.getChildL() != null && rootR.getChildL() != null;){

            D61Node left = rootL.getChildL();
            D61Node right = rootL.getChildR();

            if (left != null) {
                print(left);
                rootL = left;
            }

            if (right != null) {
                print(right);
                rootR = right;
            }
        }

    }

    public static void print(D61Node node){
        System.out.println(node.getName());
    }

}

class D61Node {
    String name;
    D61Node childL, childR;

    public D61Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public D61Node getChildL() {
        return childL;
    }

    public void setChildL(D61Node childL) {
        this.childL = childL;
    }

    public D61Node getChildR() {
        return childR;
    }

    public void setChildR(D61Node childR) {
        this.childR = childR;
    }
}
