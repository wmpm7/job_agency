package job_agency.job_agency.processors;

import java.io.FileOutputStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFileMessage;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class JPGToPDF implements Processor{


	@Override
	public void process(Exchange exchange) {

		Object body = exchange.getIn();
		if (body instanceof GenericFileMessage) 
		{
			String content = ((GenericFileMessage)body).getBody(String.class);
			int startPosXml = new String(content).indexOf("S");
			if (startPosXml >= 0) 
			{
				exchange.getIn().setBody(new String(content).substring(startPosXml));
			}
		}

		Document document = new Document();
		String input = "outbound/statistics/graphics/FemaleMalePieChart.jpg"; // .gif and .jpg are ok too!
		String output = "outbound/statistics/graphics/statistic2.pdf";
		try {
			FileOutputStream fos = new FileOutputStream(output);
			PdfWriter writer = PdfWriter.getInstance(document, fos);
			writer.open();
			document.open();
			document.add(new Paragraph(exchange.getIn().getBody(String.class)));
			document.add(Image.getInstance(input));
			document.close();
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
