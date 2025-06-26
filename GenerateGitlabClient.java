///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS fr.jmini.graphql:graphql-client-generator:1.0.0-SNAPSHOT

//JAVA 17

package codegen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import fr.jmini.genovify.util.CodeUtil;
import fr.jmini.genovify.util.FileUtil;
import fr.jmini.gql.codegen.Generator;
import fr.jmini.gql.codegen.config.ArgsFilter;
import fr.jmini.gql.codegen.config.Config;
import fr.jmini.gql.codegen.config.CustomScalarMappingStrategy;
import fr.jmini.gql.codegen.config.FieldHint;
import fr.jmini.gql.codegen.config.FieldsFilter;
import fr.jmini.gql.codegen.config.GraphQLClientApiAnnotation;
import fr.jmini.gql.codegen.config.IncludeStrategy;
import fr.jmini.gql.codegen.config.NestedParameter;
import fr.jmini.gql.codegen.config.Scope;
import fr.jmini.gql.codegen.config.TypesFilter;
import fr.jmini.gql.schema.SchemaUtil;
import fr.jmini.gql.schema.model.IntrospectionResponse;
import fr.jmini.gql.schema.model.Kind;
import fr.jmini.gql.schema.model.Schema;

class GenerateVulnerabilitiesGitlabClient {

    public static void main(String... args) throws IOException {
        Path schemaFile = Paths.get("gitlab-graphqlschema.json");
        ObjectMapper mapper = createMapper();
        Schema schema = getSchema(mapper, schemaFile);
        Config config = createConfig(schema);

        Path sourceFolder = Paths.get("src/main/java");
        FileUtil.deleteFolder(CodeUtil.toPackageFolder(sourceFolder, config.getModelPackageName()));
        FileUtil.deleteFolder(CodeUtil.toPackageFolder(sourceFolder, config.getClientApiPackageName()));
        Generator.generateCode(sourceFolder, config);

        System.out.println("DONE");
    }

    public static Config createConfig(Schema schema) {
        ObjectMapper mapper = createMapper();

        TypesFilter typesFilter = new TypesFilter()
                .setTypeKind(Kind.OBJECT)
                .addIncludeName("Project") //
                .addIncludeName("Pipeline") //
                .addIncludeName("PipelineSecurityReportFindingConnection") //
                .addIncludeName("PipelineSecurityReportFinding") //
                .addIncludeName("VulnerabilityIdentifier") //
                .addIncludeName("VulnerabilityScanner") //
                .addIncludeName("VulnerabilityLocationClusterImageScanning") //
                .addIncludeName("VulnerabilityLocationContainerScanning") //
                .addIncludeName("VulnerabilityLocationDependencyScanning") //
                .addIncludeName("VulnerabilityLocationSast") //
                .addIncludeName("VulnerabilityLocationSecretDetection") //
                .addIncludeName("VulnerabilityLocationDast") //
                .addIncludeName("VulnerabilityLocationDast") //
                .addIncludeName("VulnerableKubernetesResource") //
                .addIncludeName("ClusterAgent") //
                .addIncludeName("VulnerabilityIssueLinkConnection") //
                .addIncludeName("VulnerabilityIssueLink") //
                .addIncludeName("Issue") //
                .addIncludeName("Vulnerability") //
                .addIncludeName("VulnerabilityExternalIssueLinkConnection") //
                .addIncludeName("VulnerabilityExternalIssueLink") //
                .addIncludeName("ExternalIssue") //
                .addIncludeName("PageInfo") //
        ;

        Config config = new Config()
                .setUseJacksonAnnotation()
                .setSchema(schema)
                .setDefaultCustomScalarMapping(CustomScalarMappingStrategy.CREATE_CUSTOM_SCALAR_CLASS)
                .setScope(new Scope()
                        .setDefaultStrategy(IncludeStrategy.INCLUDE_NONE)
                        .addHint(new FieldHint()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName(SchemaUtil.getQueryType(schema)
                                        .getName())
                                .setFieldName("project")
                                .setJavaMethodName("pipelineFindings") //
                                .addNestedParameter(new NestedParameter()
                                        .setGraphQlNestedParameterPath("pipeline")
                                        .setGraphQlName("iid")
                                        .setParameterType("{ModelPackageName}.ID") //
                                        .setParameterName("pipelineId") //
                                )
                                .addNestedParameter(new NestedParameter()
                                        .setGraphQlNestedParameterPath("pipeline.securityReportFindings")
                                        .setGraphQlName("after")
                                        .setParameterType("String") //
                                        .setParameterName("findingsAfter") //
                                ) //
                        )
                        .addFilter(typesFilter)//
                        .addFilter(new TypesFilter()
                                .setTypeKind(Kind.SCALAR)
                                .addIncludeName("ID") //
                                .addIncludeName("VulnerabilitiesExternalIssueLinkID") //
                        ) //
                        .addFilter(new TypesFilter()
                                .setTypeKind(Kind.UNION)
                                .addIncludeName("VulnerabilityLocation") //
                        ) //
                        .addFilter(new TypesFilter()
                                .setTypeKind(Kind.ENUM)
                                .addIncludeName("VulnerabilityReportType") //
                                .addIncludeName("VulnerabilityState") //
                                .addIncludeName("VulnerabilitySeverity") //
                                .addIncludeName("VulnerabilityDismissalReason") //
                                .addIncludeName("IssueState") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName(schema.getQueryType()
                                        .getName())
                                .addIncludeName("project") //
                        ) //
                        .addFilter(new ArgsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName(schema.getQueryType()
                                        .getName())
                                .setFieldName("project") //
                                .addIncludeName("fullPath") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("Project")
                                .addIncludeName("id") //
                                .addIncludeName("name") //
                                .addIncludeName("fullPath") //
                                .addIncludeName("webUrl") //
                                .addIncludeName("pipeline") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("Pipeline")
                                .addIncludeName("id") //
                                .addIncludeName("securityReportFindings") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("PipelineSecurityReportFindingConnection")
                                .addIncludeName("nodes") //
                                .addIncludeName("pageInfo") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("PipelineSecurityReportFinding")
                                .addIncludeName("uuid") //
                                .addIncludeName("title") //
                                .addIncludeName("description") //
                                .addIncludeName("falsePositive") //
                                .addIncludeName("identifiers") //
                                .addIncludeName("reportType") //
                                .addIncludeName("scanner") //
                                .addIncludeName("state") //
                                .addIncludeName("dismissalReason") //
                                .addIncludeName("severity") //
                                .addIncludeName("solution") //
                                .addIncludeName("location") //
                                .addIncludeName("issueLinks") //
                                .addIncludeName("vulnerability") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityIdentifier")
                                .addIncludeName("externalType") //
                                .addIncludeName("name") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityScanner")
                                .addIncludeName("id") //
                                .addIncludeName("vendor") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityLocationClusterImageScanning")
                                .addIncludeName("image") //
                                .addIncludeName("kubernetesResource") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerableKubernetesResource")
                                .addIncludeName("agent") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("ClusterAgent")
                                .addIncludeName("id") //
                                .addIncludeName("name") //
                                .addIncludeName("webPath") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityLocationContainerScanning")
                                .addIncludeName("image") //
                                .addIncludeName("containerRepositoryUrl") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityLocationDependencyScanning")
                                .addIncludeName("blobPath") //
                                .addIncludeName("file") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityLocationSast")
                                .addIncludeName("blobPath") //
                                .addIncludeName("file") //
                                .addIncludeName("startLine") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityLocationSecretDetection")
                                .addIncludeName("blobPath") //
                                .addIncludeName("file") //
                                .addIncludeName("startLine") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityLocationDast")
                                .addIncludeName("path") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityIssueLinkConnection")
                                .addIncludeName("nodes") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityIssueLink")
                                .addIncludeName("id") //
                                .addIncludeName("issue") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("Issue")
                                .addIncludeName("id") //
                                .addIncludeName("iid") //
                                .addIncludeName("webUrl") //
                                .addIncludeName("webPath") //
                                .addIncludeName("title") //
                                .addIncludeName("state") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("Vulnerability")
                                .addIncludeName("id") //
                                .addIncludeName("externalIssueLinks") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityExternalIssueLinkConnection")
                                .addIncludeName("nodes") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("VulnerabilityExternalIssueLink")
                                .addIncludeName("id") //
                                .addIncludeName("externalIssue") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("ExternalIssue")
                                .addIncludeName("webUrl") //
                                .addIncludeName("externalTracker") //
                                .addIncludeName("title") //
                                .addIncludeName("relativeReference") //
                        ) //
                        .addFilter(new FieldsFilter()
                                .setTypeKind(Kind.OBJECT)
                                .setTypeName("PageInfo")
                                .addIncludeName("hasNextPage") //
                                .addIncludeName("endCursor") //
                                .addIncludeName("startCursor") //
                        ) //
                )
                .setModelPackageName("gitlab.model")
                .setClientApiPackageName("gitlab.api")
                .setClientApiInterfaceName("VulnerabilitiesClientApi")
                .setGraphQLClientApiAnnotation(new GraphQLClientApiAnnotation() //
                        .setConfigKey("gitlab")//
                        .setEndpoint("https://gitlab.com/api/graphql") //
                );
        return config;
    }

    public static Schema getSchema(ObjectMapper mapper, Path file) {
        String originalContent = FileUtil.readFile(file);
        try {
            return mapper.readValue(originalContent, IntrospectionResponse.class)
                    .getSchema();
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Could not read schema: " + file, e);
        }
    }

    private static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        return mapper;
    }

}
