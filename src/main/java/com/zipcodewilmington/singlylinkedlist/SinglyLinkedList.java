package com.zipcodewilmington.singlylinkedlist;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>>{

    private Node<T> tail;
    private Node<T> head;
    private Integer size;


    public T get(Integer index){
        Integer tIndex = head.getIndex();
        Node<T> tNode = head;
        while (tIndex != index){
            tIndex++;
            tNode = tNode.getNext();
        }
        return tNode.getObj();
    }

    public void add(T object){
        if(head == null){
            head = new Node<T>(object, null);
            head.setIndex(0);
        } else if(tail == null){
            tail = new Node<T>(object, null);
            head.setNext(tail);
            tail.setIndex(1);
        } else{
            int nextInd = tail.getIndex() + 1;
            tail.setNext(new Node<T>(object, null));
            tail = tail.getNext();
            tail.setIndex(nextInd);
        }
        size++;
    }

    public void remove(Integer index){
        if(index == 0 && this.size == 1){
            head = null;
        } else if(index == 0){
            Node<T> newHead = head.getNext();
            head.setNext(null);
            head = newHead;
            head.setIndex(0);
            shiftIndex(tail.getNext(), 0);
        } else if(index == 1){
            Node<T> tNode = head.getNext();
            Node<T> next = tNode.getNext();
            head.setNext(next);
            next.setIndex(1);
            tNode.setNext(null);
            shiftIndex(head.getNext(), 1);
        } else{
            Node<T> tNode = head.getNext();
            while(tNode.getIndex() != index - 1){
                tNode = tNode.getNext();
            }
            Integer tempInd = tNode.getIndex();
            Node<T> replace = tNode.getNext();
            if(replace.getNext() == null){
                tNode.setNext(null);
            } else{
                Node<T> temp = tNode.getNext();
                tNode.setNext(temp);
                replace.setNext(null);
                temp.setIndex(tempInd + 1);
                shiftIndex(temp.getNext(), temp.getIndex());
            }
        }
        size--;
    }

    public void shiftIndex(Node<T> node, Integer index){
        while(node != null){
            node.setIndex(index);
            node = node.getNext();
            index++;
        }
    }

    public void set(Integer index, T object){
        Integer tIndex = head.getIndex();
        Node<T> tNode = head;
        while (tIndex != index){
            tIndex++;
            tNode = tNode.getNext();
        }
        tNode.setObj(object);
    }

    public Boolean contains(T object){
        Node<T> tNode = head;
        if (head == null){
            return false;
        } else {
            for(int i = 0; i < this.size; i++){
                if(tNode.getObj() == object){
                    return true;
                }
                tNode = tNode.getNext();
            }
        }
        return false;
    }

    public Integer size(){
        return this.size;
    }

    public SinglyLinkedList<T> copy(){
        Integer copiedSize = this.size;
        SinglyLinkedList<T> copy = new SinglyLinkedList<T>();
        if(copiedSize == 0){
            return copy;
        } else {
            Node<T> tNode = head;
            while(tNode != null){
                copy.add(tNode.getObj());
                tNode = tNode.getNext();
            }
        }
        return copy;
    }

    public Integer find(T object){
        Node<T> tNode = head;
        Integer count = 0;
        if (head == null){
            return -1;
        }
        while(tNode != null){
            if(tNode.getObj() == object){
                return count;
            }
            count++;
            tNode = tNode.getNext();
        }
        return -1;
    }

    public void swap(T object1, T object2){
        Node<T> tNode = head;
        Integer ind1 = -1;
        Integer ind2 = -1;
        while(tNode != null){
            if(tNode.getObj() == object1){
                ind1 = tNode.getIndex();
            } else if(tNode.getObj() == object2){
                ind2 = tNode.getIndex();
            }
            tNode = tNode.getNext();
        }
        set(ind1, object2);
        set(ind2, object1);
    }

    public void sort(){
        for(int i = 0; i < this.size - 1; i++){
            T currentI = get(i);
            for(int x = i + 1; x < size; x++){
                T currentX = get(x);
                if(currentI.compareTo(currentX) > 0){
                    swap(currentI, currentX);
                    currentI = currentX;
                }
            }
        }
    }
}

