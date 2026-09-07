# Restaurant Ordering System

A Java-based restaurant ordering application developed during
my first semester of Information Technology at UTS College.

## Overview

The Restaurant Ordering System simulates a simple restaurant ordering process.

Users can:

- Select a dessert or main dish
- Enter a new dish name
- Enter a new dish price
- Prepare the selected dish
- Calculate the final price
- View the restaurant menu
- View dishes prepared by the baker

The project was developed to apply object-oriented programming concepts in Java.

---

## Technologies & Concepts

- Java
- Object-Oriented Programming
- Classes and Objects
- Constructors
- Encapsulation
- Inheritance
- Method Overriding
- Polymorphism
- ArrayList
- Loops
- User Input
- Getters and Setters
- `toString()`
- Scanner

---

## Class Structure

### Project

Contains the `main()` method and controls the restaurant ordering process.

### Dish

Parent class containing common dish information such as:

- Name
- Price
- `prepare()`
- `calculatePrice()`

### Dessert

Extends the `Dish` class.

It provides specialised dessert behaviour including:

- Dessert preparation
- Cold status
- Additional dessert pricing

### MainDish

Extends the `Dish` class.

It provides specialised main-dish behaviour including:

- Cooking status
- Main-dish preparation
- Additional main-dish pricing

### Baker

Stores information about the baker and manages an `ArrayList` of prepared dishes.

### In

Uses Java `Scanner` to handle keyboard input.

---

## OOP Example

The following code demonstrates inheritance and method overriding.

```java
class Dessert extends Dish {

    private boolean cold;

    Dessert(String name, double price, boolean cold) {
        super(name, price);
        this.cold = cold;
    }

    @Override
    public void prepare() {
        this.cold = true;

        System.out.println(
            getName() + " is prepared and enjoy your meal :)"
        );
    }

    @Override
    public double calculatePrice() {
        return getPrice() + 2.0;
    }
}
