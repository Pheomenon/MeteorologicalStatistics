package controller;

import converter.Converter;
import converter.Formatter;
import draw.LineChart;
import draw.ScatterChart;
import temperature.MaxTemperature;

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
        if(dataType.equals("Max air temperature")){
            new MaxTemperature("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\input","C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output");
        }
        drewChart(chartType);
    }
    public void drewChart(String chartType) throws IOException {
        if(chartType.equals("line chart")){
            LineChart lineChart = new LineChart();
            lineChart.line();
        }
        else{
            new ScatterChart().scatter();
        }
    }
}
