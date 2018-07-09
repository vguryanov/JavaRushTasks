package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by User2 on 20.08.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<E, Object>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = 16 > (collection.size() / .75f) ? 16 : (int) Math.ceil(collection.size() / .75f);
        map = new HashMap<>(capacity);

        for (E elem : collection) {
            map.put(elem, PRESENT);
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();

        stream.writeInt(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        stream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map, "loadfactor"));

        stream.writeInt(map.size());
        for (E e : map.keySet()) stream.writeObject(e);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        map = new HashMap<E, Object>(stream.readInt(), stream.readFloat());

        int size = stream.readInt();
        for (int i = 0; i < size; i++) map.put((E) stream.readObject(), PRESENT);
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e, PRESENT);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet amigoSet = new AmigoSet<>();
            amigoSet.addAll(this);
            amigoSet.map.putAll((Map) this.map.clone());
            return amigoSet;
        } catch (Exception e) {
            throw new InternalError();
        }

    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == null ? false : true;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}
