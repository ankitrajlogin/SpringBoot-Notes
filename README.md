# SpringBoot-Notes

# 📘 Inversion of Control (IoC) & Dependency Injection (DI) — Complete Notes

---

## 1️⃣ What is Inversion of Control (IoC)?

### ✅ Definition
**Inversion of Control (IoC)** is a **design principle** in which the **control of object creation, dependency management, and program flow** is transferred from the application code to an external entity (framework or container).

> Instead of *your code controlling everything*, the **framework controls it**.

---

### 🔑 Key Idea
- Traditional approach → *You control object creation*
- IoC approach → *Control is inverted*

📌 **“Don’t call the framework, the framework calls you.”**

---

### 🔁 Control Flow Comparison

**Without IoC**
Class A → creates → Class B

markdown
Copy code

**With IoC**
Container / External code → creates → Class B
→ injects → Class A

yaml
Copy code

---

### 🧠 Important Points
- IoC does **not provide code structure**
- IoC defines **who controls whom**
- IoC is **high-level architectural thinking**

---

### ❌ What IoC is NOT
- ❌ Not a design pattern
- ❌ Not a framework
- ❌ Not code-specific

---

## 2️⃣ Why IoC is NOT a Design Pattern

| Design Pattern | Design Principle |
|--------------|----------------|
| Concrete solution | General guideline |
| Has structure | Has philosophy |
| Directly implementable | Achieved using patterns |

📌 **IoC is a principle**, because:
- It does not tell *how* to code
- It tells *how control should flow*

---

## 3️⃣ What is Dependency Injection (DI)?

### ✅ Definition
**Dependency Injection (DI)** is a **design pattern** used to **implement the IoC principle**, where dependencies are **provided to a class from the outside** rather than created inside it.

> Dependencies are *injected*, not constructed.

---

### 🧩 What is a Dependency?
If a class **uses another class**, that other class is a **dependency**.

Example:
Car → Engine
PaymentService → PaymentMethod

yaml
Copy code

---

## 4️⃣ Relationship Between IoC and DI

Inversion of Control (Principle)
↑
Dependency Injection (Pattern)

yaml
Copy code

### ✔ Correct Understanding
- **IoC** → WHAT should happen
- **DI** → HOW it happens

---

### ❌ Common Confusion (Wrong)
- “IoC and DI are the same” ❌
- “IoC is a design pattern” ❌

---

## 5️⃣ Types of Dependency Injection

### 1️⃣ Constructor Injection (Best Practice)
```java
class Service {
    private Dependency dep;

    Service(Dependency dep) {
        this.dep = dep;
    }
}
```

✔ Mandatory dependency
✔ Immutable
✔ Best for testing

2️⃣ Setter Injection
java
Copy code
class Service {
    private Dependency dep;

    void setDependency(Dependency dep) {
        this.dep = dep;
    }
}
✔ Optional dependency
❌ Can be misused

3️⃣ Field Injection (Least Recommended)
java
Copy code
@Autowired
Dependency dep;
❌ Hard to test
❌ Hidden dependencies

6️⃣ How IoC is Achieved (Using Design Patterns)
IoC can be implemented using multiple design patterns:

Pattern	Role
Dependency Injection	Inject dependencies
Factory Pattern	Delegate object creation
Service Locator	Lookup dependencies
Template Method	Framework controls flow
Observer Pattern	Inverted event handling

7️⃣ Real-World Analogy 🚗
❌ Without IoC
You:

Design engine

Build gearbox

Assemble car

✅ With IoC
You:

Order a car

Just drive it

📌 You focus on business logic, not object management.

8️⃣ IoC in Frameworks (Conceptual)
Frameworks like Spring are IoC Containers

They:

Create objects

Manage lifecycle

Inject dependencies

Control execution flow

📌 Frameworks use DI internally to follow IoC.

9️⃣ Benefits of IoC & DI
Aspect	Benefit
Coupling	Loose coupling
Testing	Easy mocking
Maintenance	Clean code
Flexibility	Easy replacement
Scalability	High

🔟 Interview-Ready One-Line Answers
❓ Is Inversion of Control a design pattern?
❌ No. IoC is a design principle.

❓ What is Dependency Injection?
✅ DI is a design pattern used to implement IoC.

❓ Can IoC exist without DI?
✅ Yes, using Factory or Service Locator patterns.

❓ Why is constructor injection preferred?
✅ It ensures mandatory dependencies and improves testability.

🧠 Final Mental Model (Very Important)
IoC changes WHO controls the program
DI changes HOW dependencies are supplied






# 📘 Spring Bean Creation & Lazy Initialization — Complete Notes

---

## 1️⃣ Default Spring Bean Behavior

### 🔹 How Spring Creates Beans by Default
- Scope: **singleton**
- Creation time: **application startup**
- Result: **ALL singleton beans are created eagerly**

```java
@Component
class DieselEngine 
```

📌 Even if DieselEngine is never used, Spring still creates it.

2️⃣ Is This a Problem?
❌ Common Concern
“Spring creates objects that are not needed, wasting memory.”

✅ Reality
This behavior is intentional and beneficial.

3️⃣ Why Spring Creates Beans Eagerly (Design Reasons)
Spring eagerly creates beans to:

✔ Detect configuration errors early
✔ Validate the full dependency graph
✔ Fail fast (startup-time errors > runtime errors)
✔ Improve runtime performance (no creation delay later)
✔ Ensure predictable application behavior

📌 Fail fast is preferred in enterprise systems.

4️⃣ When Eager Creation Becomes a Problem
Eager creation may be inefficient when:

Bean initialization is expensive

Many implementations of an interface exist

Features are rarely used

Plugins / strategies are optional

Large microservices with multiple variants

📌 In such cases, lazy initialization is required.

5️⃣ How to Avoid Unnecessary Bean Creation
Spring provides multiple mechanisms to control bean creation.

6️⃣ @Lazy Annotation (Most Common Solution)
✅ Lazy Bean Creation
java
Copy code
```
@Component
@Lazy
class DieselEngine {
    public DieselEngine() {
        System.out.println("DieselEngine created");
    }
}
```

```
@Autowired
@Lazy
private DieselEngine engine;
```

📌 Bean is created only when accessed for the first time.

🧠 Behavior
mathematica
Copy code
Application starts
→ DieselEngine NOT created

First usage
→ DieselEngine created
✔ Simple
✔ Effective
✔ Widely used

7️⃣ ObjectProvider (Best Practice for Advanced Use)
✅ Industry-Grade Lazy Injection

```
@Service
public class CarService {

    private final ObjectProvider<Engine> engineProvider;

    public CarService(ObjectProvider<Engine> engineProvider) {
        this.engineProvider = engineProvider;
    }

    public void drive() {
        Engine engine = engineProvider.getObject();
        engine.start();
    }
}
```

📌 Bean is created only when getObject() is called

✔ No unnecessary beans
✔ Used internally by Spring
✔ Best for large systems

8️⃣ @Conditional — Create Bean Only If Needed

```
@Component
@ConditionalOnProperty(
    name = "engine.type",
    havingValue = "electric"
)
class ElectricEngine implements Engine {
}
```

properties
```
engine.type=electric
```
📌 If condition fails → bean is never created

✔ Zero memory
✔ Zero startup cost

9️⃣ @Profile — Environment-Based Bean Creation

```
@Profile("prod")
@Component
class ElectricEngine implements Engine {
}
```

properties
```
spring.profiles.active=prod
```

📌 Only beans of the active profile are created.

✔ Best for dev / test / prod separation

🔟 Problem with Map Injection (Important)
❌ Issue
java
Copy code
Map<String, Engine> engines;
➡️ Spring creates ALL Engine beans eagerly

✅ Optimized Solution: Lazy Map Injection
java
```
@Component
public class EngineFactory {

    private final Map<String, ObjectProvider<Engine>> engines;

    public EngineFactory(Map<String, ObjectProvider<Engine>> engines) {
        this.engines = engines;
    }

    public Engine getEngine(String type) {
        return engines.get(type).getObject();
    }
}
```
📌 Engine is created only when selected

🔥 Enterprise-level optimization

1️⃣1️⃣ Is Spring Wasting Memory?
❌ No
Reasons:

Beans are usually lightweight

Heavy resources are pooled

JVM memory management is efficient

Lazy options exist when required

📌 Spring prioritizes correctness + safety by default.

1️⃣2️⃣ When Should You Use Lazy Beans?
✅ Use Lazy When:
Bean creation is expensive

Multiple implementations exist

Rarely used features

Strategy-based systems

Plugin architectures

❌ Avoid Lazy When:
Core infrastructure beans

Early failure detection is important

Small or simple applications

🎯 Interview-Ready One-Liners
❓ Does Spring create unnecessary beans?
By default, Spring eagerly creates singleton beans for early validation, but lazy creation can be enabled when needed.

❓ How do you prevent unnecessary bean creation?
Using @Lazy, ObjectProvider, @Profile, or @Conditional.

❓ Which is the best lazy approach?
ObjectProvider for fine-grained control.

🧠 Final Mental Model
vbnet
Copy code
Default Spring → Safe & Eager
Optimized Spring → Lazy & Controlled
Developer decides the trade-off
✅ Final Takeaway
Spring is not inefficient by default.
It is safe by default and configurable by design.

