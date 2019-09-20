## UDP Data Producer
Produces data over UDP. These are comma-separated data.

![asciicast](https://raw.githubusercontent.com/devacto/udp-data-producer/master/demo.gif)

### Build and Package
```
mvn clean package
```

### Run
```
java -jar target/udpclient-1.0-SNAPSHOT-jar-with-dependencies.jar configuration/dev.properties
```

### Producing the gif
```
docker run --rm -v $PWD:/data asciinema/asciicast2gif -S 1 -w 180 -h 20 https://asciinema.org/a/cUqeKwZubGwR2pKc2PXI1lo8I.json demo.gif
```