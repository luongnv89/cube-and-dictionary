package csc5021.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException,
			InterruptedException {
		// if(values.equals(null)){
		// Utils.writeToFile("\nkey: " + String.valueOf(key) +
		// "\nResult: Not found!"+"\n", "Log.txt");
		// }
		// else{
		// Utils.writeToFile("Reduce: \nkey: " + String.valueOf(key) +
		// "\nContext: " + context.toString()
		// + "\n", "Log.txt");
		// if(values.)
		// if(ShareMemory.isFoundAll()){
		int sum = 0;
		for (IntWritable val : values) {
			// Utils.writeToFile("Value: " + String.valueOf(val) + " ; ");
			sum += val.get();
		}
		System.out.println("Reduce do no thing...");
		context.write(key, new IntWritable(sum));
		// }

		// Utils.writeToFile("\nkey: " + String.valueOf(key) + "\nResult: " +
		// (sum>0?"Found!":"Not found!")+"\n", "Log.txt");
	}
}
