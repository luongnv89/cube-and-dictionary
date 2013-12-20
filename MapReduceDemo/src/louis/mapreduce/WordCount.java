/**
 * 
 */
package louis.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * @author luongnv89
 *
 */
/**
 * @author luongnv89
 *
 */
/**
 * @author luongnv89
 *
 */
/**
 * @author luongnv89
 * 
 */

public class WordCount {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = new Job(conf, "wordcount");
//		Utils.writeToFile("\nWordCount: \nJob: " + job.toString() + "\nConfig: " + conf.toString() + "\nInput: "
//				+ args[0] + "\nOutput: " + args[1], "Log.txt");
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.waitForCompletion(true);
		Utils.writeToFile("\nConfig: " + conf.toString() + "\nInput: "
				+ args[0] + "\nOutput: " + args[1], "Log.txt");
	}

}