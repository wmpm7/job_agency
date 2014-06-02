package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

public class GraphicCreator extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file://outbound/statistics?noop=true")
			.beanRef("GraphicCreatorBean", "createPieChart")
			.log("Graphics created");
	}

}
