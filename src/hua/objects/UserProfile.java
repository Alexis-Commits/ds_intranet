package hua.objects;


public class UserProfile {
    private int enabled ;
    private String username ;
    private String password;
    private String authority;

    public UserProfile(String username, String password, int enabled , String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.enabled = enabled;
    }
    public UserProfile(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }
    public UserProfile(){}

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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
