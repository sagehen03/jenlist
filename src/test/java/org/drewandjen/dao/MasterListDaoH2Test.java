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
        List<MasterListItem> masterListItems = dao.fetchAll();
        for (MasterListItem masterListItem : masterListItems) {
            LOG.info("{}", masterListItem);
        }
        assertThat(masterListItems, containsInAnyOrder(new MasterListItem(1, "Tomatoes"),
                new MasterListItem(2, "Green Beans"), new MasterListItem(3, "Dog Treats")));
    }

    @Test
    public void testSaveNewItem(){
        dao.save(new MasterListItem(4, "Razor Blades"));
        List<MasterListItem> items = dao.fetchAll();
        assertThat(items, containsInAnyOrder(new MasterListItem(1, "Tomatoes"),
                new MasterListItem(2, "Green Beans"), new MasterListItem(3, "Dog Treats"),
                new MasterListItem(4, "Razor Blades")));
    }
}