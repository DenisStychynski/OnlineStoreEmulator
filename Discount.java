
public enum Discount {
    /**
     * Без скидки.
     */
    NO_DISCOUNT(0),
    /**
     * Скидка 5%.
     */
    DISCOUNT_5(0.05),
    /**
     * Скидка 10%.
     */
    DISCOUNT_10(0.10),
    /**
     * Скидка 15%.
     */
    DISCOUNT_15(0.15),
    /**
     * Скидка 20%.
     */
    DISCOUNT_20(0.20);
  
    /**
     * Значение скидки в долях от единицы.
     */
    private final double value;
  
    /**
     * @param value Значение скидки в долях от единицы.
     */
    Discount(double value) {
      this.value = value;
    }
  
    /**
     * @return Значение скидки в долях от единицы.
     */
    public double getValue() {
      return value;
    }
  
  }