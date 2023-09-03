Feature: US06 Dean Vicedean Ekleyebilmeli

  Background:
  @g
  Scenario: TC01 Dean vicedean olusturabilmeli
    Given Kullanici anasayafa gider
    And Kullanici "DeanName" olarak giris yapar
    When Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki zorunlu alanlari doldurur
    And Submit butonuna tiklar
    Then Hesabin olustugunu dogrula



    #Kullanici Dean olarak giris yapar
    #Giris yaptiktan sonra sag ustte bulunan 'menu' butonuna tiklanir
    #Acilan menuden Vice Dean butonuna tiklanir
    #Acilan sayfadaki add viceDean bolumundeki doldurmasi gerekli alanlari doldurur
    #Submit butonuna tiklanir
    #Hesabın olustugu yukarida cikan alert ile dogrulanir