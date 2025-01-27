![Logo adopet](https://github.com/lucasmrd/api_rest_adopet/assets/106198915/b73d6316-e545-4e4c-9ff3-2c036218f53f)

<div align="center">
  
  ![Badge Concluído](https://img.shields.io/static/v1?label=Status&message=Concluído&color=success&style=for-the-badge)
  ![Badge Springboot](https://img.shields.io/static/v1?label=Springboot&message=v3.2.2&color=brightgreen&style=for-the-badge&logo=spring)
  ![Badge Java](https://img.shields.io/static/v1?label=Java&message=17&color=orange&style=for-the-badge&logo=java)

</div>

# :book: Introdução
Adopet API é um projeto proposto pela Alura no Challenge Backend 6ª Edição, com o objetivo de conectar pessoas interessadas em adotar animais de estimação com abrigos. Desenvolvida em Java com Spring Boot, a API oferece endpoints para gerenciar recursos como tutor, abrigo, pet e adoção. Todos os endpoints são protegidos por autenticação via JWT (JSON Web Token), garantindo segurança no acesso e manipulação dos dados.


# 🛠️ Tecnologias e ferramentas

<a href="https://www.jetbrains.com/idea/" target="_blank"><img src="https://img.shields.io/badge/intellij-000000.svg?&style=for-the-badge&logo=intellijidea&logoColor=white" target="_blank"></a>

<a href="https://pt.wikipedia.org/wiki/Java_(linguagem_de_programa%C3%A7%C3%A3o)" target="_blank"><img src="https://img.shields.io/badge/java%2017-D32323.svg?&style=for-the-badge&logo=java&logoColor=white" target="_blank"></a>

<a href="https://spring.io/projects/spring-boot" target="_blank"><img src="https://img.shields.io/badge/Springboot-6db33f.svg?&style=for-the-badge&logo=springboot&logoColor=white" target="_blank"></a>
<a href="https://spring.io/projects/spring-data-jpa" target="_blank"><img src="https://img.shields.io/badge/Spring%20Data%20JPA-6db33f.svg?&style=for-the-badge&logo=spring&logoColor=white" target="_blank"></a>
<a href="https://spring.io/projects/spring-security" target="_blank"><img src="https://img.shields.io/badge/Spring%20Security-6db33f.svg?&style=for-the-badge&logo=spring&logoColor=white" target="_blank"></a>

<a href="https://www.mysql.com/" target="_blank"><img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white"></a>
<a href="https://www.docker.com/" target="_blank"><img src="https://img.shields.io/badge/Docker-2496ED.svg?&style=for-the-badge&logo=docker&logoColor=white" target="_blank"></a>
<a href="https://flywaydb.org/" target="_blank"><img src="https://img.shields.io/badge/Flyway-CC0200.svg?&style=for-the-badge&logo=flyway&logoColor=white" target="_blank"></a>

<a href="https://swagger.io/" target="_blank"><img src="https://img.shields.io/badge/Swagger-85EA2D.svg?&style=for-the-badge&logo=swagger&logoColor=black" target="_blank"></a>
<a href="https://springdoc.org/" target="_blank"><img src="https://img.shields.io/badge/Spring%20Doc-85EA2D.svg?&style=for-the-badge" target="_blank"></a>

<a href="https://www.postman.com/" target="_blank"><img src="https://img.shields.io/badge/postman-ff6c37.svg?&style=for-the-badge&logo=postman&logoColor=white" target="_blank"></a>


## :bulb: Funcionalidades

### :lock: Autenticação
- `Login de usuário`: O login é realizado por meio de uma requisição POST /api/auth, enviando as credenciais do usuário (login e senha) em formato JSON no corpo da requisição.

### 👨🏻‍🏫 Gerenciamento de Tutor
- `Cadastrar`: Para cadastrar um Tutor, é necessário enviar uma requisição POST /api/tutor, contendo as informações de nome, login e senha no corpo da requisição em formato JSON.</br>

- `Atualizar`: A atualização dos dados de um Tutor é feita através de um PUT /api/tutor/{ID},
   onde ID corresponde ao identificador do Tutor. As novas informações devem ser enviadas no corpo da requisição.
  - Apenas o próprio usuário Guardian pode atualizar seus dados.
  - A autenticação é obrigatória.<br>

- `Buscar por id`: Um Tutor pode ser consultado pelo seu identificador através de um GET /api/tutor/{ID}, onde {ID} representa o identificador do Tutor.
  - A autenticação é obrigatória.<br>

- `Listar Tutores`: A API permite a busca paginada de todos os Tutores cadastrados via GET /api/tutor.
  - A autenticação é obrigatória.<br>

- `Deletar`: A remoção de um Tutor é realizada por meio de um DELETE /api/tutor/{ID}, onde {ID} é o identificador do Tutor.</br>
  - Apenas o próprio usuário Tutor pode se deletar.
  - A autenticação é obrigatória.<br>

### 🏡 Gerenciamento de Abrigo
- `Cadastrar`: A criação de um novo Abrigo é feita por meio de uma requisição POST /api/abrigos, contendo as informações de login, senha, nome e telefone em um JSON no corpo da requisição.</br>

- `Listar Abrigos`: A API permite buscar todos os abrigos de forma paginada através de um GET /api/abrigo.<br>
 
- `Buscar por id`: Para obter os detalhes de um Abrigo específico, utilize o GET /api/abrigo/{ID}, onde {ID} é o identificador do Abrigo.
  - A autenticação é obrigatória.<br>

- `Atualizar`: A atualização dos dados de um Abrigo é realizada com um PUT /api/abrigo/{ID}, enviando as novas informações no corpo da requisição.
  - Apenas o próprio usuário Abrigo pode atualizar seus dados.
  - A autenticação é obrigatória.<br>

- `Deletar`: A remoção de um Abrigo pode ser feita através de um DELETE /api/abrigo/{ID}, onde {ID} representa o identificador do Abrigo.
  - Apenas o próprio usuário Abrigo pode se deletar.
  - A autenticação é obrigatória.<br>

### 🐕 API de gerenciamento de Pet
- `Cadastrar`: A criação de um novo Pet é realizada por meio de uma requisição POST /api/pet, contendo as informações de nome, idade, descricao, porte, imagem, endereco e abrigoId no corpo da requisição em formato JSON.
  - Apenas Abrigos podem cadastrar Pets.</br>

- `Listar Pets`: A API permite a busca paginada de todos os Pets cadastrados através de um GET /api/pet.
  - A autenticação é obrigatória.<br>

- `Buscar por id`: Para obter informações detalhadas de um Pet específico, utilize o GET /api/pet/{ID}, onde {ID} representa o identificador do Pet.
  - A autenticação é obrigatória.<br>

- `Atualizar`: A atualização dos dados de um Pet é feita por meio de um PUT /api/pet/{ID}, onde ID corresponde ao identificador do Pet. As novas informações devem ser enviadas no corpo da requisição.
  - Apenas o Abrigo que cadastrou o Pet pode atualiza-lo.<br>

- `Deletar`: A remoção de um Pet pode ser feita através de um DELETE /api/pet/{ID}, onde {ID} é o identificador do Pet.
  - Apenas o Abrigo que cadastrou o Pet pode deleta-lo.
  - Pet relacionado a uma Adocao não pode ser deletado.
  - A autenticação é obrigatória.<br>

### 🐶 Gerenciamento de Adocao
- `Adotar`: Para solicitar a adoção de um Pet, é necessário enviar uma requisição POST /api/adocao, contendo as informações de idPet, idTutor e data no corpo da requisição em formato JSON.
  - Apenas usuários do tipo Tutor podem solicitar uma adoção.
  - Apenas Pets não adotados podem receber uma solicitação de adoção.
  - A autenticação é obrigatória.<br>

- `Listar Adocoes`: A API permite a busca paginada de todas as adoções relacionadas ao usuário logado através de um GET /api/adocao.
  - Busca somente adoções relacionadas ao usuário autenticado (Abrigo ou Tutor).
  - A autenticação é obrigatória.<br>

- `Buscar por id`: Para obter informações detalhadas sobre uma adoção específica, utilize o GET /api/adocao/{ID}, onde {ID} é o identificador da adoção.
  - A autenticação é obrigatória.<br>

- `Deletar`: A exclusão de uma adoção pode ser realizada através de um DELETE /api/adocao/{ID}, onde {ID} representa o identificador da adoção.
  - Uma adoção só pode ser deletada pelo Abrigo relacionado na adoção.<br>

## :computer: Como executar a aplicação?

### :whale: Docker

  Clone o projeto:
  ```bash
  git clone https://github.com/lucasmrd/api_rest_adopet.git
  ```

  Acesse a pasta do projeto:
  ```bash
  cd api_rest_adopet
  ```

  Execute o comando:
  ```bash
  docker compose up -d
  ```

O comando acima irá executar o arquivo docker-compose.yml, que será responsável por subir os seguintes containers:
- Um container MySQL para armazenar os dados da aplicação.
- Um container da aplicação Adopet.
Após os containers estarem em execução, a aplicação estará disponível em: http://localhost:8080/swagger-ui.html.

Observação: Certifique-se de ter o Docker instalado em sua máquina antes de executar os comandos acima.

## 🚀 Deploy
Realizei o deploy da aplicação no **Render**, você pode acessar [aqui](https://api-rest-adopet-3tj1.onrender.com/swagger-ui/index.html)<br>

## ⚙️ Atualizações futuras
- [ ] Criar um endpoint para o usuário atualizar sua senha.
- [ ] Escrever a documentação dos erros que o usuário pode enfrentar.
- [ ] Criar usuário admin.

