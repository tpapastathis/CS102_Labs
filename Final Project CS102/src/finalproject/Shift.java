package finalproject;

import java.io.Serializable;

public class Shift implements Serializable{
	public String name, startTime, endTime;
	public static int id = 0;
	private int currentId;
	public Shift (String nameInput, String startTimeInput, String endTimeInput) {
		this.name = nameInput;
		this.startTime = startTimeInput;
		this.endTime = endTimeInput;
		this.currentId = id;
		id++;
	}
	@Override
	public String toString() {
		return this.currentId + " " + this.name + " " + this.startTime + " " + this.endTime;
	}
}
