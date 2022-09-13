package prj5;

import java.text.DecimalFormat;

/**
 * Race Class
 * Constructor Checks to see if "NA" is passed in cases or Deaths or Both.
 * IF IT IS: Values are equal to -1.
 * Other Get methods, and Equals method.
 * Calculates CFR % in constructor.
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
public class Race {

    private double valueCFR;
    private String name;
    private int cases;
    private int deaths;

    /**
     * Race Constructor
     * 
     * @param names
     *            Race name passed.
     * @param cases
     *            Cases for that specific race.
     * @param deaths
     *            Deaths for the specific race.
     */
    public Race(String names, String cases, String deaths) {

        if (cases.equals("NA") && deaths.equals("NA")) {
            valueCFR = -1;
            this.cases = -1;
            this.deaths = -1;
        }
        else if (cases.equals("NA")) {
            // If CASES IS "NA"
            this.cases = -1;
            valueCFR = -1;
            this.deaths = Integer.valueOf((String)deaths);
        }
        else if (deaths.equals("NA")) {
            // IF Deaths is "NA"
            this.cases = Integer.valueOf((String)cases);
            valueCFR = -1;
            this.deaths = -1;

        }

        else {
            this.deaths = Integer.valueOf((String)deaths);
            // Integer Representation of the String.
            this.cases = Integer.valueOf((String)cases);
            // Integer Representation of the String.
            valueCFR = (((double)this.deaths / this.cases) * 100.0);

            valueCFR = Double.parseDouble(new DecimalFormat("##.#").format(
                valueCFR));
        }
        name = names;

    }


    /**
     * Returns race name passed.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the calculated CFR.
     * 
     * @return CFR
     */
    public double getCFR() {
        return valueCFR;
    }


    /**
     * Returns death number for specific Race.
     * 
     * @return int deaths
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Returns case number for the specific Race.
     * 
     * @return int cases
     */
    public int getCases() {
        return cases;
    }


    /**
     * Boolean to see if both races are the same.
     * 
     * @param obj
     *            Object passed to be compared if Equal.
     * @return If it is Equal T/F
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
            return (this.getName().equals(((Race)obj).getName()) && this
                .getCases() == ((Race)obj).getCases() && this
                    .getDeaths() == ((Race)obj).getDeaths());
            // ALL MUST BE == FOR True.
        }

    }

}
