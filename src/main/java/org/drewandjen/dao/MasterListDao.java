package org.drewandjen.dao;

import org.drewandjen.model.MasterListItem;

import java.util.List;

/**
 * Created by dhite on 8/29/15.
 */
public interface MasterListDao {

    List<MasterListItem> fetchAll();

    void save(MasterListItem newItem);

    void delete(MasterListItem itemToDelete);
}
