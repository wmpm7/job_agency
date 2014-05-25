package job_agency.job_agency;

import job_agency.job_agency.routes.MyRouteBuilder;
import org.apache.camel.spring.Main;

public class MainApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new MyRouteBuilder());
        //main.addRouteBuilder(new MyPublishSubscribe());
        //main.addRouteBuilder(new MyMessageFilter());
        
        
        //Route1 file2POJO (inbound -> process) [questionnaire}
        //main.addRouteBuilder(new FileToPOJO());
        
        //Route2 Filter useless 
        //main.addRouteBuilder(new MyMessageFilter());

        //Route3 save2DB (process -> DB)  [questionnaire]
        //main.addRouteBuilder(new SaveToDB());
        
        //Route4 calcInterests 
        //main.addRouteBuilder(new calcInterests());
        
        //Route5 searchJobIntern (DB -> process)
        //main.addRouteBuilder(new SearchJobIntern());
        
        //Route6 searchJobExtern (API -> process)
        //main.addRouteBuilder(new SearchJobExtern());
        
        //Route7 calcStatistic 
        //main.addRouteBuilder(new calcStatistic());
        
        //Route8 statistic2Email 
        //main.addRouteBuilder(new StatisticToEmail());
        
        //Route9 statistic2FB (process -> API)
        //main.addRouteBuilder(new StatisticToFacebook());

        //Route10 statistic2Twitter (process -> API)
        //main.addRouteBuilder(new Statistic2Twitter());
        
        //Route11 statistic2Website with processor for PDF (process -> API)
        //main.addRouteBuilder(new StatisticToWebsite());

        //Route12 aggregateEmail (process -> outbound)
        //main.addRouteBuilder(new AggregateEmail());

        //Route13 sendEmail 
        //main.addRouteBuilder(new sendEmail());

        //Route14 PublishSubscribe
        //main.addRouteBuilder(new MyPublishSubscribe());
        
        //Route15 file2POJO (inbound -> process) [job offer]
        //main.addRouteBuilder(new FileToPOJO());
        
        //Route3 save2DB (process -> DB) [job offer]
        //main.addRouteBuilder(new SaveToDB());
        
        main.run(args);
    }
}

