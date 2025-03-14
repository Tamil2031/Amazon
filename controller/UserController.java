package controller;

import model.User;
import service.UserService;
import service.UserServiceImpl;

public final class UserController {


    private static UserService service = new UserServiceImpl();
    public boolean getUserSignup(User user){
     return service.getUserSignUp(user);
    }

    public boolean getUserSignIn(String email, String password){
          return service.getUserSignIn(email, password);
    }

    public boolean getUserUpdate(final String email, final String newName, final String newPassword){
        return service.userUpdate(email, newName, newPassword);
    }

    public boolean getUserDelete(){
        return service.userDelete();
    }

    public void viewUser(){
         service.viewUser();
    }




}