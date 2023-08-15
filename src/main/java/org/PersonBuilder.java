package org;

public class PersonBuilder implements IPersonBuilder {
    private String name = null;
    private String surname = null;
    private Integer age = null;
    private String address = null;

    public PersonBuilder setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Укажите корректное имя");
        }

        this.name = name;

        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname.isEmpty()) {
            throw new IllegalArgumentException("Укажите корректную фамилию");
        }

        this.surname = surname;

        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Укажите корректный возраст");
        }

        this.age = age;

        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Укажите корректный адрес");
        }

        this.address = address;

        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Отсутствуют обязательные параметры");
        }

        Person person;

        if (this.age != null) {
            person = new Person(
                name,
                surname,
                age
            );
        } else {
            person = new Person(
                name,
                surname
            );
        }

        person.setAddress(address);

        return person;
    }
}
