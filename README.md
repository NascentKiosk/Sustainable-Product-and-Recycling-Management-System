# Sustainable-Product-and-Recycling-Management-System-
This project describes the final project for the course. The focus is on object-oriented design, test-driven development, and professional development practices. The application shall be implemented as a structured, menu-driven console program 
<br>
<br>


![My Image](./images/UML_V2_noNotes.jpg.jpeg)

## Class and responsibilities sentences
---------------------------

### Product 
Represents a physical item in the recycling system, encapsulating its identity and composition. It owns its name, category, lifespan, and the list of materials it is made of. Product does not calculate impact or provide recycling guidance, it delegates those responsibilities to the appropriate services.

### Material 
Is a reusable domain concept representing a physical substance and its environmental recyclability profile. It owns its name, impact value, and recycling category/instruction. Material does not calculate or derive anything, it simply exposes its properties for others to use.

ImpactCalculationStrategy is a contract that defines interchangeable environmental impact calculation rules. It declares a single method for calculating the impact of a product based on its materials. It does not implement any logic itself, concrete classes implement and override this method to provide specific calculation strategies.

RecyclingGuide is responsible for providing recycling guidance for single and mixed materials. It simply takes in an input in the form of material(s) and gives a recommendation or guidance in return. It does not handle user interaction or presentation concerns, those belong to the presentation layer.

Category represents the classification of a material within the recycling domain. It owns a single descriptive value that identifies the material type. It has no identity of its own and does not perform any logic, it exists purely as an immutable data descriptor.

Lifespan represents the estimated durability of a product over time. It owns a single value expressing duration. It has no identity of its own and does not perform any logic, it exists purely as an immutable data descriptor attached to a Product.
Product – CRC Card
Responsibilities:
Knows name, category, lifespan, materials
Provides material list for impact calculation

Collaborators:
Material
ImpactCalculationStrategy
RecyclingGuide


Material – CRC Card
Responsibilities:
Knows name, impact value, recycling category/instruction
Exposes its properties for others to use

Collaborators:
Product
RecyclingGuide


ImpactCalculationStrategy – CRC Card
Responsibilities:
Defines contract for calculating environmental impact
Declares method all strategies must implement

Collaborators:
Product
Material


RecyclingGuide – CRC Card
Responsibilities:
Provides recycling guidance for single and mixed materials
Takes material(s) as input and returns guidance

Collaborators:
Material
