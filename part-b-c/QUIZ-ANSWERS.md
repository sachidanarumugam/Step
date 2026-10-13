# Week 10 · Part B quiz and Part C concept answers

## Part B — quiz

**Q1.** Answer: **D**

`new String("hello")` creates a distinct object each time, so `s1 == s2` is false. `equals` compares the characters, so `s1.equals(s2)` is true.

**Q2.** Answer: **B. "baL avaJ"**

`append("Java")` then `append(" Lab")` builds `"Java Lab"`. `reverse()` reverses every character, including the space: `b a L [space] a v a J`.

**Q3.** Answer: **B**

`new Student("Ravi")` directly calls `Student(String name)`. That constructor then chains with `this(name, "Not assigned")` to the two-argument constructor. The direct call is still the one-argument constructor. There is no ambiguity.

**Q4.** Answer: **D**

`w2 = w1` copies the reference, not the wallet. `w2.add(200)` changes the one object both variables name, so both balances are 700.

**Q5.** Answer: **C. 3**

`count` is static, so all `Visitor` objects share it. Each constructor increments it. Three constructions leave the count at 3. A static method can read it without an extra instance.

**Q6.** Answer: **A. 45 78 92 60 85**

The loop starts at index 0 and stops before `length`, so it prints every element from left to right. It does not reverse the array and it does not stop early.

**Q7.** Answer: **B. 1 2 4 5**

`continue` skips the rest of the body when `i` is 3. The loop still increments and continues, so 4 and 5 are printed. 3 is not printed.

**Q8.** Answer: **A. 5**

Java passes the value of `x`. `change` assigns 10 to its own parameter `n`. That does not write back into `x`, so `main` prints 5.

**Q9.** Answer: **C. 83.33333333333333**

`count` is a `double`, so `total / count` is floating-point division: 250 / 3.0. Integer division would have happened only if both operands were `int`. The printed value is the full double, not a value rounded to two places.

**Q10.** Answer: **B. Paid 510.0 by card**

`Payment p = new Card()` is legal. The variable type is abstract, but the object is a `Card`. `p.pay(500)` runs the override: fee is 500 * 0.02 = 10, and the printed amount is 510.0.

**Q11.** Answer: **B**

`String` is immutable. `name.toUpperCase()` does not change `name`. It returns a new string `"JAVA"`, which is stored in `upperName`. `name` remains `"java"`.

**Q12.** Answer: **B. 2**

`"hello"` is one pooled string, and both `s1` and `s2` refer to it. `new String("hello")` creates a second, separate string on the heap. That is two `String` objects, not three.

**Q13.** Answer: **A. 6 / m**

`"Campus"` has length 6. Index 2 is `'m'` (`C` `a` `m` `p` `u` `s`).

**Q14.** Answer: **A. 4**

In `"user@domain.com"` the `@` is at index 4. Indexes start at 0: `u` `s` `e` `r` `@`.

**Q15.** Answer: **B**

The no-argument constructor assigns `"Unknown"` and `0.0`. `getDetails()` therefore prints `Title: Unknown, Price: 0.0`.

**Q16.** Answer: **A**

The two-argument constructor stores the arguments in the fields. The print is `Title: Java Programming, Price: 450.0`.

**Q17.** Answer: **B. 2**

`new Wallet(500)` creates the first object. `w2 = w1` adds a second name for that same object. `new Wallet(500)` creates the second object. Two objects exist, and three variables name them.

**Q18.** Answer: **C**

`w1` and `w2` refer to one wallet. Adding 200 through `w2` changes that wallet, so both lines print 700.

**Q19.** Answer: **C**

`s1` and `s2` are different objects. `s1.setName("Anu")` changes only `s1`. `s2` stays `"Ravi"`.

**Q20.** Answer: **C. Total visitors: 3**

`visitorCount` is static and starts at 0. Each `new Visitor()` increments the same variable. After three objects the print is 3.

## Part C — concept questions

**Question 1.** A `String` cannot be changed after it is created. Any call that looks like a modification, such as `concat` or `toUpperCase`, builds a new string and leaves the old one as it was. Repeating that inside a loop copies a growing amount of text each time, so many temporary strings are created and later discarded. That costs time and memory. A `StringBuilder` (or `StringBuffer` when threads share it) changes one buffer in place. Build the text there, then call `toString()` once if an immutable string is needed.

**Question 2.** When a parameter and a field share a name, the parameter hides the field inside the constructor. `this.field` means the object's field. `field` alone means the parameter. For example, `public Student(String name) { this.name = name; }` stores the argument on the object. Without `this`, `name = name` would assign the parameter to itself and leave the field untouched.

**Question 3.** An object is the allocated value, with its fields, on the heap. A reference variable is a name that points at an object. It is not the object. `Wallet w2 = w1` copies the pointer. Both names then refer to one object. A change made through `w2`, such as `add(200)`, is visible through `w1`. Neither assignment copies the balance into a second wallet. A second object appears only when `new` runs again.

**Question 4.** An instance variable belongs to one object. A static variable belongs to the class and is shared. Use static data for a fact that is the same for every object, such as a college name or a count of how many students have been constructed. Use an instance field for a fact that differs per object, such as a student's name or attendance. A static count is appropriate because "how many students exist" is not a property of one student. Attendance is appropriate as an instance field because each student has their own.

**Question 5.** A `for` loop is a good fit when the number of steps is known or when an index walks an array, such as scoring five rounds or scanning every seat. A `while` loop fits when the loop should continue until a condition becomes false and the body might not run at all, such as reading digits until the remaining number is 0. A `do-while` loop runs the body once before testing, which fits a menu that must be shown at least once and then repeats until the user quits.

**Question 6.** Java always passes a copy of the value. For a primitive, the method receives a copy of the number. Assigning a new number to the parameter does not change the caller's variable, so `change(x)` cannot turn `x` from 5 into 10. For an object, the value that is copied is the reference. The method cannot replace the caller's variable with a different object by assigning the parameter, but it can change the object's fields through that reference. That is why `w2.add(200)` changes the balance seen by `w1` when both variables point at the same wallet.

**Question 7.** When both operands of `/` are integers, Java divides in integers and drops the fraction. `250 / 3` is 83, not 83.333. A floating result needs at least one floating operand, either by declaring a `double` or by casting, as in `(double) total / count`. The cast must apply before the division. Casting the already-truncated result, `(double) (total / count)`, still yields 83.0.

**Question 8.** Encapsulation keeps an object's data private and allows changes only through methods that protect the rules. In Java, `private` stops other classes from reading or writing the field. Getters can expose a safe view, such as a balance or a score, without handing out the raw data. Setters, when they exist, can reject bad values. A piggy bank with private savings, `deposit`, and `withdraw` can refuse a withdrawal that is larger than the savings. A public field could not enforce that, because any code could assign any number.

**Question 9.** `==` compares references for objects: it asks whether both variables point at the same object. `equals` is meant to compare contents. The version inherited from `Object` behaves like `==` until a class overrides it. Two `new String("hello")` objects are not `==`, but `equals` returns true because `String` overrides it to compare characters. If a class such as `IdCard` does not override `equals`, two cards with the same name and the same number of books are still not equal under `equals`. Overriding `equals` (and `hashCode`) makes content comparison possible. The hall-ticket exercise still uses `==` on purpose, because the question is about identity, not about equal field values.

**Question 10.** Overloading is several methods with the same name and different parameter lists in one class, or visible together through inheritance. The compiler picks the method from the argument types. `isEligible(double)` and `isEligible(double, int)` are overloads, resolved at compile time. Overriding is a subclass replacing a method with the same name and parameters. The method that runs is chosen at run time from the object's class. `Card.pay(double)` overriding `Payment.pay(double)` is overriding. `Payment p = new Card(); p.pay(500);` runs the card body even though the variable type is `Payment`.
