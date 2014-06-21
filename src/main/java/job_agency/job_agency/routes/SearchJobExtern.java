package job_agency.job_agency.routes;

import job_agency.job_agency.processors.LinkProcessor;

import org.apache.camel.builder.RouteBuilder;

public class SearchJobExtern extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("jms:karriereQueue")   
		.process(new LinkProcessor())
		.recipientList(header("recipient"))
		.log("Karrere.at wurde abgefragt!")
		.to("file:target/fromApi/karriere")
		.delay(3000)
		.log("karriere offers loaded");
		
		from("file:target/fromApi/karriere")
        .split(body(String.class).tokenize("\\},\\{"))
            .to("file:target/fromApi/split?fileName=${header.CamelSplitIndex}");
		
		from("file:target/fromApi/split")
		.beanRef("JobExternBean","reformat")
		.to("file:target/fromApi/reformat")
		.to("jms:JobExternQueue");
		
	}
	
	//generierter Key muss bei allen Anfragen mitgegeben werden
	// Key = d1fe2f00164ddb3223728ac6f79cd7f5
	//Bsp: http://www.karriere.at/api/job/list?key=d1fe2f00164ddb3223728ac6f79cd7f5&keyword=PHP,MySql,Linux&location=Wien
	
}
