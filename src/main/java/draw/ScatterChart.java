package draw;

import org.junit.Test;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.ScatterPlot;

import java.io.IOException;

/**
 * @Author:Gao
 * @Date:2019-12-14 21:43
 */
public class ScatterChart {
    public void scatter() throws IOException {
        Table bush = Table.read().csv("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output\\result.csv");
        Plot.show(
                ScatterPlot.create("Temperature statistics",
                        bush, "Day", "Temperature"));
    }

}
