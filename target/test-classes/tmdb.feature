@tmdbApi
Feature: Kullanici Tmdb Api üzerinde işlemler yapabilir

  Background: Kullanici baseURL setler

    Given Kullanici Tmdb icin Base URL set eder "https://api.themoviedb.org"

  @createToken
  Scenario: Kullanici request token create edebilmeli
    When Kullanici request token create edebilmek icin ilgili url e GET methodu ve ilgili endpointler ile request atar "idPath","3","authenticiationPath","authentication","tokenPath","token","newPath","new"
    And  Kullanici request token i alır
    Then Kullanici request tokenin basarili bir sekilde create edildigini dogrular

  @createTokenApprove
  Scenario: Kullanici request token i approve edebilmeli
    When Kullanici request token i approve edebilmek icin ilgili url e GET methodu ve ilgili endpointler ile request atar "idPath","3", "authenticiationPath","authentication","tokenPath","token","allowPath","validate_with_login"


  @createSessionID
  Scenario: Kullanici session id create edebilmeli
    When Kullanici session id create edebilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar "idPath","3","authenticiationPath","authentication","sessionPath","session","newPath","new"
    And  Kullanici session id i alır
    Then Kullanici session id basarili bir sekilde create edildigini dogrular

  @movieRating
  Scenario: Kullanici filmi oylama islemi yapabilmeli
    When Kullanici oylama islemi yapabilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar "idPath","3","moviePath","movie","movieIdPath","33","ratingPath","rating"
    Then Kullanici oylama islemini basarili bir sekilde yapabildigini dogrular

  @movieDelete
  Scenario: Kullanici filmi silebilmeli
    When Kullanici filmi silebilmek icin ilgili url e DELETE methodu ve ilgili endpointler ile request atar "idPath","3","moviePath","movie","movieIdPath","33","ratingPath","rating"
    Then Kullanici silme islemini basarili bir sekilde yapabildigini dogrular