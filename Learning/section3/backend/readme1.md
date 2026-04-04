# 📘 Spring Boot & API Complete Notes

---

# 🌱 1. Spring vs Spring Boot

## Spring Framework

* Comprehensive Java framework
* Features:

  * Dependency Injection (IoC)
  * AOP
  * Spring MVC
  * Transaction management
* Requires manual configuration

### Problems

* Heavy configuration
* Boilerplate code
* Needs external server

---

## Spring Boot

* Built on top of Spring
* Provides:

  * Auto-configuration
  * Embedded servers
  * Starter dependencies

### Advantages

* Faster development
* Minimal setup
* Production ready

---

## Difference

| Feature | Spring   | Spring Boot |
| ------- | -------- | ----------- |
| Config  | Manual   | Auto        |
| Server  | External | Embedded    |
| Setup   | Complex  | Easy        |
| Speed   | Slower   | Faster      |

---

# 📦 2. Spring Boot Starter

## Definition

Spring Boot Starter is a pre-configured dependency bundle.

## Example

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## Includes

* Spring MVC
* Embedded Tomcat
* Jackson
* Logging

## Benefits

* No dependency conflicts
* Clean pom.xml
* Faster setup

---

# 🌐 3. Spring MVC vs API-Based App

## Spring MVC

* Returns HTML
* Server-side rendering

Flow:

```
Client → Controller → Model → View → HTML
```

Annotation:

```java
@Controller
```

---

## API-Based (REST)

* Returns JSON
* Client handles UI

Flow:

```
Client → Controller → Service → DB → JSON
```

Annotation:

```java
@RestController
```

---

## Difference

| Feature  | MVC         | API    |
| -------- | ----------- | ------ |
| Output   | HTML        | JSON   |
| UI       | Server      | Client |
| Use Case | Traditional | Modern |

---

# 🔌 4. REST Controller & GetMapping

## @RestController

* Combination of @Controller + @ResponseBody
* Returns data instead of view

## @GetMapping

* Maps HTTP GET request to method

## Example

```java
@RestController
public class DemoController {

    @GetMapping("/home")
    public String sayHello(){
        return "Hello World";
    }
}
```

Output:

```
GET /home → Hello World
```

## HTTP Methods

| Method | Use    |
| ------ | ------ |
| GET    | Read   |
| POST   | Create |
| PUT    | Update |
| DELETE | Delete |

---

# ⚙️ 5. application.properties

## Definition

Configuration file for Spring Boot

## Location

```
src/main/resources/application.properties
```

## Examples

### Server

```properties
server.port=8081
```

### Database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=root
spring.datasource.password=1234
```

### JPA

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Custom

```properties
app.name=MyApp
```

## Usage in Code

```java
@Value("${app.name}")
private String appName;
```

## Profiles

```properties
spring.profiles.active=dev
```

---

# 🌐 6. API & REST API

## API

API is a way for systems to communicate.

## REST API

* Uses HTTP
* Stateless
* Returns JSON

## Example

```java
@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }
}
```

---

# 🔷 7. Types of APIs

## REST

* JSON based
* Most popular

## SOAP

* XML based
* Secure but heavy

## GraphQL

* Client fetches exact data

## gRPC

* Fast, binary format

## WebSocket

* Real-time communication

---

## Comparison

| API       | Format      | Use Case      |
| --------- | ----------- | ------------- |
| REST      | JSON        | Web apps      |
| SOAP      | XML         | Enterprise    |
| GraphQL   | JSON        | Flexible apps |
| gRPC      | Binary      | Microservices |
| WebSocket | JSON/Binary | Real-time     |

---

# 🧠 Final Summary

* Spring → Core framework
* Spring Boot → Simplified Spring
* Starter → Dependency bundle
* @RestController → API controller
* @GetMapping → GET request mapping
* application.properties → Configuration file
* REST API → HTTP + JSON communication

---

# 🔥 One-Line Revision

Spring Boot simplifies Spring, starters simplify dependencies, REST APIs enable communication, and application.properties controls application behavior.
