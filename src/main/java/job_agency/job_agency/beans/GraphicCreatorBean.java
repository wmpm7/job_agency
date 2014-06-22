package job_agency.job_agency.beans;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraphicCreatorBean {

	private static int count = 0;

	//	public void createPieChart(String str) throws IOException{
	public File createPieChart(String str) throws IOException{

		count++;
		double male=0;
		double female=0;
		String[] lines;
		lines = str.split("\n");
		
		male = Double.parseDouble(lines[2].split(" part")[0]);
		female = Double.parseDouble(lines[3].split(" part")[0]);
		/*for (String s : str.split("\n")){
			if (s.contains(" MALECOUNTER")){
				male = Double.parseDouble(s.split("=")[1]);
			}
			else if (s.contains(" FEMALECOUNTER")){
				female = Double.parseDouble(s.split("=")[1]);
			}
		}*/

		DefaultPieDataset dataset = new DefaultPieDataset();

		dataset.setValue("Male", male);
		dataset.setValue("Female", female);

		/* Create a 3D Pie chart. */
		JFreeChart chart = ChartFactory.createPieChart3D("FemaleMaleComparison", dataset, true, true, false);

		/* Save the chart on the hard drive. */
		File file = new File("outbound/statistics/graphics/FemaleMalePieChart" + count + ".jpg");
		ChartUtilities.saveChartAsJPEG(file, chart, 500, 280);

		return file;
	}

}
