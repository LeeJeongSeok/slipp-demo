package core.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import next.model.User;

public class DataBase {
    private static Map<String, User> users = new HashMap<String, User>();

    public static void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public static User findUserById(String userId) {
        return users.get(userId);
    }

    public static Collection<User> findAll() {
        return users.values();
    }

    public static void updateUser(User user) {
        users.remove(user.getUserId(), user);
        users.put(user.getUserId(), user);
    }
}
