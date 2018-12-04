package pl.simpleproject;

import pl.simpleproject.api.ProductService;
import pl.simpleproject.api.UserRegisterLoginFacade;
import pl.simpleproject.entity.Boots;
import pl.simpleproject.entity.Cloth;
import pl.simpleproject.entity.enumtype.Color;
import pl.simpleproject.entity.enumtype.Material;
import pl.simpleproject.entity.enumtype.SkinType;
import pl.simpleproject.entity.Product;
import pl.simpleproject.entity.User;
import pl.simpleproject.entity.parser.ColorParser;
import pl.simpleproject.entity.parser.MaterialParser;
import pl.simpleproject.entity.parser.SkinTypeParser;
import pl.simpleproject.facade.UserRegisterLoginFacadeImpl;
import pl.simpleproject.service.ProductServiceImpl;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Log in");
        System.out.println("2 - Register");
        System.out.println("0 - Exit");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Add new product");
        System.out.println("0 - Log out");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Add shoes");
        System.out.println("2 - Add clothes");
        System.out.println("3 - Other products");
    }

    public static Product createProduct() {
        String productName;
        Float price, weight;
        Integer count;
        Color color;
        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW");
        color = ColorParser.parseStringToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        return new Product(1L, productName, price, weight, color, count);
    }

    public static Product createBootsProduct() {
        String productName;
        Float price, weight;
        Integer count, size;
        Color color;
        SkinType skinType;


        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW");
        color = ColorParser.parseStringToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.nextInt();

        System.out.println("Choose type of skin: NATURAL, ARTIFICIAL");
        skinType = SkinTypeParser.parseStringToSkinType(scanner.next());


        return new Boots(1L, productName, price, weight, color, count, size, skinType);
    }

    public static Product createClothProduct() {
        String productName, size;
        Float price, weight;
        Color color;
        Integer count;
        Material material;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW");
        color = ColorParser.parseStringToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.next();

        System.out.println("Choose one of materials: LEATHER, FUR, COTTON, WOOL, POLYESTER");
        material = MaterialParser.parseStringToMaterial(scanner.next());

        return new Cloth(1L, productName, price, weight, color, count, size, material);
    }

    public static void main(String[] args) {
        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();
        boolean appOn = true;
        boolean loggedOn = false;
        int read;

        while (appOn) {
            startMenu();
            read = scanner.nextInt();

            switch (read) {
                case 1:
                    System.out.println("Login:");
                    String loginLog = scanner.next();
                    System.out.println("Password:");
                    String passwordLog = scanner.next();
                    if (userFacade.loginUser(loginLog, passwordLog)) {
                        loggedOn = true;
                        System.out.println("You are logged on!");
                    } else {
                        System.out.println("Incorrect data!");
                    }
                    break;
                case 2:
                    System.out.println("Login:");
                    String loginReg = scanner.next();
                    System.out.println("Password:");
                    String passwordReg = scanner.next();
                    User user = new User(1L, loginReg, passwordReg);
                    if (userFacade.registerUser(user)) {
                        System.out.println("You are registered!");
                    } else {
                        System.out.println("Registration error");
                    }
                    break;
                case 0:
                    appOn = false;
                    break;
            }
            while (loggedOn) {
                loggedMenu();
                read = scanner.nextInt();

                switch (read) {
                    case 1:
                        productTypeMenu();
                        read = scanner.nextInt();
                        Product product = null;
                        switch (read) {
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;
                            case 3:
                                product = createProduct();
                                break;
                        }
                        if (productService.saveProduct(product)) {
                            System.out.println("Product has been saved");
                        } else {
                            System.out.println("Product has not been saved");
                        }
                        break;
                    case 0:
                        loggedOn = false;
                        break;
                }
            }
        }
    }
}
