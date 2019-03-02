package edu.ncsu.ArrayList;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * A simple, array-based list that uses generics so that it can store any type
 * desired.
 *
 * @author Kai Presler-Marshall
 *
 * @param <E>
 *            Generic type that gets stored in this List
 */
@SuppressWarnings ( "unchecked" )
public class ArrayList <E> extends AbstractList<E> {

    /**
     * Default capacity of the list if none is specified
     */
    static private final Integer INITIAL_CAPACITY = 10;

    private Integer              size             = 0;

    private Object               objects[];

    /**
     * Construct an ArrayList with the default capacity
     *
     */
    public ArrayList () {
        this( INITIAL_CAPACITY );
    }

    /**
     * Construct an ArrayList with a custom size.
     *
     * @param size
     *            Size of the list to construct
     */
    public ArrayList ( final Integer size ) {
        if ( size <= 0 ) {
            throw new IllegalArgumentException( "Illegal size " + size + " for constructing a List" );
        }
        objects = new Object[size];
    }

    /**
     * Add the specified element to the end of the list
     */
    @Override
    public boolean add ( final E element ) {
        if ( size == objects.length ) {
            resize();
        }
        objects[size++] = element;

        return true;
    }

    /**
     * Retrieve an element from the specified index in the list
     */
    @Override
    public E get ( final int index ) {
        checkIndex( index );
        return (E) objects[index];
    }

    /**
     * Store the element provided in the index provided.
     */
    @Override
    public E set ( final int index, final E object ) {
        checkIndex( index );
        final E old = (E) objects[index];
        objects[index] = object;
        return old;
    }

    /**
     * Remove the specified object from the list
     */
    @Override
    public boolean remove ( final Object object ) {
        remove( indexOf( object ) );
        return true;
    }

    @Override
    public E remove ( final int index ) {
        checkIndex( index );
        final E element = (E) objects[index];

        final int numMoved = size - index - 1;
        if ( numMoved > 0 ) {
            System.arraycopy( objects, index + 1, objects, index,
                    numMoved );
        }
        objects[--size] = null;

        return element;

    }

    @Override
    public boolean contains ( final Object object ) {
        return indexOf( object ) != -1;
    }

    @Override
    public int size () {
        return size;
    }

    private void resize () {
        objects = Arrays.copyOf( objects, size * 2 );
    }

    private void checkIndex ( final int index ) {
        if ( index >= size ) {
            throw new IndexOutOfBoundsException();
        }
    }

}
