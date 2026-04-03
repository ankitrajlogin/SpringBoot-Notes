# 🌱 Exceptions in Spring / Spring Boot

In a Spring project, exceptions occur due to failures in:

* Application logic
* Bean lifecycle
* API request handling
* Database operations
* Security

---

# 🧩 1. Core Java Exceptions

## 🔹 NullPointerException

### ✅ Definition

Occurs when we try to use an object reference that is `null`.

### ❌ Reason

* Object not initialized
* Method returns null
* Missing dependency injection

### 💻 Example

```java
String name = null;
System.out.println(name.length());
```

### 🛠️ Solution

* Use null checks
* Use `Optional`

```java
if(name != null) {
    name.length();
}
```

---

## 🔹 NumberFormatException

### ✅ Definition

Occurs when converting a string to a number fails.

### ❌ Reason

* Invalid numeric input

### 💻 Example

```java
Integer.parseInt("abc");
```

### 🛠️ Solution

* Validate input before parsing

```java
try {
    Integer.parseInt(value);
} catch (NumberFormatException e) {
    // handle error
}
```

---

# 🧩 2. Spring Bean / IoC Exceptions

## 🔹 BeanCreationException

### ✅ Definition

Thrown when Spring fails to create a bean during application startup.

### ❌ Reason

* Exception in constructor
* Misconfiguration
* Missing dependencies

### 💻 Example

```java
@Component
class A {
    public A() {
        throw new RuntimeException("Error");
    }
}
```

### 🛠️ Solution

* Fix constructor logic
* Ensure proper configuration
* Check logs carefully

---

## 🔹 NoSuchBeanDefinitionException

### ✅ Definition

Occurs when Spring cannot find a required bean in the context.

### ❌ Reason

* Missing `@Component`, `@Service`, etc.
* Wrong package scanning

### 💻 Example

```java
@Autowired
private UserService userService; // not defined as bean
```

### 🛠️ Solution

* Add annotation (`@Service`, `@Component`)
* Ensure correct component scanning

---

## 🔹 UnsatisfiedDependencyException

### ✅ Definition

Occurs when Spring cannot inject a required dependency.

### ❌ Reason

* Dependency bean missing
* Circular dependency

### 💻 Example

```java
@Service
class A {
    @Autowired
    private B b; // B is not a bean
}
```

### 🛠️ Solution

* Define all dependencies as beans
* Avoid circular dependencies

---

# 🌐 3. Spring MVC / Web Exceptions

## 🔹 HttpRequestMethodNotSupportedException

### ✅ Definition

Thrown when a request uses an unsupported HTTP method.

### ❌ Reason

* API expects GET but request is POST

### 💻 Example

```java
@GetMapping("/user")
```

### 🛠️ Solution

* Use correct HTTP method
* Add proper mappings (`@PostMapping`)

---

## 🔹 MissingServletRequestParameterException

### ✅ Definition

Occurs when a required request parameter is missing.

### ❌ Reason

* Client didn’t send required parameter

### 💻 Example

```java
@GetMapping("/user")
public String getUser(@RequestParam String name)
```

### 🛠️ Solution

* Provide parameter in request
* Make it optional

```java
@RequestParam(required = false)
```

---

## 🔹 HttpMessageNotReadableException

### ✅ Definition

Occurs when Spring cannot read/parse request body.

### ❌ Reason

* Invalid JSON
* Type mismatch

### 💻 Example

```json
{
  "age": "abc"
}
```

### 🛠️ Solution

* Validate request body
* Use correct data types

---

## 🔹 MethodArgumentNotValidException

### ✅ Definition

Occurs when validation on request body fails.

### ❌ Reason

* Violating validation rules (`@NotNull`, etc.)

### 💻 Example

```java
class User {
    @NotNull
    private String name;
}
```

### 🛠️ Solution

* Provide valid input
* Handle using `@ControllerAdvice`

---

# 🗄️ 4. Database / Spring Data Exceptions

## 🔹 DataIntegrityViolationException

### ✅ Definition

Occurs when database constraints are violated.

### ❌ Reason

* Duplicate value (unique constraint)
* Null in non-null column

### 💻 Example

```java
@Column(unique = true)
private String email;
```

### 🛠️ Solution

* Validate before saving
* Handle duplicates properly

---

## 🔹 EmptyResultDataAccessException

### ✅ Definition

Occurs when expected data is not found.

### ❌ Reason

* Deleting non-existing record

### 💻 Example

```java
repository.deleteById(10);
```

### 🛠️ Solution

* Check existence before operation

```java
if(repository.existsById(id))
```

---

## 🔹 TransactionRequiredException

### ✅ Definition

Occurs when a database operation requires a transaction but none exists.

### ❌ Reason

* Missing `@Transactional`

### 🛠️ Solution

```java
@Transactional
public void saveData() {}
```

---

# 🧬 5. Hibernate Exceptions

## 🔹 LazyInitializationException

### ✅ Definition

Occurs when a lazy-loaded entity is accessed outside session.

### ❌ Reason

* Session closed before accessing relation

### 💻 Example

```java
user.getOrders().size();
```

### 🛠️ Solution

* Use `fetch = FetchType.EAGER` (carefully)
* Or fetch inside transaction

---

# 🔐 6. Spring Security Exceptions

## 🔹 AccessDeniedException

### ✅ Definition

Occurs when user lacks required permissions.

### ❌ Reason

* Role mismatch

### 🛠️ Solution

* Configure roles properly
* Use `@PreAuthorize` correctly

---

## 🔹 AuthenticationException

### ✅ Definition

Occurs when authentication fails.

### ❌ Reason

* Invalid username/password

### 🛠️ Solution

* Validate credentials
* Configure authentication provider

---

# 🧠 7. Custom Exceptions

## 🔹 Custom Exception

### ✅ Definition

User-defined exception for business logic.

### ❌ Reason

* Business rule failure

### 💻 Example

```java
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
```

### 🛠️ Solution

* Handle globally

---

# 🌍 8. Global Exception Handling

## 🔹 Using `@ControllerAdvice`

### ✅ Definition

Centralized exception handling across application.

### 💻 Example

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handle(UserNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
```

### 🛠️ Benefits

* Clean code
* Centralized error handling
* Better API responses

---

# 🔥 Summary

## 🧠 Categories

* Core Java Exceptions → coding mistakes
* Bean Exceptions → IoC/container issues
* Web Exceptions → request/response issues
* Database Exceptions → DB constraint failures
* Security Exceptions → auth issues
* Custom Exceptions → business logic errors
