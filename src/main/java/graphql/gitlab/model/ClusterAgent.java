package graphql.gitlab.model;

import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonProperty;

@Name("ClusterAgent")
public class ClusterAgent {

    /**
     * ID of the cluster agent.
     */
    private String id;

    /**
     * Name of the cluster agent.
     */
    private String name;

    /**
     * Web path of the cluster agent.
     */
    private String webPath;

    public String getId() {
        return id;
    }

    public ClusterAgent setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClusterAgent setName(String name) {
        this.name = name;
        return this;
    }

    public String getWebPath() {
        return webPath;
    }

    public ClusterAgent setWebPath(String webPath) {
        this.webPath = webPath;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return "ClusterAgent";
    }

    @JsonProperty("__typename")
    public void setTypename(String type) {
        //Setter only for Jackson
        if(!"ClusterAgent".equals(type)) {
            throw new IllegalArgumentException("Unexpected '__typename' value: " + type);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, webPath);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClusterAgent other = (ClusterAgent) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(webPath, other.webPath);
    }

    @Override
    public String toString() {
        return "ClusterAgent [id=" + id + ", name=" + name + ", webPath=" + webPath + "]";
    }

}
