# connect-sdk-android
[![](https://jitpack.io/v/Flip-Payments/connect-sdk-android.svg)](https://jitpack.io/#Flip-Payments/connect-sdk-android)

SDK de integração com o Connect API.

###### Você pode ver toda a nossa documentação [aqui](https://github.com/Flip-Payments/connect-sdk-android/wiki/Getting-Started)

### Gradle

Adicione o artifactory no `/build.gradle` raíz

```gradle
    allprojects {
        repositories {
            jcenter()
           maven { url "https://jitpack.io" }
        }
    }
```

E no seu `app/build.gradle`
```gradle
    // wallet sdk
      compile 'com.github.Flip-Payments:connect-sdk-android:0.1.0'
```
