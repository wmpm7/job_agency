package job_agency.job_agency.processors;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MyAggregationStrategy implements AggregationStrategy {
	 
 
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null || newExchange.getIn().getBody(String.class).equals("")) {
        	String body = newExchange.getIn().getBody(String.class).split("Ort:")[0];
            newExchange.getIn().setBody("Offers from karriere.at:\n" + body.substring(7));
            return newExchange;
        }
        String body1 = oldExchange.getIn().getBody(String.class);
        String body2 = newExchange.getIn().getBody(String.class).split("Ort:")[0].substring(7);
 
        oldExchange.getIn().setBody(body1 + body2);// + "\n");
 
        return oldExchange;
    }
}