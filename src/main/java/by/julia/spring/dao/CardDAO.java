package by.julia.spring.dao;
import java.util.List;

import by.julia.spring.model.Card;


public interface CardDAO {
	
	public List<Card> list();

	public Card get(int id);

	public void saveOrUpdate(Card card);

	public void delete(int id);
}
