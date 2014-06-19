package job_agency.job_agency;

import job_agency.job_agency.routes.AggregateEmail;
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
        
        //Route2 Filter useless 
        main.addRouteBuilder(new FilterQueueRoute());

        //Route3 save2DB (queue -> DB)  [questionnaire]
        main.addRouteBuilder(new QueueToDBRoute());
        
        //Route4 calcInterests 
        //main.addRouteBuilder(new calcInterests());
        
        //Route5 searchJobIntern (DB -> process)
        main.addRouteBuilder(new SearchJobIntern()); //dominik
        
        //Route6 searchJobExtern (API -> process)
        //Derzeit wird ein statischer String bei Karriere abgefragt. 
        //Erhaltene Jobangebote werden gesplittet und neu formatiert
        //Aggregator fehlt noch
        main.addRouteBuilder(new SearchJobExtern());
              
        
        //Route7 calcStatistic 
        main.addRouteBuilder(new CalcStatistic());
        
        //Route8 createGraphics
        main.addRouteBuilder(new GraphicCreator());
        
        //Route9 statistic2FB (process -> API)
        //main.addRouteBuilder(new StatisticToFacebook()); dominik


        //Route10 statistic2Twitter (process -> API)
        //main.addRouteBuilder(new StatisticToTwitter()); wird nicht gemacht
        
        //Route11 statistic2Website with processor for PDF (process -> API)
        //main.addRouteBuilder(new StatisticToWebsite()); irene (grafik ins pdf)

        //Route12 aggregateEmail (process -> outbound)
        main.addRouteBuilder(new AggregateEmail());

        //Route13 sendEmail 
        //main.addRouteBuilder(new EmailToCustomerRoute());


        
        //NEWSLETTER
        
        //Route14 PublishSubscribe
        //main.addRouteBuilder(new NewsletterRoute());
        
        
        //JOBOFFERS INTO INTERN DATABASE
        
      
        
        

        
        main.run(args);
    }
}

