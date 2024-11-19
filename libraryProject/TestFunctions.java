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
    private static final int TEST_FREQUENCY = 3;

    private static Random randomNumberGenerator = new Random();

    public static void testLinkedList(MyLinkedList list)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Linked List...\n");

        LinkedList<Integer> javaList = new LinkedList<>();
        MyLinkedList myList = new MyLinkedList();

        // measuring runtime for java's linked list operations:
        System.out.println("Java.util's linked list results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                javaList.add(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of inserting 100 times: " + avgOfRuntimes + "ms");

        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                javaList.contains(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of 100 lookup operations: " + avgOfRuntimes + "ms");

        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                javaList.remove(randomNumberGenerator.nextInt(javaList.size()));
            }
            endingTime = System.nanoTime();
            sumOfRuntimes = endingTime - startingTime;
            // refill java list:
            for(int i = 0; i < 100; i++)
            {
                javaList.add(i);
            }
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average of deleting at random location 100 times: " + avgOfRuntimes + "ms");

        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                javaList.remove();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
            // refill java list:
            for(int i = 0; i < 100; i++)
            {
                javaList.add(i);
            }
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of deleting 100 times: " + avgOfRuntimes + "ms\n");

        // measuring runtime for my linked list's operations:
        System.out.println("My linked list results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                myList.add(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of inserting 100 times: " + avgOfRuntimes + "ms");
        
        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                myList.contains(i);
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of 100 lookup operations: " + avgOfRuntimes + "ms");
        
        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                myList.remove(randomNumberGenerator.nextInt(myList.length));
            }
            endingTime = System.nanoTime();
            sumOfRuntimes = endingTime - startingTime;
            // refill list:
            for(int i = 0; i < 100; i++)
            {
                myList.add(i);
            }
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average of deleting at random location 100 times: " + avgOfRuntimes + "ms");
        
        sumOfRuntimes = 0;
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                myList.remove();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
            // refill list:
            for(int i = 0; i < 100; i++)
            {
                myList.add(i);
            }
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of deleting 100 times: " + avgOfRuntimes + "ms");
        System.out.println("------------------------------------------------------------\n");
    }

    public static void testHashMap(MyHashMap map)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Hash Map...\n");

        HashMap javaMap = new HashMap<Integer, Integer>();
        MyHashMap myHashMap = new MyHashMap();

        // measuring runtime for java's hash map operations:
        System.out.println("Java.util's hash map results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // get operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // put operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // remove operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms\n");

        System.out.println("My hash map results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // get operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // put operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // remove operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms\n");
        System.out.println("------------------------------------------------------------\n");
    }


    public static void testPriorityQueue(MyPriorityQueue heap)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Priority Queue...\n");

        PriorityQueue javaPriorityQueue = new PriorityQueue<>();
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();

        // measuring runtime for java's priority queue operations:
        System.out.println("Java.util's priority queue results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // add operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // contains operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // remove operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms\n");

        System.out.println("My priority queue results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // add operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // contains operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // remove operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms\n");
        System.out.println("------------------------------------------------------------\n");
    }

    public static void testStack(MyStack stack)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

        System.out.println("------------------------------------------------------------");
        System.out.println("Testing Stack...\n");

        Stack javaStack = new Stack<>();
        MyStack myStack = new MyStack();

        // measuring runtime for java's hash map operations:
        System.out.println("Java.util's stack results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // push operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // contains operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // pop operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms\n");

        System.out.println("My stack results:");
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // push operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");
        
        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // contains operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms");

        for(int j = 0; j < TEST_FREQUENCY; j++)
        {
            startingTime = System.nanoTime();
            for(int i = 0; i < 100; i++)
            {
                // pop operation
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of performing operation 100 times: " + avgOfRuntimes + "ms\n");
        System.out.println("------------------------------------------------------------");
    }
}