import java.util.*;
public class Solver {
    private static final String[] MOVES = {"F", "F'", "R", "R'", "U", "U'", "B", "B'", "L", "L'", "D", "D'"};
    private int visitedStates;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Use a default scramble");
            System.out.println("\ta: WRWWBYRGRROGYYOOGGYBBOYB");
            System.out.println("\tb: YGGWORRRYBGYOBYBGOOWWRWB");
            System.out.println("2. Enter your own.");

            String option = scanner.nextLine();

            String scrambledInput = "";
            if ("1".equals(option)) {
                System.out.println("Select a default scramble a or b:");
                String defaultOption = scanner.nextLine();
                switch (defaultOption) {
                    case "a":
                        scrambledInput = "WRWWBYRGRROGYYOOGGYBBOYB";
                        break;
                    case "b":
                        scrambledInput = "YGGWORRRYBGYOBYBGOOWWRWB";
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a char a or b.");
                        continue;
                }
            } else if ("2".equals(option)) {
                System.out.println("Enter the scrambled state (24 characters):");
                scrambledInput = scanner.nextLine();
                if (scrambledInput.length() != 24) {
                    System.out.println("Invalid input. Please enter exactly 24 characters.");
                    continue;
                }
            } else {
                System.out.println("Invalid option selected. Please choose either 1 or 2.");
                continue;
            }
            char[] scrambledState = scrambledInput.toCharArray();
            State initialState = new State(scrambledState, 0, null);
            System.out.println("Choose the search algorithm:");
            System.out.println("DFS = Depth-First Search");
            System.out.println("ASTAR = A* Search");
            System.out.println("UCS = Uniform Cost Search");
            String choice = scanner.nextLine().toUpperCase();
            Solver solver = new Solver();
            long startTime = System.nanoTime();
            List<State> solutionPath = new ArrayList<>();
            switch (choice) {
                case "DFS":
                    int maxDepth = 15;
                    solutionPath = solver.iterativeDeepeningSearch(initialState, maxDepth);
                    break;
                case "ASTAR":
                    solutionPath = solver.aStarSearch(initialState);
                    break;
                case "UCS":
                    solutionPath = solver.uniformCostSearch(initialState);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            long endTime = System.nanoTime();

            if (!solutionPath.isEmpty()) {
                System.out.println("Solution found:");
                for (State state : solutionPath) {
                    System.out.println(state.toString());
                }
                System.out.println("Solution depth: " + (solutionPath.size() - 1));
                System.out.println("Visited vertices: " + solver.visitedStates);
                long timeElapsed = endTime - startTime;
                System.out.println("Time taken: " + (timeElapsed / 1_000_000) + " milliseconds");
            } else {
                System.out.println("No solution found.");
            }
        }
    }


    /**
     * This function generates all possible states from the given state s by applying all of the posible moves, creating new state instances for each and returning them as a list.
     * @param s
     */
    ArrayList<State> successorFunction(State s) {
        ArrayList<State> moves = new ArrayList<>();
        char[] faces = s.getStateFaces();

        for (String move : MOVES) {
            char[] newFaces = faces.clone();
            performMove(faces, newFaces, move);
            moves.add(new State(newFaces, s.getDepth() + 1, s));
        }

        return moves;
    }

    /**
     * This function modifies the newFaces array to represent the state of the cube after applying the specified move to the faces array
     * effectively performing the move on the cube's configuration.
     */
    private void performMove(char[] faces, char[] newFaces, String move) {
        // Apply moves directly to the faces array
        if(move.equals("F")){
            newFaces[0] = faces[0];
            newFaces[1] = faces[1];
            newFaces[2] = faces[19];
            newFaces[3] = faces[17];
            newFaces[4] = faces[2];
            newFaces[5] = faces[5];
            newFaces[6] = faces[3];
            newFaces[7] = faces[7];
            newFaces[8] = faces[10];
            newFaces[9] = faces[8];
            newFaces[10] = faces[11];
            newFaces[11] = faces[9];
            newFaces[12] = faces[6];
            newFaces[13] = faces[4];
            newFaces[14] = faces[14];
            newFaces[15] = faces[15];
            newFaces[16] = faces[16];
            newFaces[17] = faces[12];
            newFaces[18] = faces[18];
            newFaces[19] = faces[13];
            newFaces[20] = faces[20];
            newFaces[21] = faces[21];
            newFaces[22] = faces[22];
            newFaces[23] = faces[23];
        }
        else if (move.equals("F'")){
            newFaces[0] = faces[0];
            newFaces[1] = faces[1];
            newFaces[2] = faces[4];
            newFaces[3] = faces[6];
            newFaces[4] = faces[13];
            newFaces[5] = faces[5];
            newFaces[6] = faces[12];
            newFaces[7] = faces[7];
            newFaces[8] = faces[9];
            newFaces[9] = faces[11];
            newFaces[10] = faces[8];
            newFaces[11] = faces[10];
            newFaces[12] = faces[17];
            newFaces[13] = faces[19];
            newFaces[14] = faces[14];
            newFaces[15] = faces[15];
            newFaces[16] = faces[16];
            newFaces[17] = faces[3];
            newFaces[18] = faces[18];
            newFaces[19] = faces[2];
            newFaces[20] = faces[20];
            newFaces[21] = faces[21];
            newFaces[22] = faces[22];
            newFaces[23] = faces[23];
        }
        else if (move.equals("R")){
            newFaces[0] = faces[0];
            newFaces[1] = faces[9];
            newFaces[2] = faces[2];
            newFaces[3] = faces[11];
            newFaces[4] = faces[6];
            newFaces[5] = faces[4];
            newFaces[6] = faces[7];
            newFaces[7] = faces[5];
            newFaces[8] = faces[8];
            newFaces[9] = faces[13];
            newFaces[10] = faces[10];
            newFaces[11] = faces[15];
            newFaces[12] = faces[12];
            newFaces[13] = faces[22];
            newFaces[14] = faces[14];
            newFaces[15] = faces[20];
            newFaces[16] = faces[16];
            newFaces[17] = faces[17];
            newFaces[18] = faces[18];
            newFaces[19] = faces[19];
            newFaces[20] = faces[3];
            newFaces[21] = faces[21];
            newFaces[22] = faces[1];
            newFaces[23] = faces[23];
        }
        else if (move.equals("R'")){
            newFaces[0] = faces[0];
            newFaces[1] = faces[22];
            newFaces[2] = faces[2];
            newFaces[3] = faces[20];
            newFaces[4] = faces[5];
            newFaces[5] = faces[7];
            newFaces[6] = faces[4];
            newFaces[7] = faces[6];
            newFaces[8] = faces[8];
            newFaces[9] = faces[1];
            newFaces[10] = faces[10];
            newFaces[11] = faces[3];
            newFaces[12] = faces[12];
            newFaces[13] = faces[9];
            newFaces[14] = faces[14];
            newFaces[15] = faces[11];
            newFaces[16] = faces[16];
            newFaces[17] = faces[17];
            newFaces[18] = faces[18];
            newFaces[19] = faces[19];
            newFaces[20] = faces[15];
            newFaces[21] = faces[21];
            newFaces[22] = faces[13];
            newFaces[23] = faces[23];
        }
        else if (move.equals("U")){
            newFaces[0] = faces[2];
            newFaces[1] = faces[0];
            newFaces[2] = faces[3];
            newFaces[3] = faces[1];
            newFaces[4] = faces[20];
            newFaces[5] = faces[21];
            newFaces[6] = faces[6];
            newFaces[7] = faces[7];
            newFaces[8] = faces[4];
            newFaces[9] = faces[5];
            newFaces[10] = faces[10];
            newFaces[11] = faces[11];
            newFaces[12] = faces[12];
            newFaces[13] = faces[13];
            newFaces[14] = faces[14];
            newFaces[15] = faces[15];
            newFaces[16] = faces[8];
            newFaces[17] = faces[9];
            newFaces[18] = faces[18];
            newFaces[19] = faces[19];
            newFaces[20] = faces[16];
            newFaces[21] = faces[17];
            newFaces[22] = faces[22];
            newFaces[23] = faces[23];
        }
        else if (move.equals("U'")){
            newFaces[0] = faces[1];
            newFaces[1] = faces[3];
            newFaces[2] = faces[0];
            newFaces[3] = faces[2];
            newFaces[4] = faces[8];
            newFaces[5] = faces[9];
            newFaces[6] = faces[6];
            newFaces[7] = faces[7];
            newFaces[8] = faces[16];
            newFaces[9] = faces[17];
            newFaces[10] = faces[10];
            newFaces[11] = faces[11];
            newFaces[12] = faces[12];
            newFaces[13] = faces[13];
            newFaces[14] = faces[14];
            newFaces[15] = faces[15];
            newFaces[16] = faces[20];
            newFaces[17] = faces[11];
            newFaces[18] = faces[18];
            newFaces[19] = faces[19];
            newFaces[20] = faces[4];
            newFaces[21] = faces[5];
            newFaces[22] = faces[22];
            newFaces[23] = faces[23];
        }
        else if (move.equals("B")){
            newFaces[0] = faces[5];
            newFaces[1] = faces[7];
            newFaces[2] = faces[2];
            newFaces[3] = faces[3];
            newFaces[4] = faces[4];
            newFaces[5] = faces[15];
            newFaces[6] = faces[6];
            newFaces[7] = faces[14];
            newFaces[8] = faces[8];
            newFaces[9] = faces[9];
            newFaces[10] = faces[10];
            newFaces[11] = faces[11];
            newFaces[12] = faces[12];
            newFaces[13] = faces[13];
            newFaces[14] = faces[16];
            newFaces[15] = faces[18];
            newFaces[16] = faces[1];
            newFaces[17] = faces[17];
            newFaces[18] = faces[0];
            newFaces[19] = faces[19];
            newFaces[20] = faces[22];
            newFaces[21] = faces[20];
            newFaces[22] = faces[23];
            newFaces[23] = faces[21];
        }
        else if (move.equals("B'")){
            newFaces[0] = faces[18];
            newFaces[1] = faces[16];
            newFaces[2] = faces[2];
            newFaces[3] = faces[3];
            newFaces[4] = faces[4];
            newFaces[5] = faces[0];
            newFaces[6] = faces[6];
            newFaces[7] = faces[1];
            newFaces[8] = faces[8];
            newFaces[9] = faces[9];
            newFaces[10] = faces[10];
            newFaces[11] = faces[11];
            newFaces[12] = faces[12];
            newFaces[13] = faces[13];
            newFaces[14] = faces[7];
            newFaces[15] = faces[5];
            newFaces[16] = faces[14];
            newFaces[17] = faces[17];
            newFaces[18] = faces[15];
            newFaces[19] = faces[19];
            newFaces[20] = faces[21];
            newFaces[21] = faces[23];
            newFaces[22] = faces[20];
            newFaces[23] = faces[22];
        }
        else if (move.equals("L")){
            newFaces[0] = faces[23];
            newFaces[1] = faces[1];
            newFaces[2] = faces[21];
            newFaces[3] = faces[3];
            newFaces[4] = faces[4];
            newFaces[5] = faces[5];
            newFaces[6] = faces[6];
            newFaces[7] = faces[7];
            newFaces[8] = faces[0];
            newFaces[9] = faces[9];
            newFaces[10] = faces[2];
            newFaces[11] = faces[11];
            newFaces[12] = faces[8];
            newFaces[13] = faces[13];
            newFaces[14] = faces[10];
            newFaces[15] = faces[15];
            newFaces[16] = faces[18];
            newFaces[17] = faces[16];
            newFaces[18] = faces[19];
            newFaces[19] = faces[17];
            newFaces[20] = faces[20];
            newFaces[21] = faces[14];
            newFaces[22] = faces[22];
            newFaces[23] = faces[12];
        }
        else if (move.equals("L'")){
            newFaces[0] = faces[8];
            newFaces[1] = faces[1];
            newFaces[2] = faces[10];
            newFaces[3] = faces[3];
            newFaces[4] = faces[4];
            newFaces[5] = faces[5];
            newFaces[6] = faces[6];
            newFaces[7] = faces[7];
            newFaces[8] = faces[12];
            newFaces[9] = faces[9];
            newFaces[10] = faces[14];
            newFaces[11] = faces[11];
            newFaces[12] = faces[23];
            newFaces[13] = faces[13];
            newFaces[14] = faces[21];
            newFaces[15] = faces[15];
            newFaces[16] = faces[17];
            newFaces[17] = faces[19];
            newFaces[18] = faces[16];
            newFaces[19] = faces[18];
            newFaces[20] = faces[20];
            newFaces[21] = faces[2];
            newFaces[22] = faces[22];
            newFaces[23] = faces[0];
        }
        else if (move.equals("D")){
            newFaces[0] = faces[0];
            newFaces[1] = faces[1];
            newFaces[2] = faces[2];
            newFaces[3] = faces[3];
            newFaces[4] = faces[4];
            newFaces[5] = faces[5];
            newFaces[6] = faces[10];
            newFaces[7] = faces[11];
            newFaces[8] = faces[8];
            newFaces[9] = faces[9];
            newFaces[10] = faces[18];
            newFaces[11] = faces[19];
            newFaces[12] = faces[14];
            newFaces[13] = faces[12];
            newFaces[14] = faces[15];
            newFaces[15] = faces[13];
            newFaces[16] = faces[16];
            newFaces[17] = faces[17];
            newFaces[18] = faces[22];
            newFaces[19] = faces[23];
            newFaces[20] = faces[20];
            newFaces[21] = faces[21];
            newFaces[22] = faces[6];
            newFaces[23] = faces[7];
        }
        else if (move.equals("D'")){
            newFaces[0] = faces[0];
            newFaces[1] = faces[1];
            newFaces[2] = faces[2];
            newFaces[3] = faces[3];
            newFaces[4] = faces[4];
            newFaces[5] = faces[5];
            newFaces[6] = faces[22];
            newFaces[7] = faces[23];
            newFaces[8] = faces[8];
            newFaces[9] = faces[9];
            newFaces[10] = faces[6];
            newFaces[11] = faces[7];
            newFaces[12] = faces[12];
            newFaces[13] = faces[15];
            newFaces[14] = faces[12];
            newFaces[15] = faces[14];
            newFaces[16] = faces[16];
            newFaces[17] = faces[17];
            newFaces[18] = faces[10];
            newFaces[19] = faces[11];
            newFaces[20] = faces[20];
            newFaces[21] = faces[21];
            newFaces[22] = faces[18];
            newFaces[23] = faces[19];
        }
    }

    /**
     * this function checks if the provided state is the goal state, by checking the uniformity in colors for each of the six faces.
     * because there is a meaning to how the cube represent
     * @param s
     */
    public static boolean isGoal(State s) {
        for (int i = 0; i < 24; i += 4) {
            char firstColor = s.getStateFaces()[i];
            for (int j = 1; j < 4; j++) {
                if (s.getStateFaces()[i + j] != firstColor) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *Searches for a solution path using Iterative Deepening Depth-First Search up to maxDepth, tracking visited states.
     * @param initialState
     * @param maxDepth
     */
    public List<State> iterativeDeepeningSearch(State initialState, int maxDepth) {
        List<State> solution = null;
        for (int currentDepth = 1; currentDepth <= maxDepth; currentDepth++) {
            visitedStates = 0;
            List<State> path = new ArrayList<>();
            Set<State> visited = new HashSet<>();
            if (dfs(initialState, currentDepth, path, visited)) {
                solution = path;
                break;
            }
        }
        System.out.println("Visited states: " + visitedStates);
        return solution;
    }

    /**
     * Recursively searches for a goal state within a depth limit, building a solution path if found.
     * @param currentState
     * @param depthLimit

     */
    private boolean dfs(State currentState, int depthLimit, List<State> path, Set<State> visited) {
        visitedStates++;
        if (!visited.add(currentState)) {
            return false;
        }

        if (isGoal(currentState)) {
            path.add(currentState);
            return true;
        } else if (depthLimit == 0) {
            return false;
        } else {
            ArrayList<State> successors = successorFunction(currentState);
            for (State next : successors) {
                if (dfs(next, depthLimit - 1, path, visited)) {
                    path.add(0, currentState);
                    return true;
                }
            }
            visited.remove(currentState);
            return false;
        }
    }

    /**
     * This function implements A* search to find the least cost path to a goal state, considering both path cost and heuristic estimates.
     * @param initialState
     */
    public List<State> aStarSearch(State initialState) {
        PriorityQueue<State> openSet = new PriorityQueue<>(Comparator
                .<State>comparingInt(s -> s.getDepth() + s.getHeuristicValue())
                .thenComparing(s -> Arrays.toString(s.getStateFaces())));

        initialState.setDepth(0);
        initialState.computeHeuristicValue();
        openSet.add(initialState);
        Map<String, Integer> costSoFar = new HashMap<>();
        costSoFar.put(Arrays.toString(initialState.getStateFaces()), 0);

        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();

            if (isGoal(currentState)) {
                List<State> solutionPath = new ArrayList<>();
                State tempState = currentState;
                while (tempState != null) {
                    solutionPath.add(0, tempState);
                    tempState = tempState.getParentState();
                }
                return solutionPath;
            }

            for (State nextState : successorFunction(currentState)) {
                int newCost = currentState.getDepth() + 1;
                String nextStateKey = Arrays.toString(nextState.getStateFaces());
                if (!costSoFar.containsKey(nextStateKey) || newCost < costSoFar.get(nextStateKey)) {
                    costSoFar.put(nextStateKey, newCost);
                    nextState.setDepth(newCost);
                    nextState.computeHeuristicValue();
                    openSet.add(nextState);
                    visitedStates++;
                }
            }
        }
        return Collections.emptyList();
    }

    /**
     * This function executes Uniform Cost Search to find the least cost path to a goal state, based only on path costs without heuristics.
     * @param initialState
     */
    public List<State> uniformCostSearch(State initialState) {
        PriorityQueue<State> openSet = new PriorityQueue<>(Comparator
                .<State>comparingInt(State::getDepth)
                .thenComparing(s -> Arrays.toString(s.getStateFaces())));

        openSet.add(initialState);
        Map<String, Integer> costSoFar = new HashMap<>();
        costSoFar.put(Arrays.toString(initialState.getStateFaces()), 0);

        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();

            if (isGoal(currentState)) {
                List<State> solutionPath = new ArrayList<>();
                State tempState = currentState;
                while (tempState != null) {
                    solutionPath.add(0, tempState);
                    tempState = tempState.getParentState();
                }
                return solutionPath;
            }

            for (State nextState : successorFunction(currentState)) {
                int newCost = currentState.getDepth() + 1;
                String nextStateKey = Arrays.toString(nextState.getStateFaces());
                if (!costSoFar.containsKey(nextStateKey) || newCost < costSoFar.get(nextStateKey)) {
                    costSoFar.put(nextStateKey, newCost);
                    nextState.setDepth(newCost);
                    openSet.add(nextState);
                    visitedStates++;
                }
            }
        }
        return Collections.emptyList();
    }
}
