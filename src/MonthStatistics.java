import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MonthStatistics {

    private ArrayList<ArrayList<Integer>> year;
    private int goal;

    MonthStatistics() {
        this.year = new ArrayList<ArrayList<Integer>>(12);
        for (int i = 0; i < 12; i++) {
            int days = getDaysInMonth(i + 1);
            ArrayList<Integer> zeroArray = new ArrayList<>(Collections.nCopies(days, 0));
            this.year.add(zeroArray);
        }
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public static int getDaysInMonth(int month) {
        return (int)(28 + (month + Math.floor(month / 8)) % 2 + 2 % month + 2 * Math.floor(1 / month));
    }

    public void setSteps(int steps, int month, int day) {
        int monthIndex = month - 1;
        ArrayList<Integer> monthArray = this.year.get(monthIndex);
        monthArray.set(day - 1, steps);
        this.year.set(monthIndex, monthArray);
    }

    private int countMonthSteps(int month) {
        ArrayList<Integer> monthArray = this.year.get(month - 1);
        int sum = 0;
        for (Integer steps : monthArray) {
            sum = sum + steps;
        }
        return sum;
    }

    private double calculateAverage(int month) {
        ArrayList<Integer> monthArray = this.year.get(month - 1);
        double sum = 0;
        double activeDays = 0;
        for (Integer steps : monthArray) {
            if (steps != 0) {
                activeDays = activeDays + 1;
            }
            sum = sum + steps;
        }
        return sum / activeDays;
    }

    private double calculateDistance(double steps) {
        return Converter.convertToKilometers(steps);
    }

    private double calculateBurntCalories(double kilometers) {
        return Converter.convertToCalories(kilometers);
    }

    private double getGoalCompletedDays(int month) {
        ArrayList<Integer> monthArray = this.year.get(month - 1);
        double goalCompleted = 0;
        for (Integer steps : monthArray) {
            if (steps >= this.goal) {
                goalCompleted = goalCompleted + 1;
            }
        }
        return goalCompleted;
    }

    public HashMap<String, Double> calculateStatistics(int month) {
        double goalCompleted = getGoalCompletedDays(month);

        double monthSteps = countMonthSteps(month);
        double monthDistance = calculateDistance(monthSteps);
        double monthCalories = calculateBurntCalories(monthDistance);

        double averageMonthSteps = calculateAverage(month);
        double averageMonthDistance = calculateDistance(averageMonthSteps);
        double averageMonthCalories = calculateBurntCalories(averageMonthDistance);

        HashMap<String, Double> map = new HashMap<>();

        map.put("Дней когда цель была достигнута:", goalCompleted);
        map.put("Шагов за месяц:", monthSteps);
        map.put("Пройдено километров за месяц:", monthDistance);
        map.put("Сожжено ККАЛ за месяц:", monthCalories);
        map.put("Среднее количество шагов за месяц:", averageMonthSteps);
        map.put("Пройдено в среднем километров за месяц:", averageMonthDistance);
        map.put("Сожжено в среднем ККАЛ за месяц:", averageMonthCalories);

        return map;
    }
}
