package ru.levelp.at.lesson12.design.patterns.builder.model;

public class User {

    private final String username;
    private final String email;
    private final String password;

    User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{"
            + "username='" + username + '\''
            + ", email='" + email + '\''
            + ", password='" + password + '\''
            + '}';
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {

        private String username;
        private String email;
        private String password;

        UserBuilder() {

        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(username, email, password);
        }
    }
}
