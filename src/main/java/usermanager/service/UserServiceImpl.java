package usermanager.service;

import usermanager.dao.UserDaoImpl;
import usermanager.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDaoImpl;

    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDaoImpl.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDaoImpl.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDaoImpl.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDaoImpl.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUsers(User filter) {
        return this.userDaoImpl.listUsers(filter);
    }

    @Override
    @Transactional
    public List<User> listUsers(User filter, int page) {

        List<User> list = listUsers(filter);
        return list.subList((page - 1) * 10, Math.min(list.size(), page * 10));
    }


    @Override
    @Transactional
    public int countPages(User filter) {
        return (listUsers(filter).size()-1) / 10 + 1;
    }
}
