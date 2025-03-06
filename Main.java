import view.UserView;
public class Main {
    public static void main(final String[] args) {
        String str = "  tamil  ";
        String result = str.trim();
        System.out.println(str);
        final UserView view = new UserView();
        view.displayAmazon();
    }
}