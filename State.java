import java.util.Arrays;

public class State {
    private char[] stateFaces;
    private int depth;
    private int heuristicValue;
    private State parentState;


    public State(char[] stateFaces, int depth, State parentState) {
        this.stateFaces = stateFaces;
        this.depth = depth;
        this.parentState = parentState;
        computeHeuristicValue();
    }

    //heuristic value is the number of misplaced tiles
    public void computeHeuristicValue() {
        int count = 0;
        for (int i = 0; i < stateFaces.length; i += 4) {
            for (int j = 0; j < 4; j++) {
                if (!(stateFaces[i + j]==(stateFaces[i]))) {
                    count++;
                }
            }
        }
        this.heuristicValue = count;
    }




    public char[] getStateFaces() {
        return stateFaces;
    }

    public void setStateFaces(char[] stateFaces) {
        this.stateFaces = stateFaces;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHeuristicValue() {
        return heuristicValue;
    }

    public void setHeuristicValue(int heuristicValue) {
        this.heuristicValue = heuristicValue;
    }

    public State getParentState() {
        return parentState;
    }

    public void setParentState(State parentState) {
        this.parentState = parentState;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stateFaces.length; i++) {
            builder.append(stateFaces[i]);
            if ((i + 1) % 4 == 0 && i != stateFaces.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
