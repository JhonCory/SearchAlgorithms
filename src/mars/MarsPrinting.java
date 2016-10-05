package mars;

import search.Action;
import search.Printing;
import search.State;

public class MarsPrinting extends Printing {

	public void print(Action action) {
		System.out.print("move ");
		System.out.print(((Movement) action).name());
	}

	public void print(State state) {
		MiniMap map = (MiniMap) state;

		System.out.println("# spots explored = "+map.numSpotsExplored());

		int width = map.getWidth();
		int height = map.getHeight();
		
		printChar('-', 2*width+3); // top border
		System.out.println();
		
		for (int row=0; row<height; row++) {
			System.out.print('|');

			for (int column=0; column<width; column++) {
				System.out.print(' ');

				char cellVal = '1';
				if (map.robotAt(row,column)) {
					cellVal = 'R';
				} else if (map.isAccessible(row,column)) {
					cellVal = '0';
				}
				System.out.print(cellVal);
			}

			System.out.print(" |");
			System.out.println();
		}
		printChar('-', 2*width+3); // bottom border
		System.out.println();
	}

	// Prints a char n times
	public void printChar(char c, int n) {
		for (int i=0; i<n; i++) {
			System.out.print(c);
		}
	}
}
