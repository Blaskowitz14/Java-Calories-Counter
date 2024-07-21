public class Validator {
    public static boolean validateSteps(int steps) {
        return steps >= 0;
    }
    public static boolean validateGoal(int goal) {
        return goal >= 0;
    }
    public static boolean validateMonth(int month) {
        return month > 0 && month <= 12;
    }
    public static boolean validateDay(int month, int day) {
        final int MAX_DAYS = MonthStatistics.getDaysInMonth(month);
        return day > 0 && day <= MAX_DAYS;
    }
    public static boolean validateMenuChoice(int select) {
        return select >= 0 && select <= 3;
    }

}
