package libraryProject;

import java.util.List;
import java.util.ArrayList;
public class Library
{
    // helper class to be used in Linked List and Binary Tree implementations:
    private static class Node <T>
    {
        private T val;
        public Node<T> next;

        public Node(T val)
        {
            this.val = val;
        }
    }

    public static class MyLinkedList<T>
    {
        private Node<T> head;
        private Node<T> tail;
        private int length;

        public MyLinkedList()
        {
            this.length = 0;
        }

        public Node<T> getHead()
        {
            return this.head;
        }

        public int size()
        {
            return this.length;
        }

        public boolean add(T value)
        {
            Node<T> newNode = new Node<T>(value);
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

        // optimize this later on
        public boolean contains(T element)
        {
            Node<T> crawler = this.head;
            for(int i = 0; i < this.length; i++)
            {
                if(crawler.val == element) return true;
                crawler = crawler.next;
            }
            return false;
        }

        public T remove()
        {
            if(this.length == 0) throw new IllegalStateException("Cannot remove while list is empty");
            if(this.length == 1) this.tail = null;

            T value = head.val;
            this.head = head.next;
            length--;

            return value;
        }

        public T remove(int location)
        {
            if(this.length == 0) throw new IllegalStateException("Cannot remove while list is empty");
            if(location >= this.length) throw new IndexOutOfBoundsException("Removal index is out of bounds");

            Node<T> crawler = this.head;
            for(int i = 0; i < location-1; i++)
            {
                crawler = crawler.next;
            }
            T temp = crawler.next.val;
            crawler.next = crawler.next.next;
            this.length--;

            return temp;
        }
    }
    public static class MyHashMap<K, V>
    {
        private static final int DEFAULT_CAPACITY = 16;
        // helper class to be used in HashMap
        private static class Entry<K, V>
        {
            private final K key;
            private V value;
            private Entry<K, V> next;
            
            public Entry(K key, V value)
            {
                this.key = key;
                this.value = value;
            }
        }
        private Entry<K, V> [] entries;

        @SuppressWarnings("unchecked")
        public MyHashMap()
        {
            entries = (Entry<K, V> []) new Entry[DEFAULT_CAPACITY];
        }

        public boolean put(K key, V value)
        {
            Entry<K,V> newEntry = new Entry<K, V>(key, value);
            return true;
        }

        public Entry<K, V> get(K key)
        {
            return entries[0];
        }

        public boolean remove(K key)
        {
            return true;
        }
    }
    public static class MyPriorityQueue<T>
    {
        private List<T> heap;

        public MyPriorityQueue()
        {
            heap = new ArrayList<>();
        }

        public void add(T value)
        {
            heap.add(value);
        }

        public T peek()
        {
            return heap.get(0);
        }

        public T poll()
        {
            return heap.get(0);
        }
    }
    public static class MyStack<T>
    {
        private Node<T> top;
        private int size;

        public MyStack()
        {
            this.size = 0;
        }

        public void push(T value)
        {
            Node<T> newNode = new Node<T>(value);
            if(size != 0)
            {
                newNode.next = this.top;
            }
            this.top = newNode;
            size++;
        }

        public T pop()
        {
            if(size == 0) throw new IllegalStateException("Cannot remove from the stack while it is empty!");

            T returnVal = this.top.val;
            this.top = this.top.next;
            size--;
            return returnVal;
        }

        public T peek()
        {
            if(size == 0) throw new IllegalStateException("Cannot peek while the stack is empty!");
            return top.val;
        }

        public boolean isEmpty()
        {
            return this.size == 0? true : false; 
        }

        public int size()
        {
            return this.size;
        }
    }
}