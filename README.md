
![CI](https://github.com/NascentKiosk/Sustainable-Product-and-Recycling-Management-System/actions/workflows/ci.yml/badge.svg)

## Sustainable Product and Recycling Management System

---

## Team Members & Roles

* Timothy Juma – Material domain & services
* Karla Kanizaj – Impact calculation strategies
* Peniel Mensah – Architecture & UML diagrams
* Jannatul Bushra – Testing & CI setup

## Project Overview

This project is a console-based application designed to support sustainable consumption and production (SDG 12). The system manages products and materials, calculates environmental impact using interchangeable strategies, and provides recycling guidance.  
The focus is on object-oriented design, clean architecture, and testability.

---

## Objectives

* Apply object-oriented design principles
* Implement the Strategy pattern for impact calculation
* Separate business logic from presentation (console UI)
* Ensure testability with unit tests
* Use professional Git workflow and CI practices

---

## Core Features

* Product management (create, list, view details)
* Material management (define reusable materials)
* Environmental impact calculation (multiple strategies)
* Recycling guidance for single and mixed materials

---

## Architecture

The system follows a layered architecture:

* **Presentation Layer**: Console-based UI (menus, input/output)
* **Application Layer**: Services handling use cases
* **Domain Layer**: Core business logic and models

---

## Development Plan Week 1

## Git Workflow

* `main` branch is protected
* All work is done in feature branches
* Pull Requests are required for merging
* At least one approval is required before merge

### Branch naming :

* `feature/product-management`
* `feature/material-model`
* `docs/requirements`
* `docs/uml-diagram`

---

### Functional

* Create product
* Assign materials to product
* Define material with impact value
* Calculate environmental impact
* Provide recycling guidance
* List and view products

### Non-functional

* Console-based application
* Testable and maintainable design
* Clear separation of concerns
* Continuous Integration required

---

## Development Plan

* Week 1–3: Analysis, design, and architecture (no business logic)
* Week 4+: Implementation and testing

---

## Documentation

* UML class diagram
* Sequence diagram
* Strategy pattern explanation

---

## Development Plan Week 2
<br>
<br>

![My Image](./images/UML_V2_noNotes.jpg.jpeg)

## Class and responsibilities sentences
---------------------------

### Product 
Represents a physical item in the recycling system, encapsulating its identity and composition. It owns its name, category, lifespan, and the list of materials it is made of. Product does not calculate impact or provide recycling guidance, it delegates those responsibilities to the appropriate services.

### Material 
Is a reusable domain concept representing a physical substance and its environmental recyclability profile. It owns its name, impact value, and recycling category/instruction. Material does not calculate or derive anything, it simply exposes its properties for others to use.

### ImpactCalculationStrategy 
Is a contract that defines interchangeable environmental impact calculation rules. It declares a single method for calculating the impact of a product based on its materials. It does not implement any logic itself, concrete classes implement and override this method to provide specific calculation strategies.

### RecyclingGuide 
Is responsible for providing recycling guidance for single and mixed materials. It simply takes in an input in the form of material(s) and gives a recommendation or guidance in return. It does not handle user interaction or presentation concerns, those belong to the presentation layer.

### Category 
Represents the classification of a material within the recycling domain. It owns a single descriptive value that identifies the material type. It has no identity of its own and does not perform any logic, it exists purely as an immutable data descriptor.

### Lifespan 
Represents the estimated durability of a product over time. It owns a single value expressing duration. It has no identity of its own and does not perform any logic, it exists purely as an immutable data descriptor attached to a Product.

## Week 3: Design rationale

### UML diagram V2
<br>
<br>

![My Image](./images/UML_V3.jpeg)

Association relationship between Product class and ProductApplicationService has been reversed, now the relationship indicates that ProductApplicationService uses instances of Product. Keep in mind that while not defined, the relationship between ProductApplicationService class and Product class is also a usage dependency relationship and a creation dependency relationship.


Our former App class violated DIP from the UML week2. App (merged into Product ApplicationService now) should not depend on Menu, as App is a high-level module and Menu is a low-level module. This violates DIP. The changes we have made are: 
1. App class no longer exists as it is merged into ProductApplicationService.
2. Menu is the one depending on Product ApplicationService.
3. Product ApplicationService depends on interfaces Material_repository and Product_repository (both are abstractions). We are using a constructor injection to provide dependencies (instances of both interfaces) to Product ApplicationService. 

The listed changes are visible in our updated UML. However, one of the potential on-going issues in the updated UML is that SRP might still be violated in ProductApplicationService due to improper separation of concerns (by adding methods belonging to MaterialService). If that is the case, then we are mixing two different responsibilities (handle methods related to Product class & handle methods related to Material class). In such a case, we have thought of a potential improvement to the UML diagram: 
1. Add MaterialService class.
2. Move createMaterial() from ProductApplicationService to MaterialService. Now MaterialService will take care of adding materials to the list of possible reusable materials, while ProductApplicationService will take care of methods related to the Product class. The reason for this is because we have not found information on if we are not allowed to inject objects into other classes muiltiple times if need be.
3. Add repo1 (derived from Material_repository abstract interface) as a field to MaterialService. MaterialService will need access to the material repository in order to perform its method.

Whether we decide to move forward with this change is going to depend on the Week3 project meeting. 

Additionally, on Lecture 3 slides, page 20, there are examples for each protocol applied that need to be in our new UML diagram. These statements are true for our program: 
1. Product is a domain concept — it does not calculate impact scores or render UI (satisfies SRP).
2. A new impact strategy is a new class — existing classes require no modification (satisfies OCP).
3. The application depends on the ImpactCalculationStrategy interface, not any concrete implementation (satisfies DIP).


## Week 4: Explanation of architectural decisions

<br>
<br>

![My Image](./images/walking_skeleton_file_image.jpg)
### 1.
#### domain/
Category.java,<br> 
ImpactCalculationStrategy.java, <br>
Material_repository.java, <br>
Material.java, <br>
Product_repository.java, <br>
Product.java, <br>
RecyclingGuide.java <br>

#### application/
MaterialService.java, <br>
ProductApplicationService.java, <br>
Simple_Sum_Strategy.java, <br>
Weighted_Sum_Strategy.java <br>

#### presentation/
Menu.java <br>

#### infrastructure/
In_memory_repository_product.java <br>
In_memory_repository_material.java <br>

#### Our composition root -> Main.java

### 2.	ImpactCalculationStrategy interface 
Impacts our business rules, and since it does, it belongs in the domain layer. If a class/interface contains business rules (calculates impact of product), the result of what we are trying to achieve is usually affected (the impact value of product will change depending on which implemented class we decide to inject into ProductApplicationService) and the way the result is reached is affected (we are likely going to do calculations with different fields/attributes to achieve different values).

####  Material_repository & Product_repository interface 
Repository interfaces; part of domain, implemented in infrastructure. Thanks to the interface declaration in the domain layer, detailed implementation in the infrastructure layer can be flexibly modified without worrying about changing domain logic. The domain layer should not be concerned with persistence (how), only indicate what the program needs to run (like ingredients in a fridge). Repository interfaces are implemented in the infrastructure layer because the domain layer should be the most stable out of all of our layers, so ideally we should build around it and not change their existing entities. Having repositories as interfaces inside of the domain layer contributes to loose coupling and abstraction purposes. Tightly coupled code relies on a concrete implementation, but loosely coupled code relies on abstraction. Our high level modules (belonging to application layer/domain layer) should depend on abstractions.



### 3.	Dependency direction of ImpactCalculationStrategy 
ProductApplicationService receives an ImpactCalculationStrategy via its constructor — this is an example of constructor injection. This way we are also respecting the dependency inversion of Application layer depending on Domain layer, as an interface belongs to the caller (in this case Domain layer) and not implementer (in our case Application layer). 

#### Dependency direction of Material_repository 
MaterialService receives an Material_repository via its constructor (constructor injection). Respects the dependency inversion: Application layer depends on Domain layer, as an interface belongs to the caller (in this case Domain layer) and not implementer (in our case Infrastructure layer). 

#### Dependency direction of Product_repository 
ProductApplicationService receives a Product_repository via its constructor (constructor injection). Respects the dependency inversion: Application layer depends on Domain layer, as an interface belongs to the caller (in this case Domain layer) and not implementer (in our case Infrastructure layer). 

## Week 5 - Console UI and Separation of Concerns
No required deliverables for documentation other than the code.

## Week 6 - Code Review & Design Refinement

Unfortunately, it was difficult to pinpoint exactly who worked on each implementation detail, as up until this point we have had our development process mostly in our Whatsapp group and meetings on GoogleMeet. However, we had been working together, splitting up when needed to help implement a functionality to our program as soon as possible. Once the transfer of our latest code is added to our Github repository, we will continue working through Github codespaces. For this week’s deliverables, we have focused on refactoring changes that need to happen in both versions of our code (the one uploaded to Github), and the latest version of the code that we have posted in the Whatsapp group.  

### Responsibilities:

#### Does each class have exactly one reason to change? 

Paniel: Yes, aside from MaterialService class. A domain class should not not calculate anything or interact with the UI. A good example of a class with a clean single responsibility is Product class, while MaterialService class mixes presentation (formatting) and application layer concerns (handling operations related to Material objects).

Timothy: Not Completely. Classes like CreateProductResult, DisplayProductDetailsResult and ProvideGuidanceResult exist mainly to support workflows/output handling. This leads to the spread of responsibilities across classes. Much better way will be having clearer single responsibilities like: Menu → user interaction, ProductApplicationService → orchestrates use cases, Product/Material → domain data + behavior, strategy classes → impact calculation only, repositories → data storage only.

Karla: Only MaterialService violates SRP, as its responsibilities are now too many. In listMaterials(), it formats information before returning it and the class itself is otherwise responsible for containing methods which handle Material objects (and need access to the material repository).

Bushra: Most classes follow the Single Responsibility Principle well. Result classes such as ProvideGuidanceResult, CreateProductResult, ListProductsResult, and DisplayProductDetailsResult are only responsible for transferring data between layers and do not contain business logic. ProductService is mainly responsible for product-related operations such as creating products, finding products, and adding materials to products.  ApplicationService now acts mostly as an orchestration layer between services, which is an improvement compared to the previous structure. However, it still contains some data conversion responsibilities that could later be moved into separate mapper or presenter classes.

### What to refactor for this week - group conclusion: 

Classes like CreateProductResult, DisplayProductDetailsResult and ProvideGuidanceResult do not contain business logic, and they are considered to be Data Transfer Objects (DTOs). Their only responsibility is to transfer data between the application layer and the presentation layer, hence they do not violate SRP. MaterialService violates SRP in listMaterials(), since it contains presentation layer formatting. We have decided to do a refactor for this method, where we will add a DTO object between MaterialService class and Menu class. When it comes to ApplicationService dealing with conversions such as converting String to UUID value or from UUID value to String, these are the reasons behind why they exist in the implementation of our program:
The unique identifier of each Product object is its ID. 
in order for the user to refer to a certain Product, they would need to input its id value, which would first be a String that gets converted to a UUID.
In order for ApplicationService to pass values to DTO objects, Product IDs are converted from UUID value to String form, which helps avoid making DTO objects unnecessarily depend on the UUID class.

#### Are method names specific enough to describe a single action?

Peniel: Yes. Methods like createMaterial(), initMaterials(), and find_Material() are easy to understand. Even though some names use snake case, the meaning is still clear.

Timothy: No. Some methods have mixed responsibilities. A better way will be using focused methods like calculateImpact(), addProduct(), findById() instead of broad workflow-style methods.

Bushra: Yes. Method names clearly describe their responsibilities and improve readability. Examples include: provideGuidance(), displayProductDetails(), createProduct(), assignCategoryToProduct(), addMaterialtoProduct(), etc… These methods each represent a single, understandable action, making the code easier to maintain and follow.

Karla: Yes, while going through the entirety of the program, I would have to say that the method names are generally descriptive and make their responsibilities easy to understand, which helped with my understanding of how far along in our project we have progressed and how much we still have to expand. Methods in ApplicationService such as provideGuidance(), displayProductDetails(), listPredefinedMaterials(), assignCategoryToProduct(), and addMaterialToProduct() clearly indicate the specific action each method performs. Additionally, methods createMaterial(), initMaterials(), and find_Material() from MaterialService are straightforward and self-explanatory. Even if there are a few inconsistencies with the expected Upper CamelCase naming convention, the method names still effectively communicate their purpose, making the code easy to follow and maintain.

### Layer integrity

#### Does any domain class import from the presentation layer?

Bushra: No. The uploaded classes do not contain presentation-layer dependencies such as Scanner, System.in, or direct console interaction. This indicates good separation between presentation logic and business logic. The domain and application layers remain independent from UI concerns, which helps preserve clean architecture principles. 

Paniel: No. For example, the Material class only imports: import com.mightyfour.domain.Type; It does not import: import com.mightyfour.presentation.Menu; This shows a clean separation between domain and UI.

Timothy: No. The domain layer remains independent and does not import any classes from the presentation layer. This ensures that business rules are not coupled to the user interface and helps maintain a clear layered architecture.

Karla: No, the domain layer stays independent. It does not import any classes from the presentation layer.

#### Is business logic kept out of the console/UI classes?

Group conclusion: Yes. The UI layer simply calls the services. For example; menu.menuLoop(). It does not calculate anything or manage data. The presentation layer is responsible only for handling user input and displaying output. Business operations are delegated to the application and domain layers, which helps maintain separation of concerns and makes the system easier to maintain and test. Additionally, the presentation layer is not aware of the domain objects or any business logic or rules. We believe our presentation layer is very clean in the view of object oriented design.

### Coupling

#### How many classes change if Material is renamed? 

Group conclusion: If we renamed Material to RecyclableItem, then classes such as: Product, MaterialService, and In memory repository material would need updating. This is normal for a core domain class.

#### Are collaborators injected (good) or instantiated inside (bad)?

Group conclusion: Yes. Collaborators are injected following the Dependency Inversion Principle (DIP) dependency injections, via a dependency injection technique. For example: MaterialService materialService = new MaterialService(repo1); This avoids hard-coded dependencies and makes testing easier. 

### Testability 

#### Could calculateImpact() be tested without a Scanner? 

Group conclusion: Yes. Scanner is only used in the presentation layer (and in infrastructure during instantiation).

#### Are there any static utility calls buried in domain logic? 

Group conclusion: No. There are no static utility calls, no printing, and no random behavior inside the domain or service classes. The code relies mainly on service collaboration and repository access rather than hidden static dependencies. This keeps the code predictable and easy to test.

## Week 10 - Sequence Diagram and Documentation
This project includes a sequence diagram for the “Calculate Environmental Impact” use case.
The diagram demonstrates how the Presentation layer (`Menu`) communicates with the Application layer (`ApplicationService` and `ProductService`) and finally the Domain layer (`Product`).
The sequence diagram was created directly from the Java implementation to ensure that every lifeline and method call matches the code exactly.
The diagram also models iteration behaviour using a UML `loop` fragment as required in Week 10.

### Diagram Files

![Sequence Diagram](docs/sequence-diagram.png)

# Sequence Diagram Walkthrough for Calculating Environmental Impact

## Step 1: User Starts Menu Interaction

**File Location:** `app/src/main/java/com/mightyfour/presentation/Menu.java`  
**Method:** `public void menuLoop()`

### What Happens
- Displays menu options
- Reads user input
- Routes functionality

### Matching Code

```java
user_input = readInput();

if (user_input.equals("6"))
```

### Explanation

This is the entry point for the Environmental Impact use case. When the user selects option `6`, the `Menu` class initiates the impact calculation workflow.
The `Menu` belongs to the **Presentation Layer** and is responsible only for coordinating user interaction.

---

## Step 2: Product ID Input

**File Location:** `presentation/Menu.java`

### Matching Code

```java
printOutput("Please enter product ID: ");
String product_Id_string = readInput();
```

### Explanation

The `Menu` prompts the user for a product identifier. The value is stored in `product_Id_string` and passed to the application layer.
In the sequence diagram, this is represented by the self-call responsible for collecting user input.

---

## Step 3: Strategy Input

**File Location:** `presentation/Menu.java`

### Matching Code

```java
printOutput("Please choose strategy: ");
String strategyNum = readInput();
```

### Explanation

The user selects the environmental impact calculation strategy. This value is later forwarded to `ApplicationService`.

---

## Step 4: Menu Delegates to ApplicationService

**File Location:** `presentation/Menu.java`

### Matching Code

```java
ProvideImpactValueResult result =
    serviceApp.provideImpactValue(productId_string, strategyNum);
```

### UML Arrow

```text
Menu -> AppService : provideImpactValue(productId_string, strategyNum)
```

### Explanation

This is the first cross-layer interaction. The Presentation Layer delegates the request to the Application Layer rather than performing any calculations itself.

---

## Step 5: ApplicationService Delegates to ProductService

**File Location:** `application/ApplicationService.java`

**Method**

```java
public ProvideImpactValueResult provideImpactValue(
    String productId_string,
    String strategyNum)
```

### Matching Code

```java
return serviceP.calculateImpact(productId, strategyNum);
```

### UML Arrow

```text
AppService -> ProductService : calculateImpact(productId, strategyNum)
```

### Explanation

`ApplicationService` coordinates the use case and forwards the request to `ProductService`, maintaining a clear separation of concerns.

---

## Step 6: ProductService Uses Factory

**File Location:** `application/ProductService.java`

**Method**

```java
public ProvideImpactValueResult calculateImpact(
    UUID productId,
    String strategyNum)
```

### Matching Code

```java
factory.create(strategyNum);
```

### UML Arrow

```text
ProductService -> Factory : create(strategyNum)
```

### Explanation

The factory selects the appropriate environmental impact calculation strategy.
This demonstrates the use of both the **Factory Pattern** and the **Strategy Pattern**.

---

## Step 7: Product Retrieved from Repository

**File Location:** `application/ProductService.java`

### Matching Code

```java
repo.findProduct(productId);
```

### UML Arrow

```text
ProductService -> ProductService : repo.findProduct(productId)
```

### Explanation

Before calculating the environmental impact, `ProductService` retrieves the product from the repository.

---

## Step 8: Strategy Calculates Impact

### Important Finding
The actual calculation is performed through:
```java
(factory.create(strategyNum))
    .calculateImpact(repo.findProduct(productId));
```
This means that `ProductService` does **not** directly iterate through materials.

### Potential Locations for Calculation Logic

- `application/SimpleSumStrategy.java`
- `application/WeightedSumStrategy.java`

### Explanation
Any loops or calculations involving product materials should be verified inside the strategy implementations.
The sequence diagram should reflect the actual implementation and avoid assuming that iteration occurs within `ProductService`.

---

## Step 9: Result Returned

**File Location:** `application/ProductService.java`
### Matching Code
```java
return new ProvideImpactValueResult(result);
```
### UML Arrow
```text
ProductService --> AppService : ProvideImpactValueResult
```
### Explanation
The calculated environmental impact value is wrapped in a `ProvideImpactValueResult` object and returned to the Application Layer.

---

## Step 10: Menu Displays Result

**File Location:** `presentation/Menu.java`
### Matching Code
```java
formatter.printImpactValueResult(result);
```
### UML Arrow
```text
Menu -> Menu : formatter.printImpactValueResult(result)
```
### Explanation
The Presentation Layer displays the calculated result to the user.
No business logic is executed at this stage; the layer is responsible only for presenting information.





