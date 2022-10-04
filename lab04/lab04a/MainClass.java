package lab04a;

public class MainClass {

	public static void main(String[] args) {
		double temp;
		
		double[] myArray = {5, 6, 9, 12, 133, 44, 2, 1};
		temp = mySearch(myArray, 12);
		System.out.println(temp);
		
		double[] emptyArray = {};
		temp = mySearch(emptyArray, 1);
		System.out.println(temp);
		
		double[] doubleArray = {2.3, 5.4, 598.6, 555.5555, 77.777777777, 45, -308, 56};
		temp = mySearch(doubleArray, 77.777777777);
		System.out.println(temp);
		

	}
	
	public static double mySearch(double[] inputArray, double n) {
		for(int i=0;i<inputArray.length;i++){
			if(inputArray[i] == n){
				return i;
				}
			}
		return -1;
	}

}
