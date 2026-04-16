## Sustainable Product and Recycling Management System

---

## Team Members & Roles

* Timothy Juma – Product domain & services
* Bruno Ihezie – Material domain & services
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

## Product – CRC Card
### Responsibilities:
Knows name, category, lifespan, materials
Provides material list for impact calculation

### Collaborators:
Material
ImpactCalculationStrategy
RecyclingGuide


## Material – CRC Card
### Responsibilities:
Knows name, impact value, recycling category/instruction
Exposes its properties for others to use

#### Collaborators:
Product
RecyclingGuide


## ImpactCalculationStrategy – CRC Card
### Responsibilities:
Defines contract for calculating environmental impact
Declares method all strategies must implement

### Collaborators:
Product
Material


## RecyclingGuide – CRC Card
### Responsibilities:
Provides recycling guidance for single and mixed materials
Takes material(s) as input and returns guidance

### Collaborators:
Material
