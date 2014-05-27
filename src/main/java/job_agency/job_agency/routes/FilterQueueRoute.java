package job_agency.job_agency.routes;

import job_agency.job_agency.beans.Person;
import job_agency.job_agency.beans.Questionnaire;

import org.apache.camel.builder.RouteBuilder;

public class FilterQueueRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jms:PojoInsertQueue")
		//.filter().method(Questionnaire.class, "isAut")
		//.filter().simple("$(body.address.country = 'AUT'")
		.to("jms:FilteredInsertQueue")
		.log("awefawef");
		
	}

}
