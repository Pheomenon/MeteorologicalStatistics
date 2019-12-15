package controller;

import converter.Converter;
import converter.LineFormatter;
import converter.ScatterFormatter;
import draw.LineChart;
import draw.ScatterChart;
import temperature.MaxTemperature;
import temperature.MinTemperature;
import temperature.ScatterMaxT;
import temperature.ScatterMinT;

import java.io.IOException;

/**
 * @Author:Gao
 * @Date:2019-12-15 11:09
 */
public class Scheduler {
    public Scheduler(){
        new Deleter();
    }

    public void getParameter(String dataType,String chartType) throws Exception {
//        "Max air temperature","Min air temperature",
//                "Max dew temperature","Min dew temperature",
//                "Max atmospheric pressure","Min atmospheric pressure",
//                "Comprehensive statistics"
//        {"line chart","Scatter plot"};
//        {"3D scatter plot"};
        if (dataType.equals("Max air temperature") && chartType.equals("Line chart")) {
            new MaxTemperature("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\input", "C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output");
        }
        if (dataType.equals("Min air temperature") && chartType.equals("Line chart")) {
            new MinTemperature("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\input", "C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output");
        }
        if (dataType.equals("Max air temperature") && chartType.equals("Scatter plot")) {
            new ScatterMaxT("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\input", "C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output");
        }
        if (dataType.equals("Min air temperature") && chartType.equals("Scatter plot")) {
            new ScatterMinT("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\input", "C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output");
        }
//        if(dataType.equals("Max dew temperature"))
//            new MaxDew("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\input","C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output");
        new Converter().txtToCsv();
        if (chartType.equals("Line chart")) {
            new LineFormatter().startFormat();
            drewLineChart();
        }
        else {
            new ScatterFormatter().startFormat();
            drewScatterPlot();
        }

    }
    public void drewLineChart() throws IOException {
          new LineChart().line();
        }
    public void drewScatterPlot() throws IOException {
        new ScatterChart().scatter();
    }
}
