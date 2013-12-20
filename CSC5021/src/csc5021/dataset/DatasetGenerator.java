/**
 * 
 */
package csc5021.dataset;

import csc5021.objects.Cube;
import csc5021.objects.Dictionary;
import csc5021.program.AssociatedAbstract;

/**
 * Generate the dataset for test
 * @author luongnv89
 *
 */
public class DatasetGenerator {
	//List possible size of cube
	static int[] sizeOfCube = {1000};
	//List possible size of dic
	static int[] sizeOfDic = {3,10,20,50,100,200,800,1000};
	//List possible length of word
	static int[] lengOfDic = {2,4,10,20,50,80,100};
	
	//Path to save generated cube
	public static String CUBE_PATH = "data/cube";
	//Path to save generated dictionary which is associated with cube
	public static String DIC_ASSOCIATED_PATH = "data/dic_associated";
	//Path to save generated dictionary which is not associated with cube
	public static String DIC_NO_ASSOCIATED_PATH = "data/dic_noassociated";

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Generate dataset for test perfomance:\n");
		for(int cube_size=0;cube_size<sizeOfCube.length;cube_size++){
			Cube c = new Cube(sizeOfCube[cube_size]);
			c.saveToFile(CUBE_PATH+"/cube_"+sizeOfCube[cube_size]);
			System.out.println("Create new Dictionary: " + "cube_"+sizeOfCube[cube_size]);
			for(int dic_size = 0;dic_size<sizeOfDic.length;dic_size++){
				for(int word_length = 0;word_length<lengOfDic.length;word_length++){
					if(lengOfDic[word_length]<=sizeOfCube[cube_size]){
						Dictionary associated = AssociatedAbstract.generateAssociatedDictionary(lengOfDic[word_length], sizeOfDic[dic_size], c);
						associated.saveToFile(DIC_ASSOCIATED_PATH+"/dic_associated_"+lengOfDic[word_length]+"_"+sizeOfDic[dic_size]+"_"+sizeOfCube[cube_size]);
						System.out.println("Create new Dictionary: " + "dic_associated_"+lengOfDic[word_length]+"_"+sizeOfDic[dic_size]+"_"+sizeOfCube[cube_size]);
						Dictionary noassociated = new Dictionary(lengOfDic[word_length],sizeOfDic[dic_size]);
						noassociated.saveToFile(DIC_NO_ASSOCIATED_PATH+"/dic_noassociated_"+lengOfDic[word_length]+"_"+sizeOfDic[dic_size]);
						System.out.println("Create new Dictionary: " + "dic_noassociated_"+lengOfDic[word_length]+"_"+sizeOfDic[dic_size]+"_"+sizeOfCube[cube_size]);
					}
				}
			}
		}
		System.out.println("FINISHED!");
	}

}