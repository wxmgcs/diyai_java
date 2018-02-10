    package cn.diyai.datastructures;

    // Basic node stored in skip lists
    // Note that this class is not accessible outside
    // of package DataStructures

    import java.lang.Comparable;

    class SkipNode
    {
            // Constructors
        SkipNode( java.lang.Comparable theElement )
        {
            this( theElement, null, null );
        }

        SkipNode(java.lang.Comparable theElement, SkipNode rt, SkipNode dt )
        {
            element  = theElement;
            right    = rt;
            down     = dt;
        }

            // Friendly data; accessible by other package routines
        Comparable element;      // The data in the node
        SkipNode   right;        // Right link 
        SkipNode   down;         // Down link
    }
