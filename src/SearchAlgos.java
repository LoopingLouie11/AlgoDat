
public class SearchAlgos {

	//penis
	public static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] sortedArray, int low, int high, int key) {
			    int index = Integer.MAX_VALUE;
			    
			    while (low <= high) {
			        int mid = low  + ((high - low) / 2);
			        if (sortedArray[mid] < key) {
			            low = mid + 1;
			        } else if (sortedArray[mid] > key) {
			            high = mid - 1;
			        } else if (sortedArray[mid] == key) {
			            index = mid;
			            break;
			        }
			    }
			    
			    if(index == Integer.MAX_VALUE) {
			    	return -1;
			    }
			    return index;
			}
}

