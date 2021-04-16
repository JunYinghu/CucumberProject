Feature: Demo Test for Baidu
  - This is a demo for cucumber feature

  Test data:
  url: www.baidu.com
  searchKeywords: Cucumber Demo, <script> alert("testing") </script>, empty

  @Smoke
  Scenario Outline: Verify baidu search feature, covering normal searching keywords, javascript, empty
    Given User is on "<Url>" page
    When User enter "<searchKeywords>" in search box "<textboxId>"
    And User clicks on Search button "<buttonId>"
    Then user should see "<searchResultPage>"
    Examples:
      | Url                   | searchKeywords                      | textboxId | buttonId | searchResultPage |
      | https://www.baidu.com | Cucumber Demo                       | kw        | su       | Cucumber Demo    |
      | https://www.baidu.com | <script> alert("testing") </script> | kw        | su       | <script>         |
      | https://www.baidu.com |                                     | kw        | su       | remain           |