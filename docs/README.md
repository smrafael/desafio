<br />
Uma simples API REST para cadastro de clientes

# Rodando a aplicação
É recomendado utilizar o [Spring Tool Suite](https://spring.io/tools/sts) (STS) para executar a aplicação

 - Clone na aplicação
	 - `git clone https://github.com/smrafael/desafio.git`
 - Importe a aplicação no STS
	 - File -> Import... -> Existing Maven Projects... -> Browser... -> Finish
 - Run -> Run (ou Ctrl + F11)

# API
Lista dos endpoints disponíveis

## [POST] /api/client
Cadastro de clientes

### Request

 - Tipo: `application/json`
 - Body (obrigatórios*)
 
| Campo | Descrição |
|--|--|
| nomeCompleto* | Nome do cliente |
| sexo* | Sexo do cliente (MASCULINO ou FEMININO) |
| dataNascimento* | Data de nascimento do cliente no formato <br /> dd/MM/yyyy|
| email* | Email do cliente|
| cpf* | CPF do cliente no formato ###.###.###-##|
| rua* | Rua do cliente |
| numero* | Número da casa do cliente |
| bairro* | Bairro do cliente |
| cidade* | Cidade do cliente |
| estado* | UF do cliente |
| complemento | Complemento da residência do cliente |

 - Exemplo: <br />
```
{
	"nomeCompleto": "João da Silva",
	"sexo": "MASCULINO",
	"dataNascimento": "17/09/1990",
	"email": "joaosilva@email.com",
	"cpf": "873.345.133-80",
	"rua": "Rua de lá",
	"numero": 111,
	"bairro": "Bairro daqui",
	"cidade": "João Pessoa",
	"estado": "PB",
	"complemento": "102A"
}
```

### Response

 - 200 - OK
	 - Tipo: application/json
	 - Body: O mesmo cliente enviado, agora com ID
	 - Exemplo: <br />
```
{
	"id": 1,
	"nomeCompleto": "João da Silva",
	"sexo": "MASCULINO",
	"dataNascimento": "17/09/1990",
	"email": "joaosilva@email.com",
	"cpf": "873.345.133-80",
	"rua": "Rua de lá",
	"numero": 111,
	"bairro": "Bairro daqui",
	"cidade": "João Pessoa",
	"estado": "PB",
	"complemento": "102A"
}
```
 - 400 - Bad Request
	 - CPF ou Email inválidados
	 - CPF já existente
	 - Data inválida
	 - Email já existente
	 - Campos obrigatório não preenchidos

## [PUT] /api/client
Atualização de clientes

### Request

 - Tipo: `application/json`
 - Body (obrigatórios*)
 
| Campo | Descrição |
|--|--|
| id* | ID do cliente que se deseja atualizar |
| nomeCompleto* | Nome do cliente |
| sexo* | Sexo do cliente (MASCULINO ou FEMININO) |
| dataNascimento* | Data de nascimento do cliente no formato <br /> dd/MM/yyyy|
| email* | Email do cliente|
| cpf* | CPF do cliente no formato ###.###.###-##|
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
	"nomeCompleto": "João da Silva e Neto",
	"sexo": "MASCULINO",
	"dataNascimento": "17/09/1990",
	"email": "joaosilva@email.com",
	"cpf": "873.345.133-80",
	"rua": "Rua de lá",
	"numero": 111,
	"bairro": "Bairro daqui",
	"cidade": "João Pessoa",
	"estado": "PB",
	"complemento": "102A"
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
	"nomeCompleto": "João da Silva e Neto",
	"sexo": "MASCULINO",
	"dataNascimento": "17/09/1990",
	"email": "joaosilva@email.com",
	"cpf": "873.345.133-80",
	"rua": "Rua de lá",
	"numero": 111,
	"bairro": "Bairro daqui",
	"cidade": "João Pessoa",
	"estado": "PB",
	"complemento": "102A"
}
```
 - 400 - Bad Request
	 - CPF ou Email inválidados
	 - CPF já existente
	 - Data inválida
	 - Email já existente
	 - Campos obrigatório não preenchidos

## [GET] /api/client?page={page}&size={size}&search={query}
Pesquisa por clientes baseada em páginas

### Request

 - Parâmetro de requisição
 
|Parâmetro| Descrição |
|--|--|
| page | Página da listagem dos clientes |
| size | Quantidade de clientes por página |
| search | Query para filtragem dos clientes no <br /> formato "campo1:valor1,campo2:valor2".<br /> Os nomes dos campos devem ser iguais aos<br /> utilizados no cadastro de clientes. |

 - Exemplo: `/api/client?page=0&size=10&search=nomeCompleto:Joao`


### Response
 - 200 - OK
	 - Tipo: application/json
	 - Body: Lista de clientes e informações da página
	 - Exemplo: <br />
```
{
    "content": [
        {
            "id": 1,
            "nomeCompleto": "João da Silva",
            "sexo": "MASCULINO",
            "dataNascimento": "1990-09-17",
            "email": "joaosilva@email.com",
            "cpf": "873.345.133-80",
            "rua": "Rua de lá",
            "numero": 111,
            "bairro": "Bairro daqui",
            "cidade": "João Pessoa",
            "estado": "PB",
            "complemento": "102A"
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