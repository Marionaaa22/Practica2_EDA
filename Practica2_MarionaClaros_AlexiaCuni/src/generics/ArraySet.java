package generics;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> implements Iterable<T>{

    private final T[] array;
    private int firstEmptyPos;


    @SuppressWarnings("unchecked")
    public ArraySet(Class<T> c, int size){
        firstEmptyPos = 0;
        array = (T[]) Array.newInstance(c, size); //Per crear nou array
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    public boolean add(T element) {
        if (firstEmptyPos == array.length) {
            return false;
        }
        for (int i = 0; i < firstEmptyPos; i++) {
            if (array[i].equals(element)) {
                return false;
            }
        }

        array[firstEmptyPos] = element;
        firstEmptyPos++;

        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= firstEmptyPos) {
            throw new IndexOutOfBoundsException("la posiscio del index esta fora de rang o esta vuida");
        }

        return array[index];
    }

    public boolean isEmpty() {
        return firstEmptyPos == 0;
    }

    public boolean contains(T object){
        for(int i = 0; i < firstEmptyPos; i++){
            if(array[i].equals(object)){
                return true;
            }
        }

        return false;
    }

    public boolean remove(T object){
        for(int i = 0; i<firstEmptyPos; i++){
            if(array[i].equals(object)){
                for(int j = i; j<firstEmptyPos -1; j++){
                    array[j] = array[j+1];

                }
                array[firstEmptyPos - 1] = null;

                firstEmptyPos--;

                return true;
            }
        }

        return false;
    }

    public int size(){

        return firstEmptyPos;
    }

    public int maxSize(){
        return array.length;
    }

    private class ArraySetIterator implements Iterator<T>{

        private int currentPos = 0;
        @Override
        public boolean hasNext() {
            return currentPos < firstEmptyPos;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            return array[currentPos++];
        }
        }

    }
