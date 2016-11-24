package usermanager.dao;

import usermanager.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);

    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if(user !=null){
            session.delete(user);
        }

    }

    @Override
    public User getUserById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(id));

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers(User filter) {
        Session session = this.sessionFactory.getCurrentSession();

        List<User> userList;
        if (filter.getName() == null)
            userList =  session.createCriteria(User.class).list();
        else
            userList =  session.createCriteria(User.class).add(Restrictions.like("name", filter.getName() + "%")).list();

        return userList;
    }
}
