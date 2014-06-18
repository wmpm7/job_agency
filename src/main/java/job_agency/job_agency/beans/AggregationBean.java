package job_agency.job_agency.beans;

import org.apache.camel.Exchange;

public class AggregationBean {

	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			newExchange.getIn().setBody(new StringBuilder(newExchange.getIn().getBody(String.class)));
			return newExchange;
		}

		oldExchange.getIn().getBody(StringBuilder.class).append(newExchange.getIn().getBody(String.class));

		return oldExchange;
	}

}