package graphql.gitlab.api;

import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;

import graphql.gitlab.model.ID;
import graphql.gitlab.model.Project;
import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import io.smallrye.graphql.client.typesafe.api.NestedParameter;

@GraphQLClientApi(configKey = "gitlab")
public interface VulnerabilitiesClientApi {

    /**
     * Find a project.
     */
    @Query("project")
    Project pipelineFindings(@Name("fullPath") @NonNull @Id String fullPath, @NestedParameter("pipeline") @Name("iid") ID pipelineId, @NestedParameter("pipeline.securityReportFindings") @Name("after") String findingsAfter);

}
