Feature: Vicedean Ekleme Testi

  @US06_Api
  Scenario: Vicedean basarili bir sekilde eklenebilmeli
  Given Vicedean eklemek icin Post Request hazirligi yapilir
  And Gonderilecek vicedean bilgileri hazirlanir
  When Vicedean eklemek icin Post Request gonderilir
  Then Viceden bilgileri dogrulanir



    #  Feature: Dean Ekleme Testi
    #    Scenario: Dean basarili bir sekilde eklenebilmeli
    #      Given Dean eklemek icin Post request hazirligi yapilir
    #      And Gonderilecek dean bilgileri hazirlanir
    #      When Dean eklemek icin Post request gonderilir
    #      Then Dean bilgileri dogrulanir