# Maven, POM, Dependencies, JAR & settings.xml — Complete Notes

---

# 📌 1. What is Maven?

**Maven** is a **build automation and dependency management tool** for Java projects.

### ✅ Key Responsibilities:

* Dependency Management
* Build Automation
* Standard Project Structure

---

## 🔹 Why Maven is Needed?

### ❌ Without Maven:

* Manually download JAR files
* Handle dependencies yourself
* Manage classpath manually
* Build process is complex

### ✅ With Maven:

* Dependencies auto-downloaded
* One command builds project
* Clean and standard structure

---

## 🔹 Maven Project Structure

```
project/
 ├── src/
 │   ├── main/java
 │   ├── main/resources
 │   └── test/java
 ├── pom.xml
 └── target/
```

---

## 🔹 Maven Lifecycle

| Phase   | Purpose                |
| ------- | ---------------------- |
| clean   | Remove old build files |
| compile | Compile Java code      |
| test    | Run test cases         |
| package | Create JAR/WAR         |
| install | Store in local repo    |
| deploy  | Upload to remote repo  |

---

# 📌 2. What is `pom.xml`?

**POM = Project Object Model**

It is the **core configuration file of a Maven project**.

---

## 🔹 Purpose of `pom.xml`

* Define project details
* Add dependencies
* Configure build process
* Set Java version

---

## 🔹 Example

```xml
<project>
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
    <version>1.0</version>

    <dependencies>
        <!-- dependencies here -->
    </dependencies>
</project>
```

---

## 🔹 Important Elements

| Element      | Meaning            |
| ------------ | ------------------ |
| groupId      | Organization name  |
| artifactId   | Project name       |
| version      | Project version    |
| dependencies | External libraries |

---

## ❌ Without `pom.xml`

* Maven will not work
* No dependency management
* No build automation

---

# 📌 3. Maven Dependency

Example:

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>7.0.3</version>
</dependency>
```

---

## 🔹 Explanation

### 1. groupId → Organization

* Identifies who created the library
* Example: `org.springframework`

---

### 2. artifactId → Library Name

* The actual module/library
* Example: `spring-context`

---

### 3. version → Library Version

* Specifies exact version
* Example: `7.0.3`

---

## 🔹 Unique Identity

```
groupId + artifactId + version
```

---

## 🔹 Transitive Dependencies

Maven automatically downloads:

* Required sub-dependencies
* No manual work needed

---

# 📌 4. Without Maven vs With Maven

---

## ❌ Without Maven

```
project/
 ├── lib/
 │    ├── spring-core.jar
 │    ├── spring-context.jar
 │    ├── many more jars...
 ├── src/
 └── out/
```

### Problems:

* Manual dependency download
* Version conflicts
* Hard to manage

---

## ✅ With Maven

```
project/
 ├── src/
 ├── pom.xml
 └── target/
```

### Benefits:

* Automatic dependency management
* Standard structure
* Easy build

---

# 📌 5. What is JAR?

**JAR = Java ARchive**

A **compressed file containing compiled Java code and resources**.

---

## 🔹 Structure of JAR

```
app.jar
 ├── META-INF/
 │    └── MANIFEST.MF
 ├── com/example/Main.class
 └── resources
```

---

## 🔹 Contents

* `.class` files (compiled code)
* Resources (config files)
* Manifest file

---

## 🔹 Create JAR

```
mvn package
```

---

## 🔹 Run JAR

```
java -jar app.jar
```

---

## 🔹 Types of JAR

### 1. Normal JAR

* Only project code
* Needs external dependencies

### 2. Fat JAR (Executable JAR)

* Contains all dependencies
* Directly runnable

---

## 🔹 Importance

* Easy distribution
* Platform independent
* Clean packaging

---

# 📌 6. `.m2` Directory

```
~/.m2/
 ├── repository/
 └── settings.xml
```

---

## 🔹 repository/

* Stores downloaded dependencies
* Local cache

---

# 📌 7. What is `settings.xml`?

A **configuration file for Maven execution** (not project-specific).

---

## 🔹 Purpose

* Configure repositories
* Store credentials
* Setup proxy
* Define mirrors

---

## 🔹 Example

```xml
<settings>

    <localRepository>/custom/path</localRepository>

    <servers>
        <server>
            <id>my-repo</id>
            <username>user</username>
            <password>pass</password>
        </server>
    </servers>

    <mirrors>
        <mirror>
            <id>central</id>
            <mirrorOf>central</mirrorOf>
            <url>https://repo.url</url>
        </mirror>
    </mirrors>

</settings>
```

---

## 🔹 Key Sections

| Tag             | Purpose                 |
| --------------- | ----------------------- |
| localRepository | Change storage location |
| servers         | Authentication          |
| mirrors         | Redirect repositories   |
| proxies         | Network proxy           |

---

# 📌 8. Global vs User Settings

---

## 🔹 Global Settings

Location:

```
Maven/conf/settings.xml
```

* Applies to all users

---

## 🔹 User Settings

Location:

```
~/.m2/settings.xml
```

* Applies only to current user

---

## 🔹 Priority Order

```
Global Settings < User Settings
```

👉 User settings override global settings

---

## 🔹 Why This Design?

* Flexibility
* Security (credentials)
* Developer customization

---

# 📌 9. Difference: `pom.xml` vs `settings.xml`

| Feature  | pom.xml        | settings.xml       |
| -------- | -------------- | ------------------ |
| Scope    | Project        | User/System        |
| Shared   | Yes            | No                 |
| Purpose  | Project config | Maven behavior     |
| Contains | Dependencies   | Credentials, proxy |

---

# 📌 Final Summary

* **Maven** automates build and dependency management
* **pom.xml** defines project structure and dependencies
* **Dependencies** are external libraries identified by groupId, artifactId, version
* **JAR** is a packaged Java application
* **settings.xml** configures Maven environment
* **.m2** stores dependencies locally

---

# 🚀 One-Line Summary

> Maven simplifies Java development by automating dependency management, build processes, and project structure, making development faster and more scalable.

---
