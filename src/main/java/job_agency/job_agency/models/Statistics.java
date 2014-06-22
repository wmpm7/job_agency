package job_agency.job_agency.models;

public class Statistics {
	private int maleCounter;
	private int femaleCounter;

	private double percentMale;
	private double percentFemale;

	private double meanAge;



	/**
	 * @return the meanAge
	 */
	public double getMeanAge() {
		return meanAge;
	}
	/**
	 * @param meanAge the meanAge to set
	 */
	public void setMeanAge(double meanAge) {
		this.meanAge = meanAge;
	}


	/**
	 * @return the maleCounter
	 */
	public double getMaleCounter() {
		return maleCounter;
	}
	/**
	 * @param maleCounter the maleCounter to set
	 */
	public void setMaleCounter(int maleCounter) {
		this.maleCounter = maleCounter;
	}
	/**
	 * @return the femaleCounter
	 */
	public double getFemaleCounter() {
		return femaleCounter;
	}
	/**
	 * @param femaleCounter the femaleCounter to set
	 */
	public void setFemaleCounter(int femaleCounter) {
		this.femaleCounter = femaleCounter;
	}
	/**
	 * @return the percentMale
	 */
	public double getPercentMale() {
		return percentMale;
	}
	/**
	 * @param percentMale the percentMale to set
	 */
	public void setPercentMale(double percentMale) {
		this.percentMale = percentMale;
	}
	/**
	 * @return the percentFemale
	 */
	public double getPercentFemale() {
		return percentFemale;
	}
	/**
	 * @param percentFemale the percentFemale to set
	 */
	public void setPercentFemale(double percentFemale) {
		this.percentFemale = percentFemale;
	}

	/**
	 * @return the number of people
	 */
	public double getNumberOfPeople(){
		return maleCounter+femaleCounter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Participant statistics of the WMPM job agency\n"
				+ "\n\t" + maleCounter +" participant(s) is(are) male." 
				+ "\n\t" + femaleCounter +" participant(s) is(are) female."
				+ "\n\t" + Math.round(percentMale*100) + "% of the participants are male."
				+ "\n\t" + Math.round(percentFemale*100)  + "% of the participants are female."
				+ "\n\tThe average age of the participants is " + Math.round(meanAge) + ".\n\n";
	}

}
