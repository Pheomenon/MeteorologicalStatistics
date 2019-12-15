package temperature;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @Author:Gao
 * @Date:2019-12-15 14:12
 */
public class ScatterMinT {
    public ScatterMinT(String inputPath, String outputPath) throws Exception {
        Job job = new Job();
        job.setJarByClass(MaxTemperature.class);
        job.setJobName("Min temperature");

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        job.setMapperClass(ScatterMinTMapper.class);
        job.setReducerClass(ScatterMinTReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        if(job.waitForCompletion(true)){ }
    }
}
