package com.zipcodewilmington.singlylinkedlist;

public class Node<T> {

    private T obj;
    private Node next;
    private Integer index = 0;

    public Node(T obj, Node next){
        this.next = next;
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public Node getNext() {
        return next;
    }

    public Integer getIndex() {
        return index;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
