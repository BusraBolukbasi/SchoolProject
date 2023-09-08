Feature: US07 Dean Kullanicilarin Gonderdigi Mesajlari Gorebilmelidir

  @US_07
  Scenario: TC01 Dean Atilan Mesajlari Gorebilmelidir
    Given Kullanici "homePageUrl" sayfasina gider
    When Kullanici "DeanName" olarak giris yapar
    And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve contact get all butonunu secer
    Then Mesajlarin gorunur oldugunu dogrula
    And Kullanici sayfayi kapatir

