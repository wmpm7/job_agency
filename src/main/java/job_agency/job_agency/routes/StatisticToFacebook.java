package job_agency.job_agency.routes;

import org.apache.camel.builder.RouteBuilder;

public class StatisticToFacebook extends RouteBuilder{

	@Override
	public void configure() throws Exception {
//		from("file://src/data/test?noop=true")
//		  .to("facebook://postStatusMessage?"
//		  		+ "message=blub"
//		  		+ "&oAuthAccessToken=CAADe3mZCA6xsBAHqTXCc66d4ZAqPy9apCSEAfziR7irRN6DHYuvyzu2BBVn2ZAc2krC5MlgtqINhxu6QjjMBkH1rNm6LYmfeKZAZCJDJKkZCqEm3oZAG8wG166b01AeemDWbcNHyCrjZBzyuJJ8cOojz3ZCxdXtuPF1CYZBEWYa7zT1lqCg7DJeCLBlas7aQlxWtcZD"
//		  		+ "&oAuthAppId=245046939020059"
//		  		+ "&oAuthAppSecret=fba916c9088b2776937f4715dd0e5b00");
		
		from("file://src/data/test?noop=true")
		.routeId("StatisticToFacebook-Route")
		  .to("facebook://postStatusMessage?"
		  		+ "message=blub"
		  		+ "&oAuthAccessToken={{FBAuthAccessToken}}"
		  		+ "&oAuthAppId={{FBAuthAppId}}"
		  		+ "&oAuthAppSecret={{FBAuthAppSecret}}");
		
	}

}

//wennst was brauchst bin ich jederzeit erreichbar
//mein facebook login: roscoe.baston@hotmail.com	pass:ekms67
//auf facebook for developer kannst rein
//bis jetzt nach besten wissen und gewissen gamcht -- ich vermut es fehlt nicht viel ..
//oauthappid und oauthappsecret sind ziemlich sicher richtig --> ich vermute der fehler liegt beim accesstoken