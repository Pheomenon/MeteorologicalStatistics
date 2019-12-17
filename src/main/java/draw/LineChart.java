package draw;

import org.junit.Test;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.LinePlot;

import java.io.IOException;

/**
 * @Author:Gao
 * @Date:2019-12-14 17:38
 */
public class LineChart {
    @Test
    public void line() throws IOException {
        Table bush = Table.read().csv("C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output\\result.csv");
        Plot.show(
                LinePlot.create(
                        "Temperature statistics",
                        bush, "Day", "Temperature X10"));
    }
}
