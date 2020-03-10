package hibernate.dao;

import hibernate.task.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TaskDao extends CrudRepository<Task, Integer> {
    List<Task> findByDuration(int duration);
    @Query
    List<Task> retrieveByDuration();
    @Query(nativeQuery = true)
    List<Task> retrieveFromTasks();
    @Query
    List<Task> retrieveTaksWithParametrs(@Param("Duration") int duration);
}
