    package cn.diyai.datastructures;

    // Basic node stored in treaps
    // Note that this class is not accessible outside
    // of package DataStructures

    import java.lang.Comparable;

    class TreapNode
    {
            // Constructors
        TreapNode( java.lang.Comparable theElement )
        {
            this( theElement, null, null );
        }

        TreapNode(java.lang.Comparable theElement, TreapNode lt, TreapNode rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            priority = randomObj.randomInt( );
        }

            // Friendly data; accessible by other package routines
        Comparable element;      // The data in the node
        TreapNode  left;         // Left child
        TreapNode  right;        // Right child
        int        priority;     // Priority

        private static Random randomObj = new Random( );
    }
