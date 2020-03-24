package hibernate.manytomany.facade;

import hibernate.manytomany.Company;
import hibernate.manytomany.Employee;
import hibernate.manytomany.dao.CompanyDao;
import hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class Facade {

    private final EmployeeDao employeeDao;
    private final CompanyDao companyDao;

    public Facade(EmployeeDao employeeDao, CompanyDao companyDao) {
        this.employeeDao = employeeDao;
        this.companyDao = companyDao;
    }

    public List<Employee> retrieveEmployeesWithNameLike(String arg) {
        return employeeDao.retrieveEmployeesWithNameLike(arg);
    }

    public List<Company> retrieveCompaniesWithNameLike(String arg) {
        return companyDao.retrieveCompaniesWithNameLike(arg);
    }
}
