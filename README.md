COWWEB
======
Cosay Web API.

```
$ curl "http://localhost:8080/cowsay/say?message=Hello%20cowweb"
 ______________
< Hello cowweb >
 --------------
        \   ^__^
         \  (oo)\_______
            (__)\       )\/\
                ||--WWW |
                ||     ||
```

How to build and run
--------------------

### gradle
Build a executable jar with dependencies and run localy.

#### Clone this repository.

```
git clone https://github.com/hhiroshell/cowweb.git && cd cowweb
```

#### Build and run.

```
./gradlew build
```
```
java -jar build/libs/cowweb-1.0.jar
```

#### Call the API.
You can call the API via localhost:8080 .

```
curl "http://localhost:8080/cowsay/say"
```

And you can specify a message using "message" query (special characters have to be URL encorded).

```
curl "http://localhost:8080/cowsay/say?message=hello%20cowweb"
```
