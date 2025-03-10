package service;

import model.User;

import java.util.HashMap;

public class UserServiceImpl implements UserService {
    private static final HashMap<String, String> userData = new HashMap<>();
    public final HashMap<String, User> userList = new HashMap<>();
    public static String currentUser;

    @Override
    public final boolean getUserSignUp(final User user) {
        if (userList.containsKey(user.getEmail())) {
            return false;
        } else {
            userList.put(user.getEmail(), user);
            userData.put(user.getEmail(), user.getPassword());

            System.out.println(userList.entrySet());
            return true;
        }
    }

    @Override
    public final boolean getUserSignIn(final String email, final String password) {
        if (userList.containsKey(email) && userData.get(email).equals(password)) {
            currentUser = email;
            //return userList.get(email).getPassword().equals(password);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public final boolean userUpdate(final String email, final String newName, final String newPassword) {
        if (userList.containsKey(email)) {
            User user = new User();
            user.setEmail(email);
            user.setUsername(newName);
            user.setPassword(newPassword);
            //user.setUserId(user.getUserId());
            userList.put(email, user);
            return true;
        } else {
            //System.out.println("please enter valid email");
            return false;
        }
    }

    @Override
    public final boolean userDelete() {
        if (currentUser != null && userList.containsKey(currentUser)) {
            userList.remove(currentUser);
            userData.remove(currentUser);
        }
        return false;
    }

    public final void viewUser() {
        if (userList.containsKey(currentUser)) {
            final User user = userList.get(currentUser);
            System.out.println("user information: " + user);
        }else {
            System.out.println("user email not found");
        }
    }
}