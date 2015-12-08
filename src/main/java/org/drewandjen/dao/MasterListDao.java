package org.drewandjen.dao;

import org.drewandjen.model.MasterListItem;

import java.util.List;

/**
 * Created by dhite on 8/29/15.
 */
public interface MasterListDao {

    List<MasterListItem> fetchAll(Integer userId);

    void save(MasterListItem newItem, Integer userId);

    void delete(MasterListItem itemToDelete, Integer userId);
}
