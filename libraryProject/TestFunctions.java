package libraryProject;

import libraryProject.Library.*;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Performance benchmarking suite for custom data structure implementations.
 * Compares runtime performance against Java's standard library equivalents.
 */
public class TestFunctions
{
    private static final int TEST_FREQUENCY = 5;
    private static final int NUM_OPERATIONS = 1000;
    private static final Random randomNumberGenerator = new Random();

    /**
     * Helper method to measure average runtime of an operation across multiple trials.
     * @param operation The operation to benchmark
     * @return Average runtime in nanoseconds
     */
    private static long measureAverageRuntime(Runnable operation)
    {
        long sumOfRuntimes = 0;
        
        for (int trial = 0; trial < TEST_FREQUENCY; trial++)
        {
            long startTime = System.nanoTime();
            operation.run();
            long endTime = System.nanoTime();
            sumOfRuntimes += (endTime - startTime);
        }
        
        return sumOfRuntimes / TEST_FREQUENCY;
    }

    /**
     * Convert nanoseconds to milliseconds with precision.
     */
    private static double nanosToMillis(long nanos)
    {
        return nanos / 1_000_000.0;
    }

    /**
     * Print a formatted performance result.
     */
    private static void printResult(String operation, long avgNanos)
    {
        System.out.printf("  %-45s %.3f ms%n", operation + ":", nanosToMillis(avgNanos));
    }

    public static void testLinkedList(MyLinkedList<Integer> list)
    {
        System.out.println("============================================================");
        System.out.println("LINKED LIST PERFORMANCE COMPARISON");
        System.out.println("============================================================\n");

        LinkedList<Integer> javaList = new LinkedList<>();
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        // Warm-up phase to avoid JVM initialization overhead
        for (int j = 0; j < TEST_FREQUENCY; j++)
        {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.add(i);
                myList.add(i);
            }
        }

        System.out.println("Java.util.LinkedList:");
        
        // Test add operation
        long javaAddTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.add(i);
            }
        });
        printResult("Add " + NUM_OPERATIONS + " elements", javaAddTime);

        // Test contains operation
        long javaContainsTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.contains(i);
            }
        });
        printResult("Contains lookup " + NUM_OPERATIONS + " times", javaContainsTime);

        // Test remove from head operation
        long javaRemoveTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaList.removeFirst();
            }
        });
        printResult("Remove from head " + NUM_OPERATIONS + " times", javaRemoveTime);

        System.out.println("\nCustom MyLinkedList:");

        // Test add operation
        long myAddTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myList.add(i);
            }
        });
        printResult("Add " + NUM_OPERATIONS + " elements", myAddTime);

        // Test contains operation
        long myContainsTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myList.contains(i);
            }
        });
        printResult("Contains lookup " + NUM_OPERATIONS + " times", myContainsTime);

        // Test remove at random index
        long myRemoveRandomTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS && myList.size() > 0; i++)
            {
                int randomIndex = randomNumberGenerator.nextInt(myList.size());
                myList.remove(randomIndex);
            }
        });
        printResult("Remove at random index " + NUM_OPERATIONS + " times", myRemoveRandomTime);

        // Refill list for next test
        for (int i = 0; i < NUM_OPERATIONS; i++)
        {
            myList.add(i);
        }

        // Test remove from head
        long myRemoveTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS && myList.size() > 0; i++)
            {
                myList.remove();
            }
        });
        printResult("Remove from head " + NUM_OPERATIONS + " times", myRemoveTime);

        System.out.println("\n");
    }

    public static void testHashMap(MyHashMap<Integer, Integer> map)
    {
        System.out.println("============================================================");
        System.out.println("HASH MAP PERFORMANCE COMPARISON");
        System.out.println("============================================================\n");

        HashMap<Integer, Integer> javaMap = new HashMap<>();
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

        // Warm-up phase
        for (int j = 0; j < TEST_FREQUENCY; j++)
        {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaMap.put(i, i);
                myHashMap.put(i, i);
            }
        }

        System.out.println("Java.util.HashMap:");

        // Test put operation
        long javaPutTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaMap.put(i, i);
            }
        });
        printResult("Put " + NUM_OPERATIONS + " entries", javaPutTime);

        // Test get operation
        long javaGetTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaMap.get(i);
            }
        });
        printResult("Get " + NUM_OPERATIONS + " entries", javaGetTime);

        // Test remove operation
        long javaRemoveTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaMap.remove(i);
            }
        });
        printResult("Remove " + NUM_OPERATIONS + " entries", javaRemoveTime);

        System.out.println("\nCustom MyHashMap:");

        // Test put operation
        long myPutTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myHashMap.put(i, i);
            }
        });
        printResult("Put " + NUM_OPERATIONS + " entries", myPutTime);

        // Test get operation
        long myGetTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myHashMap.get(i);
            }
        });
        printResult("Get " + NUM_OPERATIONS + " entries", myGetTime);

        // Test remove operation
        long myRemoveTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myHashMap.remove(i);
            }
        });
        printResult("Remove " + NUM_OPERATIONS + " entries", myRemoveTime);

        System.out.println("\n");
    }

    public static void testPriorityQueue(MyPriorityQueue<Integer> heap)
    {
        System.out.println("============================================================");
        System.out.println("PRIORITY QUEUE PERFORMANCE COMPARISON");
        System.out.println("============================================================\n");

        PriorityQueue<Integer> javaPriorityQueue = new PriorityQueue<>();
        MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();

        // Warm-up phase
        for (int j = 0; j < TEST_FREQUENCY; j++)
        {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaPriorityQueue.add(i);
                myPriorityQueue.add(i);
            }
            javaPriorityQueue.clear();
            // Note: If MyPriorityQueue doesn't have clear(), we'll need to poll all elements
        }

        System.out.println("Java.util.PriorityQueue:");

        // Test add operation
        long javaAddTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaPriorityQueue.add(i);
            }
        });
        printResult("Add " + NUM_OPERATIONS + " elements", javaAddTime);

        // Test peek operation
        long javaPeekTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaPriorityQueue.peek();
            }
        });
        printResult("Peek " + NUM_OPERATIONS + " times", javaPeekTime);

        // Test poll operation
        long javaPollTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaPriorityQueue.poll();
            }
        });
        printResult("Poll " + NUM_OPERATIONS + " elements", javaPollTime);

        System.out.println("\nCustom MyPriorityQueue:");

        // Test add operation
        long myAddTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myPriorityQueue.add(i);
            }
        });
        printResult("Add " + NUM_OPERATIONS + " elements", myAddTime);

        // Test peek operation
        long myPeekTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myPriorityQueue.peek();
            }
        });
        printResult("Peek " + NUM_OPERATIONS + " times", myPeekTime);

        // Test poll operation
        long myPollTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myPriorityQueue.poll();
            }
        });
        printResult("Poll " + NUM_OPERATIONS + " elements", myPollTime);

        System.out.println("\n");
    }

    public static void testStack(MyStack<Integer> stack)
    {
        System.out.println("============================================================");
        System.out.println("STACK PERFORMANCE COMPARISON");
        System.out.println("============================================================\n");

        Stack<Integer> javaStack = new Stack<>();
        MyStack<Integer> myStack = new MyStack<>();

        // Warm-up phase
        for (int j = 0; j < TEST_FREQUENCY; j++)
        {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaStack.push(i);
                myStack.push(i);
            }
        }

        System.out.println("Java.util.Stack:");

        // Test push operation
        long javaPushTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaStack.push(i);
            }
        });
        printResult("Push " + NUM_OPERATIONS + " elements", javaPushTime);

        // Test peek operation
        long javaPeekTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaStack.peek();
            }
        });
        printResult("Peek " + NUM_OPERATIONS + " times", javaPeekTime);

        // Test pop operation
        long javaPopTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                javaStack.pop();
            }
        });
        printResult("Pop " + NUM_OPERATIONS + " elements", javaPopTime);

        System.out.println("\nCustom MyStack:");

        // Test push operation
        long myPushTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myStack.push(i);
            }
        });
        printResult("Push " + NUM_OPERATIONS + " elements", myPushTime);

        // Test peek operation
        long myPeekTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myStack.peek();
            }
        });
        printResult("Peek " + NUM_OPERATIONS + " times", myPeekTime);

        // Test pop operation
        long myPopTime = measureAverageRuntime(() -> {
            for (int i = 0; i < NUM_OPERATIONS; i++)
            {
                myStack.pop();
            }
        });
        printResult("Pop " + NUM_OPERATIONS + " elements", myPopTime);

        System.out.println("\n");
    }
}