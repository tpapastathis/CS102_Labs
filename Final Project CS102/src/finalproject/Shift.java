package finalproject;

public class Shift {
	public String name, startTime, endTime;
	public Shift(String nameInput, String startTimeInput, String endTimeInput) {
		this.name = nameInput;
		this.startTime = startTimeInput;
		this.endTime = endTimeInput;
		
	}
	@Override
	public String toString() {
		return this.name + " " + this.startTime + " " + this.endTime;
	}
//	public void displayShift(String shiftString) {
//		System.out.println(shiftString);
//	}
	public static void main(String[] args) {
		Shift test = new Shift("Ted", "12:34", "12:35");
	}

}
