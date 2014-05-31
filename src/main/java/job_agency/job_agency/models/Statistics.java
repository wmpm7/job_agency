package job_agency.job_agency.models;

public class Statistics {
	private double maleCounter;
	private double femaleCounter;

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
	public void setMaleCounter(double maleCounter) {
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
	public void setFemaleCounter(double femaleCounter) {
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
		return "Statistics [maleCounter=" + maleCounter + ", femaleCounter="
				+ femaleCounter + ", percentMale=" + percentMale
				+ ", percentFemale=" + percentFemale + ", meanAge=" + meanAge
				+ "]";
	}

}
