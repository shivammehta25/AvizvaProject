import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.dao.UserDAOImpl;
import com.avizva.trainingProject.backend.model.User;

public class trials {

	public static void main(String[] args) {
		UserDAO userDao  = new UserDAOImpl();
		User u = new User();
		u.setName("Shivam");
		u.setContact(98111L);
		boolean x = userDao.registerUser(u);
		System.out.println(x);
	}
	
	
}
