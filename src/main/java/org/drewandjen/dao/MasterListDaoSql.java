package org.drewandjen.dao;

import org.drewandjen.model.MasterListItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by dhite on 8/29/15.
 */
public class MasterListDaoSql implements MasterListDao {

    private JdbcTemplate template;

    public MasterListDaoSql(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<MasterListItem> fetchAll(Integer userId) {
        return template.query("SELECT id, name, category FROM master_list where user_id = ? ORDER BY category", (rs, rowNum) -> {
            return new MasterListItem(rs.getInt("id"), rs.getString("name"), rs.getString("category"));
        }, userId);
    }

    @Override
    public MasterListItem save(MasterListItem newItem, Integer userId) {
        PreparedStatementCreator pc = con -> {
            PreparedStatement ps = con.prepareStatement("insert into master_list (name, category, user_id, " +
                    "created_at) values (?, ?, ?, current_timestamp)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, newItem.getName());
            ps.setString(2, newItem.getCategory());
            ps.setInt(3, userId);
            return ps;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        template.update(pc, generatedKeyHolder);
        return new MasterListItem((Integer)generatedKeyHolder.getKeys().get("id"), newItem.getName(), newItem.getCategory());
    }

    @Override
    public void delete(MasterListItem itemToDelete, Integer userId) {
        template.update("delete from master_list where id = ? and user_id = ?", itemToDelete.getId(), userId);
    }
}
