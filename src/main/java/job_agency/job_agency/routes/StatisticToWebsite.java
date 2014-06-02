package job_agency.job_agency.routes;

import job_agency.job_agency.processors.PDFProcessor;
import org.apache.camel.builder.RouteBuilder;

public class StatisticToWebsite extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		
		from("file://outbound/statistics?noop=true&idempotentKey=${file:name}-${file:modified}")
        .routeId("textToPdf")
        .process(new PDFProcessor())
        .to("fop:application/pdf")
        .to("file://outbound/statistics/pdf");
	}

}
