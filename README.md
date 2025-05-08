Sure! Here's the revised README with detailed explanations of the algorithms and project structure:

---

# Rubik's Cube Solver

## Overview

This project implements a solver for a Rubik's Cube using three different search algorithms: Breadth-First Search (BFS), Depth-First Search (DFS), and A* Search. The program allows users to input the initial state of the cube and choose the algorithm to find the solution.

## Key Features

- **User Input**: The program allows users to input the initial state of the cube.
- **Algorithm Selection**: Users can choose between BFS, DFS, and A* Search to solve the cube.
- **Solution Path**: The program outputs the sequence of moves to solve the cube and the number of vertices visited during the search.

## Classes and Methods

### Solver Class

- **`main(String[] args)`**: The entry point of the program, handles user input and algorithm selection.

### CubeSolver Class

- **`isGoal(State state)`**: Checks if the current state is the goal state.
- **`successorFunction(State state)`**: Generates all possible moves from the current state.
- **`applyMove(State state, String move)`**: Applies a move to the current state and returns the resulting state.
- **`breadthFirstSearch(State initialState)`**: Implements BFS to find a solution.
- **`depthFirstSearch(State initialState)`**: Implements DFS to find a solution.
- **`aStarSearch(State initialState)`**: Implements A* Search to find a solution.
- **`constructSolutionPath(State goalState)`**: Constructs the solution path from the initial state to the goal state.

### State Class

Represents the state of the cube, including the faces, parent state, move applied, and depth.

## Search Algorithms

- **Breadth-First Search (BFS)**:
  - Explores all possible moves level by level, ensuring the shortest path to the solution is found.
  - Suitable for finding the minimal number of moves from the initial state to the goal state.

- **Depth-First Search (DFS)**:
  - Explores as far as possible along each branch before backtracking.
  - Useful for exploring all possible moves but can be inefficient for large state spaces like the Rubik's Cube.

- **A* Search**:
  - Uses a priority queue to explore the most promising paths first, combining the cost to reach a state and a heuristic estimate of the cost to reach the goal.
  - Utilizes heuristics to guide the search towards the goal state more efficiently than BFS or DFS.
  - Ensures the shortest path is found by using an admissible heuristic.

## Usage

1. **Input the initial state**: Enter a string representing the cube's faces.
2. **Choose the algorithm**: Select 'B' for BFS, 'D' for DFS, or 'A' for A* Search.
3. **View the solution**: The program outputs the sequence of moves and the number of visited vertices.

### Example

```sh
Enter the initial state of the cube (For example: YGGWORRRYBGYOBYBGOOWWRWB):
YGGWORRRYBGYOBYBGOOWWRWB
Choose the algorithm: BFS (B) or DFS (D) or A* (A):
A
Solution path:
[Y, G, G, W, O, R, R, R, Y, B, G, Y, O, B, Y, B, G, O, O, W, W, R, W, B]
Visited vertices: 104
```

## Project Structure

- `src/State.java`: Contains the representation of the Rubik's Cube state.
- `src/Solver.java`: Contains the main solver logic and algorithms.
- `test/`: Directory containing test cases and example states.

## Acknowledgments

- Inspired by various Rubik's Cube solving algorithms and techniques.
- Special thanks to the contributors and the open-source community for their continuous support and inspiration.
