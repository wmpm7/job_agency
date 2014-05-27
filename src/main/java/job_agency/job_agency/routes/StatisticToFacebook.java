package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

public class StatisticToFacebook extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file://src/data/test?noop=true")
		  .to("facebook://postStatusMessage?"
		  		+ "message=blub"
		  		+ "&oAuthAccessToken=CAADe3mZCA6xsBAFZA9IG0kN2h5YkX3j1BLH0gfZCYAxoHlj8juLVUjsyhjHjs61RETtlqioxWloKZAnyF3t"
		  		+ "Uwe0MPDeZAy2KpxvImiD1ZBhDJYHA1HUE1WTuZAVhkdq1ZABcHMZCEaeNphy0UQIDKxiKKgFLFt5DcZCLZCOBqChsRL1q8rpjEZBVOY0"
		  		+ "SZCHFlI0t2FqnPbnfbdvZBNTQZDZD"
		  		+ "&oAuthAppId=245046939020059"
		  		+ "&oAuthAppSecret=fba916c9088b2776937f4715dd0e5b00");
	}

}
