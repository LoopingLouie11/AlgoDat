import java.util.Arrays;
import java.util.Random;

public class searchAlgo {
	
	static Random r = new Random();
	
	public static void main(String args[]) {
		int[] arr1 = generateArray(1000000);
		int[] arr2 = generateArray(1000000000);
		int[] arr3 = generateRandomArray(10000);
		int[] arr4 = generateRandomArray(100000);
		
		long startTime = System.currentTimeMillis();
		
		//linear search tests
		//System.out.println(linearSearch(arr1, 10)); 			//1ms
		//System.out.println(linearSearch(arr1, 1000000)); 		//5ms
		//System.out.println(linearSearch(arr2, 10)); 			//1ms
		//System.out.println(linearSearch(arr2, 1000000000)); 	//300ms
		
		//binary search tests
		//binarySearch(arr1, 0, arr1.length-1, 10); 			//1ms
		//binarySearch(arr1, 0, arr1.length-1, 1000000); 		//1ms
		//binarySearch(arr2, 0, arr2.length-1, 10); 			//1ms
		//binarySearch(arr2, 0, arr2.length-1, 1000000000); 	//1ms
		
		//insertion sort tests
		//int[] sortedArr = insertionSort(arr3); 				//37ms
		//int[] sortedArr = insertionSort(arr4);  				//3000
		//int[] sortedArr = mergeSort(arr3, 0, arr3.length-1);	//2ms
		//int[] sortedArr = mergeSort(arr4, 0, arr4.length-1);	//20ms
		
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		
		System.out.println("time to run: " + runTime + " ms");
	}
	
	public static int[] generateArray(int n) {
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i + 10;
		}
		return arr;
	}
	
	public static int[] generateRandomArray(int n) {
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = r.nextInt();
		}
		return arr;
	}
	
	public static int linearSearch(int[] arr, int key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	public static void binarySearch(int[] arr, int first, int last, int key) {
	   int mid = (first + last)/2;  
	   while( first <= last ){  
	      if ( arr[mid] < key ){  
	        first = mid + 1;     
	      }else if ( arr[mid] == key ){  
	        System.out.println("Element is found at index: " + mid);  
	        break;  
	      }else{  
	         last = mid - 1;  
	      }  
	      mid = (first + last)/2;  
	   }  
	   if ( first > last ){  
	      System.out.println("Element is not found!");  
	   }  
	 } 
	
	public static int[] insertionSort(int[] arr) {
		for(int j = 1; j < arr.length; j ++) {
			int key = arr[j];
			int i = j - 1;
			while(i > 0 && arr[i] > key) {
				arr[i + 1] = arr [i];
				i = i - 1;
			}
			arr[i + 1] = key;
		}
		return arr;
	}
	
	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] sorted = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				sorted[k] = one[i];
				k++;
				i++;
			} else {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}
		if (i == one.length) {
			while (j < two.length) {
				sorted[k] = two[j];
				k++;
				j++;
			}
		}
		if (j == two.length) {
			while (i < one.length) {
				sorted[k] = one[i];
				k++;
				i++;
			}
		}
		return sorted;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];

			return br;
		}
		int mid = (lo + hi) / 2;
		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);
		int[] merged = mergeTwoSortedArrays(fh, sh);
		return merged;
	}
}