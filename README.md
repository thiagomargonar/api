# api
Java 8, Spring Boot, Lombok, Liquibase, banco de dados MySQL 7  <br/>
Configurações do banco no arquivo application.properties e liquiabse.properties <br/>

Serviços

Empresa
GET <br/>
Params Required: page:number, pageSize:number <br/>
http://127.0.0.1:8080/company <br/>
 <br/>
POST <br/>
http://127.0.0.1:8080/company <br/>
{ <br/>
    "company_name": "String",<br/>
    "fantasy_name": "String",<br/>
    "typeEnum": "TAKER or PROVIDER",<br/>
    "cnpj": "String"<br/>
} <br/>
<br/>

PUT <br/>
http://127.0.0.1:8080/company <br/>
{ <br/>
    "id": number, <br/>
    "company_name": "String",<br/>
    "fantasy_name": "String",<br/>
    "typeEnum": "TAKER or PROVIDER",<br/>
    "cnpj": "String"<br/>
} <br/>

DELETE  <br/>
http://127.0.0.1:8080/company/id_company
#
Notas
GET <br/>
Params Required: page:number, pageSize:number <br/>
http://127.0.0.1:8080/note <br/><br/>

GET <br/>
Params Required: provider:number, page:number, pageSize:number <br/>
http://127.0.0.1:8080/note/provider <br/><br/>

POST <br/>
http://127.0.0.1:8080/note <br/>
{<br/>
    "number": number,<br/>
    "taker": {<br/>
        "company_name": "String",<br/>
        "fantasy_name": "String",<br/>
        "typeEnum": "TAKER",<br/>
        "cnpj": "String"<br/>
    },<br/>
    "provider": {<br/>
      "company_name": "String",<br/>
      "fantasy_name": "String",<br/>
      "typeEnum": "PROVIDER",<br/>
      "cnpj": "String"<br/>
    },<br/>
    "date": "yyyy-MM-dd",<br/>
    "value": number<br/>
}<br/>

PUT <br/>
http://127.0.0.1:8080/note <br/>
{<br/>
    "id": number,
    "number": number,<br/>
    "taker": {<br/>
        "id": number,
        "company_name": "String",<br/>
        "fantasy_name": "String",<br/>
        "typeEnum": "TAKER",<br/>
        "cnpj": "String"<br/>
    },<br/>
    "provider": {<br/>
        "id": number,
        "company_name": "String",<br/>
        "fantasy_name": "String",<br/>
        "typeEnum": "PROVIDER",<br/>
        "cnpj": "String"<br/>
    },<br/>
    "date": "2018-12-25",<br/>
    "value": 150.00<br/>
}<br/>

DELETE  <br/>
http://127.0.0.1:8080/id_note <br/><br/>
br/><br/>
