import java.util.HashMap;
import java.util.Scanner;

public class DataActions {

    private int goal;
    private Scanner scanner;
    private MonthStatistics monthStatistics;

    DataActions() {
        this.scanner = new Scanner(System.in);
        this.monthStatistics = new MonthStatistics();
    }
    DataActions(Scanner scanner, MonthStatistics monthStatistics) {
        this.scanner = scanner;
        this.monthStatistics = monthStatistics;
    }

    public void handleGoalSet() {
        int goal = scanner.nextInt();
        if (!Validator.validateGoal(goal)) {
            System.out.println("Цель не может отрицательной");
            return;
        }
        monthStatistics.setGoal(goal);
        System.out.println("Данные внесены");
    }

    public void handleStepsEnter(int month, int day) {
        int steps = scanner.nextInt();
        if (!Validator.validateSteps(steps)) {
            System.out.println("Количестов шагов не может быть отрицательным");
            return;
        }
        monthStatistics.setSteps(steps, month, day);
        System.out.println("Данные внесены");
    }

    public HashMap<String, Double> getData(int month) {
        return monthStatistics.calculateStatistics(month);
    }
}
