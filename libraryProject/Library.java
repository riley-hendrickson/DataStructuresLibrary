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
            // null comparator if none is provided, we will then default to using comparable's compareTo method
            this(null);
        }

        private int compare(T a, T b)
        {
            // if a comparator is provided, use that comparator to compare the provided elements
            if(comparator != null) return comparator.compare(a, b);

            // if a comparator is not provided, default to comparable's compareTo method. This requires us to cast the elements to the type comparable,
            // which is an unchecked cast as java cannot verify at runtime that the type being compared implements comparable, so we suppress that warning
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

        private void heapifyUp(int index)
        {
            int parent = getParent(index);
            if(index == 0 || compare(heap.get(index), heap.get(parent)) >= 0) return;
            swap(index, parent);
            heapifyUp(parent);
        }

        private void heapifyDown(int index)
        {
            int leftChild = getLeftChild(index);
            int rightChild = getRightChild(index);
            int heapSize = heap.size();
            int elementToBeSwapped = index;

            // check left child:
            if(leftChild < heapSize && compare(heap.get(leftChild), heap.get(elementToBeSwapped)) < 0)
            {
                elementToBeSwapped = leftChild;
            }

            // check right child:
            if(rightChild < heapSize && compare(heap.get(rightChild), heap.get(elementToBeSwapped)) < 0)
            {
                elementToBeSwapped = rightChild;
            }

            // if one of the children was violates the heap property, elementToBeSwapped and index will not be equal, so we swap and recur
            if(elementToBeSwapped != index)
            {
                swap(index, elementToBeSwapped);
                heapifyDown(elementToBeSwapped);
            }
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
            if(heap.isEmpty()) throw new IllegalStateException("Cannot remove from the heap while it is empty!");

            T returnVal = heap.get(0);
            T tail = heap.remove(heap.size()-1);

            if(!heap.isEmpty())
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