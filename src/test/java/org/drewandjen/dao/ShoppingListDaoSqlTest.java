package org.drewandjen.dao;

import org.drewandjen.config.WebRunner;
import org.drewandjen.model.ShoppingListItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by dhite on 8/30/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebRunner.class)
public class ShoppingListDaoSqlTest {

    private static final Logger LOG = LoggerFactory.getLogger(ShoppingListDaoSqlTest.class);

    @Autowired
    private ShoppingListDao dao;

    @Test
    public void testFetch(){
        List<ShoppingListItem> items = dao.fetchAll(1);
        for (ShoppingListItem item : items) {
            LOG.info("{}", item);
        }
        assertTrue(items.size() == 3);
    }

    @Test
    public void testSave(){
        List<ShoppingListItem> existingItems = dao.fetchAll(1);
        int prevSize = existingItems.size();
        dao.save(new ShoppingListItem("Razor blades", "Schick", null, false, 1, 0, "Cosmetics"));
        assertTrue(dao.fetchAll(1).size() == prevSize+1);
    }
}
