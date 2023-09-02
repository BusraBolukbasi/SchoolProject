Feature: US06 Dean Vicedean Ekleyebilmeli

  Background: Kullanici anasayafa gider
  Scenario: TC01 Dean vicedean olusturabilmeli
    Given Kullanici "DeanGiris" olarak giris yapar
    When Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar
    Then Kullanici menudeki Vicedean butonuna tiklar
    And Kullanici Add Vicedean bolumundeki zorunlu alanlari doldurur
    And Submit butonuna tiklar
    And Hesabin olustugunu dogrula



    #Kullanici Dean olarak giris yapar
    #Giris yaptiktan sonra sag ustte bulunan 'menu' butonuna tiklanir
    #Acilan menuden Vice Dean butonuna tiklanir
    #Acilan sayfadaki add viceDean bolumundeki doldurmasi gerekli alanlari doldurur
    #Submit butonuna tiklanir
    #Hesabın olustugu yukarida cikan alert ile dogrulanir