package view;

import controller.*;
import model.Product;

import java.util.Scanner;

public class ProductView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductController proController = new ProductController();
    private static int idGenerator = 0;

    public final void displayAddProduct() {
        System.out.println("enter your product name");
        final String name = scanner.nextLine();
        System.out.println("enter your product price");
        final double price = scanner.nextInt();
        scanner.nextLine();
        final Product product = new Product(name, price);
        idGenerator++;
        product.setId(idGenerator);

        if (proController.addProduct(product)) {
            System.out.println("Added successfully");
        } else {
            System.out.println("please enter valid product");
        }
    }

    public final void displayUpdateProduct() {
        System.out.println("please enter your id");
        final int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("please enter your new product name");
        final String newName = scanner.nextLine();
        System.out.println("please enter your new product price");
        final double newPrice = scanner.nextDouble();
        scanner.nextLine();
        if (proController.updateProduct(id, newName, newPrice)) {
            System.out.println("Updated successfully");
        } else {
            System.out.println("your user id doesn't match please try again");
        }
    }

    public final void displayDeleteProduct() {
        System.out.println("please enter your id");
        final int id = scanner.nextInt();
        scanner.nextLine();
        if (proController.deleteProduct(id)) {
            System.out.println("deleted successfully");
        } else {
            System.out.println("please enter your correct id ");
        }
    }

    public final void showProductDetails() {
            displayAddProduct();
            updateAndDelete();
    }

    public final void updateAndDelete() {
        while (true) {
            System.out.println("1. update your product");
            System.out.println("2. delete your product");
            System.out.println("3. viewProduct");
            System.out.println("4. previous");
            System.out.println("5. existing......");
            final String number = scanner.nextLine();
            switch (number) {
                case "1":
                    displayUpdateProduct();
                    break;
                case "2":
                    displayDeleteProduct();
                    break;
                case "3":
                    proController.viewProduct();
                    break;
                case "4":
                    UserView view = new UserView();
                    view.addCartAndView();
                    break;
                case "5":
                    System.exit(3);
                    break;
                default:
                    System.out.print("enter valid number");
            }
        }
    }
}