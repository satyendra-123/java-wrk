package com.test.dsa;

public class Node {
    private int data;
     Node(int data){
        this.data = data;
    }

    public Node left;
    public Node right;

    public int getData(){
        return data;
    }
}
