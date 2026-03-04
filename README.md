# TrucoScoreBoard

Aplicativo Android simples para marcar pontos no **Truco**, com placar para **duas equipes (A e B)**.

## Funcionalidades

- Placar para **Equipe A** e **Equipe B**
- Botões para adicionar **+1** e **+3** pontos para cada equipe
- **Bloqueio do +3** quando a equipe chega em **11 pontos** (mão de 11)
- Alertas de **Mão de 11**:
  - Quando **uma** equipe chega em 11
  - Quando **ambas** chegam em 11 (“jogo no escuro”)
- Estrutura usando **ViewBinding**
- Projeto em **Kotlin**

## Regras consideradas (implementação)

- A pontuação vai sendo somada normalmente
- Ao chegar em **11 pontos**, o botão de **+3** daquela equipe é desabilitado
- Ao atingir **12 pontos ou mais**, deve ser exibido o vencedor

## Requisitos

- **Android Studio** (recomendado: versão mais recente)
- **JDK 11** (o projeto está configurado com compatibilidade Java 11)
- Dispositivo/emulador Android

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/MuriloCSS/TrucoScoreBoard.git
   ```
2. Abra no **Android Studio**
3. Aguarde o **Gradle Sync**
4. Rode o app (Run) em um **emulador** ou **dispositivo físico**

## Estrutura (resumo)

- `app/src/main/java/.../MainActivity.kt`: lógica principal do placar e alertas
- `app/src/main/res/`: recursos (layout, strings, temas, etc.)

## Tecnologias

- Kotlin
- Android SDK
- ViewBinding
- Material / AndroidX
