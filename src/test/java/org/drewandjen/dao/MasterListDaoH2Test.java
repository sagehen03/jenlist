package org.drewandjen.dao;

import org.drewandjen.config.WebRunner;
import org.drewandjen.model.MasterListItem;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Autowired
    private MasterListDao dao;

    @Test
    public void testFetchAll() throws Exception {
        List<MasterListItem> masterListItems = dao.fetchAll();
        assertThat(masterListItems, containsInAnyOrder(new MasterListItem(1, "Tomatoes"), new MasterListItem(2, "Green Beans")));
    }
}