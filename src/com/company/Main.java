package com.company;

public class Main {


    private static final int SALARY = 10 * 1000;
    private static final double MONTHLY_PREMIERE_FEE = 0.04;
    private static final double YEARLY_PREMIERE_FEE = 0.0125;
    private static final int STARTING_AGE = 36;
    private static final int RETIREMENT_AGE = 67;
    private static final int SAVING_INITIAL_SUM = 29 * 1000;

    public static void main(String[] args) {
        int savingOnRetirement = (int) calcSavingOnRetirement();

        System.out.println("Your saving on retirement will be: " + savingOnRetirement);
    }

    public static double calcSavingOnRetirement() {
        double monthlyPremiere = SALARY * 0.18333;
        double yearlyPremiere = monthlyPremiere * 12;
        System.out.println("Yearly Premiere: " + Math.round(yearlyPremiere + 0.5));
        int savings = SAVING_INITIAL_SUM;
        int totalFee = 0;

        for (int age = STARTING_AGE; age < RETIREMENT_AGE; age++) {
            savings += yearlyPremiere;

            double yearlyManagementFee = calcYearlyManagementFee(savings);
            double monthlyManagementFee = calcMonthlyManagementFee(monthlyPremiere);

            double totalFeeThisYear = yearlyManagementFee + 12 * monthlyManagementFee;
            System.out.println(String.format("On age %d Total fee this year: %.0f (yearly: %.0f, monthly: %.0f) total savings: %d)", age, totalFeeThisYear, yearlyManagementFee, monthlyManagementFee, savings));
            totalFee += totalFeeThisYear;

            savings -= totalFeeThisYear;
        }

        System.out.println("Total fees paid: " + totalFee);

        return savings;
    }

    private static double calcYearlyManagementFee(double totalSavingInASpecificTime) {
        return totalSavingInASpecificTime * YEARLY_PREMIERE_FEE;
    }

    private static double calcMonthlyManagementFee(double monthlyPremiere) {
        return monthlyPremiere * MONTHLY_PREMIERE_FEE;
    }
}
