package hibernate.invoice.dao;

import hibernate.invoice.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Integer> {
}
