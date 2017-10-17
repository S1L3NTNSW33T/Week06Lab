
package Servlets;

import Users.User;

/**
 *
 * @author 734972
 */
public class UserService {
    public User login(String username, String password) {
        if ((username.equals("adam") || username.equals("betty")) && password.equals("password")) {
            return new User(username);
        }
        
        return null;
    }
}
