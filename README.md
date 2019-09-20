## UDP Data Producer
Produces data over UDP. These are comma-separated data.

[![asciicast](https://asciinema.org/a/cUqeKwZubGwR2pKc2PXI1lo8I.png)](https://asciinema.org/a/cUqeKwZubGwR2pKc2PXI1lo8I)

![example gif 2](https://s3.eu-central-1.amazonaws.com/sickill/github/asciicast2gif/demo-2.gif)

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
docker run --rm -v $PWD:/data asciinema/asciicast2gif -S 1 -w 206 -h 35 https://asciinema.org/a/cUqeKwZubGwR2pKc2PXI1lo8I.json demo.gif
```