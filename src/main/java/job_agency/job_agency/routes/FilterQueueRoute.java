package job_agency.job_agency.routes;

import job_agency.job_agency.processors.CountryFilter;

import org.apache.camel.builder.RouteBuilder;

public class FilterQueueRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		CountryFilter cf = new CountryFilter();
		
		from("jms:PojoInsertQueue")
			.filter().method(cf)
		.to("jms:FilteredInsertQueue")
			.log("Person filtered and added to FilteredInsertQueue!");
		
	}

}
