package graphql.gitlab.model;

import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a vulnerable Kubernetes resource. Used in vulnerability location data
 */
@Name("VulnerableKubernetesResource")
public class VulnerableKubernetesResource {

    /**
     * Kubernetes agent that performed the scan.
     */
    private ClusterAgent agent;

    public ClusterAgent getAgent() {
        return agent;
    }

    public VulnerableKubernetesResource setAgent(ClusterAgent agent) {
        this.agent = agent;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return "VulnerableKubernetesResource";
    }

    @JsonProperty("__typename")
    public void setTypename(String type) {
        //Setter only for Jackson
        if(!"VulnerableKubernetesResource".equals(type)) {
            throw new IllegalArgumentException("Unexpected '__typename' value: " + type);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(agent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VulnerableKubernetesResource other = (VulnerableKubernetesResource) obj;
        return Objects.equals(agent, other.agent);
    }

    @Override
    public String toString() {
        return "VulnerableKubernetesResource [agent=" + agent + "]";
    }

}
