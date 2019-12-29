package hua.objectsDao;

import hua.objects.Users;

import java.util.List;

public interface UserDao {
    public List<Users> getUsers();
    public List<Users> getUserByUsername(String username);
    public void saveUser(Users user);
    public void updateUser(Users user);
    public void updateUserPC(Users user); //PC = PASSWORD CHANGED
    public void deleteUser(String user);

}
