Feature: Print alle Books

  Scenario: Print alle Books
    Given We are browsing the Library
    When print the list
      | title                  | author              | yearOfPublishing |
      | To kill a mockingbird  | Harper Lee          | 1960             |
      | The catcher in the rye | J.D. Salinger       | 1951             |
      | The great Gatsby       | F. Scott Fitzgerald | 1925             |
    Then check that there are really 3 books
      | title                  | author              | yearOfPublishing |
      | To kill a mockingbird  | Harper Lee          | 1960             |
      | The catcher in the rye | J.D. Salinger       | 1951             |
      | The great Gatsby       | F. Scott Fitzgerald | 1925             |

    Scenario: Treating placeholders in tables
      Given The following table
      |key         |value         |
      |date        |today         |
      |number      |randomNumber  |
      |StringOne   |emptyString   |
      |StringThree |textOfElement |