package edu.ncsu.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {

    @Test
    public void emptyListSize () {
        final ArrayList<String> list = new ArrayList<String>();

        assertEquals( 0, list.size() );
    }

    @Test
    public void simpleTestAddElement () {
        final ArrayList<String> list = new ArrayList<String>();

        list.add( "An Element" );

        assertEquals( 1, list.size() );

        assertEquals( "An Element", list.get( 0 ) );

        list.add( "Another Element" );
        list.add( "A Third Element" );

        assertEquals( 3, list.size() );

        assertEquals( "A Third Element", list.get( 2 ) );

    }

    @Test
    public void testLotsOfElements () {
        final ArrayList<Integer> list = new ArrayList<Integer>();

        for ( int i = 0; i < 100; i++ ) {
            list.add( i );
        }

        for ( int i = 0; i < 100; i++ ) {
            assertTrue( list.contains( i ) );
        }

        for ( int i = 0; i < 100; i++ ) {
            assertEquals( i, (int) list.get( i ) );
        }
        assertEquals( 100, list.size() );

    }

    @Test
    public void testRemoveElements () {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        for ( int i = 0; i < 100; i++ ) {
            list.add( i );
        }
        list.remove( 0 );
        assertEquals( 99, (int) list.get( 98 ) );

        assertEquals( 99, list.size() );

    }

}
