package se.zust.orm.service;

import jdk.internal.instrumentation.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import se.zust.orm.Application;
import se.zust.orm.entity.RelationExample;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration/*("server.port:8888")*/
public class RelationServiceTest {
    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());

    @Autowired
    private RelationService relationService;
    @Test
    public void insertRelationship() throws Exception {
        relationService.insertRelationship(1,12);
    }

    @Test
    public void delectRelationship() throws Exception {

        relationService.delectRelationship(1,12);

    }

}