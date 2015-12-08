package org.drewandjen.model;

import org.drewandjen.dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dhite on 11/28/15.
 */
public class UserInfoCache {

    private Map<String, Integer> userNameToId = new HashMap<>();

    public UserInfoCache(UserDao userDao) {
        List<ListUser> allUsers = userDao.getAllUsers();
        for (ListUser allUser : allUsers) {
            userNameToId.put(allUser.getName(), allUser.getId());
        }
    }

    public Integer getUserId(String userName){
        return userNameToId.get(userName);
    }
}
