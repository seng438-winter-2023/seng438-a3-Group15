**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#: 15          |     |
| --------------------- | --- |
| Student Names:        |     |
| Carlos Morera Pinilla |     |
| Neil Adrian Sarmiento |     |
| Hassan Anwar          |     |
| Toshi Biswas          |     |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Extending from our Black Box test suite from the previous lab on the JFreeGraph SUT. We will now be creating test cases using various White Box
Techniques learned in class and depending on the class to test, employing various forms of coverage and attempting to improve the current code coverage from a exisiting test suite or creating a test suite for a class to get a certain threshold of coverage.

# 2 Manual data-flow coverage calculations for X and Y methods

CALCULATECOLUMNTOTAL:
![Control Flow  Graph for Column Total](./media/Calculate_Column_CFG.jpg)

- Def Use Table: (Where node 1 will be )
  | Def | Use |
  | --------------------- | --- |
  | DEF(0) = {data, column} | USE(0) = Ø |
  | DEF(1) = Ø | USE(1) = data |
  | DEF(2) = {total} | USE(2) = Ø |
  | DEF(3) = {rowCount} | USE(3) = Ø |
  | DEF(4) = {r} | USE(4) = Ø |
  | DEF(5) = Ø | USE(5) = {r, rowCount}|
  | DEF(6) = {r2} | USE(6) = Ø |
  | DEF(7) = Ø | USE(7) = {r2, rowCount} |
  | DEF(8) = {n} | USE(8) = {r2, column}|
  | DEF(9) = Ø | USE(9) = {n}|
  | DEF(10) = Ø | USE(10) = {r2}|
  | DEF(11) = Ø | USE(11) = {total, n} |
  | DEF(12) = Ø | USE(12) = Ø |
  | DEF(13) = {n} | USE(13) = {data, r, column} |
  | DEF(14) = Ø | USE(14) = {n} |
  | DEF(15) = Ø| USE(15) = {total, n} |
  | DEF(16) = Ø | USE(16) = {r}|

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

For this assignment, we decided to use OpenClover because during the execution, it automatically gives the classes, three different metrics. Statement, Branch and Method coverage. Eclemma did not make clear which coverage metric it was calculating, as it only reports the coverage ratio as a whole average of every different metric.

Pros of OpenClover:

- Easy to test and sort metrics of classes.
- Much neater and easy to install.

Pros of Eclemma:

- Already included when you install Eclipse.
- Easy to run tests.

Cons of OpenClover:

- Not as intuitive to run tests, you need to select the project as a whole to test.

Cons of Eclemma:

- Does not report the various metrics, it was hard to find out what metrics were being tested.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Advantages of Requirements-Based Testing:

- Much quicker way to test important functionality of methods in a class.
- Makes planning a test suite easier.
- Ensures quickly that requirements are correct, complete and logically consisent.
- Smaller Test Suite

Advantages of Coverage-Based Testing:

- Much more powerful in terms of testing logical execution of methods in a class.
- Better at tracking and finding bugs in a system that are more obscure.
- Due to more coverage of methods, it increases software quality indirectly.

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Getting the control flow coverage higher.

# 10 Comments/feedback on the lab itself

Text…
