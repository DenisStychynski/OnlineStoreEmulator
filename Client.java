
public class Customer {
   
    private String lastName;
    
    private String firstName;
    
    private int age;
    
    private String phone;
    
    
  
    /**
     * @param lastName Фамилия клиента.
     * @param firstName Имя клиента.
     * @param age Возраст клиента.
     * @param phone Номер телефона клиента.
     */
    public Customer(String lastName, String firstName, int age, String phone) {
      setLastName(lastName);
      setFirstName(firstName);
      setAge(age);
      setPhone(phone);
      }
  
    
  
    /**
     * @return Возврат фамилия клиента.
     */
    public String getLastName() {
      return lastName;
    }
  
    /**
     * Если фамилия равна null или пустая строка, выбрасывается исключение IllegalArgumentException.
     *
     * @param lastName Фамилия клиента.
     */
    public void setLastName(String lastName) {
      if (lastName == null || lastName.isEmpty()) {
        throw new IllegalArgumentException("Last name cannot be null or empty.");
      }
      this.lastName = lastName;
    }
  
    /**
     * @return Имя клиента.
     */
    public String getFirstName() {
      return firstName;
    }
  
    /**
     * Если имя равно null или пустая строка, выбрасывается исключение IllegalArgumentException.
     * 
     * @param firstName Имя клиента.
     */
    public void setFirstName(String firstName) {
      if (firstName == null || firstName.isEmpty()) {
        throw new IllegalArgumentException("First name cannot be null or empty.");
      }
      this.firstName = firstName;
    }
  
    /**
     * @return Возраст клиента.
     */
    public int getAge() {
      return age;
    }
  
    /**
     *  Если возраст меньше нуля, выбрасывается исключение IllegalArgumentException.
     *
     * @param age Возраст клиента.
     */
    public void setAge(int age) {
      if (age < 0 || age > 120) {
        throw new IllegalArgumentException("Age must be between 0 and 150.");
      }
      this.age = age;
    }
  
    /**
     * @return Номер телефона клиента.
     */
    public String getPhone() {
      return phone;
    }
  
    /**
     *  Если номер телефона равен null или пустая строка, выбрасывается исключение IllegalArgumentException.
     *
     * @param phone Номер телефона клиента.
     */
    public void setPhone(String phone) {
      if (phone == null || phone.isEmpty() || !phone.matches("\\d+")) {
        throw new IllegalArgumentException("Phone number cannot be null or empty or contain non-digit characters");
      }
      this.phone = phone;
    }
  
  
  
    /**
     * @return Строковое представление объекта клиента.
     */
    @Override
    public String toString() {
      return
          lastName + " " + firstName + '\n' +
              " Возраст " + age + '\n' +
              " телефон " + phone + '\n';
    }
  
  }