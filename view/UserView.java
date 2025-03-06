package view;

import controller.UserController;
import model.User;

import java.util.Scanner;

public class UserView {
    private static final UserController controller = new UserController();
    private static final Scanner scanner = new Scanner(System.in);
    private static int userIdGenerator = 0;

    public void signUp() {
        User user = new User();
        System.out.println(".......welcome to signup page.......");
        System.out.println("enter your name:");
        String userName = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();
        System.out.println("enter your email");
        String email = scanner.nextLine();
        ++userIdGenerator;
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setUserId(userIdGenerator);

        if (controller.getUserSignup(user)) {
            System.out.println("your are signUp successfully");
        } else {
            System.out.println("email already exists please use different email");
        }
        displayAmazon();
    }

    public void signIn() {
        User user = new User();
        System.out.println("enter your email:");
        String email = scanner.nextLine();
        System.out.println("enter your password:");
        String password = scanner.nextLine();
        user.setEmail(email);
        user.setUsername(password);
        if (controller.getUserSignIn(email, password)) {
            System.out.println("signIn successfully");
            addCartAndView();
        } else {
            System.out.println("your email and password mismatch");
            displayAmazon();
        }
    }

    public void addCartAndView(){
        System.out.println("1. user");
        System.out.println("2. add Product");
        System.out.println("3. cart");
        System.out.println("4. previous");
        System.out.println("5. exists");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                showUser();
                break;
            case "2":
                ProductView view = new ProductView();
                view.showProductDetails();
                break;
            case "3" :
                CartView cartView = new CartView();
                cartView.addProductToCart();
                break;
            case "4" :
                displayAmazon();
                break;
            case "5":
                System.exit(9);
        }
    }

    public void displayUpdateUser() {
        System.out.println("enter your email");
        String email = scanner.nextLine();
        System.out.println("please enter your name");
        String newName = scanner.nextLine();
        System.out.println("enter your  new password");
        String newPassword = scanner.nextLine();
        if (controller.getUserUpdate(email, newName, newPassword)) {
            System.out.println("your name and password updated successfully");
        } else {
            System.out.println("please enter your valid email");
        }
    }

    public void displayDeletedUser() {
        System.out.println("conformation do you want to delete");
        System.out.println("1.yes");
        System.out.println("2. no");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            controller.getUserDelete();
            System.out.println("deleted successfully");
        } else if (choice.equals("2")) {
            showUser();
        } else {
            System.out.println("your email doesn't match");
        }
    }

    public void  viewUser(){
        controller.viewUser();
    }

    public void showUser() {
        while (true) {
            System.out.println("1. updateUser");
            System.out.println("2. delete user");
            System.out.println("3. viewUser");
            System.out.println("5. previous");
           final String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    displayUpdateUser();
                    break;
                case "2":
                    displayDeletedUser();
                    break;
                case "3" :
                    viewUser();
                    break;
                case "5" :
                    displayAmazon();
                default:
                    System.out.println("enter valid number");
            }
        }
    }

    public void displayAmazon() {
        System.out.println(".......welcome to Amazon.......");
        System.out.println("1. signUp");
        System.out.println("2. signIn");
        System.out.println("3. exists");
        System.out.println("choose the option");
       final String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                signUp();
                break;
            case "2":
                signIn();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                displayAmazon();
        }
    }
}