# TesteOnedoor
Agendamento de Serviços - MapLink

Foi feito somente no Backend - API Rest

O serviço é uma entidade responsável pelo armazenamento dos dados de serviços e deve
possuir as operações bases (criar, listar, atualizar e deletar).

Feramenta utilizadas(no Windows) foram:

Framework/lib | Versão Recomendada
--- | --- 
Maven	| 3.6.3	
JDK	| 8	
Docker	| 19.03.13 
Docker Compose |	1.27.4	
VSCode(Com todas bibliotecas necessárias do Maven)	| -	

## Execução do projeto
### Passo 1
Baixar o projeto e entrar com ele pront comando com

```shell script
$ cd agendamentoapp
```
### Passo 2
Executar o comando do maven para gerar o artefato que será publicado no docker
```shell script
$ cd mvn clean install
```
### Passo 3
Execute o comando para levantar toda infraestrutura necessária

```shell script
$ docker-compose up --build
```
Acompanhar logs:
```shell script
$ docker-compose logs -f
