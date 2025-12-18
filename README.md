# Data Structures Library

A performance-focused Java implementation of fundamental data structures with comprehensive benchmarking against `java.util` equivalents.

https://github.com/user-attachments/assets/818d2267-0704-4d66-a988-e1fd6d5da8ed

## Overview

This library provides ground-up implementations of essential data structures, emphasizing both correctness and performance. Each structure includes detailed performance tests that compare custom implementations against Java's standard library, offering insights into algorithmic efficiency and real-world runtime characteristics.

## Implemented Data Structures

### MyLinkedList
A generic singly-linked list implementation with O(1) insertion at tail and O(n) search/removal operations.

**Key Features:**
- Head and tail pointer maintenance for efficient append operations
- Generic type support with type-safe operations
- Index-based removal with bounds checking
- Linear search with proper value equality checking

**Benchmarked Operations:**
- `add(T value)` - Append to end (O(1))
- `contains(T element)` - Linear search (O(n))
- `remove()` - Remove from head (O(1))
- `remove(int location)` - Remove at index (O(n))

### MyHashMap
A custom hash table implementation using separate chaining for collision resolution.

**Key Features:**
- Fixed capacity with linked-list collision handling
- Generic key-value pairs with proper encapsulation
- Standard map operations (put, get, remove)
- Hash code computation with absolute value protection against negative hashes

**Benchmarked Operations:**
- `put(K key, V value)` - Insert or update entry (O(1) average)
- `get(K key)` - Retrieve value by key (O(1) average)
- `remove(K key)` - Delete entry and return it (O(1) average)

**Implementation Details:**
- Default capacity: 16 buckets
- Collision resolution: Chaining with linked entries
- Key equality checking for collision traversal

### MyPriorityQueue
A min-heap or max-heap implementation backed by an ArrayList with configurable comparison logic.

**Key Features:**
- Generic type support with optional custom Comparator
- Falls back to Comparable's `compareTo()` when no Comparator provided
- Standard heap operations with proper heapify
- Dynamic resizing through ArrayList backing

**Benchmarked Operations:**
- `add(T element)` - Insert with heap rebalancing (O(log n))
- `peek()` - View minimum/maximum element (O(1))
- `poll()` - Remove and return minimum/maximum (O(log n))

### MyStack
A LIFO stack implementation with standard push/pop operations.

**Key Features:**
- Generic type support
- Standard stack interface (push, pop, peek)
- All operations run in O(1) time

**Benchmarked Operations:**
- `push(T element)` - Add to top (O(1))
- `peek()` - View top element (O(1))
- `pop()` - Remove and return top element (O(1))

## Performance Benchmarking

The library includes a comprehensive testing suite (`TestFunctions.java`) that measures runtime performance across multiple iterations to provide statistically meaningful comparisons.

**Methodology:**
- Each operation tested 1,000 times per trial
- 5 trials per operation for statistical averaging
- Warm-up phase to account for JVM initialization
- Results displayed in milliseconds with 3-decimal precision
- Side-by-side comparison with `java.util` implementations

**Enhanced Testing Features:**
- Helper method pattern eliminates code duplication
- Accurate unit conversion (nanoseconds → milliseconds)
- Professional formatted output with aligned columns
- Clear visual separators for easy result comparison

**Sample Output:**
```
============================================================
LINKED LIST PERFORMANCE COMPARISON
============================================================

Java.util.LinkedList:
  Add 1000 elements:                             0.245 ms
  Contains lookup 1000 times:                    0.189 ms
  Remove from head 1000 times:                   0.156 ms

Custom MyLinkedList:
  Add 1000 elements:                             0.252 ms
  Contains lookup 1000 times:                    0.193 ms
  Remove at random index 1000 times:             1.847 ms
  Remove from head 1000 times:                   0.159 ms
```


## Running Benchmarks

```bash
# Compile the project
javac Demonstration.java

# Run performance tests
java Demonstration
```

This will execute the full benchmark suite, comparing each custom data structure against Java's standard library implementations with detailed performance metrics.

## Technical Highlights

- **Generic Programming**: All structures use Java generics for type safety
- **Proper Encapsulation**: Private fields with controlled access through methods
- **Inner Classes**: Strategic use of static and non-static inner classes (Node, Entry)
- **Comparator Pattern**: Flexible comparison logic in PriorityQueue
- **Performance Analysis**: Statistical runtime measurement with JVM warm-up and accurate unit conversion
- **Edge Case Handling**: Proper exception throwing for invalid operations
- **Code Quality**: Clean, well-commented code with minimal suppressed warnings

## Code Quality Improvements

This project demonstrates attention to detail through:
- Strategic comments explaining algorithms and time complexities
- Proper use of `.equals()` for value comparison
- Helper methods to eliminate code duplication in testing
- Professional output formatting for benchmark results

## Learning Outcomes

This project demonstrates:
- Deep understanding of fundamental data structure implementations
- Knowledge of time and space complexity tradeoffs
- Performance testing methodology and statistical analysis
- Generic programming patterns in Java
- Practical comparison between custom and standard library implementations
- Software engineering best practices (DRY principle, proper encapsulation, clean code)

## Future Enhancements

- Unit tests for correctness verification (currently focuses on performance)
- Dynamic resizing for HashMap (currently fixed capacity)
- Additional structures (trees, graphs, tries)
- Thread-safe implementations
- Memory profiling alongside runtime benchmarks

---