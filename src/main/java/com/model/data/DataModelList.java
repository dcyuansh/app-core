package com.model.data;

import java.io.Serializable;
import java.util.*;

/**
 * @author DC Yuan
 * @version 1.0
 */
public class DataModelList implements List, Serializable {

    private final List<Object> modelList = new ArrayList<>();


    public DataModel getDataModel(int index) {
        return (DataModel) this.get(index);
    }

    @Override
    public boolean add(Object o) {
        if (o instanceof DataModel) {
            return modelList.add(o);
        } else {
            throw new IllegalArgumentException("object is not a DataModel object");
        }
    }

    @Override
    public void add(int index, Object element) {
        if (element instanceof DataModel) {
            modelList.add(index, element);
        } else {
            throw new IllegalArgumentException("object is not a DataModel object");
        }
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object element : c) {
            if (!(element instanceof DataModel)) {
                throw new IllegalArgumentException("object is not a DataModel object");
            }
        }
        return modelList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        for (Object element : c) {
            if (!(element instanceof DataModel)) {
                throw new IllegalArgumentException("object is not a DataModel object");
            }
        }
        return modelList.addAll(index, c);
    }

    @Override
    public int size() {
        return modelList.size();
    }

    @Override
    public boolean isEmpty() {
        return modelList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return modelList.contains(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        return modelList.containsAll(c);
    }

    @Override
    public Iterator iterator() {
        return modelList.iterator();
    }

    @Override
    public Object[] toArray() {
        return modelList.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return modelList.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return modelList.remove(o);
    }

    @Override
    public Object remove(int index) {
        return modelList.remove(index);
    }

    @Override
    public boolean removeAll(Collection c) {
        return modelList.remove(c);
    }

    @Override
    public void clear() {
        modelList.clear();
    }

    @Override
    public Object get(int index) {
        return modelList.get(index);
    }

    @Override
    public Object set(int index, Object element) {
        return modelList.set(index, element);
    }

    @Override
    public int indexOf(Object o) {
        return modelList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return modelList.lastIndexOf(o);
    }

    @Override
    public ListIterator listIterator() {
        return modelList.listIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return modelList.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return modelList.subList(fromIndex, toIndex);
    }

    @Override
    public boolean retainAll(Collection c) {
        return modelList.retainAll(c);
    }
}
