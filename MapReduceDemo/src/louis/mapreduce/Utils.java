/**
 * 
 */
package louis.mapreduce;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author luongnv89
 * 
 */
public class Utils {
	public static void writeToFile(String msg, String path) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
			out.write(msg);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
