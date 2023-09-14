Feature: Vicedean Ekleme Testi

  @US06_Post
  Scenario: Vicedean basarili bir sekilde eklenebilmeli
    Given Vicedean eklemek icin Post Request hazirligi yapilir
    And Gonderilecek vicedean bilgileri hazirlanir
    When Vicedean eklemek icin Post Request gonderilir
    Then Viceden bilgileri dogrulanir

  @US06_GetByID
  Scenario: Olusturulan Vicedean dogrulama islemi
    Given Vicedean sorgulamak icin Get islemi yapilir
    When Viceden sorgulamak icin Get Request gonderilir
    Then Body dogrulanir

  @US06_Put
  Scenario: Olusturulan Vicedean uzerinde degisiklik yapma
    Given Viceden guncellemek icin Put hazirligi yapilir
    And Guncellenecek vicedean bilgileri hazirlanir
    When Vicedean guncellemek icin Put Request gonderilir
    Then Gelen body dogrulanir

    @US06_GetAll
    Scenario: Olusturulan Vicedeanlari dogrulama islemi
    Given Vicedean'lari sorgulamak icin Get islemi yapilir
    When Viceden'lari sorgulamak icin Get Request gonderilir
    Then Status code dogrulanir


  @US06_Delete
  Scenario: Olusturulan Vicedean'i silme islemi
    Given Vicedean silmek icin Delete islemi yapilir
    When Silmek icin Delete Request gonderilir
    Then Silindigini dogrula
