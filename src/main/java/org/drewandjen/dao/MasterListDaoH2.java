package org.drewandjen.dao;

import org.drewandjen.model.MasterListItem;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

/**
 * Created by dhite on 8/29/15.
 */
public class MasterListDaoH2 implements MasterListDao {

    private JdbcTemplate template;

    public MasterListDaoH2(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<MasterListItem> fetchAll() {
        return template.query("SELECT id, name, category FROM master_list ORDER BY category", (rs, rowNum) -> {
            return new MasterListItem(rs.getInt("id"), rs.getString("name"), rs.getString("category"));
        });
    }

    @Override
    public void save(MasterListItem newItem) {
        template.update("insert into master_list (name, category, created_at) values (?, ?, ?)",
                newItem.getName(), newItem.getCategory(), new Date());
    }

    @Override
    public void delete(MasterListItem itemToDelete) {
        template.update("delete from master_list where id = ?", itemToDelete.getId());
    }
}
