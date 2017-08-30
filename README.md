
# connect-sdk-android

# ⚠ DEPRECATED ⚠

[![](https://jitpack.io/v/Flip-Payments/connect-sdk-android.svg)](https://jitpack.io/#Flip-Payments/connect-sdk-android) [![Github Version](https://img.shields.io/github/release/Flip-Payments/connect-sdk-android.svg)](https://github.com/Flip-Payments/connect-sdk-ios/releases)

## ⚠ ATENÇÃO ⚠

**Esta SDK não recebe mais suporte. Para integrar com a nossa plataforma, favor usar [stone-payments/onestap-sdk-android](https://github.com/stone-payments/onestap-sdk-android)**

SDK de integração com o Connect API.

## Como funciona

A FlipConnectSDK funciona recebendo **ClientId** e **ClientSecret** para abrir uma página web para logar exatamente como na autenticação do Facebook e do Google. O usuário irá logar no nosso ambiente e, caso seja bem sucedido, o usuário será redirecionado para a aplicação usando a previamente configurada **RedirectURI**.

Quando a aplicação abre, a SDK irá procurar por parâmetros válidos na URI, para que então possa fazer requisições para recuperar o **access token**, o **refresh token** e a **account key**.

Com essas informações você será capaz de acessar as informações do usuário!

## Instalação

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
      compile 'com.github.Flip-Payments:connect-sdk-android:x.x.x'
```

Veja abaixo como realizar a configuração inicial do Connect

## Usabilidade

### Configurando o Manifest

Você deve adicionar a activity de Login do Connect ao seu manifest. Também é necessário adicionar uma `intent-filter` contendo seu host e seu schema cadastrado no ambiente do Connect.
```xml
 <activity android:name="com.flip.connect.presentation.login.LoginActivity">
            <intent-filter>
                <data
                    android:host="SEU_HOST"
                    android:schema="SEU_SCHEMA" />
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.BROWSABLE" />
                <category android:name="android.intent.category.DEFAULT" />

            </intent-filter>
        </activity>
```

### Inicialização
É necessário inicializar a classe ConnectConfigurations na abertura do app e devemos fazer esse trabalho dentro de uma especialização da classe Application, uma vez que essas instâncias devem ser declaradas apenas uma vez durante o ciclo de vida do aplicativo.

Você deve fornecer suas informações cadastradas no ambiente do Connect para inicializar a lib.
```java


public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ConnectConfigurations config = new ConnectConfigurations();
        config.setClientId("CLIENT_ID");
        config.setClientSecret("CLIENT_SECRET");
        config.setHost("HOST");
        config.setSchema("SCHEMA");
        config.setFingerPrintID("FINGER_PRINT_ID");
        config.setEnvironment("ENVIRONMENT"); // Environment.SANDBOX or Environment.PRODUCTION

        // config.setTempProfile(feedTempProfile()); // READ THE DOCUMENTATION


        Connect.initializer(App.this, config);

    }
}

```

Por especializar a classe `Application`, precisamos especificar a classe `MyApp` no arquivo `AndroidManifest.xml`. 
Com isso, por padrão seu app vai inicialmente instanciar a classe `MyApp`.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="br.com.flip">

    <application
        android:name=".MyApp"
        android:allowBackup="true">
        
        ...
        
    </application>

</manifest>

```


Após a inicialização, se for passado o fingerPrintID, o fingerPrintSessionId será setado e você poderá acessá-lo:

```java

  Connect.getInstance().getFingerPrintSessionId()

```

Após a configuração básica do Connect você poderá fazer o Login

### Adicionando botão de Login

Para realizar o login você deve adicionar nosso botão de Login da seguinte maneira:
```xml
  <com.flip.connect.presentation.widget.ConnectAuthenticationButton
        android:id="@+id/connectButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true" />
```

### Adicionar Callback para retorno do Login
```java 
 connectButton.setAccountCallback(new AccountCallback() {
            @Override
            public void success(OauthToken response) {
                Toast.makeText(MainActivity.this, "login realizado com sucesso", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void error(Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
```

### Atualizando o token

A atualização de token é feita através da classe ConnectAuth. É necessário implementar a interface `AccountCallback `para ter acesso ao sucesso ou falha da solicitação de atualização do token.

**Exemplo de implementação:**
```java
 new ConnectAuth(context).refreshToken(new AccountCallback() {
                    @Override
                    public void success(OauthToken response) {
                        Toast.makeText(MainActivity.this, "refresh realizado com sucesso", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void error(Throwable e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

```

### Verificando se o token é válido

A verificação de token é feita através da classe ConnectAuth. É necessário implementar a interface `AccountCallback `para ter acesso ao sucesso ou falha da solicitação de verificação do token. Ao receber o retorno no `success `do `AccountCallback` você deve verificar se o `token.hasSuccess()` é `true`(token válido) ou `false `(token inválido)

**Exemplo de implementação:**
```java
  new ConnectAuth(context).verifyToken(new AccountCallback() {
                    @Override
                    public void success(OauthToken response) {
                        Toast.makeText(MainActivity.this, "verify token realizado com sucesso", Toast.LENGTH_SHORT).show();
                        if (response.hasSuccess()) {
                            Toast.makeText(MainActivity.this, "token valido", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "token invalido", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void error(Throwable e) {
                        e.printStackTrace();
                    }
                });
```

## Contribuições

Pull requests serão muito bem-vindos!

## Problemas

Algum problema, dúvida ou sugestão? [Abra uma issue!](https://github.com/Flip-Payments/connect-sdk-android/issues/new)
