package org.drewandjen.dao;

import org.drewandjen.config.WebRunner;
import org.drewandjen.model.MasterListItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertTrue;

/**
 * Created by dhite on 8/29/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebRunner.class)
public class MasterListDaoH2Test {

    private static final Logger LOG = LoggerFactory.getLogger(MasterListDaoH2Test.class);

    @Autowired
    private MasterListDao dao;

    @Test
    public void testFetchAll() throws Exception {
        List<MasterListItem> masterListItems = dao.fetchAll(1);
        for (MasterListItem masterListItem : masterListItems) {
            LOG.info("{}", masterListItem);
        }
        assertThat(masterListItems, containsInAnyOrder(new MasterListItem(1, "Tomatoes", "Produce"),
                new MasterListItem(2, "Green Beans", "Produce"), new MasterListItem(3, "Dog Treats", "Tenna")));
    }

    @Test
    public void testSaveNewItem(){
        dao.save(new MasterListItem(4, "Razor Blades", "Cosmetics"), 1);
        List<MasterListItem> items = dao.fetchAll(1);
        assertThat(items, containsInAnyOrder(new MasterListItem(1, "Tomatoes", "Produce"),
                new MasterListItem(2, "Green Beans", "Produce"), new MasterListItem(3, "Dog Treats", "Tenna"),
                new MasterListItem(4, "Razor Blades", "Cosmetics")));
    }

    @Test
    public void testDeleteItem(){
        List<MasterListItem> initialItems = dao.fetchAll(1);
        dao.delete(new MasterListItem(1, "Tomatoes", "Produce"), 1);
        List<MasterListItem> remainingItems = dao.fetchAll(1);
        assertTrue(remainingItems.size() == initialItems.size()-1);
    }
}