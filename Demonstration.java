import libraryProject.Library.*;
import libraryProject.TestFunctions;

public class Demonstration
{
    public static void main(String[] args)
    {
        MyPriorityQueue heap = new MyPriorityQueue();
        MyHashMap map = new MyHashMap();
        MyLinkedList list = new MyLinkedList();
        MyStack stack = new MyStack();

        TestFunctions.testPriorityQueue(heap);
        TestFunctions.testHashMap(map);
        TestFunctions.testLinkedList(list);
        TestFunctions.testStack(stack);
    }
}