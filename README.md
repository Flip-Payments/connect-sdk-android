# connect-sdk-android
[![](https://jitpack.io/v/Flip-Payments/connect-sdk-android.svg)](https://jitpack.io/#Flip-Payments/connect-sdk-android) [![Github Version](https://img.shields.io/github/release/Flip-Payments/connect-sdk-android.svg)](https://github.com/Flip-Payments/connect-sdk-ios/releases)

SDK de integração com o Connect API.

## Como funiona

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
    // wallet sdk
      compile 'com.github.Flip-Payments:connect-sdk-android:0.1.0'
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

### Inicializando o Connect

Você deve fornecer suas informações cadastradas no ambiente do Connect para inicializar a lib
```java

ConnectConfigurations config = new ConnectConfigurations();
config.setClientId("CLIENTID");
config.setClientSecret("CLIENTSECRET");
config.setHost("HOST");
config.setSchema("SCHEMA");
config.setPublicToken("PUBLICTOKEN");
config.setFingerPrintID("FINGERPRINT");

//config.setTempProfile(feedTempProfile()); // Leia na WIKI(em progresso)

Connect.initializer(config);
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
