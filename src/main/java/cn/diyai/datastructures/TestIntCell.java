package cn.diyai.datastructures;

// Exercise the IntCell class
    public class TestIntCell
    {
        static class IntCell
        {
            /**
             * Construct the IntCell.
             * Initial value is 0.
             */
            public IntCell( )
            { this( 0 ); }

            /**
             * Construct the IntCell.
             * @param initialValue the initial value.
             */
            public IntCell( int initialValue )
            { storedValue = initialValue; }

            /**
             * Get the stored value.
             * @return the stored value.
             */
            public int read( )
            { return storedValue; }

            /**
             * Store a value
             * @param x the number to store.
             */
            public void write( int x )
            { storedValue = x; }

            private int storedValue;
        }
        public static void main( String [ ] args )
        {
            IntCell m = new IntCell( );

            m.write( 5 );
            System.out.println( "Cell contents: " + m.read( ) );
            // The next line would be illegal if uncommented
        //  m.storedValue = 0;
        }
    }
