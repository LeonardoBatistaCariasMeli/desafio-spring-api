# Desafio Spring
  <p  align="justify">Desafio proporcionado pela Digital House para o teste dos conhecimentos, com base em um determinado problema a ser solucionado.</p>
 
# Objetivo
  <p align="justify">O Mercado Livre continua a crescer e para o próximo ano pretende começar a implementar uma série de ferramentas que permitam a compradores e vendedores uma experiência totalmente inovadora, onde o vínculo que os une é muito mais forte. A data de lançamento está próxima, por isso é necessário apresentar uma versão Beta do que será conhecido como "SocialMeli", onde os compradores poderão acompanhar seus vendedores favoritos e saber todas as novidades que eles mesmos postam.</p>

# Solução
  <p align="justify"> Como solução, foi desenvolvido uma API em Java utilizando o paradigma de Orientação a Objetos e suas boas práticas, além de, a utilização do framework Spring para o desenvolvimento do mesmo.</p>
  
# Utilização da API
  O arquivo `desafio-spring.postman_collection-example.json`, referente a collection criada e utilizada no Postman, foi disponibilizado para maior facilidade, possuindo já a implementação das chamadas aos endpoints.

##   endpoints
* **POST /{userId}/follow/{userIdToFollow}**
  </br> Realização do ato de seguir um vendedor na rede social (até o momento apenas é possível seguir vendedores, usuários comuns não tem essa possibilidade). 
    * **URL Params - Required:** <br />
      * `userId=[integer]`: id do usuário que está fazendo a requisição. Exemplo: 1, 2, 3...<br />
      * `userIdToFollow=[integer]`: id do usuário que deverá ser seguido. Exemplo: 1, 2, 3...<br />
    * **Success Response** <br />
      * Code: 200 - OK<br />
    * **Error Respons** <br />
      * Code: 400 - BAD REQUEST
       ```json
        {
            "timeStamp": 1623084296702,
            "status": 400,
            "error": "Integrity data",
            "message": "This message can be alterned by multiples errors",
            "path": "/users/2/follow/1"
         }
       ```
* **GET /users/{userId}/followers/count**
  </br> Obtenção da quantidade de usuários que seguem um determinado vendedor. 
    * **URL Params - Required:** <br />
      * `userId=[integer]`: id do usuário que está fazendo a requisição. Exemplo: 1, 2, 3...<br />
    * **Success Response** <br />
      * Code: 200 - OK 
      ```json
        {
          "userId": 1569,
          "userName": "vendedor1",
          "followers_count": 35
        }
       ```
    * **Error Respons** <br />
       * Code: 400 - BAD REQUEST
       ```json
        {
            "timeStamp": 1623084296702,
            "status": 400,
            "error": "Integrity data",
            "message": "This message can be alterned by multiples errors",
            "path": "/users/2/followers/count"
         }
       ```

* **GET /users/{userId}/followers/list**
  </br> Obtenção da lista de usuários que seguem um determinado vendedor. 
    * **URL Params - Required:** <br />
      * `userId=[integer]`: id do usuário que está fazendo a requisição. Exemplo: 1, 2, 3...<br />
    * **Quuery Params - Not Required:** <br />
      * `order=[String]`: Metodo de ordenação que deseja. Exemplo: name_asc e name_desc<br />
    * **Success Response** <br />
      * Code: 200 - OK 
      ```json
        {
          "userId": 1,
          "name": "Leonardo",
          "followers": [
              {
                  "userId": 5,
                  "name": "Gustavo"
              },
              {
                  "userId": 2,
                  "name": "Nycolas"
              }
          ]
        }
       ```
    * **Error Respons** <br />
       * Code: 400 - BAD REQUEST
       ```json
        {
            "timeStamp": 1623084296702,
            "status": 400,
            "error": "Integrity data",
            "message": "This message can be alterned by multiples errors",
            "path": "/users/2/followers/list"
         }
       ```
       
* **GET /users/{userId}/followed/list**
  </br> Obtenção da lista todos os vendedores que seguem um determinado usuário segue. 
    * **URL Params - Required:** <br />
      * `userId=[integer]`: id do usuário que está fazendo a requisição. Exemplo: 1, 2, 3...<br />
    * **Success Response** <br />
      * Code: 200 - OK 
      ```json
        {
          "userId": 5,
          "name": "Gustavo",
          "followed": [
              {
                  "userId": 1,
                  "name": "Leonardo"
              }
          ]
        }
       ```
    * **Error Respons** <br />
       * Code: 400 - BAD REQUEST
       ```json
        {
            "timeStamp": 1623084296702,
            "status": 400,
            "error": "Integrity data",
            "message": "This message can be alterned by multiples errors",
            "path": "/users/2/followed/list"
         }
       ```

* **POST /posts**
  </br> Cadastrar uma nova publicação. (Apenas vendedores podem fazer isso).
    * **Payload - Required:** <br />
      * Examplo de payload válido: 
      ```json
        {
          "userId": 1,
          "date": "22-05-2021",
          "detail": {
              "productId": 2
          },
          "category": 100,
          "price": 1500.50
        }
       ```
    * **Success Response** <br />
      * Code: 201 - Created 
    * **Error Respons** <br />
       * Code: 400 - BAD REQUEST
       ```json
        {
            "timeStamp": 1623084296702,
            "status": 400,
            "error": "Integrity data",
            "message": "This message can be alterned by multiples errors",
            "path": "/post"
         }
       ```

* **GET /followed/{userId}/posts**
  </br> Obtenção da lista todos os vendedores que seguem um determinado usuário segue. 
    * **URL Params - Required:** <br />
      * `userId=[integer]`: id do usuário que está fazendo a requisição. Exemplo: 1, 2, 3...<br />
    * **Success Response** <br />
      * Code: 200 - OK 
      ```json
        {
          "userId": 1,
          "posts": [
              {
                  "postId": 1,
                  "date": "07-06-2021",
                  "detail": {
                      "productId": 1,
                      "productName": "Cadeira DX Racer",
                      "type": "GAMER",
                      "brand": "DX Racer",
                      "color": "Vermelho e Preto",
                      "notes": "Cadeira gamer top do mercado"
                  },
                  "category": 1,
                  "price": 1600.0
              },
              {
                  "postId": 2,
                  "date": "07-06-2021",
                  "detail": {
                      "productId": 2,
                      "productName": "Mesa de escritório",
                      "type": "STANDARD",
                      "brand": "Tok Stok",
                      "color": "Marrom",
                      "notes": "Mesa de escritório nova e de muita qualidade"
                  },
                  "category": 2,
                  "price": 400.0,
                  "hasPromo": true,
                  "discount": 0.25
              }
          ]
          }
       ```
    * **Error Respons** <br />
       * Code: 400 - BAD REQUEST
       ```json
        {
            "timeStamp": 1623084296702,
            "status": 400,
            "error": "Integrity data",
            "message": "This message can be alterned by multiples errors",
            "path": "/followed/5/posts"
         }
       ```

* **PATCH /users/{userId}/unfollow/{userIdToUnfollow}**
  </br> Obtenção da lista todos os vendedores que seguem um determinado usuário segue. 
    * **URL Params - Required:** <br />
      * `userId=[integer]`: id do usuário que está fazendo a requisição. Exemplo: 1, 2, 3...<br />
      * `userId=[userIdToUnfollow]`: id do usuário que deve deixar de seguir. Exemplo: 1, 2, 3...<br />
    * **Success Response** <br />
      * Code: 204 - No content 
    * **Error Respons** <br />
       * Code: 400 - BAD REQUEST
       ```json
        {
            "timeStamp": 1623084296702,
            "status": 400,
            "error": "Integrity data",
            "message": "This message can be alterned by multiples errors",
            "path": "/users/4/unfollow/2"
         }
       ```
