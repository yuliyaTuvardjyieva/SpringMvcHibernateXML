package by.julia.spring.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.julia.spring.model.Card;



@Repository
public class CardDAOImpl implements CardDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public CardDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CardDAOImpl() {

	}

	@Override
	@Transactional
	public List<Card> list() {
		@SuppressWarnings("unchecked")
		List<Card> listCard = (List<Card>) sessionFactory.getCurrentSession()
				.createCriteria(Card.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCard;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Card card) {
		sessionFactory.getCurrentSession().saveOrUpdate(card);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Card cardToDelete = new Card();
		cardToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(cardToDelete);
	}

	@Override
	@Transactional
	public Card get(int id) {
		String hql = "from Card where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Card> listCard = (List<Card>) query.list();

		if (listCard != null && !listCard.isEmpty()) {
			return listCard.get(0);
		}

		return null;
	}


}
