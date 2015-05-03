package by.julia.spring.dao;
import java.util.List;

import by.julia.spring.model.Count;

public interface CountDAO {
	
	public List<Count> list();

	public Count get(int id);

	public void saveOrUpdate(Count user);

	public void delete(int id);
}
