Feature: Demo Test for Baidu
  - This is a demo for cucumber feature

  Test data:
  url: www.baidu.com
  searchKeywords: Testing

  @Smoke
  Scenario Outline: User Login ShopBack APP
    Given User is on "<Url>" page
    When User enter "<searchKeywords>" in search box "<textboxId>"
    And User clicks on Search button "<buttonId>"
    Then user should see "<searchKeywords>"
    Examples:
      | Url                   | searchKeywords | textboxId | buttonId |
      | https://www.baidu.com | Cucumber Demo  | kw        | su       |
