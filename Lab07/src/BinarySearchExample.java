class BinarySearchExample{
 public static void binarySearch(int arr[], int first, int last, int key){ 
   int mid = (first + last)/2; //midpoint is 0 + last index/2
   while( first <= last ){ //while 0 is less than or equal to the last index
      if ( arr[mid] < key ){ //if the value at the midpoint of the array is less than the key value
        first = mid + 1;   //first = the midpoint + 1 which pulls the search to the right bound
      }else if ( arr[mid] == key ){ 
        System.out.println("Element is found at index: " + mid); //if the value is found break loop and print where it is located
        break;
      }else{ //if the right side of the array doesn't catch the value, this will push the search back towards the left side of the array
         last = mid - 1;
      }
      mid = (first + last)/2; //finally the mid point will be changed if the loop remains
   }
   if ( first > last ){ //if the value is not caught/found element is not found will be printed to the console
      System.out.println("Element is not found!");
   }
 }
 public static void main(String args[]){
		int arr[] = {10,20,30,40,50};
		int key = 30;
        int last=arr.length-1;
		binarySearch(arr,0,last,key);	//arr is passed along with 0 as the first index, last as the last index, and key as the value we are searching for
 }
}