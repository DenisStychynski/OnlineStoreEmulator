/**
 * Этот класс представляет собой исключение, которое выбрасывается при ошибке продукта.
 */
public class ProductException extends Exception {
    /**
     * Конструктор для создания нового исключения с указанным сообщением об ошибке.
     *
     * @param message Сообщение об ошибке.
     */
    public ProductException(String message) {
      super(message);
    }
  }