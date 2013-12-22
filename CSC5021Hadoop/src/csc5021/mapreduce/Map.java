package csc5021.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import csc5021.utilities.Utils;

import java.io.IOException;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		System.out.println("Map starting :D " + value.toString());
		Utils.writeToFile("\nMap: \nValue: " + value.toString());

		if (ShareMemory.getListWords().size() > 0) {
			String line = value.toString();
			System.out.println("Input value: " + value.toString());
			for (int i = 0; i < ShareMemory.getListWords().size(); i++) {
				String word = ShareMemory.getListWords().get(i);
				if (line.contains(word) || Utils.revertLine(line).contains(word)) {
					ShareMemory.getListWords().remove(word);
					Utils.writeToFile("\nFOUND :)))!" + word + "\nNumber of remain word: " + ShareMemory.getListWords().size());
					i--;
				}
			}
			context.write(new Text(String.valueOf(key)), new IntWritable(1));
		}
		System.out.println("Map stop :D " + ShareMemory.getListWords().size());

	}

}
