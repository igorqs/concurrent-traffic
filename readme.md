# Concurrent Traffic

Esse simulador de tráfego, feito em Java, desenvolvido usando a biblioteca gráfica Swing, foi criado como parte das aulas da disciplina Programação Concorrente. A estrutura do código segue as práticas recomendadas pelo professor.

Nesse simulador, cada carro é uma Thread, e elas compartilham regiões críticas. Para controlar o acesso simuntâneo a essas regiões, são utilizados semáforos.

![Peek 2023-11-30 01-49](https://github.com/igorqs/concurrent-traffic/assets/33406239/925e9ca5-08c6-44d9-9f8c-176299b987d3)

Para compilar, utilize o seguinte comando no terminal:

```bash

javac Principal.java
```

Para executar o jogo, digite o seguinte comando:

```bash

java Principal
```

