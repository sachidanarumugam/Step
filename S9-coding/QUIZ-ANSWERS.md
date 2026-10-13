# Week 9 · S9 coding sheet — quiz and concept answers

## Part B — quiz

**Q1.** Answer: **C**

Abstraction hides how an object does its work and shows only what it does. Showing every internal detail is the opposite. Protecting fields from direct access is encapsulation. Inheriting from many classes is a language rule about inheritance, not the definition of abstraction.

**Q2.** Answer: **C**

An abstract class cannot be instantiated with `new`, even when it has no abstract methods. Java does not require an abstract class to contain an abstract method. An abstract class extends only one other class.

**Q3.** Answer: **B**

A concrete subclass must implement every inherited abstract method. If it does not, it has to be declared abstract itself. Otherwise the code does not compile. Java does not invent an empty body, and this is not delayed until runtime.

**Q4.** Answer: **C. private**

An abstract method must be visible to the subclass that implements it. `private` is not allowed. `public`, `protected`, and package-private (no modifier) are allowed. `static`, `final`, and `private` are the modifiers that cannot appear on an abstract method; among the listed choices, `private` is the one that is not allowed.

**Q5.** Answer: **C**

A field written in a Java interface is implicitly `public`, `static`, and `final`. It is a constant shared by the interface, not a private or per-object field.

**Q6.** Answer: **C**

A class may implement any number of interfaces. It may also extend one class at the same time.

**Q7.** Answer: **D. public**

Interface methods are public. The implementing method must be public as well. A weaker modifier would narrow the access and would not compile.

**Q8.** Answer: **C**

A class can extend only one class because two parent classes could both contribute instance fields and method bodies for the same member, which is the diamond problem. An interface does not carry instance state. A class can implement several interfaces, and if two of them supply the same default method, the class must resolve that clash itself.

**Q9.** Answer: **D**

If two interfaces provide a default method with the same signature and the class does not override it, the compiler reports an error. Java does not pick the first or the last interface, and it does not wait until the method is called.

**Q10.** Answer: **B**

An abstract class can have a constructor. That constructor runs when a subclass object is created, before the subclass constructor body. It does not create an object of the abstract class by itself. Interfaces do not have constructors. Concrete classes do.

## Part C — concept questions

**Question 1.** Abstraction means the user sees the operation and not the steps inside it. A metro gate is a clear example that is not a payment or shape example: the rider taps a card and the gate opens or stays shut. The rider is shown the result. Hidden details include how the balance is read, how the fare table is chosen, and how the turnstile motor is driven. The gate's public action is "tap to enter." The machinery stays behind that action.

**Question 2.** Abstraction decides which operations are visible. Encapsulation decides who may touch the data those operations use. They work together in one class: the class exposes a small set of methods (abstraction) and keeps the fields private so only those methods change them (encapsulation). A locker exposes `changeCode(current, next)` and hides the combination. Callers know what they can do. They cannot read or overwrite the code directly, so the "current code must match" rule cannot be skipped.

**Question 3.** An abstract class cannot be created with `new` because it may still have unfinished methods. It can still have a constructor so subclasses share setup of common fields. That constructor runs as the first step of constructing a subclass object, when the subclass calls `super(...)`. A `Ticket` constructor can store the ticket count and leave `pricePerTicket()` abstract. `Regular` and `Premium` call that constructor, then supply their own price. No plain `Ticket` object is ever created.

**Question 4.** An abstract method cannot be `private` because a subclass in another class must be able to override it, and private methods are not visible or overridable. It cannot be `static` because overriding is based on the object the call is made on, and a static method belongs to the class, not to an object. It cannot be `final` because `final` forbids overriding, while an abstract method exists specifically so a subclass will provide the body. Those three modifiers each contradict the reason an abstract method exists.

**Question 5.** The diamond problem appears when a class inherits from two parents that both provide a method or a field of the same name. The child then has two competing copies or two competing bodies, and the language must decide which one is used. Java avoids that for classes by allowing only one superclass. A class may implement many interfaces because interfaces do not carry instance fields. If two interfaces still bring the same default method, Java refuses to guess and requires the class to override the method, so the conflict is explicit instead of silent.
