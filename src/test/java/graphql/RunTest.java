package graphql;

import graphql.gitlab.api.VulnerabilitiesClientApi;
import io.smallrye.graphql.client.typesafe.api.TypesafeGraphQLClientBuilder;

class RunTest {

    private VulnerabilitiesClientApi api = createApi();

    private static VulnerabilitiesClientApi createApi() {
        return TypesafeGraphQLClientBuilder.newBuilder()
                .endpoint("https://gitlab.com/api/graphql")
                .allowUnexpectedResponseFields(true)
                .build(VulnerabilitiesClientApi.class);
    }
}
