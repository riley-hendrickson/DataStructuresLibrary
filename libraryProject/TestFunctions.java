package libraryProject;

import libraryProject.Library.*;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Stack;
import java.util.PriorityQueue;

public class TestFunctions
{
    public static void testLinkedList(MyLinkedList list)
    {
        System.out.println("Testing Linked List...\n");

        LinkedList javaList = new LinkedList<>();

        MyLinkedList myList = new MyLinkedList();
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