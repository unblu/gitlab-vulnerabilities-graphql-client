# Smallrye Typesafe GraphQL client for GitLab Vulnerabilities

GraphQL typesafe client (relying on [Smallrye GraphQL](https://smallrye.io/smallrye-graphql/)) to call some [GitLab GraphQL endpoints](https://docs.gitlab.com/ee/api/graphql/reference/), in particular the Vulnerabilities one.

## Usage:

With this library and `io.smallrye:smallrye-graphql-client-implementation-vertx:2.11.0` on the classpath, the client can be instantiated with:

```java
VulnerabilitiesClientApi api =  TypesafeGraphQLClientBuilder.newBuilder()
                            .endpoint("https://gitlab.com/api/graphql")
                            // .header("Authorization", "Bearer " + gitlabToken)
                            .build(VulnerabilitiesClientApi.class);
```

This library can be used with Quarkus or Jbang.
