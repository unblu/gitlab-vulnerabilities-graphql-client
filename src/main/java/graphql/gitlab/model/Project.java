package graphql.gitlab.model;

import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonProperty;

@Name("Project")
public class Project {

    /**
     * Full path of the project.
     */
    private String fullPath;

    /**
     * ID of the project.
     */
    private String id;

    /**
     * Name of the project (without namespace).
     */
    private String name;

    /**
     * Pipeline of the project. If no arguments are provided, returns the latest pipeline for the head commit on the default branch
     */
    private Pipeline pipeline;

    /**
     * Web URL of the project.
     */
    private String webUrl;

    public String getFullPath() {
        return fullPath;
    }

    public Project setFullPath(String fullPath) {
        this.fullPath = fullPath;
        return this;
    }

    public String getId() {
        return id;
    }

    public Project setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public Pipeline getPipeline() {
        return pipeline;
    }

    public Project setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
        return this;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public Project setWebUrl(String webUrl) {
        this.webUrl = webUrl;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return "Project";
    }

    @JsonProperty("__typename")
    public void setTypename(String type) {
        //Setter only for Jackson
        if(!"Project".equals(type)) {
            throw new IllegalArgumentException("Unexpected '__typename' value: " + type);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullPath, id, name, pipeline, webUrl);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        return Objects.equals(fullPath, other.fullPath) && Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(pipeline, other.pipeline) && Objects.equals(webUrl, other.webUrl);
    }

    @Override
    public String toString() {
        return "Project [fullPath=" + fullPath + ", id=" + id + ", name=" + name + ", pipeline=" + pipeline + ", webUrl=" + webUrl + "]";
    }

}
