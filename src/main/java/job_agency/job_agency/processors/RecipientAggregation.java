package job_agency.job_agency.processors;

import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class RecipientAggregation implements AggregationStrategy  {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		final String body = oldExchange.getIn().getBody(String.class);
	    final Questionnaire recipient = newExchange.getIn().getBody(Questionnaire.class);
	    
	    newExchange.getIn().setHeader("recipient", recipient.person.getEmail());
	    newExchange.getIn().setBody(body);
	    return newExchange;
	}

}
