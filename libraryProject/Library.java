package libraryProject;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
public class Library
{
    // helper class to be used in Linked List implementation:
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
        // helper class to be used in HashMap
        private class Entry<EK, EV>
        {
            private final K key;
            private V value;
            private Entry<K, V> next;
            
            public Entry(K key, V value)
            {
                this.key = key;
                this.value = value;
            }
            public K getKey()
            {
                return this.key;
            }
            public V getValue()
            {
                return this.value;
            }
            public void setValue(V value)
            {
                this.value = value;
            }
        }
        private final int DEFAULT_CAPACITY = 16;
        private Entry<K, V> entries[];

        @SuppressWarnings("unchecked")
        public MyHashMap()
        {
            this.entries = new Entry[DEFAULT_CAPACITY];
        }

        public void put(K key, V value)
        {
            int hashcode = key.hashCode() % DEFAULT_CAPACITY;
            Entry<K, V> newEntry = entries[hashcode];

            if(newEntry == null)
            {
                entries[hashcode] = new Entry<K, V>(key, value);
                newEntry = entries[hashcode];
            }
            else
            {
                while (newEntry.next != null)
                {
                    if(newEntry.key.equals(key))
                    {
                        newEntry.value = value;
                        return;
                    }
                    newEntry = newEntry.next;
                }
                if(newEntry.key.equals(key))
                {
                    newEntry.value = value;
                    return;
                }
            }

            newEntry.next = new Entry<K, V>(key, value);
        }

        public V get(K key)
        {
            int hashcode = key.hashCode() % DEFAULT_CAPACITY;
            Entry<K, V> newEntry = entries[hashcode];

            if(newEntry == null) return null;

            while(newEntry != null)
            {
                if(newEntry.getKey().equals(key)) return newEntry.value;
                else newEntry = newEntry.next;
            }
            return null;
        }

        public Entry<K, V> remove(K key)
        {
            int hashcode = key.hashCode() % DEFAULT_CAPACITY;
            Entry<K, V> newEntry = entries[hashcode];

            if(newEntry == null) return null;
            
            if(newEntry.getKey().equals(key))
            {
                entries[hashcode] = newEntry.next;
                newEntry.next = null;
                return newEntry;
            }

            Entry<K, V> previous = newEntry;
            newEntry = newEntry.next;
            while(newEntry != null)
            {
                if(newEntry.getKey().equals(key))
                {
                    previous.next = newEntry.next;
                    newEntry.next = null;
                    return newEntry;
                }
                previous = previous.next;
                newEntry = newEntry.next;
            }
            return null;
        }
    }
    public static class MyPriorityQueue<T>
    {
        private ArrayList<T> heap;
        private Comparator<? super T> comparator;

        public MyPriorityQueue(Comparator<? super T> comparator) 
        {
            this.heap = new ArrayList<>();
            this.comparator = comparator;
        }
    
        public MyPriorityQueue() 
        {
            this(null); // Natural ordering if no comparator is provided
        }

        private int getParent(int index) 
        {
            return (index - 1) / 2;
        }
        
        private int getLeftChild(int index) 
        {
            return (2 * index) + 1;
        }
        
        private int getRightChild(int index) 
        {
            return (2 * index) + 2;
        }

        private void heapifyUp(int index)
        {

        }

        private void heapifyDown(int index)
        {

        }

        private void swap(int a, int b)
        {
            T temp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, temp);
        }

        public void add(T value)
        {
            heap.add(value);
            heapifyUp(heap.size()-1);
        }

        public T peek()
        {
            if(heap.size() == 0) throw new IllegalStateException("Cannot peek while the heap is empty!");

            return heap.get(0);
        }

        public T poll()
        {
            return heap.get(0);
        }

        public int size()
        {
            return heap.size();
        }

        public boolean isEmpty()
        {
            return heap.size() == 0;
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