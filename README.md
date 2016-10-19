## O Projeto 
O objetivo dessa prática é desenvolver os conhecimentos adquiridos em programação Socket com a linguagem de programação Java.

## Autor(a)
Ana Clara (github.com/claranobre)

## Proposta
Criar um protocolo de aplicação que simule um chat de conversação garantindo a segurança dos integrantes e a integridade das suas mensagens, em quê só pessoas autorizadas poderão utilizar o chat em redes distintas. A implementação busca resolver as falhas de segurança de comunicação existentes em que ataques como "man in the middle" são propícios. 

## O quê foi desenvolvido?
O desenvolvimento está baseado em uma classe Servidor, que irá gerir o recebimento das mensagens e garantir que a mensagem enviada seja recebida pelo seu destinatário. E uma classe Cliente que irá enviar mensagens para outros clientes passando pelo servidor para garantir sua integridade. O uso de Thread garante a organização do envio das mensagens, escalonamento do uso da porta de acesso para a comunicação e o Socket irá garantir a escuta do servidor e seus clientes. O protocolo de rede utilizado foi o TCP por ser necessário o recebimento total dos dados, uma vez que, se algum pacote for perdido, a mensagem não śerá recebida pelo receptor.

## Problemáticas
A aplicação não está garantindo integridade das conversas até o momento, por faltar desenvolver a leitura e armazenamento de chaves de acesso para comunicação de ponta a ponta. Assim como não está garantindo a segurança dos usuários, já que os testes foram locais, sem envio ou recebimento de mensagem externa da rede, sem autenticação. Para tal é necessário criar uma estrutura para o Servidor e nele configurar sua infraestrutura para solicitação de autenticação, verificação de chaves de acesso e não armazenamento de mensagens. 

## Como utilizar
Após baixar o .zip do projeto, independente da IDE que seja utilizada, é necessário acessar o terminal(Linux) ou cmd(Windows) e digitar:
 * javac RodaServidor.java
 * javac RodaCliente.java

 Se não existir nenhum erro no terminal o usuário precisa executar:
 * java RodaServidor
 * java RodaCliente

 Com a aplicação rodando, os clientes poderão trocar mensagens entre si.