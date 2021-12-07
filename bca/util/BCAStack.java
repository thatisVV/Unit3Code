package bca.util;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class BCAStack<Element> {
    private ArrayList<Element> list = new ArrayList<Element>();

    public void push(Element e) {
        list.add(e);
    }

    public Element pop() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    public Element peek() {
        if (list.size() == 0) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
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