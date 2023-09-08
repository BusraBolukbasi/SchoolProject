Feature: US06 Dean Vicedean Ekleyebilmeli

  Background: Kullanici Managementon Schools gider
    Given Kullanici "homePageUrl" sayfasina gider
    When Kullanici "DeanName" olarak giris yapar
    And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer


  @US06_Positive
  Scenario Outline: TC01 Dean vicedean olusturabilmeli
    #When Kullanici "DeanName" olarak giris yapar
    #And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki name "<name>", lastName "<lastname>", birthPlace "<birthPlace>", gender "<gender>", dateOfBirth "<dateOfBirth>", phone "<phone>", SSN "<ssn>", userName "<userName>", password "<password>" doldurur
    And Submit butonuna tiklar
    Then Hesabin olustugunu dogrula
    Examples:
      | name  | lastname | birthPlace | gender | dateOfBirth | phone        | ssn         | userName    | password     |
      | Marry | laurce   | New York   | Male   | 26.02.1994  | 155-638-4569 | 125-54-4576 | MarryLaurce | MarryLaurce1 |
    #Her calistiginda yeni degerler gir


  @US06_Negative1
  Scenario: TC02 Dean Zorunlu Alanlari Bos Birakir
  #When Kullanici "DeanName" olarak giris yapar
    And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki zorunlu alanlari bos birakir
    And Submit butonuna tiklar
    Then Requied yazisini dogrula


  @US06_Negative2
  Scenario Outline: TC03 Dean PhoneNumber Alanina Invalid Numara Girer
    #When Kullanici "DeanName" olarak giris yapar
    #And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki name "<name>", lastName "<lastname>", birthPlace "<birthPlace>", gender "<gender>", dateOfBirth "<dateOfBirth>", phone "<phone>", SSN "<ssn>", userName "<userName>", password "<password>" doldurur
    And Kullanici phoneNumber'a invalid bir numara girer
    Then Submit butonuna tikla ve cikan alert ile phoneNumber'in invalid deger oldugunu dogrula
    Examples:
      | name  | lastname | birthPlace | gender | dateOfBirth | phone | ssn         | userName     | password |
      | Ronas | Weasley  | New York   | Male   | 12.03.1959  |       | 125-65-4569 | RonasWeasley | RonasWe1 |

  @US06_Negative3
  Scenario Outline: TC04 Dean SSN Alanina Invalid Numara Girer
     # When Kullanici "DeanName" olarak giris yapar
    #And Giris yaptiktan sonra sag ustte bulunan menu butonuna tiklar ve vicdean butonunu secer
    And Kullanici Add Vicedean bolumundeki name "<name>", lastName "<lastname>", birthPlace "<birthPlace>", gender "<gender>", dateOfBirth "<dateOfBirth>", phone "<phone>", SSN "<ssn>", userName "<userName>", password "<password>" doldurur
    And Kullanici SSN'e invalid bir numara girer
    Then Submit butonuna tikla ve cikan alert ile SSN'in invalid  deger oldugunu dogrula
    Examples:
      | name  | lastname | birthPlace | gender | dateOfBirth | phone        | ssn | userName    | password     |
      | Draco | Malfoy   | New York   | Male   | 29.06.1992  | 156-635-4569 |     | DracoMalfoy | DracoMalfoy1 |

  @US06_Negative4
  Scenario Outline: TC05 Dean SSn Alanina 11 Karakterden Az Numara Girer
    And Kullanici Add Vicedean bolumundeki name "<name>", lastName "<lastname>", birthPlace "<birthPlace>", gender "<gender>", dateOfBirth "<dateOfBirth>", phone "<phone>", SSN "<ssn>", userName "<userName>", password "<password>" doldurur
    And Kullanici SSN'e 11 karakterden az numara girer
    Then Submit butonuna tikla ve cikan mesaj ile SSN'in 11 karakterden az oldugunu dogrula
    Examples:
      | name | lastname | birthPlace | gender | dateOfBirth | phone        | ssn | userName | password |
      | thv  | thv      | Korea      | Male   | 30.12.1995  | 546-785-7854 |     | thvTk    | thvTk123 |

  @US06_Negative5
  Scenario Outline: TC06 Dean Phone Alanina 12 Karakterden Az Numara Girer
    And Kullanici Add Vicedean bolumundeki name "<name>", lastName "<lastname>", birthPlace "<birthPlace>", gender "<gender>", dateOfBirth "<dateOfBirth>", phone "<phone>", SSN "<ssn>", userName "<userName>", password "<password>" doldurur
    And Kullanici phone alanina 12 karakterden az numara girer
    Then Submit butonuna tikla ve cikan mesaj ile phone'in 12 karakterden az oldugunu dogrula
    Examples:
      | name     | lastname | birthPlace | gender | dateOfBirth | phone | ssn         | userName | password |
      | Jeongguk | Kim      | Korea      | Male   | 01.09.1197  |       | 145-85-9654 | Jktkv    | Jktkv123 |

  @US06_Negative6
  Scenario Outline: TC07 Dean Password alanina buyuk, kucuk harf ve bir rakamsiz password girer
    And Kullanici Add Vicedean bolumundeki name "<name>", lastName "<lastname>", birthPlace "<birthPlace>", gender "<gender>", dateOfBirth "<dateOfBirth>", phone "<phone>", SSN "<ssn>", userName "<userName>", password "<password>" doldurur
    And Kullanici password alanina kucuk harf ve sayi iceren 8 karakterli bir sifre girer
    Then Password altinda cikan mesaji dogrula
    And Kullanici password alanina buyuk harf ve sayi iceren 8 karakterli bir sifre girer
    Then Password altinda cikan mesaji dogrula
    And Kullanici password alanina buyuk harf ve kucuk harf iceren 8 karakterli bir sifre girer
    Then Password altinda cikan mesaji dogrula
    And Kullanici pasword alanina 8 karakterden az bir sifre girer
    Then Password altinda cikan mesaji dogrula
    And Kullanici sayfayi kapatir
    Examples:
      | name  | lastname | birthPlace | gender | dateOfBirth | phone        | ssn         | userName     | password |
      | Elena | Backham  | Egypt      | Female | 08.10.1985  | 789-546-7458 | 789-55-6254 | ElanaBackham |          |
