package prj5;

import java.util.Comparator;

/**
 * SortAlpha Class
 * Sorts Two passed Races Alphabetically.
 *
 * @author Benjamin Rosenbloom (bprosenbloom@vt.edu)
 * @version 2021.11.18
 * @author Raena Rahimi Bafrani (raenar@vt.edu)
 * @version 2021.11.18
 * @author Tejas Choudhary
 * @version 2021.11.18
 * 
 *          // Virginia Tech Honor Code Pledge:
 *          //
 *          // As a Hokie, I will conduct myself with honor and integrity at all
 *          times.
 *          // I will not lie, cheat, or steal, nor will I accept the actions
 *          // of those who do.
 *          // Your name: Group 51
 */
public class SortAlpha implements Comparator<Race> {
    /**
     * Method to Sort Alphabetically.
     * Passes Two Names in, selects in Alphabetical Order.
     * 
     * @param firstRace
     *            Race being compared First.
     * @param secondRace
     *            Race that is being compared Second.
     * @return Returns An Int to which Name is in Alphabetical Order.
     */
    public int compare(Race firstRace, Race secondRace) {
        return firstRace.getName().compareTo(secondRace.getName());
    }
}
