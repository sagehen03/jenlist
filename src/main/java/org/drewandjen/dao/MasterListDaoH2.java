package org.drewandjen.dao;

import org.drewandjen.model.MasterListItem;
import org.springframework.jdbc.core.JdbcTemplate;

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
        return template.query("SELECT id, name FROM master_list ORDER BY created_at", (rs, rowNum) -> {
            return new MasterListItem(rs.getInt("id"), rs.getString("name"));
        });
    }
}
