package bca.util;

import java.util.*;

public class BCAQueue<E> {
    private List<E> list = new LinkedList<>();
    
    public void enqueue(E e){
        list.add(e);
    }

    public E dequeue(){
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.remove(0);
    }

    public E peek(){
        if (list.isEmpty()){
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
} 
