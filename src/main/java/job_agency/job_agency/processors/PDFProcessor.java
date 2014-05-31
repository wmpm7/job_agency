package job_agency.job_agency.processors;

import job_agency.job_agency.models.PDFUtil;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.fop.FopConstants;

public class PDFProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        final String body = exchange.getIn().getBody(String.class);
        final String fileNameWithoutExtension = PDFUtil.getFileNameWithoutExtension(exchange);
        final String convertToXSLFOBody = PDFUtil.getFilledXSLFO(body);
        exchange.getIn().setBody(convertToXSLFOBody);
        exchange.getIn().setHeader(Exchange.FILE_NAME, fileNameWithoutExtension + ".pdf");
        exchange.getIn().setHeader(FopConstants.CAMEL_FOP_RENDER + "author", "Shreyas Purohit");
    }

}
