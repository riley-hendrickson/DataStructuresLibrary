package libraryProject;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Collection of custom data structure implementations.
 * Includes LinkedList, HashMap, PriorityQueue, and Stack.
 */
public class Library
{
    // ============================================================
    // SHARED NODE CLASS
    // ============================================================
    
    /**
     * Generic node used by LinkedList and Stack implementations.
     */
    private static class Node<T>
    {
        private T val;
        private Node<T> next;

        public Node(T val)
        {
            this.val = val;
        }
    }

    // ============================================================
    // LINKED LIST IMPLEMENTATION
    // ============================================================
    
    /**
     * Singly-linked list implementation with O(1) append and O(n) search/removal.
     */
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

        /**
         * Appends element to the end of the list in O(1) time.
         */
        public boolean add(T value)
        {
            Node<T> newNode = new Node<>(value);
            
            // If list is empty, initialize as both head and tail
            if (this.head == null)
            {
                this.head = newNode;
                this.tail = newNode;
                this.length++;
                return true;
            }
            
            // Otherwise append to end using tail pointer
            this.tail.next = newNode;
            this.tail = newNode;
            this.length++;
            return true;
        }

        /**
         * Searches for element using linear traversal - O(n) time.
         */
        public boolean contains(T element)
        {
            Node<T> crawler = this.head;
            for (int i = 0; i < this.length; i++)
            {
                if (crawler.val.equals(element)) return true;
                crawler = crawler.next;
            }
            return false;
        }

        /**
         * Removes and returns the head element - O(1) time.
         */
        public T remove()
        {
            if (this.length == 0) 
                throw new IllegalStateException("Cannot remove while list is empty");
            if (this.length == 1) 
                this.tail = null;

            T value = head.val;
            this.head = head.next;
            length--;

            return value;
        }

        /**
         * Removes element at specified index - O(n) time.
         * Special case: removing head (index 0) should use remove() instead.
         */
        public T remove(int location)
        {
            if (this.length == 0) 
                throw new IllegalStateException("Cannot remove while list is empty");
            if (location >= this.length) 
                throw new IndexOutOfBoundsException("Removal index is out of bounds");

            // Traverse to node before target
            Node<T> crawler = this.head;
            for (int i = 0; i < location - 1; i++)
            {
                crawler = crawler.next;
            }
            
            // Remove target node by updating pointer
            T temp = crawler.next.val;
            crawler.next = crawler.next.next;
            this.length--;

            return temp;
        }
    }

    // ============================================================
    // HASH MAP IMPLEMENTATION
    // ============================================================
    
    /**
     * Hash table with separate chaining for collision resolution.
     * Fixed capacity of 16 buckets.
     */
    public static class MyHashMap<K, V>
    {
        /**
         * Entry class for key-value pairs in the hash table.
         * Forms a linked list to handle collisions via chaining.
         */
        private class Entry
        {
            private final K key;
            private V value;
            private Entry next;
            
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
        
        private static final int DEFAULT_CAPACITY = 16;
        private final Entry[] entries;

        @SuppressWarnings("unchecked")
        public MyHashMap()
        {
            // Generic array creation requires unchecked cast - this is safe
            this.entries = (Entry[]) new MyHashMap<?, ?>.Entry[DEFAULT_CAPACITY];
        }

        /**
         * Inserts or updates a key-value pair.
         * Uses separate chaining to handle hash collisions.
         */
        public void put(K key, V value)
        {
            int hashcode = Math.abs(key.hashCode() % DEFAULT_CAPACITY);
            Entry current = entries[hashcode];

            // If bucket is empty, create new entry
            if (current == null)
            {
                entries[hashcode] = new Entry(key, value);
                return;
            }
            
            // Otherwise traverse chain to find key or reach end
            while (current.next != null)
            {
                if (current.key.equals(key))
                {
                    current.setValue(value);
                    return;
                }
                current = current.next;
            }
            
            // Check final node in chain
            if (current.key.equals(key))
            {
                current.value = value;
                return;
            }

            // Key not found, append to end of chain
            current.next = new Entry(key, value);
        }

        /**
         * Retrieves value for given key, or null if not found.
         */
        public V get(K key)
        {
            int hashcode = Math.abs(key.hashCode() % DEFAULT_CAPACITY);
            Entry current = entries[hashcode];

            if (current == null) return null;

            // Traverse chain looking for matching key
            while (current != null)
            {
                if (current.getKey().equals(key)) return current.getValue();
                current = current.next;
            }
            
            return null;
        }

        /**
         * Removes and returns entry for given key, or null if not found.
         */
        public Entry remove(K key)
        {
            int hashcode = Math.abs(key.hashCode() % DEFAULT_CAPACITY);
            Entry current = entries[hashcode];

            if (current == null) return null;
            
            // Special case: key is at head of chain
            if (current.getKey().equals(key))
            {
                entries[hashcode] = current.next;
                current.next = null;
                return current;
            }

            // Traverse chain with previous pointer for removal
            Entry previous = current;
            current = current.next;
            while (current != null)
            {
                if (current.getKey().equals(key))
                {
                    previous.next = current.next;
                    current.next = null;
                    return current;
                }
                previous = previous.next;
                current = current.next;
            }
            
            return null;
        }
    }

    // ============================================================
    // PRIORITY QUEUE IMPLEMENTATION
    // ============================================================
    
    /**
     * Min-heap implementation backed by ArrayList.
     * Supports custom comparators or uses natural ordering via Comparable.
     */
    public static class MyPriorityQueue<T>
    {
        private final ArrayList<T> heap;
        private final Comparator<? super T> comparator;

        public MyPriorityQueue(Comparator<? super T> comparator) 
        {
            this.heap = new ArrayList<>();
            this.comparator = comparator;
        }
    
        public MyPriorityQueue() 
        {
            this(null);
        }

        /**
         * Compares two elements using comparator if provided,
         * otherwise uses Comparable interface.
         */
        private int compare(T a, T b)
        {
            if (comparator != null)
            {
                return comparator.compare(a, b);
            }
            
            // Cast to Comparable - caller responsible for ensuring T implements Comparable
            // This is the standard approach used by Java's PriorityQueue
            @SuppressWarnings("unchecked")
            Comparable<? super T> comparable = (Comparable<? super T>) a;
            return comparable.compareTo(b);
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

        /**
         * Restores heap property by moving element up the tree.
         * Called after insertion.
         */
        private void heapifyUp(int index)
        {
            // Base case: reached root or heap property satisfied
            int parent = getParent(index);
            if (index == 0 || compare(heap.get(index), heap.get(parent)) >= 0)
            {
                return;
            }
            
            swap(index, parent);
            heapifyUp(parent);
        }

        /**
         * Restores heap property by moving element down the tree.
         * Called after removal.
         */
        private void heapifyDown(int index)
        {
            int leftChild = getLeftChild(index);
            int rightChild = getRightChild(index);
            int heapSize = heap.size();
            int smallest = index;

            // Find smallest among node and its children
            if (leftChild < heapSize && compare(heap.get(leftChild), heap.get(smallest)) < 0)
            {
                smallest = leftChild;
            }

            if (rightChild < heapSize && compare(heap.get(rightChild), heap.get(smallest)) < 0)
            {
                smallest = rightChild;
            }

            // If heap property violated, swap and continue
            if (smallest != index)
            {
                swap(index, smallest);
                heapifyDown(smallest);
            }
        }

        private void swap(int a, int b)
        {
            T temp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, temp);
        }

        /**
         * Inserts element and restores heap property - O(log n).
         */
        public void add(T value)
        {
            heap.add(value);
            heapifyUp(heap.size() - 1);
        }

        /**
         * Returns minimum element without removing - O(1).
         */
        public T peek()
        {
            if (heap.isEmpty()) 
                throw new IllegalStateException("Cannot peek while the heap is empty!");

            return heap.get(0);
        }

        /**
         * Removes and returns minimum element - O(log n).
         */
        public T poll()
        {
            if (heap.isEmpty()) 
                throw new IllegalStateException("Cannot remove from the heap while it is empty!");

            T returnVal = heap.get(0);
            T tail = heap.remove(heap.size() - 1);

            // If heap not empty after removal, restore heap property
            if (!heap.isEmpty())
            {
                heap.set(0, tail);
                heapifyDown(0);
            }

            return returnVal;
        }

        public int size()
        {
            return heap.size();
        }

        public boolean isEmpty()
        {
            return heap.isEmpty();
        }
    }

    // ============================================================
    // STACK IMPLEMENTATION
    // ============================================================
    
    /**
     * LIFO stack implementation using linked nodes.
     * All operations are O(1).
     */
    public static class MyStack<T>
    {
        private Node<T> top;
        private int size;

        public MyStack()
        {
            this.size = 0;
        }

        /**
         * Pushes element onto top of stack - O(1).
         */
        public void push(T value)
        {
            Node<T> newNode = new Node<>(value);
            
            if (size != 0)
            {
                newNode.next = this.top;
            }
            
            this.top = newNode;
            size++;
        }

        /**
         * Removes and returns top element - O(1).
         */
        public T pop()
        {
            if (size == 0) 
                throw new IllegalStateException("Cannot remove from the stack while it is empty!");

            T returnVal = this.top.val;
            this.top = this.top.next;
            size--;
            
            return returnVal;
        }

        /**
         * Returns top element without removing - O(1).
         */
        public T peek()
        {
            if (size == 0) 
                throw new IllegalStateException("Cannot peek while the stack is empty!");
                
            return top.val;
        }

        public boolean isEmpty()
        {
            return this.size == 0;
        }

        public int size()
        {
            return this.size;
        }
    }
}