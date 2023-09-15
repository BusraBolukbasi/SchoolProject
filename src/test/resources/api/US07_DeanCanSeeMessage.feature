@US07_Api
Feature: Dean mesajlari gorebilmeli

  Scenario Outline: US07 Gelen Mesajlari Dogrulama
    Given Mesajlari almak icin Get request hazirligi yapilir
    Then Verify Body : name="<name>", email="<email>", subject="<subject>",message="<message>",date="<date>"
    Examples:
      | name       | email            | subject | message | date       |
      | Ying Doyle | Noemi@hoegerinfo | lvsp    | z2qnj   | 2023-09-14 |