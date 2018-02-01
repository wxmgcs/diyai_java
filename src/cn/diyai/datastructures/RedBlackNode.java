    package cn.diyai.datastructures;

    // Basic node stored in red-black trees
    // Note that this class is not accessible outside
    // of package DataStructures

    import java.lang.Comparable;

    class RedBlackNode
    {
            // Constructors
        RedBlackNode( java.lang.Comparable theElement )
        {
            this( theElement, null, null );
        }

        RedBlackNode(java.lang.Comparable theElement, RedBlackNode lt, RedBlackNode rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            color    = RedBlackTree.BLACK;
        }

            // Friendly data; accessible by other package routines
        Comparable element;    // The data in the node
        RedBlackNode left;       // Left child
        RedBlackNode right;      // Right child
        int          color;      // Color
    }
