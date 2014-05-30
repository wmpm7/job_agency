package job_agency.job_agency.models;

public class Statistics {
	private double maleCounter;
	private double femaleCounter;
	
	private double percentMale;
	private double percentFemale;
	
	
	
	public double getPercentMale() {
		return percentMale;
	}
	public void setPercentMale(double percentMale) {
		this.percentMale = percentMale;
	}
	public double getPercentFemale() {
		return percentFemale;
	}
	public void setPercentFemale(double percentFemale) {
		this.percentFemale = percentFemale;
	}
	public double getMaleCounter() {
		return maleCounter;
	}
	public void setMaleCounter(double maleCounter) {
		this.maleCounter = maleCounter;
	}
	public double getFemaleCounter() {
		return femaleCounter;
	}
	public void setFemaleCounter(double femaleCounter) {
		this.femaleCounter = femaleCounter;
	}
	
	public double getNumberOfPeople(){
		return maleCounter+femaleCounter;
	}
	@Override
	public String toString() {
		return "Statistics [maleCounter=" + maleCounter + ", femaleCounter="
				+ femaleCounter + ", percentMale=" + percentMale
				+ ", percentFemale=" + percentFemale + "]";
	}
	
}
