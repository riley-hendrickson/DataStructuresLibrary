package libraryProject;

public class Library
{
    // helper class to be used in Linked List and Binary Tree implementations:
    private static class Node
    {
        private int val;
        public Node next;

        public Node(int val)
        {
            this.val = val;
        }
        // public Node(int val, Node next)
        // {
        //     this.val = val;
        //     this.next = next;
        // }
    }

    public static class MyLinkedList
    {
        Node head;
        public int length;

        public MyLinkedList()
        {
            this.length = 0;
        }

        public int size()
        {
            return this.length;
        }

        public boolean add(int value)
        {
            // if list is empty create a new node and initialize it as head pointer
            if(this.head == null)
            {
                Node newNode = new Node(value);
                this.head = newNode;
                this.length++;
                return true;
            }

            // otherwise add to existing list
            this.length++;
            return true;
        }

        public boolean contains(int element)
        {
            return true;
        }

        public int remove()
        {
            return 0;
        }

        public int remove(int location)
        {
            return location;
        }
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