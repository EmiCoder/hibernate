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

import javax.transaction.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;


    @Test
    public void testSaveManyToMany() {
        Employee employee1 = new Employee("John", "Kowalsky");
        Employee employee2 = new Employee("Clara", "Fig");
        Employee employee3 = new Employee("Robert", "Emmy");


        Company company1 = new Company("Company_1");
        Company company2 = new Company("Company_2");
        Company company3 = new Company("Company_3");


        employee1.getCompanies().add(company1);
        employee1.getCompanies().add(company2);
        employee2.getCompanies().add(company2);
        employee3.getCompanies().add(company1);
        employee3.getCompanies().add(company3);

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        company1.getEmployees().add(employee1);
        company1.getEmployees().add(employee3);
        company2.getEmployees().add(employee2);
        company2.getEmployees().add(employee1);
        company3.getEmployees().add(employee3);

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        Assert.assertNotEquals(0, company1.getId());

    }
}
