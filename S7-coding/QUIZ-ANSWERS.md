# Week 7 · S7 coding sheet — quiz and concept answers

These 20 questions follow the five coding problems in the same PDF.

## Part B — multiple choice

**Question 1.** Answer: **C. Polymorphism**

Repeated `if` / `else if` checks on document type, followed by `render()`, mean the caller is choosing behavior that each document already knows. Polymorphism lets a `Document` reference call `render()` and run the PDF or Word version. Encapsulation hides data. Overloading picks a method by the argument list at compile time. Abstraction is the broader idea of hiding how something works, but the fix for this conditional is polymorphic dispatch.

**Question 2.** Answers: **A, B, and C**

- A `Car` is a `Vehicle`.
- A `Rectangle` is a `Shape`.
- A `DatabaseConnection` is a `NetworkResource`.

D is not inheritance. A helper that *contains* a calculator is a has-a relationship (composition).

**Question 3.** Answer: **C. Runtime method dispatch**

`Car` and `Motorcycle` override `startEngine()`. A `Vehicle` reference still runs the method of the real object. That choice is made when the call happens, not when the code is compiled. Overloading and static binding are compile-time.

**Question 4.** Answer: **C. Inheritance-based polymorphism**

`Circle` and `Rectangle` each implement `calculateArea()`, and the program calls that method through `Shape` references. The same call does different work depending on the object. That is not overloading, method hiding, or composition.

**Question 5.** Answers: **A, C, and D**

- `Book.getLoanPeriod()` adds a new-release rule on top of the inherited idea, so it extends inherited behavior.
- `LibraryItem` is where the shared loan-period operation is declared.
- A `DVD` object can be held and processed as a `LibraryItem`.

B is not a good description. The DVD version replaces the loan period with a fixed value. That is overriding, not "shared behavior."

**Question 6.** Answers: **A and C**

- An `Animal` reference that points at a `Dog` still runs `Dog.makeSound()`.
- `Dog.makeSound()` is overridden behavior.

B is backwards: `Animal.makeSound()` is the general behavior, and the dog and cat versions are the specialized ones. D is false. A subclass can add methods the base class never declared.

**Question 7.** Answer: **C**

`PaymentProcessor` loops over `Payment` references and calls `calculateFee()`. A new `WalletPayment` subclass can be dropped into that collection. The loop does not change. The new type does not have to use the same fee math, and this design is not mainly about security or about avoiding fields.

**Question 8.** Answer: **A**

Inheriting only to copy methods, when there is no real is-a relationship, ties unrelated classes together and makes later changes risky. It does not automatically make programs slower, and it does not ban interfaces.

**Question 9.** Answers: **A and C**

- A `NotificationSender` can call `send()` without knowing whether the object is email, SMS, or push.
- A new channel such as `InAppNotification` is another subclass. Existing sender code keeps calling `send()`.

B is the opposite of this design: the channel-specific work lives in the subclasses, not in one giant `Notification` class. D is also the opposite: each channel overrides `send()` because the delivery is different.

**Question 10.** Answers: **A, B, and C**

A list of base-type references is easy to loop over, each object still uses its own method, and the loop usually needs no cast. D is false. Adding a derived type is easier, not harder.

## Concept questions

**Question 1.** Inheritance lets a specialized class start from a base class instead of rewriting shared fields and methods. The subclass keeps that behavior, and it can add fields or override a method when its rule is different. A payroll system can define `Employee` with `name` and `monthlySalary()`. `FullTimeEmployee` inherits the name and overrides the pay method to return 10% as a festival bonus, while `Intern` overrides it to return a flat 2000. Both are still employees, so a payroll list of `Employee` can pay either kind.

**Question 2.** An is-a relationship means every object of the subclass really is a kind of the base type and can stand in for it. A `Car` is a `Vehicle`. A `Wallet` is not a `Database` just because both open and close. Inheritance is the right tool only for a genuine is-a link. Using it without that link forces the subclass to carry behavior and changes that do not belong to it, and callers may treat the object as something it is not.

**Question 3.** Method overriding is a subclass supplying its own body for a method the base class already declared, with the same name and parameters. A company can declare `Employee.bonus()`. `FullTimeEmployee` returns 10% of salary, `PartTimeEmployee` returns 5%, and `Intern` returns 2000. The payroll code calls `bonus()` on an `Employee` reference. The object that was actually constructed decides which body runs.

**Question 4.** Runtime polymorphism means the method that runs is chosen from the real object's class while the program is running, even when the variable's type is the base class. The JVM looks at the object the reference points to, finds that class's override, and calls it. If `Payment p = new CardPayment()`, then `p.calculateFee()` runs the card version. If the same variable later refers to a wallet payment, the wallet version runs. The call site does not contain a type test.

**Question 5.** A polymorphic collection stores base-type references, while the objects inside may be different subclasses. A `List<Payment>` can hold a card payment, a wallet payment, and a bank transfer. One loop calls `adjustedAmount()` on each element. The advantage is that the loop stays the same when behavior differs, and a new payment type can be added by writing a new class rather than editing the loop.

**Question 6.** Type-based conditionals put every rule in one method: `if card`, `else if wallet`, `else if bank`. Every new type edits that method, and it is easy to forget a branch. Polymorphism puts each rule in the class that owns it and lets the caller use one method call. The caller depends on the base type, not on the full list of subtypes, so the design stays open to new kinds of the same thing.

**Question 7.** Shared processing code should depend on the base type. Adding a subclass does not require a change to that code if it only calls base methods. A payment processor that loops over `Payment` and calls `calculateFee()` already works for card and bank transfer. Introducing `WalletPayment` means writing the class, implementing `calculateFee()` with the 1% rule, and placing instances in the existing collection. The iteration logic stays as it is.

**Question 8.** Inherited behavior is a method the subclass uses exactly as the base class wrote it. Overridden behavior is a method the subclass replaces. A `LibraryItem` might inherit `getTitle()` unchanged because every item has a title and the formatting does not change. `Book` would override `getLoanPeriod()` when books follow a 14-day rule and new releases follow a shorter one. Inherit when the base body is already correct. Override when the subclass has a different rule for the same operation.

**Question 9.** Inheritance for reuse alone says "I want these methods" without saying "this object is one of those." The subclass is then stuck with the parent's fields, protected details, and future changes. Callers can pass it where the parent is expected, which is a lie if the is-a relationship is not real. A common result is a fragile hierarchy that breaks when the parent changes, and a design that should have used a helper object or an interface instead.

**Question 10.** In a vehicle rental desk, every rental has a customer, a start date, and a way to compute a charge. Those belong on `VehicleRental`. A car rental and a truck rental differ in the daily rate, the deposit, and maybe a truck weight surcharge. Those differences belong in `CarRental` and `TruckRental`, usually by overriding `charge()`. The desk can keep a list of `VehicleRental` and call `charge()` on each. Common steps stay in the base class. Specialized pricing stays in the subclass.
