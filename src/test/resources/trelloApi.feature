@trelloApi
  Feature: Kullanıcı Trello API uzerinde cesitli islemler yapabilmelidir

    Background: Kullanıcı Base URL i setler
      Given Kullanıcı Trello icin Base URL set eder "https://api.trello.com"

     #Bu scen. de bizler board create edeceğiz ayrıca taskımıza bizlere verilen
    # diğer işlemleri gerçekleştirebilmek için bizlerin board id sine ihtiyacı vardır
    #Board ıd yi de bu scen. alabacağız. Ve Boardun create edildiğini assert edeceğiz.    ------->>>>>>>>>< class seviyesinde tanımla

    # URL = 'https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken'   (POST)
    @createboard
    Scenario: Kullanıcı board create edebilmeli
      When Kullanıcı board create edebilmek icin ilgili url e POST methodu ve ilgili endpointler ile request atar "idPath","1","boardsPath","boards"
      And Kullanıcı board id yi alır
      Then Kullanıcı boad un basarili bir sekilde create edildigini dogrular


    #https://api.trello.com/1/lists?name={name}&idBoard=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken
    @createList
    Scenario: Kullanıcı card create edebilmek icin list create edebilmeli
      When Kullanıcı list create edebilmek icin ilgili url e POST methodu ile request atar "idPath","1","listsPath","lists"
      And Kullanıcı list id yi alir
      Then Kullanıcı listin basari ile create edidldigini verfiy eder

    #"https://api.trello.com/1/cards?idList=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken"
    @createCard
    Scenario Outline: Kullanıcı card create edebilmeli
      When Kullanıcı card ccreate edebilmek icin ilgili url e POST metodu ile request atar "idPath","1","cardsPath","<cards>"
      And Kullanıcı card is yi alir
      Then Kullanıcı vard create edildigini verify eder
      Examples:
        | cards |
        | cards |
        | cards |

    #'https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken
    @updateCard
    Scenario: Kullanıcı olusturdugu kartlardan herhangi birini update edebilmeli
      When Kullanıcı update islemi iicn ilgili url ePUT metodu ile request atar "idPath","1","cardsPath","cards"
      Then Kullanıcı basarili bir sekilde cardlardan birini update ettigini verify eder


      #"https://api.trello.com/1/cards/{id}?key=APIKey&token=APIToken"
    @deleteCard
    Scenario Outline: Kullanıcı olusturdugu cardlari silebilmeli
      When Kullanıcı delete islemi yapabilmek icin ilgili url e DELETE metodu ile request atar "idPath","1","cardsPath","cards","cardIdPath",<cardsId>
      Then Kullanıcı basarili bir sekilde cardalrin delete edildigini verfiy eder

      Examples:
        | cardsId |
        | 0       |
        | 1       |

    #"https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken"
    @deleteBoard
    Scenario: Kullanıcı bord silebilmeli
      When Kullanıcı board delete islemi icin ilgili url e DELETE metodu ile request atar "idPath","1","boardsPath","boards"
      Then Kullanıcı basarili bir sekilde boardun delete edildigini verfiy eder

