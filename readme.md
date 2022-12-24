# Сonnect

## Introduction

The library describes client-server connections in java, without using SpringFramework.

## Installation

[![](https://jitpack.io/v/blckRbbit/connect.svg)](https://jitpack.io/#blckRbbit/connect)

Add Dependencies

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

## Examples

**Client**

```java
Connect connect = new Connect("0.0.0.0", 8007);
String request = "Hey, Connect!";
connect.write(request);
```


**Server**

```java
int port = 8007;
ServerSocket server = new ServerSocket(port);
Connect connect = new Connect(server);
String request = connect.read();
String response = "Hey, User!";
connect.write(response);
```

## P.S


If your server is multi-threaded, then in each separate thread it is recommended to close the connection with the command

```java
connect.close();
```

Connect can be used as an argument in a try-with-resources block.

## License

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

## Note

**(Eng)**
All information and source code is provided in its original form,
without express or implied warranties. The use of the source code or part of it is carried out
solely at your discretion and risk. Developer takes reasonable steps to
ensure the relevance of the information posted in this repository, but does not assume
responsible for maintaining or updating this repository or parts thereof.