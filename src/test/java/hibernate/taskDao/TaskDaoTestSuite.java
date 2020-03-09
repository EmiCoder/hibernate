package hibernate.taskDao;

import hibernate.dao.TaskDao;
import hibernate.dao.TaskFinancialDetailsDao;
import hibernate.task.Task;
import hibernate.task.TaskFinancialDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    public void testTaskDaoSave() {
        Task task = new Task("description1", 3);
        taskDao.save(task);
        Assert.assertEquals(1, taskDao.findByDuration(3).size());
        taskDao.deleteAll();
    }

    @Test
    public void testTaskDaoSaveWithFinancialDetails() {
        Task task = new Task("description1", 3);
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal("25"), true);
        task.setTaskFinancialDetails(taskFinancialDetails);
        taskDao.save(task);
        List<TaskFinancialDetails> list = new ArrayList<>();
        for (Task task1 : taskDao.findAll()) {
            list.add(task1.getTaskFinancialDetails());
        }
        Assert.assertEquals(true, list.stream().anyMatch(n->n.isPaid()));
        taskDao.deleteAll();
    }

}
