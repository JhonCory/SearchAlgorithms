package mars;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;
import search.Action;
import search.State;

/** Keeps track of the planet’s layout as well as the robot’s position */
public class MiniMap implements State {
	protected Planet planet; // reference to the layout of the planet
	protected int robotRow; // current coordinates of robot
	protected int robotCol; 
	protected HashSet<Tuple<Integer,Integer>> spotsExplored; // list of all squares already explored by robot
	protected int numMovesMade; // number of moves made by robot before this state

	public MiniMap(Planet planet, int startRow, int startCol, HashSet<Tuple<Integer,Integer>> spotsExplored, int numMovesMade) {
		this.planet = planet;
		this.robotRow = startRow;
		this.robotCol = startCol;
		this.spotsExplored = spotsExplored;
		this.numMovesMade = numMovesMade;
	}
	
	public Set<Action> getApplicableActions() {
		Set<Action> actions = new LinkedHashSet<Action>();
		for (Movement movement : Movement.values()) {
			int newRow = robotRow + movement.deltaRow;
			int newCol = robotCol + movement.deltaColumn;

			if (planet.isAccessible(newRow,newCol))
				actions.add(movement);
		}

		return actions;
	}
	

	public State getActionResult(Action action) {
		Movement movement = (Movement) action;
	
		// Update the new location of the robot, and add the new location if it isn't new
		Tuple<Integer,Integer> newSpot = new Tuple<Integer,Integer>(robotRow+movement.deltaRow,robotCol+movement.deltaColumn);
		HashSet<Tuple<Integer,Integer>> newSpotsExplored = (HashSet<Tuple<Integer,Integer>>) spotsExplored.clone();
		if (!newSpotsExplored.contains(newSpot))
			newSpotsExplored.add(newSpot);

		return new MiniMap(planet, newSpot._0, newSpot._1, newSpotsExplored, (numMovesMade+1));
	}

	public boolean isAccessible(int row, int col) {
		return planet.isAccessible(row,col);
	}

	public int getWidth() {
		return planet.width();
	}

	public int getHeight() {
		return planet.height();
	}

	public boolean robotAt(int row, int col) {
		return (robotRow==row && robotCol==col);
	}

	public int numSpotsExplored() {
		return spotsExplored.size();
	}

	public HashSet<Tuple<Integer,Integer>> spotsExplored() {
		return spotsExplored;
	}

	public int numMovesMade() {
		return numMovesMade;
	}

	// Takes into account only robot position and spots explored
	public boolean equals(Object that) {
		try {
			MiniMap otherMap = (MiniMap) that;
			boolean result = otherMap.robotAt(robotRow,robotCol);
			result = result && otherMap.spotsExplored().equals(spotsExplored);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int hashCode() {
		return (20*robotRow*robotCol + numSpotsExplored());	
	}
}
