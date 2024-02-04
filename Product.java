import java.util.Random;

/**
 * Этот класс представляет собой продукт.
 */
public class Product {

  /**
   * Название продукта.
   */
  private String name;
  /**
   * Цена продукта.
   */
  private double price;
  /**
   * Категория продукта.
   */
  private String category;
  /**
   * Размер скидки на продукт.
   */
  private static DiscountSize discountSize;

  /**
   * Конструктор для создания нового продукта с указанными параметрами.
   *
   * @param name     Название продукта.
   * @param price    Цена продукта.
   * @param category Категория продукта.
   */
  public Product(String name, double price, String category) {
    setName(name);
    setPrice(price);
    setCategory(category);
    this.discountSize = DiscountSize.NO_DISCOUNT;
  }

  /**
   * Присваивает случайный размер скидки продукту.
   */
  public static void assignRandomDiscount() {
    DiscountSize[] discounts = DiscountSize.values();
    Random random = new Random();
    int index = random.nextInt(discounts.length);
    DiscountSize randomDiscount = discounts[index];

    Product product = new Product("Sample Product", 100.0,
        Category.NORMAL);  // Создаем экземпляр класса Product
    try {
      product.setDiscountSize(
          randomDiscount);  // Вызываем метод setDiscountSize() на экземпляре класса Product
    } catch (TooMuchSaleException e) {
      System.out.println("TooMuchSaleException: " + e.getMessage());
    }
  }

  // Геттеры и сеттеры

  /**
   * Возвращает название продукта.
   *
   * @return Название продукта.
   */
  public String getName() {
    return name;
  }

  /**
   * Устанавливает название продукта. Если название равно null или пустая строка, выбрасывается
   * исключение IllegalArgumentException.
   *
   * @param name Название продукта.
   */
  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Product name cannot be null or empty.");
    }
    this.name = name;
  }

  /**
   * Возвращает цену продукта.
   *
   * @return Цена продукта.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Устанавливает цену продукта. Если цена меньше нуля, выбрасывается исключение
   * IllegalArgumentException.
   *
   * @param price Цена продукта.
   */
  public void setPrice(double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Product price cannot be negative.");
    }
    this.price = price;
  }

  /**
   * Возвращает категорию продукта.
   *
   * @return Категория продукта.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Устанавливает категорию продукта. Если категория равна null, выбрасывается исключение
   * IllegalArgumentException.
   *
   * @param category Категория продукта.
   */
  public void setCategory(String category) {
    if (category == null) {
      throw new IllegalArgumentException("Category cannot be null.");
    }
    this.category = category;
  }

  /**
   * Возвращает размер скидки на продукт.
   *
   * @return Размер скидки на продукт.
   */
  public DiscountSize getDiscountSize() {
    return discountSize;
  }

  /**
   * Устанавливает размер скидки на продукт. Если размер скидки равен null, выбрасывается исключение
   * IllegalArgumentException. Если категория продукта является премиум и размер скидки больше 15%,
   * выбрасывается исключение TooMuchSaleException.
   *
   * @param discountSize Размер скидки на продукт.
   */
  public void setDiscountSize(DiscountSize discountSize) throws TooMuchSaleException {
    if (discountSize == null) {
      throw new IllegalArgumentException("Discount size cannot be null.");
    }
    if (this.category == Category.PREMIUM && discountSize.getValue() > 0.15) {
      throw new TooMuchSaleException(
          "Discount greater than 15% is not allowed for premium products.");
    }
    this.discountSize = discountSize;
  }

  /**
   * @return Строковое представление объекта продукта.
   */
  @Override
  public String toString() {
    return
        "Название " + name + '\n' +
            " Цена " + price + '\n' +
            " Категория " + category + '\n' +
            " Скидка " + discountSize + '\n';
  }
}