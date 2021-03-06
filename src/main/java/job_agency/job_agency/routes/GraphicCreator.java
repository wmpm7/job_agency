package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

public class GraphicCreator extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("jms:graphicQueue")
		.routeId("GraphicCreator-Route")
		.beanRef("GraphicCreatorBean", "createPieChart")
		.log("PieChart created: Comparision between female and male people! Output folder: outbound/statistics/graphics")
		.to("jms:pieChart");
	}

}
