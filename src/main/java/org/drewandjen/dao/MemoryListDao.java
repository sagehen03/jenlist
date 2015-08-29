package org.drewandjen.dao;

import org.drewandjen.model.ListItem;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by dhite on 8/24/15.
 */
public class MemoryListDao implements ListDao {

    @Override
    public List<ListItem> getListItems() {
        return Arrays.asList(new ListItem(1, "Hello", "Comment", new Date(), false));
    }

    @Override
    public void save(ListItem item) {

    }

    @Override
    public ListItem getItemById(int id) {
        return null;
    }
}
