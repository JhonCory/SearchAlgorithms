package mars;

import search.GoalTest;
import search.State;

public class BatteryTest implements GoalTest {

	// Returns true if we've exhausted the battery (i.e. made 20 moves)
	public boolean isGoal(State state) {
		MiniMap mapState = (MiniMap) state;
		return (mapState.numMovesMade() == 20);
	}

}
