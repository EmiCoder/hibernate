package hibernate.manytomanyDao;

import hibernate.manytomany.Company;
import hibernate.manytomany.Employee;
import hibernate.manytomany.dao.CompanyDao;
import hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueriesTestSuite {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;

    @Test
    public void doCompanyNameNativeQueriesWorkCorrectly() {
        Company company1 = new Company("Company1");
        Company company2 = new Company("Company2");
        Company company3 = new Company("Firm3");
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        Assert.assertEquals(2, companyDao.findByThreeFirstCharacters("Com").size());
        companyDao.deleteById(company1.getId());
        companyDao.deleteById(company2.getId());
        companyDao.deleteById(company3.getId());
        companyDao.deleteAll();
    }

    @Test
    public void doEmployeeNamedQueriesWorkCorrectly() {
        Employee employee1 = new Employee("Emilia", "Traczyk");
        Employee employee2 = new Employee("Franek", "Nowak");
        Employee employee3 = new Employee("Lucy", "Traczyk");
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        Assert.assertEquals(2, employeeDao.findByLastname("Traczyk").size());
        employeeDao.deleteById(employee1.getId());
        employeeDao.deleteById(employee2.getId());
        employeeDao.deleteById(employee3.getId());
        employeeDao.deleteAll();
    }

}
