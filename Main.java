import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

  
  private static final int MAX_QUANTITY = 80;
 
  private static final int RANDOM_QUANTITY_BOUND = 8;
 
  private static final String CLIENT_NOT_FOUND = "Несуществующий покупатель";
  
  private static final String PRODUCT_NOT_FOUND = "Несуществующий товар";
  
  private static final String INVALID_QUANTITY = "Некорректное количество товара";

  /**
   * Создает клиентов и продукты, совершает случайные покупки и выводит результаты.
   * @param args Аргументы командной строки (не используются).
   */
  public static void main(String[] args) {
    List<Customer> clients = createClients();
    List<Product> products = createProducts();

    List<Order> orders = new ArrayList<>();
    try {
      Order order1 = makeRandomPurchase(clients, products);
      addOrder(orders, order1);

      Order order2 = makeRandomPurchase(clients, products);
      addOrder(orders, order2);

      Order order3 = makeRandomPurchase(clients, products);
      addOrder(orders, order3);

      Order order4 = makeRandomPurchase(clients, products);
      addOrder(orders, order4);

    } catch (ClientException | ProductException | SumException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("Количество совершенных покупок: " + orders.size());
  }

  /**
   * @return Список клиентов.
   */
  public static List<Client> createClients() {
    List<Client> clients = new ArrayList<>();
    clients.add(new Client("Дмитриев", "Дмитрий", 25, "1234567890"));
    clients.add(new Client("Василенко", "Василиса", 20, "9876543210"));
    clients.add(new Client("Кузьмина", "Анна", 35, "5746374534"));
    clients.add(new Client("Чекан", "Виктор", 30, "2437546697"));
    return clients;
  }

  /**
   * @return Список продуктов со случайными скидками.
   */
  public static List<Product> createProducts() {
    List<Product> products = new ArrayList<>();
    products.add(new Product("Квас", 100.0, Category.NORMAL));
    Product.assignRandomDiscount();
    products.add(new Product("Пельмени", 200.0, Category.PREMIUM));
    Product.assignRandomDiscount();
    products.add(new Product("Молоко", 300.0, Category.NORMAL));
    Product.assignRandomDiscount();
    products.add(new Product("Хлеб", 250.0, Category.PREMIUM));
    Product.assignRandomDiscount();
    products.add(new Product("Вода", 450.0, Category.NORMAL));
    Product.assignRandomDiscount();
    products.add(new Product("Сыр", 350.0, Category.PREMIUM));
    Product.assignRandomDiscount();
    return products;
  }

  /**
   *  Если заказ для этого клиента уже существует, выводится сообщение об этом.
   *
   * @param orders Список заказов.
   * @param order  Заказ, который нужно добавить.
   */
  public static void addOrder(List<Order> orders, Order order) {
    orders.stream()
        .filter(existingOrder -> existingOrder.getClient().equals(order.getClient()))
        .findFirst()
        .ifPresent(existingOrder -> {
          System.out.println(
              "Заказ для покупателя " + order.getClient().getFirstName() + " уже существует");
        });

    orders.add(order);
    System.out.println("Добавлен заказ: " + '\n' + order);
  }

  /**
   * Создает случайный заказ.
   *
   * @param clients Список клиентов.
   * @param products  Список продуктов.
   * @return Случайный заказ.
   */
  public static Order makeRandomPurchase(List<Client> clients, List<Product> products)
      throws ClientException, ProductException, SumException {
    Client randomClient = getRandomElement(clients);
    Product randomProduct = getRandomElement(products);
    int randomQuantity = getRandomQuantity();

    return makePurchase(randomClient, randomProduct, randomQuantity);
  }

  /**
   * Создает заказ с указанными параметрами.
   *
   * @param customer Клиент, который сделал заказ.
   * @param product  Продукт, который был заказан.
   * @param quantity Количество заказанного продукта.
   * @return Заказ с указанными параметрами.
   */
  public static Order makePurchase(Client client, Product product, int quantity)
      throws ClientException, ProductException, SumException {
    if (quantity < 0 || quantity > MAX_QUANTITY) {
      throw new SumException("Неверное количество товара");
    }

    double cost = calculateCost(product.getPrice(), quantity);
    Order order = new Order(client, product, quantity);

    return order;
  }

  /**
   * Возвращает случайный элемент из списка.
   *
   * @param list Список элементов.
   * @return Случайный элемент из списка.
   */
  public static <T> T getRandomElement(List<T> list) {
    Random random = new Random();
    int randomIndex = random.nextInt(list.size());
    return list.get(randomIndex);
  }

  /**
   * Возвращает случайное количество продукта.
   *
   * @return Случайное количество продукта.
   */
  public static int getRandomQuantity() {
    Random random = new Random();
    return random.nextInt(RANDOM_QUANTITY_BOUND) - 1;
  }

  /**
   * Вычисляет стоимость заказа на основе цены и количества продукта.
   *
   * @param price    Цена продукта.
   * @param quantity Количество продукта.
   * @return Стоимость заказа.
   */
  public static double calculateCost(double price, int quantity) {
    return price * quantity;
  }

  /**
   * Если клиент равен null, выбрасывается исключение ClientException.
   *
   * @param customer Клиент для проверки.
   */
  public static void validateClient(Client client) throws ClientException {
    if (client == null) {
      throw new ClientException(CLIENT_NOT_FOUND);
    }
  }

  /**
   * Eсли продукт равен null, выбрасывается исключение
   * ProductException.
   *
   * @param product Продукт для проверки.
   */
  public static void validateProduct(Product product) throws ProductException {
    if (product == null) {
      throw new ProductException(PRODUCT_NOT_FOUND);
    }
  }

  /**
   * Если количество меньше или равно нулю или больше максимального значения, выбрасывается исключение SumException.
   *
   * @param quantity Количество продукта для проверки.
   */
  public static void validateQuantity(int quantity) throws SumException {
    if (quantity <= 0 || quantity > MAX_QUANTITY) {
      throw new SumException(INVALID_QUANTITY);
    }
  }
}