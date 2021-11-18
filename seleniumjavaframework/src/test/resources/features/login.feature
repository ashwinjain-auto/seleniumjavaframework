#Author: Ashwin Jain
Feature: Title of your feature
  I want to use this template for my feature file

  @tag
  Scenario Outline: Title of your scenario outline
    Given I launch the web xfinity.com
    When I login with <username> and <password>
    Then I should be signed in  state

    Examples: 
      | username         | password  | state   |
      | ashwin_jain_test | PickCart7 | success |
