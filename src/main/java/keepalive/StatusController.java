package keepalive;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	@RequestMapping(value = "/status")
	public String healthCheck() {
		return "Application is running.";
	}
	

}
