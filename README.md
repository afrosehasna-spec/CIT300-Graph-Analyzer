# CIT300 Data Structure and Graph Performance Analyzer

## Project Description
A Java console-based application that demonstrates the practical use of data structures and algorithms:
Array, Stack, Queue, Linked List, Searching (Linear and Binary), Graph (BFS and DFS) and a
performance comparison of algorithms using step counts and execution time.

Course: CIT300 Data Structures and Algorithms (Graded Practical Assignment 2)

## Team Members

**Student Name:** MA Hasna
**Student ID:** 23DA2-0610
**Assigned Responsibility:** Graph Component, Main Menu and System Integration (Team Leader)

**Individual Contribution:**
- Implemented the Graph class using an adjacency list (add vertex, add edge, display graph)
- Implemented BFS traversal (queue based) and DFS traversal (recursion based) with step counting
- Implemented the main menu, all submenus and input validation (`Main.java`)
- Integrated all modules into one application and tested the full system
- Set up the GitHub repository, branches, pull requests and README



**Student Name:** MRF Roshan
**Student ID:** 23DA2-0512
**Assigned Responsibility:** Array and Searching

**Individual Contribution:**
- `ArrayOperations.java`: fixed-capacity array with insert (end and at position), delete, search and display
- Handled full array, empty array and invalid position cases
- Added insertion sort so the array can be sorted before binary search
- `SearchOperations.java`: Linear Search (O(n)) and Binary Search (O(log n))
- Recorded number of steps and execution time for each search
- Added a comparison feature that runs both searches on the same data

**Student Name:** JK Riska
**Student ID:** 23DA2-0978
**Assigned Responsibility:** Stack and Queue

**Individual Contribution:**
- `MyStack.java`: push, pop, peek, display, with stack overflow and empty stack handling
- `MyQueue.java`: enqueue, dequeue, peek/front, display, with full and empty queue handling
- All stack and queue operations run in O(1)



**Student Name:** SHF Nasra
**Student ID:** 23DA2-1047
**Assigned Responsibility:** Linked List and Performance Comparison

**Individual Contribution:**
- `MyLinkedList.java`: singly linked list with insert at beginning, insert at end, delete, search and display
- `PerformanceAnalyzer.java`: stores operation, algorithm, steps and time, and displays the results table

## Technologies Used
- Java (console application)
- Git and GitHub (branches, commits, pull requests)

## Main Features
- Menu-driven console interface with submenus for every component
- Array, Stack, Queue and Linked List operations with empty/full handling
- Linear Search vs Binary Search with step count and execution time
- Undirected graph with BFS and DFS traversal
- Performance comparison table (Search and Graph Traversal)
- Input validation for all numeric inputs and menu choices

## Complexity Summary
| Operation | Complexity |
|---|---|
| Stack push / pop / peek | O(1) |
| Queue enqueue / dequeue / peek | O(1) |
| Linked list insert at beginning | O(1) |
| Linked list search / delete | O(n) |
| Array insert at position / delete | O(n) |
| Linear Search | O(n) |
| Binary Search (sorted array) | O(log n) |
| BFS / DFS | O(V + E) |

## How to Run
```
cd src
javac *.java
java Main
```
Requires JDK 8 or higher.

## GitHub Collaboration
Each member worked on an individual feature branch and merged through pull requests:
- `feature/graph-menu` (Hasna)
- `feature/array-search` (Roshan)
- `feature/stack-queue` (Riska)
- `feature/linkedlist-performance` (Nasra)

## AI Assistance Declaration
AI assistance (Claude) was used during this project to help write and test code for
the Graph, Main menu, Array and Searching components, and to provide project guidance.
All team members reviewed their own components and are able to explain them.
