package temperature;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author:Gao
 * @Date:2019-12-15 14:12
 */
public class ScatterMinTReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable total = new IntWritable();
    private Text var = new Text();
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();//对应mapper中的set()
        }
        total.set(sum);
        context.write(key,total);
    }
}