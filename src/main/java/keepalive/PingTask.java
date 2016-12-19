package keepalive;

import java.text.SimpleDateFormat;
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
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    

    @Scheduled(fixedRate = 3600000)
    private void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
    	sendPing();
    }
    
    private void sendPing() {
    	WebDriver driver = new HtmlUnitDriver(false);
//    	
    	ArrayList<String> hosts = new ArrayList<String>(Arrays.asList(System.getenv("hosts").split(",")));
    	
    	for (String host : hosts) {
    		log.info("Pinging host " + host);        	
        	driver.get("https://" + host);
        	log.info("Page title: " + driver.getTitle());
    	}
    	
    	
    	
//    	boolean isReachable;
//		try {
//			isReachable = InetAddress.getByName(host).isReachable(20);
//			
//			if (isReachable) {
//	    		log.info("Pinged ");
//	    	} else {
//	    		log.error("Couldn't ping");
//	    	}
//			
//		} catch (UnknownHostException e) {
//			log.error(e.getMessage());
//		} catch (IOException e) {
//			log.error(e.getMessage());
//		}
    	
    	
    	
//		try (Socket socket = new Socket()) {
//	        socket.connect(site, 20);
//	    
//	    } catch (IOException e) {
//	    	log.error("Unable to ping");
//	    }
    }
    
    
}