/**
 * Этот класс представляет собой заказ.
 */
public class Order {

    /**
     * Клиент, который сделал заказ.
     */
    private Customer customer;
    /**
     * Продукт, который был заказан.
     */
    private Product product;
    /**
     * Количество заказанного продукта.
     */
    private int quantity;
    /**
     * Общая цена заказа.
     */
    private double totalPrice;
  
    /**
     * Конструктор для создания нового заказа с указанными параметрами.
     *
     * @param customer Клиент, который сделал заказ.
     * @param product  Продукт, который был заказан.
     * @param quantity Количество заказанного продукта.
     */
    public Order(Customer customer, Product product, int quantity) {
      setCustomer(customer);
      setProduct(product);
      setQuantity(quantity);
      calculateTotalPrice();
    }
  
    // Геттеры и сеттеры
  
    /**
     * Возвращает клиента, который сделал заказ.
     *
     * @return Клиент, который сделал заказ.
     */
    public Customer getCustomer() {
      return customer;
    }
  
    /**
     * Устанавливает клиента, который сделал заказ. Если клиент равен null, выбрасывается исключение
     * IllegalArgumentException.
     *
     * @param customer Клиент, который сделал заказ.
     */
    public void setCustomer(Customer customer) {
      if (customer == null) {
        throw new IllegalArgumentException("Customer cannot be null.");
      }
      this.customer = customer;
    }
  
    /**
     * Возвращает продукт, который был заказан.
     *
     * @return Продукт, который был заказан.
     */
    public Product getProduct() {
      return product;
    }
  
    /**
     * Устанавливает продукт, который был заказан. Если продукт равен null, выбрасывается исключение
     * IllegalArgumentException.
     *
     * @param product Продукт, который был заказан.
     */
    public void setProduct(Product product) {
      if (product == null) {
        throw new IllegalArgumentException("Product cannot be null.");
      }
      this.product = product;
    }
  
    /**
     * Возвращает количество заказанного продукта.
     *
     * @return Количество заказанного продукта.
     */
    public int getQuantity() {
      return quantity;
    }
  
    /**
     * Устанавливает количество заказанного продукта. Если количество меньше или равно нулю,
     * выбрасывается исключение IllegalArgumentException.
     *
     * @param quantity Количество заказанного продукта.
     */
    public void setQuantity(int quantity) {
      if (quantity <= 0 || quantity > 100 ) {
        throw new IllegalArgumentException("Quantity must be greater than zero and less than or equal to 100");
      }
      this.quantity = quantity;
      calculateTotalPrice();
    }
  
    /**
     * @return Общая цена заказа.
     */
    public double getTotalPrice() {
      return totalPrice;
    }
  
    /**
     * Вычисляет общую цену заказа на основе количества и цены продукта с учетом скидки.
     */
    private void calculateTotalPrice() {
      double discountedPrice = product.getPrice() * (1 - product.getDiscountSize().getValue());
      totalPrice = quantity * discountedPrice;
    }
  
  
    /**
     * @return Строковое представление объекта заказа.
     */
    @Override
    public String toString() {
      return
          "Покупатель " + customer + '\n' +
              " Продукт " + product + '\n' +
              " Количество " + quantity + '\n' +
              " Цена итого " + totalPrice + '\n';
    }
  }