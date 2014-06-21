package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

public class StatisticToTwitter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		
		from("file://outbound/statistics?noop=true")
		.routeId("StatisticToTwitter-Route")
		  .to("twitter://timeline/user?"
		  		+ "consumerKey={{TconsumerKey}}"
		  		+ "&consumerSecret={{TconsumerSecret}}"
		  		+ "&accessToken={{TaccessToken}}"
		  		+ "&accessTokenSecret={{TaccessTokenSecret}}");
	}

}
