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

#### Inatall gradle.
See [the official documentation](https://gradle.org/install/).

#### Clone this repository.

```
git clone https://github.com/hhiroshell/cowweb.git && cd cowweb
```

#### Build and run.

```
gradle build
```
```
java -jar build_local/dist/libs/cowweb-0.1.jar
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


### Skaffold
Build a containized app and deploy to a kubernets cluster using skaffold.

#### Set up required CLIs
Set up kubectl, docker and skaffold.

- [kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)
- [docker](https://docs.docker.com/install/)
- [skaffold](https://github.com/GoogleContainerTools/skaffold)

And make sure you have access to a kuberentes cluster you want to deploy this app via kubectl. Typically you can use [minikube](https://github.com/kubernetes/minikube) for experimental use.

#### Clone this repository.

```
git clone https://github.com/hhiroshell/cowweb.git && cd cowweb
```

#### Call the API.
Skaffold builds containinzed app, and deploy to kubernets cluster automatically. As regards this repository, skaffold configured to skip pushing the container image to resistry. For details, see the configuration file [skaffold.yaml](https://github.com/hhiroshell/cowweb/blob/master/skaffold.yaml).

```
skaffold run
```

#### Build and run
You can find the app runnig in a pod and be exporsed via a service in the namespace "cowweb-local-dev", You can get the IP and port like a command below.

```
export COWWEB_HOST=$(kubectl get pod -n cowweb-local-dev -o 'jsonpath={.items[0].status.hostIP}'):$(kubectl get service cowweb -n cowweb-local-dev -o 'jsonpath={.spec.ports[0].nodePort}')
```

Then, call the API via COWWEB\_HOST.

```
curl "http://$COWWEB_HOST/cowsay/say?message=hello%20cowweb"
```
