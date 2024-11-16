package libraryProject;

import libraryProject.Library.*;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Stack;
import java.util.PriorityQueue;

// Testing Plan: Check memory usage before and after runtime of each method, and measure its runtime, take the average of recordings from 3 separate runs

public class TestFunctions
{
    private static final int TEST_FREQUENCY = 3;

    public static void testLinkedList(MyLinkedList list)
    {
        long sumOfRuntimes = 0;
        long startingTime;
        long endingTime;
        long avgOfRuntimes;

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
                javaList.remove();
            }
            endingTime = System.nanoTime();
            sumOfRuntimes += endingTime - startingTime;
        }
        avgOfRuntimes = sumOfRuntimes / TEST_FREQUENCY;
        System.out.println("Average runtime of deleting 100 times: " + avgOfRuntimes + "ms");


        System.out.println();
    }

    public static void testHashMap(MyHashMap map)
    {
        System.out.println("Testing Hash Map...");

        HashMap javaMap = new HashMap<Integer, Integer>();

        MyHashMap myHashMap = new MyHashMap();
    }


    public static void testPriorityQueue(MyPriorityQueue heap)
    {
        System.out.println("Testing Binary Tree...");

        PriorityQueue javaPriorityQueue = new PriorityQueue<>();

        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
    }

    public static void testStack(MyStack stack)
    {
        System.out.println("Testing Stack...");

        Stack javaStack = new Stack<>();

        MyStack myStack = new MyStack();
    }
}