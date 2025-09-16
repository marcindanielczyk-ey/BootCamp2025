package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        session.flush();
        if (user.getId() == 2L) {
            throw new RuntimeException("Simulated error for test");
        }
    }
}