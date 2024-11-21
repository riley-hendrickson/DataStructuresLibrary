package libraryProject;

import libraryProject.Library.*;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Random;

// Testing Plan: Check memory usage before and after runtime of each method, and measure its runtime, take the average of recordings from 3 separate runs

public class TestFunctions
{
    private static final int TEST_FREQUENCY = 5;
    private static final int NUM_OPERATIONS = 1000;

    private static Random randomNumberGenerator = new Random();

    public static void testLinkedList(MyLinkedList<Integer> list)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Linked List...\n");

        LinkedList<Integer> javaList = new LinkedList<>();
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        // warm up phase before measuring runtime to avoid JVM initialization overhead, and to ensure we don't need to refill lists after testing remove function
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.add(i);
                myList.add(i);
            }
        }

        // measuring runtime for java's linked list operations:
        System.out.println("Java.util's linked list results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.add(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of inserting NUM_OPERATIONS times: " + avgOfRuntimes + "ms");

        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.contains(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of NUM_OPERATIONS lookup operations: " + avgOfRuntimes + "ms");

        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.remove(randomNumberGenerator.nextInt(javaList.size()));
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average of deleting at random location NUM_OPERATIONS times: " + avgOfRuntimes + "ms");

        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.remove();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of deleting NUM_OPERATIONS times: " + avgOfRuntimes + "ms\n");

        // measuring runtime for my linked list's operations:
        System.out.println("My linked list results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myList.add(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of inserting NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        
        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myList.contains(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of NUM_OPERATIONS lookup operations: " + avgOfRuntimes + "ms");
        
        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myList.remove(randomNumberGenerator.nextInt(myList.size()));
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average of deleting at random location NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        
        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myList.remove();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of deleting NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        System.out.println("------------------------------------------------------------\n");
    }

    public static void testHashMap(MyHashMap<Integer, Integer> map)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Hash Map...\n");

        HashMap <Integer, Integer> javaMap = new HashMap<Integer, Integer>();
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        // warm up phase before measuring runtime to avoid JVM initialization overhead, and to ensure we don't need to refill lists after testing remove function
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaMap.put(i, i);
                myHashMap.put(i, i);
            }
        }        

        // measuring runtime for java's hash map operations:
        System.out.println("Java.util's hash map results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaMap.put(i, i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing put operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaMap.get(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing get operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaMap.remove(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing remove operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms\n");

        System.out.println("My hash map results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myHashMap.put(i, i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing put operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myHashMap.get(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing get operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myHashMap.remove(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing remove operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms\n");
        System.out.println("------------------------------------------------------------\n");
    }


    public static void testPriorityQueue(MyPriorityQueue<Integer> heap)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Priority Queue...\n");

        PriorityQueue <Integer> javaPriorityQueue = new PriorityQueue<Integer>();
        MyPriorityQueue <Integer> myPriorityQueue = new MyPriorityQueue<>();

        // measuring runtime for java's priority queue operations:
        System.out.println("Java.util's priority queue results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                // add operation
                javaPriorityQueue.add(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing add operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaPriorityQueue.peek();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing peek operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaPriorityQueue.poll();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing poll operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms\n");

        System.out.println("My priority queue results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myPriorityQueue.add(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing add operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myPriorityQueue.peek();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing peek operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myPriorityQueue.poll();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing poll operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms\n");
        System.out.println("------------------------------------------------------------\n");
    }

    public static void testStack(MyStack<Integer> stack)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Stack...\n");

        Stack <Integer> javaStack = new Stack<>();
        MyStack <Integer>myStack = new MyStack<>();

        // measuring runtime for java's hash map operations:
        System.out.println("Java.util's stack results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaStack.push(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing push operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaStack.peek();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing peek operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaStack.pop();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing pop operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms\n");

        System.out.println("My stack results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myStack.push(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing push operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myStack.peek();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing peek operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < NUM_OPERATIONS; i++)
            {
                myStack.pop();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing pop operation NUM_OPERATIONS times: " + avgOfRuntimes + "ms\n");
        System.out.println("------------------------------------------------------------");
    }
}