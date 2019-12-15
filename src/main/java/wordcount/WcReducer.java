package wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Author:Gao
 * @Date:2019-12-14 13:43
 */
//reducer输入的泛型即是mapper输出的泛型
public class WcReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable total = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        //做累加
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();//对应mapper中的set()
        }
        //包装结果输出
        total.set(sum);
        context.write(key,total);
    }
}
