package by.julia.spring.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.julia.spring.model.Count;


@Repository
public class CountDAOImpl implements CountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public CountDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CountDAOImpl() {

	}

	@Override
	@Transactional
	public List<Count> list() {
		@SuppressWarnings("unchecked")
		List<Count> listCount = (List<Count>) sessionFactory.getCurrentSession()
				.createCriteria(Count.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCount;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Count count) {
		sessionFactory.getCurrentSession().saveOrUpdate(count);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Count countToDelete = new Count();
		countToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(countToDelete);
	}

	@Override
	@Transactional
	public Count get(int id) {
		String hql = "from Count where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Count> listCount = (List<Count>) query.list();

		if (listCount != null && !listCount.isEmpty()) {
			return listCount.get(0);
		}

		return null;
	}


}
