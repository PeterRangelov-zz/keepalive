package keepalive;

import java.util.ArrayList;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PingTask {
    private static final Logger log = LoggerFactory.getLogger(PingTask.class);
    
    @Scheduled(fixedRate = 3600000)
    private void reportCurrentTime() {
    	sendPing();
    }
    
    private void sendPing() {
    	WebDriver driver = new HtmlUnitDriver(false);
    	ArrayList<String> hosts = new ArrayList<String>(Arrays.asList(System.getenv("hosts").split(",")));
    	
    	for (String host : hosts) {
    		log.info("Pinging host " + host);        	
        	driver.get("https://" + host + ".herokuapp.com");
        	log.info("Page title: " + driver.getTitle());
    	}
    	
    }
    
   
}