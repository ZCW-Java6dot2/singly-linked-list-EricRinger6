package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {
    @Test
    public void constructorTest(){
        Integer actual = 5;
        Node node = new Node(actual, null);

        Assert.assertEquals(actual, node.getObj());
        Assert.assertNull(node.getNext());
    }

    @Test
    public void indexTest(){
        Integer actual = 5;
        Node node= new Node(actual, null);
        node.setIndex(actual);

        Assert.assertEquals(actual, node.getIndex());
    }

    @Test
    public void objTest(){
        Integer actual = 5;
        Node node = new Node(actual, null);
        actual = 10;
        node.setObj(actual);

        Assert.assertEquals(actual, node.getObj());
    }

    @Test
    public void nextTest(){
        Integer actual = 5;
        Node node = new Node(actual, null);

        node.setNext(node);

        Assert.assertEquals(node, node.getNext());
    }
}
