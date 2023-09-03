Feature: US06 Dean Vicedean Ekleyebilmeli

  Background: Kullanici "homePageUrl" sayfasina gider
    Given Kullanici "homePageUrl" sayfasina gider
  @g
  Scenario: TC01 Dean vicedean olusturabilmeli
    When Kullanici "DeanName" olarak giris yapar
    And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki zorunlu alanlari doldurur
    And Submit butonuna tiklar
    Then Hesabin olustugunu dogrula



  @b
  Scenario: TC02 Dean Zorunlu Alanlari Bos Birakir
  When Kullanici "DeanName" olarak giris yapar
  And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
  And Kullanici Add Vicedean bolumundeki zorunlu alanlari bos birakir
  And Submit butonuna tiklar
  Then Requied yazisini dogrula


  @v
  Scenario: TC03 Dean PhoneNumber Alanina Invalid Numara Girer
    When Kullanici "DeanName" olarak giris yapar
    And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki zorunlu alanlari doldurur
    And Kullanici phoneNumber'a invalid bir numara girer
    Then Submit butonuna tikla ve cikan alert ile phoneNumber'in invalid deger oldugunu dogrula