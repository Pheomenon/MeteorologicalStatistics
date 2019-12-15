import tech.tablesaw.api.*;
import tech.tablesaw.columns.numbers.NumberColumnFormatter;

/**
 * @Author:Gao
 * @Date:2019-12-14 16:11
 */
public class Test {
    @org.junit.Test
    public void test(){
        String[] students = {"小明", "李雷", "小二"};
        double[] scores = {90.1, 84.3, 99.7};
        Table table = Table.create("学生分数统计表").addColumns(
                StringColumn.create("姓名", students),
                DoubleColumn.create("分数", scores));
        System.out.println(table.print());
    }
    @org.junit.Test
    public void tableSawTest10() throws Exception{
        Table table = Table.read().csv("/data/bush.csv");
        Table whoPercents = table.xTabPercents("who");
        whoPercents.columnsOfType(ColumnType.DOUBLE)
                .forEach(x -> ((NumberColumn) x).setPrintFormatter(
                        NumberColumnFormatter.percent(0)));
        System.out.println(whoPercents.toString());
    }

}
