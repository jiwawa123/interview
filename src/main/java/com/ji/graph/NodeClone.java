package com.ji.graph;

import java.util.*;

/**
 * user ji
 * data 2020/3/25
 * time 9:48 AM
 */
public class NodeClone {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (map.containsKey(node))
            return map.get(node);
        if (node == null)
            return null;
        Node root = new Node(node.val);
        map.put(node, root);
        root.neighbors = cloneList(node.neighbors);
        return root;
    }

    public List<Node> cloneList(List<Node> list) {
        List<Node> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Node tmp = cloneGraph(list.get(i));
            if (tmp != null) {
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NodeClone clone = new NodeClone();
        Node node = new Node(2);
        ArrayList<Node> list = new ArrayList<>();
        list.add(node);
        Node root = new Node(1, list);
        clone.cloneGraph(root);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
