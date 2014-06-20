package job_agency.job_agency.processors;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class AggregateAllStrategy implements AggregationStrategy {
	 
 
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
        	String body = newExchange.getIn().getBody(String.class);
            newExchange.getIn().setBody("Your offers:\n\n" + body);
            return newExchange;
        } else if(newExchange.getIn().getBody(String.class).equals("") || newExchange == null)
        {
        	return oldExchange;
        }
        String body1 = oldExchange.getIn().getBody(String.class);
        String body2 = newExchange.getIn().getBody(String.class);
 
        oldExchange.getIn().setBody(body1 + "\n" + body2);
 
        return oldExchange;
    }
}