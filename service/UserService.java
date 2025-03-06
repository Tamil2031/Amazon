package service;

import model.User;

public interface UserService {

    boolean getUserSignUp(User user);
    boolean getUserSignIn(String email, String password);
    boolean userUpdate(String email, String newName, String newPassword);
    boolean userDelete();
    public void viewUser();



}
