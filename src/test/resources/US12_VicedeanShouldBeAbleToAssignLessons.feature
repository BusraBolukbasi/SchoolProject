Feature:ViceDean ders programi olusturabilmelidir (Lesson Program - Add Lesson Program)

  Background:
    Given Anasayfaya git
    When  ViceDean olarak sayfaya login ol
    Then  Lesson Program kismina tikla


  @mmg4
  Scenario: ViceDean hesabi ile ders programi olusturma islemi
    When Choose Lessons kismina tikla ve herhangi bir ders sec
    Then Choose Day kismina tikla ve bir gun ismi sec
    And Choose Education Term kismindan bir donem ismi sec
    And Start Time kismina sayisal bir deger gir
    And Stop Time kismina sayisal bir deger gir
    Then Submit butonuna tikla ve kayit oldugunu dogrula


  @mmg5
  Scenario:ViceDean hesabi ile ders programi olusturamama islemi (Negative Scenario)
    When Submit butonuna tikla
    Then Choose Lessons kismini bos birak
    When Choose Day,Choose Education Term,Start Time,Stop Time kismini doldur
    Then Submit butonuna tikla
    When Choose Day kismini bos birak
    Then Choose Lessons,Choose Education Term,Start Time,Stop Time  kismini doldur
    When Submit butonuna tikla
    Then Choose Education Term kismini bos birak
    When Choose Lessons,Choose Day,Start Time,Stop Time  kismini doldur Submit butonuna tikla
    Then Start Time kismini bos birak
    When Choose Lessons,Choose Day,Choose Education Term,Stop Time kismini doldur
    Then Submit butonuna tikla
    When Stop Time kismini bos birak
    Then Choose Lessons,Choose Day,Choose Education Term,Start Time  kismini doldur
    When Submit butonuna tikla