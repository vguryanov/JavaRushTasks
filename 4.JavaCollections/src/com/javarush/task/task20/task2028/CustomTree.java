package com.javarush.task.task20.task2028;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    int size = -1;
    ArrayList<ArrayList<Entry>> lines = new ArrayList<>();

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    public static void main(String[] args) {
        CustomTree list = new CustomTree();
        for (int i = 0; i < 18; i++) {
            System.out.println(list.add(String.valueOf(i)));
        }

        System.out.println(list.size());
        System.out.println(list.getEntry("11"));
        System.out.println(list.getParent("10"));
        list.remove("3");
        System.out.println(list.size());
//        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
//        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String getParent(String s) {
        return getEntry(s).parent.elementName;
    }

    @Override
    public int size() {
        return size;
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public Entry getEntry(String s) {
        Entry result;

        for (ArrayList<Entry> list : lines)
            for (Entry entry : list)
                if (entry.elementName.equals(s)) {
                    return entry;
                }

        return null;
    }

    public boolean setAvailableParent(Entry startEntry, Entry childEntry) {
        for (Entry entry : lines.get(startEntry.lineNumber)) {
            if (entry.availableToAddLeftChildren) {
                entry.leftChild = childEntry;
                entry.availableToAddLeftChildren = false;
                childEntry.parent = entry;
                childEntry.lineNumber = entry.lineNumber + 1;

                if (lines.size() == childEntry.lineNumber) lines.add(new ArrayList<>());
                lines.get(childEntry.lineNumber).add(childEntry);
                size++;

                return true;
            } else if (entry.availableToAddRightChildren) {
                entry.rightChild = childEntry;
                entry.availableToAddRightChildren = false;
                childEntry.parent = entry;
                childEntry.lineNumber = entry.lineNumber + 1;

                if (lines.get(childEntry.lineNumber) == null) lines.add(new ArrayList<>());
                lines.get(childEntry.lineNumber).add(childEntry);
                size++;

                return true;
            }
        }

        return setAvailableParent(lines.get(startEntry.lineNumber + 1).get(0), childEntry);
    }

    @Override
    public boolean add(String s) {
        if (root == null) {
            root = new Entry<>(s);
            root.lineNumber = 0;
            lines.add(new ArrayList<>());
            lines.get(0).add(root);
            size++;
            return true;
        } else {
            Entry newEntry = new Entry(s);
            return setAvailableParent(root, newEntry);
        }
    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(String s) {
        Queue<Entry> removingEntries = new ConcurrentLinkedQueue();
        removingEntries.offer(getEntry(s));

        while (!removingEntries.isEmpty()) {
            Entry entry = removingEntries.poll();
            if (entry.leftChild != null) removingEntries.offer(entry.leftChild);
            if (entry.rightChild != null) removingEntries.offer(entry.rightChild);

            lines.get(entry.lineNumber).remove(entry);
            if (entry.lineNumber > 0) {
                if (entry.parent.leftChild != null && entry.parent.leftChild.equals(entry))
                    entry.parent.leftChild = null;
                else if (entry.parent.rightChild != null && entry.parent.rightChild.equals(entry))
                    entry.parent.rightChild = null;
            }

            size--;
        }


        return false;
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}
