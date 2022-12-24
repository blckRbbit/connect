# Connect

## Введение

Библиотека описывает клиент-серверные соединения на языке java, без использования SpringFramework.

## Установка

[![](https://jitpack.io/v/blckRbbit/connect.svg)](https://jitpack.io/#blckRbbit/connect)

Добавьте зависимости

```groovy
  allprojects {
        repositories {
            // ...
            maven { url 'https://jitpack.io' }
        }
    }

    dependencies {
	        implementation 'com.github.blckRbbit:connect:Tag'
	}
```

## Примеры

**Клиент**

```java
Connect connect = new Connect("0.0.0.0", 8007);
String request = "Привет, Connect!";
connect.write(request);
```


**Сервер**

```java
int port = 8007;
ServerSocket server = new ServerSocket(port);
Connect connect = new Connect(server);
String request = connect.read();
String response = "Привет, User!";
connect.write(response);
```

## P.S

Если Ваш сервер многопоточен, то в каждом отдельном потоке рекомендуется закрывать соединение командой

```java
connect.close();
```

Connect может быть использован в качестве аргумента в блоке try-with-resources.

## Лицензия

Copyright 2022 blckRbbit

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## Примечание

**(Ru)**
Вся информация и исходный код предоставляются в исходном виде,
без явно выраженных или подразумеваемых гарантий. Использование исходного кода или его части осуществляются
исключительно по вашему усмотрению и на ваш риск. Разработчик принимает разумные меры для
обеспечения актуальности информации, размещенной в данном репозитории, но не принимает на себя
ответственности за поддержку или актуализацию данного репозитория или его частей.