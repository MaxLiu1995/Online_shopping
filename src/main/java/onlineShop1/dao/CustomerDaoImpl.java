package onlineShop1.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import onlineShop1.model.Authorities;
import onlineShop1.model.Cart;
import onlineShop1.model.Customer;
import onlineShop1.model.User;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	//往数据库中添加一个customer

	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomer(Customer customer) {
		customer.getUser().setEnabled(true);

		Authorities authorities = new Authorities();
		authorities.setAuthorities("ROLE_USER");//自己定义普通user
		authorities.setEmailId(customer.getUser().getEmailId());

		Cart cart = new Cart();
		//Cart不用save， 因为customer中会cascade的保存
		//但是authority没有，需要手动保存
		cart.setCustomer(customer);
		customer.setCart(cart);
		
		Session session = null;//这个是hibernate session 和数据库相连，和http session不一样
		//JDBC没有session概念
		

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(authorities);
			session.save(customer);
			session.getTransaction().commit();
			//
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			//rollback把保存的也去掉
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Customer getCustomerByUserName(String userName) {
		//根据名字找customer
		User user = null;
		try (Session session = sessionFactory.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			//建立搜索条件的对象
			//创建一个query
			CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);//告诉说我们要搜索的是user.class
			//CriteriaQuery是一个搜索条件
			Root<User> root = criteriaQuery.from(User.class);
			criteriaQuery.select(root).where(builder.equal(root.get("emailId"), userName));
			//从节点开始搜， 找节点emailId等于userName
			user = session.createQuery(criteriaQuery).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user != null)
			return user.getCustomer();
		return null;
	}
}
