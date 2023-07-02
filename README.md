# Pomodoro timer

This is a simple [pomodoro timer](https://en.wikipedia.org/wiki/Pomodoro_Technique).
It was built to try out how [Kotlin Compose](https://www.jetbrains.com/lp/compose-multiplatform/)
UI framework works for desktop.

<img width="794" alt="Screenshot 2023-07-02 at 14 25 55" src="https://github.com/chillleader/pomodoro/assets/38818382/d80ee58f-14d7-4cba-94cb-003a91740899">

## How to run

```shell
./gradlew run
```

## How to build a native executable

(for Mac OS X, other OS would require changes to the `build.gradle.kts` file)

```shell
./gradlew packageDmg
```
