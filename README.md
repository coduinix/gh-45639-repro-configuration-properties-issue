Spring ConfigurationProperties issue reproduction
-------------------------------------------------

The [GreetingProperties](src/main/java/com/example/demo/GreetingProperties.java) is a `@ConfigurationProperties` annotated class.
It contains a nested properties object `GreetingDetails`.

When the application is ran without specifying any system properties it runs as expected:
```shell
./mvnw spring-boot:run
```
A call to the hello endpoint will return the default salutation and default message:

```
$ curl http://localhost:8080/hello
Default Salutation, Default Message
```

All good, so far. Now **Stop** the application


Now when you try to override the `demo.greeting.message` and `demo.greeting.details.salutation` properties using System properties, something odd is going on.
```shell
./mvnw spring-boot:run \
  -Dspring-boot.run.jvmArguments='-Ddemo.greeting.message="Custom Message" -Ddemo.greeting.details.salutation="Custom Salutation"'
```

When the endpoint is called again with:
```shell
curl http://localhost:8080/hello
```

When the application is ran with `3.5.0-M3` the curl command returns:
```
Custom Salutation, Custom Message
```

But when the application is ran with `3.5.0-RC1` the curl command returns:
```
Default Salutation, Custom Message
```

> _NOTE_ The salutation should have been **Custom**, but it's returning **Default**

The system property does not seem to affect the _nested_ `GreetingDetails` property. 