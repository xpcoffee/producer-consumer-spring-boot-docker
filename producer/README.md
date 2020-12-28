# Producer

Exposes an API on port 8080 which can be called to produce new messages.

## API

**To create a new message**

```text
POST to /produce with the message in the call body
```

e.g.

```sh
curl -X POST -d "hello world" localhost:8080/produce
```

## Development

### Pre-requisites

**AWS Credentials**

This service uses [Amazon SQS](https://aws.amazon.com/sqs/) and requires valid API credentials. 

The credentials:

1. Must be defined in `$HOME/.aws/credentials` as the profile defined in [application.yaml](./src/main/resources/application.yml).
1. Must have write permissions for Amazon SQS

**Amazon SQS queue**

An Amazon SQS queue must exist:

 * with the name defined in [AppConfig](./src/main/java/com/example/producer/AppConfig.java) and in the AWS region defined 
 * in the AWS region defined in [application.yaml](./src/main/resources/application.yml)

### Using Docker

This is meant to be the primary way to test the service. Ensure that Docker is installed on your system.

Build:

```sh
docker build -t xpcoffee/producer . 
```

Run:

```sh
docker run -p 8080:8080 -e AWS_EC2_METADATA_DISABLED=true -v $HOME/.aws/credentials:/home/.aws/credentials xpcoffee/producer
```

### Without Docker

If you cannot use Docker, this section will guide you through some local modifications needed to run the service directly.

**NOTE:** You will need to have a Java runtime for Java 11 installed on your system.

1. Comment out `cloud > aws > credentials > profile-path` key in [application.yaml](./src/main/resources/application.yml)
1. Build the project
```sh
./gradlew build
```
1. Run the resulting JAR
```sh
java -jar ./build/libs/producer-0.0.1.jar
```
