public class Main {
    public static void main(String[] args) {
        AppInterface appInterface = new AppInterface();
        int flag = 1;
        while (flag == 1) {
            flag = appInterface.actionHandler();
        }
    }
}
