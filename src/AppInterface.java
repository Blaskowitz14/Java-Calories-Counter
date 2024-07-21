import java.util.Scanner;

public class AppInterface {
    private DataActions dataActions;
    private Scanner scanner;
    private OutputFormat outputFormat;

    AppInterface() {
        this.dataActions = new DataActions();
        this.scanner = new Scanner(System.in);
    }

    AppInterface(DataActions dataActions, Scanner scanner) {
        this.dataActions = dataActions;
        this.scanner = scanner;
    }



    private static void printMenu() {
        System.out.println("Добро пожаловать!");
        System.out.println("1. Ввод количества шагов");
        System.out.println("2. Вывод статистики");
        System.out.println("3. Изменить цель");
        System.out.println("0. Выйти из приложения");
    }

    public int actionHandler() {
        printMenu();
        int selected = scanner.nextInt();
        if (!Validator.validateMenuChoice(selected)) {
            System.out.println("Такого пункта нет");
            return 1;
        }
        if (selected == 1) {
            System.out.println("Введите месяц:");

            int month = scanner.nextInt();
            if (!Validator.validateMonth(month)) {
                System.out.println("Месяц выходит за допустимый диапазон");
                return 1;
            }

            System.out.println("Введите день:");
            int day = scanner.nextInt();
            if (!Validator.validateDay(month, day)) {
                System.out.println("День выходит за допустимый диапазон");
                return 1;
            }

            System.out.println("Введите количество шагов:");
            dataActions.handleStepsEnter(month, day);
        }
        else if (selected == 2) {
            System.out.println("Введите месяц:");
            int month = scanner.nextInt();
            if (!Validator.validateMonth(month)) {
                System.out.println("Месяц выходит за допустимый диапазон");
                return 1;
            }
            this.outputFormat = new OutputFormat(dataActions.getData(month));
            outputFormat.printStatistics();
            return 1;
        }
        else if (selected == 3) {
            System.out.println("Введите цель:");
            dataActions.handleGoalSet();
        }
        else if (selected == 0) {
            return 0;
        }
        return 1;
    }
}