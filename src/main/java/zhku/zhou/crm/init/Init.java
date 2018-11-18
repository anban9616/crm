/**
 * 
 */
package zhku.zhou.crm.init;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Init {

	@Autowired ServletContext context;
	
	@PostConstruct
	public void init() {
		context.setAttribute("path", context.getContextPath());
	}
}
