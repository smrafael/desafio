<br />
Uma simples API REST para cadastro de clientes

# Rodando a aplicação
É recomendado utilizar o [Spring Tool Suite](https://spring.io/tools/sts) (STS) para executar a aplicação

 - Clone na aplicação
	 - `git clone https://github.com/smrafael/desafio.git`
 - Importe a aplicação no STS
	 - File -> Import... -> Existing Maven Projects... -> Browser... -> Finish
 - Run -> Run (ou Ctrl + F11)

A aplicação utiliza o banco de dados h2 por padrão (in-memory). Para utilizar o MySql vá em `src/main/resources/application.properties`, descomente o bloco relacionado ao MySql e comente o bloco do h2.

# API
Lista dos endpoints disponíveis

## [POST] /api/cliente
Cadastro de clientes

### Request

 - Tipo: `application/json`
 - Body (obrigatórios*)
 
| Campo | Descrição |
|--|--|
| nomeFantasia* | Nome fantasia do cliente |
| razaoSocial* | Razao social do cliente |
| email* | Email do cliente|
| cnpj* | CNPJ do cliente no formato ##.###.###/####-##|
| endereco | |
| rua* | Rua do cliente |
| numero* | Número da casa do cliente |
| bairro* | Bairro do cliente |
| cidade* | Cidade do cliente |
| estado* | UF do cliente |
| complemento | Complemento da residência do cliente |

 - Exemplo: <br />
```
{
	"razaoSocial": "Rafael Mendes",
	"nomeFantasia": "Rafael Mendes Lanches",
	"email": "rafael.sm199@gmail.com",
	"cnpj": "38.961.826/0001-90",
	"endereco" : {
		"rua": "Rua de lá",
		"numero": 111,
		"bairro": "Bairro daqui",
		"cidade": "João Pessoa",
		"estado": "PB"
	}
}
```

### Response

 - 200 - OK
	 - Tipo: application/json
	 - Body: O mesmo cliente enviado, agora com ID
	 - Exemplo: <br />
```
{
	"id": 1
	"razaoSocial": "Rafael Mendes",
	"nomeFantasia": "Rafael Mendes Lanches",
	"email": "rafael.sm199@gmail.com",
	"cnpj": "38.961.826/0001-90",
	"endereco" : {
		"id": 1
		"rua": "Rua de lá",
		"numero": 111,
		"bairro": "Bairro daqui",
		"cidade": "João Pessoa",
		"estado": "PB"
	}
}
```
 - 400 - Bad Request
	 - CPF ou Email inválidados
	 - CPF já existente
	 - Data inválida
	 - Email já existente
	 - Campos obrigatório não preenchidos

## [PUT] /api/cliente
Atualização de clientes

### Request

 - Tipo: `application/json`
 - Body (obrigatórios*)
 
| Campo | Descrição |
|--|--|
| id* | ID do cliente que se deseja atualizar |
| nomeFantasia* | Nome fantasia do cliente |
| razaoSocial* | Razao social do cliente |
| email* | Email do cliente|
| cnpj* | CNPJ do cliente no formato ##.###.###/####-##|
| endereco | |
| id* | ID do enderenco do cliente |
| rua* | Rua do cliente |
| numero* | Número da casa do cliente |
| bairro* | Bairro do cliente |
| cidade* | Cidade do cliente |
| estado* | UF do cliente |
| complemento | Complemento da residência do cliente |

 - Exemplo: <br />
```
{
	"id": 1
	"razaoSocial": "Rafael Mendes EDITADO",
	"nomeFantasia": "Rafael Mendes Lanches",
	"email": "rafael.sm199@gmail.com",
	"cnpj": "38.961.826/0001-90",
	"endereco" : {
		"id": 1
		"rua": "Rua de lá",
		"numero": 111,
		"bairro": "Bairro daqui",
		"cidade": "João Pessoa",
		"estado": "PB"
	}
}
```

### Response

 - 200 - OK
	 - Tipo: application/json
	 - Body: O mesmo cliente enviado com os campos atualizados
	 - Exemplo: <br />
```
{
	"id": 1
	"razaoSocial": "Rafael Mendes EDITADO",
	"nomeFantasia": "Rafael Mendes Lanches",
	"email": "rafael.sm199@gmail.com",
	"cnpj": "38.961.826/0001-90",
	"endereco" : {
		"id": 1
		"rua": "Rua de lá",
		"numero": 111,
		"bairro": "Bairro daqui",
		"cidade": "João Pessoa",
		"estado": "PB"
	}
}
```
 - 400 - Bad Request
	 - CPF ou Email inválidados
	 - CPF já existente
	 - Data inválida
	 - Email já existente
	 - Campos obrigatório não preenchidos

## [GET] /api/cliente?page={page}&size={size}&search={query}
Pesquisa por clientes baseada em páginas

### Request

 - Parâmetro de requisição
 
|Parâmetro| Descrição |
|--|--|
| page | Página da listagem dos clientes |
| size | Quantidade de clientes por página |
| search | Query para filtragem dos clientes no <br /> formato "campo1:valor1,campo2:valor2".<br /> Os nomes dos campos devem ser iguais aos<br /> utilizados no cadastro de clientes. |

 - Exemplo: `/api/cliente?page=0&size=10&search=nomeFantasia:Rafael,endereco.rua:Rua


### Response
 - 200 - OK
	 - Tipo: application/json
	 - Body: Lista de clientes e informações da página
	 - Exemplo: <br />
```
{
    "content": [
        {
		"id": 1
		"razaoSocial": "Rafael Mendes EDITADO",
		"nomeFantasia": "Rafael Mendes Lanches",
		"email": "rafael.sm199@gmail.com",
		"cnpj": "38.961.826/0001-90",
		"endereco" : {
			"id": 1
			"rua": "Rua de lá",
			"numero": 111,
			"bairro": "Bairro daqui",
			"cidade": "João Pessoa",
			"estado": "PB"
		}
	}
    ],
    "last": true,
    "totalElements": 1,
    "totalPages": 1,
    "sort": null,
    "first": true,
    "numberOfElements": 1,
    "size": 10,
    "number": 0
}
```
 - 400 - Bad Request
	 - Parâmetro `size` negativo ou maior que 100
	 - Parâmetro `page` negativo
