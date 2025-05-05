Feature: Calculator
  Данный фича файл содержит сценарии использования калькулятора

  Scenario: Addition
  Тест на проверку сложения
    Given I opened a calculator
    When I add 2 and 2
    Then the result should be 4

  Scenario: Addition negative number
  Тест на проверку сложения отрицательных чисел
    Given I opened a calculator
    When I add 2 and -2
    Then the result should be 0

  Scenario: Multiply
  Тест на проверку умножения
    Given I opened a calculator
    When I multiply 2.0 and 3.0
    Then the result should be 6.0

  Scenario: Multiply negative
  Тест на проверку умножения отрицательных чисел
    Given I opened a calculator
    When I multiply 2.0 and -7.0
    Then the result should be -14.0

  Scenario: Subtract
  Тест на проверку вычитания чисел
    Given I opened a calculator
    When I subtract 31 and -14
    Then the result should be 45


  Scenario: Subtract negative
  Тест на проверку вычитания отрицательных чисел
    Given I opened a calculator
    When I subtract -15 and -22
    Then the result should be 7

  Scenario: Divide
  Тест на проверку деления на отрицательное число
    Given I opened a calculator
    When I divide 21 and -3
    Then the result should be -7