package hibernate.taskDao;


import hibernate.dao.TaskFinancialDetailsDao;
import hibernate.task.TaskFinancialDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskFinancialDetailsDaoTestSuite {

    @Autowired
    TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    public void testFindByPaid() {
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal("25"), true);
        taskFinancialDetailsDao.save(taskFinancialDetails);
        Assert.assertEquals(1, taskFinancialDetailsDao.findByPaid(true).size());
        taskFinancialDetailsDao.deleteAll();
    }
}
