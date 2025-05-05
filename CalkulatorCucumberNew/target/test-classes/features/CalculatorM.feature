Feature: Calculator
  Данный фича файл содержит дополнительные сценарии использования калькулятора

 Scenario Outline: Addition
  Тест на проверку сложения
    Given I opened a calculator
    When I add <num1> and <num2>
    Then the result should be <result>

   Examples:
     | num1           | num2   | result |
     | 2              |  2     | 4      |
     | 2              | -2     | 0      |
     | 32             | 55     | 87     |


  Scenario Outline: e: Multiply
  Тест на проверку умножения
    Given I opened a calculator
    When I multiply <num4> and <num3>
    Then the result should be <result>

     Examples:
       | num4   | num3   | result |
       | 2      |  2     | 4      |
       | 3      |  7     | 21     |
       | 14     |  -22   | -308   |


  Scenario Outline: Subtract
  Тест на проверку вычитания чисел
    Given I opened a calculator
    When I subtract <num1> and <num2>
    Then the result should be <result>

    Examples:
      | num1           | num2   | result |
      | 35             |  17    | 18     |
      | -56            |  7     | -63    |
      | 89             |  -33   | 122    |


  Scenario Outline: Divide
  Тест на проверку деления
    Given I opened a calculator
    When I divide <num1> and <num2>
    Then the result should be <result>

    Examples:
      | num1           | num2   | result     |
      | 34             |  17    | 2          |
      | -39            |  3     | -13        |
      | 81             |  9     | 9          |
      | 81             |  0     | 0.00       |