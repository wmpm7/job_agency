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
		
		
//		from("direct:foo")
//		  .to("twitter://timeline/user?consumerKey=[s]&consumerSecret=[s]&accessToken=[s]&accessTokenSecret=[s]);
		
//		from("twitter://timeline/home?type=polling&delay=50&consumerKey=nAGVOKcO5CjRWhUfgK9wm06nL&consumerSecret=5kILcU7xzh1hhxMomnLEGPULd2hxdX8uPcuBG4PbFsB3rrJMMu&accessToken=2523357524-DuGqB5DgVXR7z6zjdoyyf7jFrR3SJ9tMCaubPwJ&accessTokenSecret=3xNSFRfE9FR7sYe0HqMMwhBukSkO3mEleIOHAncsOkaaI")
//		  .to("file://target/test/twitter");
		
	}

}
