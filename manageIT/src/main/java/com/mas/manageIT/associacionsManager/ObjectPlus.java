package com.mas.manageIT.associacionsManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class ObjectPlus implements Serializable {

    private static Map<Class, List<ObjectPlus>> allExtents = new Hashtable<>();


    public ObjectPlus() {
        List<ObjectPlus> extent = null;
        Class theClass = this.getClass();

        if (allExtents.containsKey(theClass)) {
            extent = allExtents.get(theClass);
        } else {
          extent = new ArrayList<>();
          allExtents.put(theClass, extent);
        }
        extent.add(this);
    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }

    public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException {
        if (allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }
        throw new ClassNotFoundException(String.format ("%s. Stored extents: %s",
                type.toString(), allExtents.keySet()));
    }

}
