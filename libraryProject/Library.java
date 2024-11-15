package libraryProject;

public class Library
{
    // helper class to be used in Linked List and Binary Tree implementations:
    public static class Node
    {
        int val;
        Node next;

        public Node(int val)
        {
            this.val = val;
        }
        public Node(int val, Node next)
        {
            this.val = val;
            this.next = next;
        }
    }

    public static class MyLinkedList
    {
        Node head;
        private int length;

        public int size()
        {
            return this.length;
        }

        public MyLinkedList add(MyLinkedList list, int value)
        {
            if(list == null)
            {
                Node newNode = new Node(value);
                MyLinkedList newList = new MyLinkedList();
                newList.head = newNode;
                return newList;
            }

            return list;
        }

        public MyLinkedList clear(MyLinkedList list)
        {
            return list;
        }

        // remove first
        // remove last
        // remove at index
        // remove all
        // contains element


    }
    public static class MyHashMap
    {
        
    }
    public static class MyPriorityQueue
    {
        
    }
    public static class MyStack
    {
        
    }
}