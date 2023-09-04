Feature: US06 Dean Vicedean Ekleyebilmeli

  Background: Kullanici Managementon Schools gider
    Given Kullanici "homePageUrl" sayfasina gider
    When Kullanici "DeanName" olarak giris yapar
    And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer


  @g
  Scenario Outline: TC01 Dean vicedean olusturabilmeli
    #When Kullanici "DeanName" olarak giris yapar
    #And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki name "<name>", lastName "<lastname>", birthPlace "<birthPlace>", gender "<gender>", dateOfBirth "<dateOfBirth>", phone "<phone>", SSN "<ssn>", userName "<userName>", password "<password>" doldurur
    And Submit butonuna tiklar
    Then Hesabin olustugunu dogrula
    Examples:
      | name  | lastname | birthPlace | gender | dateOfBirth | phone        | ssn         | userName   | password    |
      | Harrs | Potte    | New York   | Male   | 26.02.1994  | 155-635-4569 | 125-54-4586 | HarrsPotte | HarrsPotte1 |
    #Her calistiginda yeni degerler gir


  @b
  Scenario: TC02 Dean Zorunlu Alanlari Bos Birakir
  #When Kullanici "DeanName" olarak giris yapar
    And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki zorunlu alanlari bos birakir
    And Submit butonuna tiklar
    Then Requied yazisini dogrula


  @v
  Scenario Outline: TC03 Dean PhoneNumber Alanina Invalid Numara Girer
    #When Kullanici "DeanName" olarak giris yapar
    #And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki name "<name>", lastName "<lastname>", birthPlace "<birthPlace>", gender "<gender>", dateOfBirth "<dateOfBirth>", phone "<phone>", SSN "<ssn>", userName "<userName>", password "<password>" doldurur
    And Kullanici phoneNumber'a invalid bir numara girer
    Then Submit butonuna tikla ve cikan alert ile phoneNumber'in invalid deger oldugunu dogrula
    Examples:
      | name | lastname | birthPlace | gender | dateOfBirth | phone        | ssn         | userName     | password     |
      | Ron  | Weasley  | New York   | Male   | 12.03.1959  | 126-45a-41as | 125-65-4569 | Dumbledore12 | Dumbledore12 |

  @j
  Scenario: TC04 Dean SSN Alanina Invalid Numara Girer
     # When Kullanici "DeanName" olarak giris yapar
    And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki zorunlu alanlari doldurur
    And Kullanici SSN'e invalid bir numara girer
    Then Submit butonuna tikla ve cikan alert ile SSN'in invalid  deger oldugunu dogrula
