package org.drewandjen.dao;

import org.drewandjen.model.ListUser;

import java.util.List;

/**
 * Created by dhite on 11/28/15.
 */
public interface UserDao {

    List<ListUser> getAllUsers();

}
