public class Converter {
    public static double convertToKilometers(double steps) {
        return steps * 0.75 / 1000;
    }
    public static double convertToCalories(double kilometers) {
        return 1.15 * kilometers * 65;
    }
}
