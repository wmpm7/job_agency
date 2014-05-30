package job_agency.job_agency.models;

public class Statistics {
	private int maleCounter;
	private int femaleCounter;
	
	public int getMaleCounter() {
		return maleCounter;
	}
	public void setMaleCounter(int maleCounter) {
		this.maleCounter = maleCounter;
	}
	public int getFemaleCounter() {
		return femaleCounter;
	}
	public void setFemaleCounter(int femaleCounter) {
		this.femaleCounter = femaleCounter;
	}
	
	public int getNumberOfPeople(){
		return maleCounter+femaleCounter;
	}
	
}
