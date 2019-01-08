package lt.bt.task.node;

import java.util.LinkedList;
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

//        D61Node f = new D61Node("f");
//        D61Node g = new D61Node("g");
//
//        c.setChildL(f);
//        c.setChildR(g);

        spausdinti(a);

    }


    public static void spausdinti(D61Node root) {
        print(root);
        List<D61Node> node = new LinkedList<>();
        node.add(root);
        sukti(node);
    }



    public static List <D61Node> sukti(List <D61Node> rootList) {
        List<D61Node> newRoot = new LinkedList<>();
        List<D61Node> allRoot = new LinkedList<>();
        if (rootList.size() != 0) {
            for (D61Node n : rootList) {
                if (n.getChildL() != null) newRoot.add(n.getChildL());
                if (n.getChildR() != null) newRoot.add(n.getChildR());
            }
            for (D61Node node : newRoot) {
                if (!allRoot.contains(node)){
                    allRoot.add(node);
                    print(node);
                }
            }
            sukti(newRoot);
        }
       return newRoot;
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

    @Override
    public String toString() {
        return name;
    }
}

