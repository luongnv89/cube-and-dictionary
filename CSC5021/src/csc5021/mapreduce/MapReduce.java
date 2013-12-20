/**
 *
 */
package csc5021.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Progressable;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;

/**
 * @author luongnv89
 */


public class MapReduce {
    static String hdfsURL = "hdfs://localhost:54310";

    public static void main(String[] args) throws Exception {


        long startTime = System.currentTimeMillis();
        Configuration conf = new Configuration();
        ShareMemory.setRESULT_PATH("Log_"+String.valueOf(startTime));
        Utils.writeToFile("Setup Share memory...");
        ShareMemory.setup(hdfsURL, args[0], args[1], conf);
        Utils.writeToFile("\nFinished setup Share memory"+"\nhdfsURL: "+hdfsURL+"\nDictionary path: "+args[0]+"\nCube path: " + args[1]);
        //Test write file
        FileSystem hdfs = FileSystem.get( new URI( "hdfs://localhost:54310" ), conf );
        Path file = new Path(ShareMemory.getDataHDFS()+"/empty.txt");
        if ( hdfs.exists( file )) { hdfs.delete( file, true ); }
        OutputStream os = hdfs.create( file,
                new Progressable() {
                    public void progress() {
                        System.out.println("Created data path");
                    } });
        hdfs.close();


        Job job = new Job(conf, "wordcount");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapperClass(Map.class);
//        job.setReducerClass(Reduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path("hdfs://localhost:54310/data_"+ShareMemory.getDataName()));
        FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:54310/data_"+ShareMemory.getDataName() + "/output"));

        job.waitForCompletion(true);
        long totalTime = System.currentTimeMillis() - startTime;

        if (ShareMemory.isAssocciated()) {
            System.out.println("ASSOCIATED!");
            Utils.writeToFile("\nTotal executed time: " + String.valueOf(totalTime) + "\nASSOCIATED!");
        } else {
            System.out.println("NO ASSOCIATED!");
            Utils.writeToFile("\nTotal executed time: " + String.valueOf(totalTime) + "\nNO ASSOCIATED!" + "\nThe list of words which could not found: \n");
            for (int i = 0; i < ShareMemory.getListWords().size(); i++) {
                Utils.writeToFile(ShareMemory.getListWords().get(i) + " ; ");
            }
        }
    }

}