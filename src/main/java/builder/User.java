package builder;

public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;

    public User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        String str = "";
        str += "The firstName is: \"" + firstName + "\"\n";
        str += "The lastName is: \"" + lastName + "\"\n";

        if (age > 0) {
            str += "The age is: \"" + age + "\"\n";
        }
        if (phone != null) {
            str += "The phone is: \"" + phone + "\"\n";
        }
        if (address != null) {
            str += "The address is: \"" + address + "\"\n";
        }
        return str;
    }

    static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user1 = new UserBuilder("Ali", "Jaber")
                .age(23)
                .phone("079xxxx")
                .address("Amman")
                .build();
        System.out.println(user1);
        User user2 = new UserBuilder("Bashar", "Rawa")
                .age(24)
                .address("Amman")
                .build();
        System.out.println(user2);
        User user3 = new UserBuilder("Ali", "Jaber")
                .build();
        System.out.println(user3);
    }
}
