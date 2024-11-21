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
        // public Node(int val, Node next)
        // {
        //     this.val = val;
        //     this.next = next;
        // }
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
            return this.head.val;
        }

        public T remove(int location)
        {

            return this.head.val;
        }
    }
    public static class MyHashMap<K, V>
    {
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
        private List<T> stack;

        public MyStack()
        {
            stack = new ArrayList<>();
        }

        public void push(T value)
        {
            stack.add(value);
        }

        public T pop()
        {
            return stack.get(0);
        }

        public T peek()
        {
            return stack.get(stack.size()-1);
        }
    }
}