package job_agency.job_agency.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FBProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        body = body.replaceAll("\n", "");
        body = body.replaceAll(" ", "%20");
        body = body.replaceAll("\t", "    ");
        
        String fbendpoint = "facebook://postStatusMessage?"
	  		+ "message="+body
	  		+ "&oAuthAccessToken={{FBAuthAccessToken}}"
	  		+ "&oAuthAppId={{FBAuthAppId}}"
	  		+ "&oAuthAppSecret={{FBAuthAppSecret}}";
		  
        
        exchange.getIn().setHeader("recipient",fbendpoint);
    }

}
