package com.entrepaginas.utils;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T>{

    private T[] array;
    private int size;
    
    public ArrayList() {
      this(10);
    }
    
    public ArrayList(int initialCapacity) {
      if (initialCapacity < 0) {
        throw new IllegalArgumentException("Invalid initial capacity");
      }
      array = (T[]) new Object[initialCapacity];
    }
    public void add(T element) {
        if (size == array.length) {
          // Array is full, so we need to increase its capacity
          T[] newArray = (T[]) new Object[array.length * 2];
          System.arraycopy(array, 0, newArray, 0, array.length);
          array = newArray;
        }
        array[size++] = element;
      }
      
      public T get(int index) {
        if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
      }
      
      public int size() {
        return size;
      }
      
      public boolean isEmpty() {
        return size == 0;
      }
      public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (size == array.length) {
            // Array is full, so we need to increase its capacity
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index, newArray, index + 1, size - index);
            array = newArray;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }
    
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        T removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removedElement;
    }
    
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }
    
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        T replacedElement = array[index];
        array[index] = element;
        return replacedElement;
    }
    
    public T[] toArray() {
        T[] newArray = (T[]) new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            
            public boolean hasNext() {
                return currentIndex < size && array[currentIndex] != null;
            }
            
            public T next() {
                return array[currentIndex++];
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}