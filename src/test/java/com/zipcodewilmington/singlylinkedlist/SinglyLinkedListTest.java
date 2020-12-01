package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> list;
    private Integer first;
    private Integer sec;
    private Integer third;
    private Integer fourth;

    @Before
    public void setup(){
        first = 1;
        sec = 2;
        third = 4;//  :-)
        fourth = 3;
        list = new SinglyLinkedList<Integer>();
        list.add(first);
        list.add(sec);
        list.add(third);
        list.add(fourth);
    }

    @Test
    public void addTest(){
        Assert.assertEquals(first, list.get(0));
        Assert.assertEquals(sec, list.get(1));
        Assert.assertEquals(third, list.get(2));
        Assert.assertEquals(fourth, list.get(3));
    }

    @Test
    public void removeTest(){
        list.remove(0);
        list.remove(3);

        Assert.assertEquals(sec, list.get(0));
        Assert.assertEquals(third, list.get(1));
    }

    @Test
    public void containsTest(){
        Assert.assertTrue(list.contains(first));
        Assert.assertTrue(list.contains(sec));
        Assert.assertTrue(list.contains(third));
        Assert.assertTrue(list.contains(fourth));
    }

    @Test
    public void sizeTest(){
        Integer actual = 4;
        Assert.assertEquals(list.size(), actual);
    }

    @Test
    public void doesntContainsTest(){
        Assert.assertFalse(list.contains(6));
    }

    @Test
    public void sortTest(){
        SinglyLinkedList<Integer> expected = new SinglyLinkedList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        list.sort();
        Assert.assertEquals(list.get(0), expected.get(0));
        Assert.assertEquals(list.get(1), expected.get(1));
        Assert.assertEquals(list.get(2), expected.get(2));
        Assert.assertEquals(list.get(3), expected.get(3));
    }

    @Test
    public void findTest(){
        Integer expected = list.find(sec);
        Integer actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest(){
        SinglyLinkedList<Integer> copy = list.copy();

        Assert.assertEquals(list.get(0), copy.get(0));
        Assert.assertEquals(list.get(1), copy.get(1));
        Assert.assertEquals(list.get(2), copy.get(2));
        Assert.assertEquals(list.get(3), copy.get(3));
    }



}
