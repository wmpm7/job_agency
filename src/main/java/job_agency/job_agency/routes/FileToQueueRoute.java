package job_agency.job_agency.routes;

import javax.xml.bind.JAXBContext;

import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat; 
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;

public class FileToQueueRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Questionnaire.class); 
		JaxbDataFormat jaxb = new JaxbDataFormat(); 
		jaxb.setContext(jc); 
		DataFormat df = jaxb;
		
		from("file://inbound/questionnaires?noop=true")
		.routeId("FileToQueue-Route")
		.log("Content-based routing started for incoming XML and JSON files (folder: inbound/questionnaires)")
		.choice()
			.when().simple("${file:name.ext} == 'json'").
				//JSON TO POJO
				unmarshal().json(JsonLibrary.Jackson,Questionnaire.class)
				.to("jms:PojoInsertQueue")
				.to("file:target/test")
				.log("PojoInsertQueue:JSON file added!")
			.otherwise()
			 	.unmarshal(df)
			 	.to("jms:PojoInsertQueue")
			 	.to("file:target/test")
			 	.log("PojoInsertQueue:XML file added!");
	}

}
