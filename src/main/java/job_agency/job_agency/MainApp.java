  package job_agency.job_agency;

import job_agency.job_agency.routes.AggregateAllOffers;
import job_agency.job_agency.routes.CalcStatistic;
import job_agency.job_agency.routes.EmailToCustomerRoute;
import job_agency.job_agency.routes.FileToQueueRoute;
import job_agency.job_agency.routes.FilterQueueRoute;
import job_agency.job_agency.routes.GraphicCreator;
import job_agency.job_agency.routes.JobofferQueueToDBRoute;
import job_agency.job_agency.routes.JobofferToQueueRoute;
import job_agency.job_agency.routes.NewsletterRoute;
import job_agency.job_agency.routes.QueueToDBRoute;
import job_agency.job_agency.routes.SearchJobExtern;
import job_agency.job_agency.routes.SearchJobIntern;
import job_agency.job_agency.routes.StatisticToFacebook;
import job_agency.job_agency.routes.StatisticToWebsite;

import org.apache.camel.spring.Main;
import org.apache.log4j.BasicConfigurator;

public class MainApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();
        
        BasicConfigurator.configure();        
        
        //Route15 file2Queue [job offer]
        main.addRouteBuilder(new JobofferToQueueRoute());
        
        //Route16 save2DB (queue -> DB) [job offer]
        main.addRouteBuilder(new JobofferQueueToDBRoute());
        
        //Route1 file2Queue [questionnaire]
        main.addRouteBuilder(new FileToQueueRoute());
        
        //Route2 Filter [questionnaire] 
        main.addRouteBuilder(new FilterQueueRoute());

        //Route3 save2DB (queue -> DB)  [questionnaire]
        main.addRouteBuilder(new QueueToDBRoute());        
        
        //Route4 searchJobIntern (DB -> process)
        main.addRouteBuilder(new SearchJobIntern());
        
        //Route5 searchJobExtern (API -> process)
        main.addRouteBuilder(new SearchJobExtern());
        
        //Route6 calcStatistic 
        main.addRouteBuilder(new CalcStatistic());
        
        //Route7 createGraphics
        main.addRouteBuilder(new GraphicCreator());
        
        //Route8 statistic2FB (process -> API)
        main.addRouteBuilder(new StatisticToFacebook());

        
        //IN AUT NICHT MOEGLICH --> WIE BEI MR1 BESPROCHEN
        //Route9 statistic2Twitter (process -> API)
        //main.addRouteBuilder(new StatisticToTwitter());
        
        //Route10 statistic2Website with processor for PDF (process -> API)
        main.addRouteBuilder(new StatisticToWebsite()); 

        //Route11 merge internal and external offers
        main.addRouteBuilder(new AggregateAllOffers());

        //Route12 sendEmail 
        main.addRouteBuilder(new EmailToCustomerRoute());

        //Route13 PublishSubscribe
        main.addRouteBuilder(new NewsletterRoute());

        
        main.run(args);
    }
}

