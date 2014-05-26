package job_agency.job_agency.routes;

import javax.xml.bind.JAXBContext;

import job_agency.job_agency.beans.Questionnaire;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat; 
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;

public class FileToDatabaseRouter extends RouteBuilder{

	@Override
	
	public void configure() throws Exception {
		//Person p;
		JAXBContext jc = JAXBContext.newInstance(Questionnaire.class); 
		JaxbDataFormat jaxb = new JaxbDataFormat(); 
		jaxb.setContext(jc); 
		DataFormat df = jaxb;
		
		
		
		from("file:src/data?noop=true")
		.log("start content-based rounting for incoming XML and JSON files")
		.choice()
			.when().simple("${file:name.ext} == 'json'").
		//from("file:src/data/json?noop=true").
				
				//JSON TO POJO
				unmarshal().json(JsonLibrary.Jackson,Questionnaire.class)
				.to("jms:PojoInsertQueue").log("PojoInsertQueue:JSON file added!")
			//to("file:src/data/json")
			.otherwise()
			 	.unmarshal(df)
			 	.to("jms:PojoInsertQueue").log("PojoInsertQueue:XML file added!");
			//.to("file:src/data/xml");
			//HIER KOMMT XML TO POJO + IN DB SCHREIBEN
		
	}

}
