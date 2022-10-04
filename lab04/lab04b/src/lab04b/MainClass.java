package lab04b;

public class MainClass {

	public static void main(String[] args) {
		int[] myArray1 = {4, 7, 2, 3, 1};
		
		mySort(myArray1);
		

	}
	public static void mySort(int[] inputArray) {
		int arraySize = inputArray.length;
		for (int i = 0; i < arraySize - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arraySize; j++) {
				if (inputArray[j] < inputArray[index]){
					index = j;
					}
				}
			int temp = inputArray[i];
			inputArray[i] = inputArray[index];
			inputArray[index] = temp;
		}
		
		for(int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]+" ");
		}
	}

}
