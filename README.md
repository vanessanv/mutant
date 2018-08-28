# Mutante
Programa escrito para teste.
Nele foram utilizadas as seguintes tecnologias: Java 1.8, SpringBoot, Rest e Google App Engine.
Esse programa consiste em receber um array de String e retornar true ou false para as validações pedidas no teste.

## Getting Started


A API REST do projeto possui o serviço "/mutante" que recebe como parâmetro um array de String através do método POST e verifica se a sequência passada é considerada um DNA mutante ou não. 
Formato recebido pela API:

POST → /mutant/
{
“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

Caso seja mutante retornará a mensagem HTTP 200-OK, caso contrário 403-Forbidden.
 
### Pré-requisito

Para utilizar a API será necessário o uso de uma aplicação Rest Client, como o Postman, por exemplo.

### Acessando a aplicação

A aplicação foi disponibilizada no endereço https://projeto-mutante.appspot.com/mutant através do Google App Engine.
Para o teste será necessário o uso de uma aplicação Rest Client como citado no item de pré-requisito. A aplicação escolhida para exemplificar será o Postman.

#### Utilizando o Postman para testar a aplicação

Caso a aplicação para teste escolhida seja o Postman, seguir os próximos passos:
* Dentro da aba selecionar o método de envio de parâmetro como POST
* Após isso preencher com o seguinte endereço: 
https://projeto-mutante.appspot.com/mutant
* Selecionar a opção Body 
* Marcar a opção raw e JSON(application/json)
* Na caixa de texto preencher com o JSON com os dados que quiser testar. Exemplo:

{
"dna":["ATCGCTA","CAGTAC","TTATTT","AGAAGG","CCAATA","TCACTG"]
}

* Deverá ficar como na imagem abaixo:
![alt text](https://user-images.githubusercontent.com/39503782/44693275-4c9ec280-aa3d-11e8-8223-2bd383bf404e.png)

* Enviar clicando no botão SEND
* A resposta aparecerá abaixo no campo "Status"

## Autora
Vanessa Viana - https://github.com/vanessanv
