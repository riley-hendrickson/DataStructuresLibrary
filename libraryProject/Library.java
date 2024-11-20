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
        Node tail;
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
            Node newNode = new Node(value);
            // if list is empty initialize new node as head pointer
            if(this.head == null)
            {
                this.head = newNode;
                this.tail = newNode;
                this.length++;
                return true;
            }
            // otherwise add to existing list
            this.tail.next = newNode;
            this.tail = newNode;
            this.length++;
            return true;
        }

        public boolean contains(int element)
        {
            Node crawler = this.head;
            for(int i = 0; i < this.length; i++)
            {
                if(crawler.val == element) return true;
                crawler = crawler.next;
            }
            return false;
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