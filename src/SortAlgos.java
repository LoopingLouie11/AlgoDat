
public class SortAlgos {
	
	//diablo stinkt
	public static int[] insertionSort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;
			while (i > 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
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
