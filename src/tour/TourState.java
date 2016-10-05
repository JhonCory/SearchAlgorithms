package tour;



import java.util.Collections;

import java.util.LinkedHashSet;

import java.util.Set;


import search.Action;

import search.State;



public class TourState implements State {

	protected final Set<City> visitedCities;
	protected final City currentCity;

	

	public TourState(City startCity) {

		this.visitedCities = Collections.emptySet();

		this.currentCity = startCity;

	}


	public TourState(Set<City> visitedCities, City currentCity) {

		this.visitedCities = visitedCities;

		this.currentCity = currentCity;

	}


	public Set<Road> getApplicableActions() {
		return currentCity.outgoingRoads;

	}


	public State getActionResult(Action action) {

		Road road = (Road)action;

		Set<City> newVisitedCities = new LinkedHashSet<City>(visitedCities);

		newVisitedCities.add(road.targetCity);

		return new TourState(newVisitedCities, road.targetCity);

	}


	// Returns true iff it is a TourState with the same currentCity
	@Override
	public boolean equals(Object that) {
		if (!(that instanceof TourState)) 
			return false;					// TourStates can only equal other TourStates
		else {	
			TourState other = (TourState) that;	
			return (hashCode() == other.hashCode());	// compare hashcodes to determine equality
		}
	}

	// Returns a hashcode; uses currentyCity as its only field
	// Be careful about use in hash tables
	@Override
	public int hashCode() {
		return ((currentCity == null) ? 0 : currentCity.hashCode());
	}
}
