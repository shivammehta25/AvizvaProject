import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.trainingProject.backend.config.ApplicationContextConfig;
import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.dao.UserDAOImpl;
import com.avizva.trainingProject.backend.model.Address;
import com.avizva.trainingProject.backend.model.User;

public class trials {

	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		 UserDAOImpl m=(UserDAOImpl)ctx.getBean("userDAOImpl");
		//UserDAO userDao  = new UserDAOImpl();
		 Address a = new Address();
		 a.setAddress("Ghar");
		User u = new User();
		u.setName("Shivam");
		u.setContact(98111L);
		List<Address> al = new ArrayList<Address>();
		al.add(a);
		u.setAddress(al);
		boolean x = m.registerUser(u);
		System.out.println(x);
	}
	
	
}
