package hua.objectsDao;


import hua.objects.Authorities;

import java.util.List;

public interface AuthoritiesDao {

    public List<Authorities> getAuthoritiesByUsername(String username);
    public void saveUserAuthority(Authorities authorities);
    public void updateAuthorities(Authorities authorities);
    public void deleteUserAuthority(String username);
}
