package job_agency.job_agency.routes;

import javax.xml.bind.JAXBContext;

import job_agency.job_agency.beans.Joboffer;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.spi.DataFormat;

public class JobofferToQueueRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Joboffer.class); 
		JaxbDataFormat jaxb = new JaxbDataFormat(); 
		jaxb.setContext(jc); 
		DataFormat df = jaxb;
		
		
		
		from("file:inbound/joboffers?noop=true")
			.unmarshal(df)
			.to("jms:JobofferQueue")
			.log("JobofferQueue:new Joboffer added!");
		
	}

}
