package hua.objectsDao;

import hua.objects.Users;

import java.util.List;

public interface UserDao {
    public List<Users> getUsers();
    public Users getUserByUsername(String username);
    public void saveUser(Users user);
}
