package services;
import beans.UserBean;
import dao.UserDAO;

public class UserService {

    public UserService() {
        // TODO Auto-generated constructor stub
    }

    public UserBean getUser(String username, String password)
    {

        UserBean userBean = UserDAO.getUserByUsername(username);
        System.out.print(userBean);
        if(userBean != null && userBean.getPassword().equals(password)) 
        	return userBean;
        return null;
        	

//        return userBean != null && bCryptPasswordEncoder.matches(password, userBean.getPassword()) ? userBean : null;
   //     return userBean != null && password == userBean.getPassword()? userBean : null;
    }

}
