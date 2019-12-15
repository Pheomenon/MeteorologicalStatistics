package temperature;

import draw.ScatterChart;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.junit.Test;

/**
 * @Author:Gao
 * @Date:2019-12-15 14:04
 */
public class ScatterMaxT {
    public ScatterMaxT(String inputPath, String outputPath) throws Exception {
        Job job = new Job();
        job.setJarByClass(MaxTemperature.class);
        job.setJobName("Max temperature");

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        job.setMapperClass(ScatterMaxTMapper.class);
        job.setReducerClass(ScatterMaxTReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        if(job.waitForCompletion(true)){ }
    }
}
