import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class OutputFormat {
    private final String FORMAT = "#0.00";
    HashMap<String, Double> monthData;

    OutputFormat(HashMap<String, Double> monthData) {
        this.monthData = monthData;
    }

    public void resetMonthData(HashMap<String, Double> monthData) {
        this.monthData = monthData;
    }

    public void printStatistics() {
        for (Map.Entry enter : monthData.entrySet()) {
            String formatted = new DecimalFormat(FORMAT).format(enter.getValue());
            String data = enter.getKey().toString() + " " + formatted;
            System.out.println(data);
        }
    }
}
