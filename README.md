# TrucoScoreBoard

Marcador de pontos para partidas de Truco desenvolvido para Android, projetado para controlar a pontuação de dois times (A e B).

## Recursos

- Controle de pontos para o Time A e Time B
- Ações rápidas para somar +1 ou +3 tentos por rodada
- Desativação automática do acréscimo de +3 pontos ao atingir 11 tentos (mão de onze)
- Notificações na interface para cenários de Mão de 11:
  - Notificação quando um dos times atinge 11 pontos
  - Notificação especial quando ambos alcançam 11 pontos (mão de ferro / no escuro)
  - Interface vinculada via ViewBinding
  - Código-fonte escrito em Kotlin

## Lógica e Regras do Jogo

- Incremento contínuo da pontuação durante a partida
- Desativação do botão de +3 pontos para o time que alcançar a marca de 11 tentos
- Encerramento e declaração de vitória ao atingir ou ultrapassar 12 pontos

## Pré-requisitos

- Android Studio (recomenda-se utilizar a versão estável mais atual)
- Java Development Kit (JDK) 11 configurado
- Aparelho físico com Android ou emulador configurado

## Instruções de Execução

1. Faça o clone deste repositório:
   ```bash
   git clone [https://github.com/MuriloCSS/TrucoScoreBoard.git](https://github.com/MuriloCSS/TrucoScoreBoard.git)
