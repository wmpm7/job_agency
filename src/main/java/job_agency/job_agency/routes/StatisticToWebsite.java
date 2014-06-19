package job_agency.job_agency.routes;

import java.io.File;
import java.io.OutputStream;

import job_agency.job_agency.processors.JPGToPDF;
import job_agency.job_agency.processors.JpgAggregation;
import job_agency.job_agency.processors.PDFProcessor;

import org.apache.camel.builder.RouteBuilder;

public class StatisticToWebsite extends RouteBuilder {

	@Override
	public void configure() throws Exception {


		from("file://outbound/statistics?noop=true&idempotentKey=${file:name}-${file:modified}")
		.routeId("TextToPdf-Route")
		.delay(1000)
		.process(new JPGToPDF())
		//        .pollEnrich("file://outbound/statistics/graphics?noop=true&idempotentKey=${file:name}-${file:modified}", 
		//        		new JpgAggregation())
		//        .aggregate(constant(true), new JpgAggregation())
		//        .completionSize(2)
		//        .process(new PDFProcessor())
//		.pollEnrich("file://outbound/statistics/graphics?noop=true&idempotentKey=${file:name}-${file:modified}")
		.convertBodyTo(String.class, "utf-8")
		.process(new PDFProcessor())
		.to("fop:application/pdf")
		.to("file://outbound/statistics/pdf")
		.log("PDF file created and stored in outbound/statistics/pdf");
	}

}
