### MAS - Mini-project 3

Abstraction and polymorphism
    dynamic.PersonDynamic {abstract} - multi_inheritance.Customer / Employer
    polymorphism - getType() method

Overlapping
dynamic.PersonDynamic - overlapping.DeveloperOverlapping / overlapping.ProductOwnerOverlapping

Multiple inheritance
    dynamic.PersonDynamic - multi_inheritance.Customer / multi_inheritance.Supplier - multi_inheritance.CustomerSupplier (discount)

Multiple aspect inheritance
    dynamic.PersonDynamic - role (overlapping.ProductOwnerOverlapping, overlapping.DeveloperOverlapping, multi_inheritance.Customer)
    dynamic.PersonDynamic - gender (dynamic.FemaleDynamic, dynamic.MaleDynamic)

Dynamic inheritance
    dynamic.PersonDynamic - dynamic.MaleDynamic / dynamic.FemaleDynamic

