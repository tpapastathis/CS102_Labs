package bu;

public class MergeSort {
	public static int ops = 0;
	public static void main(String[] args) {
		int[] random = {42, 987, 346, 999, 1, 42, 7, 8, 4632, 10};
		
		mergeSort(random);
		System.out.println("Total operations: "+ops);

	}
	public static void mergeSort(int[] inputArray) {
		int inputLength = inputArray.length;
		
		if(inputLength<2)
			return;
		
		int midpoint = inputLength / 2;
		int[] leftHalf = new int[midpoint];
		int[] rightHalf = new int[inputLength - midpoint];
		
		for(int i=0; i<midpoint; i++) {
			leftHalf[i] = inputArray[i];
			ops++;
		}
		for(int i=midpoint; i<inputLength; i++) {
			rightHalf[i-midpoint] = inputArray[i];
			ops++;
		}
		
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		merge(inputArray, leftHalf, rightHalf);
	}
	public static void merge(int[] inputArray, int[] left, int[] right) {
		int leftSize = left.length;
		int rightSize = right.length;
		
		int i = 0, j = 0, k = 0;
		
		while(i<leftSize && j<rightSize) {
			if(left[i]<=right[j]){
				inputArray[k]=left[i];
				i++;
				ops++;
			}
			else {
				inputArray[k] = right[j];
				j++;
				ops++;
			}
			k++;
		}
		while(i<leftSize) {
			inputArray[k]=left[i];
			i++;
			k++;
			ops++;
		}
		while(j<rightSize) {
			inputArray[k]=right[j];
			j++;
			k++;
			ops++;
		}
		
		
	}
}
