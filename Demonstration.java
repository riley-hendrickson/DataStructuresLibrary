import libraryProject.Library.*;
import libraryProject.TestFunctions;

public class Demonstration
{
    public static void main(String[] args)
    {
        MyLinkedList <Integer> list = new MyLinkedList<>();
        MyHashMap <Integer, Integer> map = new MyHashMap<>();
        MyPriorityQueue <Integer> heap = new MyPriorityQueue<>();
        MyStack <Integer> stack = new MyStack<>();

        TestFunctions.testLinkedList(list);
        TestFunctions.testHashMap(map);
        TestFunctions.testPriorityQueue(heap);
        TestFunctions.testStack(stack);
    }
}