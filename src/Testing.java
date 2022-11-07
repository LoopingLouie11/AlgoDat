import java.util.Arrays;
import java.util.Random;

public class Testing {

	static Random r = new Random();

	// creating 3 arrays with different degree of sorting:
	static int[] almostSorted = createArray(100_000, 25);
	static int[] semiRandom = createArray(100_000, 4);
	static int[] fullRandom = createArray(100_000, 1);
	static int[][] unsortedArrays = { almostSorted, semiRandom, fullRandom };
	static int[][] sortedArrays = new int[3][];
	static String[] arrayNames = {"almostSorted", "semiRandom", "fullRandom"};

	public static void main(String[] args) {
		
		//needs to be added: comparison percentage wise in console; quick-sort; randomized-quick-sort
		//pls help :)
		insertionTesting();
		mergeTesting();
		
		linearTesting(7000);
		binaryTesting(7000);

	}

	public static void insertionTesting() {
		System.out.println("Insertion Testing");
		for (int i = 0; i < unsortedArrays.length; i++) {
			long startTime = System.nanoTime();
			sortedArrays[i] = SortAlgos.insertionSort(unsortedArrays[i]);
			long result = System.nanoTime() - startTime;
			System.out.println(arrayNames[i] + ":  " + result + " ns");
		}
		System.out.println();
	}
	
	public static void mergeTesting() {
		System.out.println("Merge Testing");
		for (int i = 0; i < unsortedArrays.length; i++) {
			long startTime = System.nanoTime();
			sortedArrays[i] =  SortAlgos.mergeSort(unsortedArrays[i], 0, unsortedArrays[i].length - 1);
			long result = System.nanoTime() - startTime;
			System.out.println(arrayNames[i] + ":  " + result + " ns");
		}
		System.out.println();
	}
	
	public static void binaryTesting(int value) {
		System.out.println("Binary Testing -- searching for number " + value);
		for (int i = 0; i < sortedArrays.length; i++) {
			long startTime = System.nanoTime();
			int position = SearchAlgos.binarySearch(sortedArrays[i], 0, sortedArrays[i].length, value);
			long result = System.nanoTime() - startTime;
			System.out.println(arrayNames[i] + ":  " + result + " ns -- position: " + position);
		}
		System.out.println();

	}
	
	// bug: first array needs suspiciously long
	public static void linearTesting(int value) {
		System.out.println("Linear Testing -- searching for number " + value);
		for (int i = 0; i < sortedArrays.length; i++) {
			long startTime = System.nanoTime();
			int position = SearchAlgos.linearSearch(sortedArrays[i], value);
			long result = System.nanoTime() - startTime;
			System.out.println(arrayNames[i] + ":  " + result + " ns -- position: " + position);
		}
		System.out.println();
	}

	// creates arrays with different degree of sorting
	// if arrayParts == length --> completely sorted
	// if arrayParts == 1 --> completely random
	static int[] createArray(int length, int arrayParts) {

		int[] array = new int[length];
		int partSize = length / arrayParts;

		for (int i = 0; i < arrayParts; i++) {
			for (int j = i * partSize; j < (i + 1) * partSize; j++) {
				array[j] = r.nextInt(i * partSize, (i + 1) * partSize);
			}
		}
		return array;
	}
}
