package hibernate.taskListDao;

import hibernate.dao.TaskDao;
import hibernate.dao.TaskFinancialDetailsDao;
import hibernate.dao.TaskListDao;
import hibernate.task.Task;
import hibernate.task.TaskFinancialDetails;
import hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;
    @Autowired
    TaskFinancialDetailsDao taskFinancialDetailsDao;
    @Autowired
    TaskDao taskDao;

    @Test
    public void testFindByListName() {
        TaskList taskList = new TaskList();
                    taskList.setListName("taskList_1");
                    taskList.setDescription("taskListDescription");
        taskListDao.save(taskList);
        Assert.assertEquals(1, taskListDao.findByListName("taskList_1").size());
        taskListDao.deleteAll();
    }

    @Test
    public void testTaskListDaoSaveWithTasks() {
        Task task1 = new Task("description1", 2);
        Task task2 = new Task("description2", 3);
        Task task3 = new Task("description3", 3);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal("25"), true);
        TaskFinancialDetails tf2 = new TaskFinancialDetails(new BigDecimal("25"), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal("25"), true);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tf2);
        task3.setTaskFinancialDetails(tfd3);
        TaskList taskList1 = new TaskList();
                    taskList1.setListName("ListName1");
                    taskList1.setDescription("ListDescription1");
                    taskList1.getTasks().add(task1);
                    taskList1.getTasks().add(task2);
                    taskListDao.save(taskList1);
        TaskList taskList2 = new TaskList();
                    taskList2.setListName("ListName2");
                    taskList2.setDescription("ListDescription2");
                    taskList2.getTasks().add(task3);
                    taskListDao.save(taskList2);
        task1.setTaskList(taskList1);
        taskDao.save(task1);
        task2.setTaskList(taskList1);
        taskDao.save(task2);
        task3.setTaskList(taskList2);
        taskDao.save(task3);
        Assert.assertEquals(2, taskListDao.findAll().size());
    }
}
