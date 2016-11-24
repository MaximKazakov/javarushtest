package usermanager.service;

import usermanager.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUsers(User filter);

    public List<User> listUsers(User filter, int page);


    int countPages(User filter);
}
