package model;

interface SimpleSet<E> {

    boolean add(E e);

    E remove(E e) throws ElementDoesNotExistException;

    boolean contains(E e);

    E[] removeAll(E[] e) throws ElementDoesNotExistException;

    //removes all elements
    void clear();

    int size();

    boolean isEmpty();

    E getRandomElement() throws ElementDoesNotExistException;

    E[] toArray();

    @Override
    String toString();

}
