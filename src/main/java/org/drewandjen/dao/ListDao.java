package org.drewandjen.dao;

import org.drewandjen.model.ListItem;

import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
public interface ListDao {

    List<ListItem> getListItems();

    void save(ListItem item);

    ListItem getItemById(int id);

}
