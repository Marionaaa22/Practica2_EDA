package generics;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> implements Iterable<T>{

    private final T[] array;
    private int firstEmptyPos;


    public ArraySet(Class<T> c, int size){
        firstEmptyPos = 0;
        //@SuppressWarnings("unchecked")
        array = (T[]) Array.newInstance(c, size); //Per crear nou array
    }

    //TODO: Complete


    private class ArraySetIterator implements Iterator<T>{

        //TODO: Complete

    }

}
