# 🌱 Spring Core Concepts — Complete Notes

---

# 📌 1. What is a Bean?

A **Bean** is simply an object that is:

* Created
* Managed
* Controlled
  by the **Spring IoC Container**.

👉 Instead of:

```java
Vehicle v = new Vehicle();
```

👉 We use:

```java
Vehicle v = context.getBean(Vehicle.class);
```

---

# 📌 2. @Configuration and @Bean

## 🔹 @Configuration

* Marks a class as a **source of bean definitions**
* Spring processes it and registers beans

```java
@Configuration
class Config {}
```

---

## 🔹 @Bean

Used to manually define a bean

```java
@Bean
Vehicle vehicle() {
    Vehicle v = new Vehicle();
    v.setName("Toyota");
    return v;
}
```

---

## 🔥 Important Concept: Proxy Behavior

If `@Configuration` is present:

```java
person.setVehicle(vehicle());
```

👉 This does NOT create a new object
👉 Spring intercepts and returns the SAME bean

---

# 📌 3. Ways to Create Beans

## ✅ 1. @Bean

* Manual creation

## ✅ 2. @Component

* Automatic detection

## ✅ 3. @Service

* Business logic layer

## ✅ 4. @Repository

* Data access layer

## ✅ 5. @Controller

* Web layer

---

# 📌 4. Stereotype Annotations

| Annotation  | Purpose         |
| ----------- | --------------- |
| @Component  | Generic bean    |
| @Service    | Business logic  |
| @Repository | Database access |
| @Controller | Web layer       |

👉 All are internally `@Component`

---

# 📌 5. Bean Lifecycle Hooks

## 🔹 @PostConstruct

* Runs after bean creation

## 🔹 @PreDestroy

* Runs before bean destruction

```java
@PostConstruct
public void init() {}

@PreDestroy
public void destroy() {}
```

---

# 📌 6. Bean Wiring (Dependency Injection)

## 🔥 Definition

Connecting one bean to another

---

## 🔹 Types of Injection

### 1. Constructor Injection (BEST)

```java
@Component
class Person {
    private final Vehicle vehicle;

    public Person(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
```

---

### 2. Setter Injection

```java
@Autowired
public void setVehicle(Vehicle vehicle) {}
```

---

### 3. Field Injection (NOT RECOMMENDED)

```java
@Autowired
private Vehicle vehicle;
```

---

# 📌 7. final with @Autowired

## ✅ Works ONLY with constructor

```java
private final Vehicle vehicle;
```

## ❌ Not with field injection

Reason:

* Field injection happens AFTER object creation
* final requires initialization DURING construction

---

# 📌 8. Constructor Injection — Internal Flow

1. Spring creates dependency (Vehicle)
2. Finds constructor in Person
3. Calls:

```java
new Person(vehicle)
```

👉 Dependency injected during creation

---

# 📌 9. @Bean vs @Component

| Feature      | @Bean             | @Component          |
| ------------ | ----------------- | ------------------- |
| Creation     | Manual            | Automatic           |
| Wiring       | Manual            | Automatic           |
| Proxy needed | Yes               | No                  |
| Usage        | Config / external | Application classes |

---

# 📌 10. Multiple Beans Problem

If two beans exist:

```java
@Component
Vehicle vehicle;

@Bean
Vehicle myfavVehicle();
```

👉 Error:

```
NoUniqueBeanDefinitionException
```

---

## ✅ Solutions

### 1. Use name

```java
context.getBean("myfavVehicle", Vehicle.class);
```

### 2. Use @Primary

```java
@Primary
```

### 3. Use @Qualifier

```java
@Qualifier("myfavVehicle")
```

---

# 📌 11. getBean() Methods

## ✅ Correct

```java
getBean("name", Class)
getBean(Class)
```

## ❌ Wrong

```java
getBean(Class, "name")
```

---

# 📌 12. Singleton Behavior

Spring beans are singleton by default

```java
vehicle == person.getVehicle() → true
```

👉 Only ONE object created

---

# 📌 13. Layered Architecture

```
Controller → Service → Repository
```

| Layer      | Responsibility  |
| ---------- | --------------- |
| Controller | Handle requests |
| Service    | Business logic  |
| Repository | DB access       |

---

# 📌 14. Common Mistakes

❌ Mixing @Component and @Bean unnecessarily

❌ Wrong import (different package class)

❌ Field injection with final

❌ Wrong getBean() usage

---

# 📌 15. Key Takeaways

* Spring manages objects (IoC)
* Beans are singleton by default
* Constructor injection is best
* @Configuration enables proxy behavior
* @Component is preferred for real projects

---

# 🎯 Interview Summary

* Bean = object managed by Spring
* DI = injecting dependencies
* @Configuration = defines beans
* @Component = auto bean creation
* Constructor injection = best practice
* @PostConstruct = init method
* @PreDestroy = cleanup method

---

# 🚀 Final Insight

👉 Spring is about:

```
Loose Coupling + Dependency Injection + Centralized Management
```
