# 🌱 Spring vs Spring Boot + IoC & Dependency Injection (DI)

---

# 📌 1. Introduction

The **Spring Ecosystem** is widely used for building Java applications.

Two important parts of it are:

* **Spring Framework** → Core framework
* **Spring Boot** → Simplified version of Spring

Both rely heavily on:

* **Inversion of Control (IoC)**
* **Dependency Injection (DI)**

---

# 🌱 2. Spring Framework

## 🔹 Definition

Spring is a **lightweight, open-source Java framework** used to build enterprise applications.

---

## 🔹 Key Features

* Dependency Injection (DI)
* Inversion of Control (IoC)
* Aspect-Oriented Programming (AOP)
* Spring MVC (web applications)
* Transaction management

---

## 🔹 Problem with Spring

* Requires heavy configuration (XML/Java)
* Needs external server setup
* Slower development setup

---

## 🧠 Example (Spring Configuration)

```java
@Configuration
@ComponentScan
@EnableWebMvc
public class AppConfig {
}
```

👉 Developer handles everything manually.

---

# 🚀 3. Spring Boot

## 🔹 Definition

Spring Boot is built on top of Spring to simplify development and reduce configuration.

---

## 🔹 Key Features

* Auto-configuration
* Embedded servers (Tomcat, Jetty)
* Starter dependencies
* Production-ready features (Actuator)
* Minimal setup

---

## 🧠 Example (Spring Boot)

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

👉 Just run → application starts 🚀

---

# ⚖️ 4. Spring vs Spring Boot

| Feature               | Spring Framework       | Spring Boot              |
| --------------------- | ---------------------- | ------------------------ |
| Setup                 | Manual configuration   | Auto-configuration       |
| Complexity            | High                   | Low                      |
| Server                | External (Tomcat)      | Embedded                 |
| Development Speed     | Slower                 | Faster                   |
| Configuration         | Verbose                | Minimal                  |
| Dependency Management | Manual                 | Starter dependencies     |
| Use Case              | Large, complex systems | Microservices, REST APIs |

---

## 💡 Analogy

* **Spring** → Build a car from scratch 🚗
* **Spring Boot** → Ready-to-drive car 🚙

---

# 🔁 5. Inversion of Control (IoC)

## 🔹 Definition

IoC is a design principle where:

> The control of object creation is transferred from the developer to the framework.

---

## 🧠 Without IoC

```java
class Car {
    Engine engine = new Engine();
}
```

❌ Tight coupling
❌ Hard to test

---

## ✅ With IoC

```java
class Car {
    Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }
}
```

✔ Loose coupling
✔ Better flexibility

---

## 💡 Key Idea

Framework (Spring) creates and manages objects instead of the developer.

---

# 🔌 6. Dependency Injection (DI)

## 🔹 Definition

Dependency Injection is a technique to implement IoC.

> Dependencies are provided from outside instead of being created inside the class.

---

## 🧠 Without DI

```java
class UserService {
    Database db = new Database();
}
```

---

## ✅ With DI

```java
class UserService {
    Database db;

    UserService(Database db) {
        this.db = db;
    }
}
```

---

# 🔧 7. Types of Dependency Injection

---

## 1. Constructor Injection (Best Practice ✅)

```java
class A {
    private final B b;

    public A(B b) {
        this.b = b;
    }
}
```

✔ Immutable dependencies
✔ Easier testing

---

## 2. Setter Injection

```java
class A {
    private B b;

    public void setB(B b) {
        this.b = b;
    }
}
```

✔ Optional dependencies

---

## 3. Field Injection (Not Recommended ❌)

```java
@Autowired
private B b;
```

❌ Hard to test
❌ Breaks encapsulation

---

# ⚖️ 8. IoC vs DI

| Feature  | IoC                          | DI                            |
| -------- | ---------------------------- | ----------------------------- |
| Type     | Principle                    | Technique                     |
| Meaning  | Who controls object creation | How dependencies are provided |
| Relation | Parent concept               | Implementation of IoC         |

---

# 🧠 9. Spring IoC Container

## 🔹 What is it?

Spring provides an IoC Container that:

* Creates objects (Beans)
* Manages lifecycle
* Injects dependencies

---

## 🔹 Important Terms

### 📦 Bean

An object managed by Spring container.

### 📄 Configuration

Defines how beans are created.

### 🔗 Autowiring

Automatic dependency injection.

---

## 🔹 Example

```java
@Component
class Engine {}

@Component
class Car {
    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
}
```

---

# 🚀 10. Why IoC & DI Are Important

* Loose coupling
* Easy unit testing
* Better maintainability
* Reusability
* Cleaner architecture

---

# 🎯 11. Real-Life Analogy

## IoC:

Restaurant → Chef cooks → You don’t control process

## DI:

Food is served to you → You just use it

---

# ✅ 12. Final Summary

* **Spring** → Powerful but requires configuration
* **Spring Boot** → Simplifies Spring with auto-configuration
* **IoC** → Framework controls object lifecycle
* **DI** → Dependencies are injected into objects

👉 **DI is the implementation of IoC**

---

# 🎤 Interview One-Liners

* "Spring Boot is a simplified version of Spring with auto-configuration and embedded servers."
* "IoC is a principle where control is given to the framework."
* "Dependency Injection is a technique used to implement IoC."

---
