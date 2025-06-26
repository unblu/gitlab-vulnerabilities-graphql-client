package graphql.gitlab.model;

import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonProperty;

@Name("Pipeline")
public class Pipeline {

    /**
     * ID of the pipeline.
     */
    private String id;

    /**
     * Vulnerability findings reported on the pipeline. By default all the states except dismissed are included in the response.
     */
    private PipelineSecurityReportFindingConnection securityReportFindings;

    public String getId() {
        return id;
    }

    public Pipeline setId(String id) {
        this.id = id;
        return this;
    }

    public PipelineSecurityReportFindingConnection getSecurityReportFindings() {
        return securityReportFindings;
    }

    public Pipeline setSecurityReportFindings(PipelineSecurityReportFindingConnection securityReportFindings) {
        this.securityReportFindings = securityReportFindings;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return "Pipeline";
    }

    @JsonProperty("__typename")
    public void setTypename(String type) {
        //Setter only for Jackson
        if(!"Pipeline".equals(type)) {
            throw new IllegalArgumentException("Unexpected '__typename' value: " + type);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, securityReportFindings);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pipeline other = (Pipeline) obj;
        return Objects.equals(id, other.id) && Objects.equals(securityReportFindings, other.securityReportFindings);
    }

    @Override
    public String toString() {
        return "Pipeline [id=" + id + ", securityReportFindings=" + securityReportFindings + "]";
    }

}
