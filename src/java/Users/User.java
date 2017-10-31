
package Users;

import java.io.Serializable;

/**
 *
 * @author 734972
 */
public class User implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public User() {
        this.username = "";
        this.password = null;
    }
    
    public User(String username) {
        this.username = username;
    }
    
    
}
