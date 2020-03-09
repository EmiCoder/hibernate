package hibernate.manytomany.dao;

import hibernate.manytomany.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
