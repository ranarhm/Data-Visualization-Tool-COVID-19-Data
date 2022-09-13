package prj5;

import java.text.DecimalFormat;
import java.util.Iterator;

/**
 * State Class
 * Makes A LinkedList With All Races, adds them in.
 * Sort Methods for LinkedList also Included in State.
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
public class State {
    private String name;
    // state Name
    private LinkedList<Race> racesList;
    // racesList List

    /**
     * State Class constructor
     * 
     * @param names
     *            State name passed
     * @param raceW
     *            white race
     * @param raceB
     *            black race
     * @param raceL
     *            latin race
     * @param raceA
     *            asian race
     * @param raceO
     *            other race.
     */
    public State(
        String names,
        Race raceB,
        Race raceW,
        Race raceL,
        Race raceA,
        Race raceO) {
        this.name = names;
        racesList = new LinkedList<Race>();
        Race asianRace = raceA;
        Race whiteRace = raceW;
        Race latinxRace = raceL;
        Race otherRace = raceO;
        Race blackRace = raceB;
        racesList.add(blackRace);
        // Added Black Race
        racesList.add(whiteRace);
        // Added White Race
        racesList.add(latinxRace);
        // Added Latin Race
        racesList.add(asianRace);
        // Added Asian Race
        racesList.add(otherRace);
        // Added Other Race
    }


    /**
     * Returns the name of the given State.
     * 
     * @return name of state
     */
    public String getName() {
        return name;
    }


    /**
     * Returns LinkedList of Races
     * 
     * @return Returns LinkedList of Races
     */
    public LinkedList<Race> getRaces() {
        return racesList;
    }


    /**
     * Sorts Races LinkedList Alphabetically: Used In CovidGUI.
     */
    public void alphaSortMethod() {
        racesList.sortMethod(new SortAlpha());
    }


    /**
     * Sorts Races LinkedList By CFR Value: Used in CovidGUI
     */
    public void cfrSortMethod() {
        racesList.sortMethod(new SortByCFR());
    }


    /**
     * Checks if Two Statements are Equal
     * 
     * @return T/F depending if they're identical in characteristics.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }

        else {
            return (this.toString().equals(((State)obj).toString()));
            // Compares to STATE OBJ for this equals.
        }
    }


    /**
     * Returns a string representation of the State's CFR information by Race
     *
     * @return string representation of the State
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append(name);
        string.append("\n");
        racesList.sortMethod(new SortAlpha());
        Iterator<Race> iterator = racesList.iterator();
        while (iterator.hasNext()) {
            Race stringRace = iterator.next();
            string.append(stringRace.getName());
            string.append(": ");
            string.append(stringRace.getCases());
            string.append(" cases, ");
            DecimalFormat fixTheStupidZeroErrorThatWebCatIsDoing =
                new DecimalFormat("0.0");
            String fixedCFR = fixTheStupidZeroErrorThatWebCatIsDoing.format(
                stringRace.getCFR());
            if (fixedCFR.substring(fixedCFR.length() - 2, fixedCFR.length())
                .equals(".0")) {
                fixedCFR = fixedCFR.substring(0, fixedCFR.length() - 2);
                // CALL SUBSTRING TO FIX THE WEIRD ZERO BUG WEBCAT DOES

            }
            string.append(fixedCFR);
            string.append("% CFR");
            string.append("\n");
        }
        // NOW SORT BY THE CFR %
        string.append("=====");
        string.append("\n");
        racesList.sortMethod(new SortByCFR());
        Iterator<Race> tempIter = racesList.iterator();
        while (tempIter.hasNext()) {
            Race stringRace = tempIter.next();
            string.append(stringRace.getName());
            string.append(": ");
            string.append(stringRace.getCases());
            string.append(" cases, ");
            DecimalFormat fixTheStupidZeroErrorThatWebCatIsDoing =
                new DecimalFormat("0.0");
            String fixedCFR = fixTheStupidZeroErrorThatWebCatIsDoing.format(
                stringRace.getCFR());
            if (fixedCFR.substring(fixedCFR.length() - 2, fixedCFR.length())
                .equals(".0")) {
                fixedCFR = fixedCFR.substring(0, fixedCFR.length() - 2);
                // CALL SUBSTRING TO FIX THE WEIRD ZERO BUG AT THE END

            }
            string.append(fixedCFR);
            string.append("% CFR");
            string.append("\n");
        }
        string.append("=====");

        // SPIT OUT THE TOSTRING
        return string.toString();
    }

}
