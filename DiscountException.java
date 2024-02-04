/**
 * Этот класс представляет собой исключение, которое выбрасывается при слишком большой скидке.
 */
public class DiscountException extends Exception {
    /**
     * @param message Сообщение об ошибке.
     */
    public DiscountException(String message) {
      super(message);
    }
  }