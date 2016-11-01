package applicationCtx;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware{
	 private static ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		// TODO Auto-generated method stub
		context = ctx;
		
	}

}
