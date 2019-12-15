package temperature;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @Author:Gao
 * @Date:2019-12-15 13:01
 */
public class MinTemperature {
    public MinTemperature(String inputPath, String outputPath) throws Exception {
        Job job = new Job();
        job.setJarByClass(MinTemperature.class);
        job.setJobName("Min temperature");

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        job.setMapperClass(MinTemperatureMapper.class);
        job.setReducerClass(MinTemperatureReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        if(job.waitForCompletion(true)){
        }
    }
}
