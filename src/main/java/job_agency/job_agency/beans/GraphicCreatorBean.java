package job_agency.job_agency.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraphicCreatorBean {

	public void createPieChart(String str) throws IOException{
	
		//String str = exchange.getIn().getBody(String.class);
		double male=0;
		double female=0;
		for (String s : str.split("\n")){
			if (s.contains(" MALECOUNTER")){
				male = Double.parseDouble(s.split("=")[1]);
			}
			else if (s.contains(" FEMALECOUNTER")){
				female = Double.parseDouble(s.split("=")[1]);
			}
		}
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		 
		dataset.setValue("Male", male);
		dataset.setValue("Female", female);
		 
		/* Create a 3D Pie chart. */
		JFreeChart chart = ChartFactory.createPieChart3D("FemaleMaleComparison", dataset, true, true, false);
		 
		/* Save the chart on the hard drive. */
		ChartUtilities.saveChartAsJPEG(new File("outbound/statistics/graphics/FemaleMalePieChart.jpg"), chart, 500, 280);
		
	}
	
}
