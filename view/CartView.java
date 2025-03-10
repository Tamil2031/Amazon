package view;

import controller.CartController;

import java.util.Scanner;

public class CartView {
    private static final CartController controller = new CartController();
    private static final Scanner scanner = new Scanner(System.in);

    public final void  addProductToCart() {
        while (true) {
            System.out.println("1. addToCart");
            System.out.println("2. proceed to pay");
            System.out.println("3. previous");
            System.out.println("4. viewCart");
            final String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addToCart();
                    break;
                case "2":
                    System.out.println("paying successful");
                    final UserView view = new UserView();
                    view.addCartAndView();
                    break;
                case "3":
                    final UserView viewUser = new UserView();
                    viewUser.addCartAndView();
                case "4":
                    cartView();
            }
        }
    }

    public final void addToCart(){
        controller.availableProduct();
        System.out.println("enter your product id");
       final int id = scanner.nextInt();
        scanner.nextLine();
        controller.addProductToCart(id);
    }

    public final void cartView(){
        System.out.println("enter your product id");
       final int id = scanner.nextInt();
       scanner.nextLine();
       controller.viewCart(id);
    }

    public final void addTotalAmount(){
        System.out.println("1. quantity");
        System.out.println("2. total amount");
    }
}