## Socket 
Projeto para a disciplina de Redes de Computadores para a prática do uso de Sockets e Threads.

## Autor(a)
Ana Clara (github.com/claranobre)

## Objetivo
Criar uma aplicação que simule um chat de conversação garantindo a segurança dos integrantes e a integridade das suas mensagens, em quê só pessoas autorizadas poderão utilizar o chat.

## O quê foi desenvolvido?
A aplicação possui o Cliente e Servidor, funcionando com o uso de thread e socket garantindo o envio e recebimento de mensagens entre eles. Em que uma classe fica responsável pela inicialiação do servidor e outra pelo cliente.

## Problemáticas
A aplicação não está garantindo integridade das conversas até o momento, por faltar desenvolver a leitura e armazenamento de chaves de acesso para comunicação de ponta a ponta. Assim como não está garantindo a segurança dos usuários, já que os testes foram locais, sem envio ou recebimento de mensagem externa da rede.

## Como testar
Após baixar o .zip do projeto, independente da IDE que seja utilizada, ou não, é necessário acessar o terminal(Linux) ou cmd(Windows) e digitar:
 * javac RodaServidor.java
 * javac RodaCliente.java

 Se não existir nenhum erro no mesmo portal acessado (terminal) o usuário precisa executar:
 java RodaServidor
 java RodaCliente