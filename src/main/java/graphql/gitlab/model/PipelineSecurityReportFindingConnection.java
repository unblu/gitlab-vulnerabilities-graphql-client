package graphql.gitlab.model;

import java.util.List;
import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The connection type for PipelineSecurityReportFinding.
 */
@Name("PipelineSecurityReportFindingConnection")
public class PipelineSecurityReportFindingConnection {

    /**
     * A list of nodes.
     */
    private List<PipelineSecurityReportFinding> nodes;

    /**
     * Information to aid in pagination.
     */
    private PageInfo pageInfo;

    public List<PipelineSecurityReportFinding> getNodes() {
        return nodes;
    }

    public PipelineSecurityReportFindingConnection setNodes(List<PipelineSecurityReportFinding> nodes) {
        this.nodes = nodes;
        return this;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public PipelineSecurityReportFindingConnection setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return "PipelineSecurityReportFindingConnection";
    }

    @JsonProperty("__typename")
    public void setTypename(String type) {
        //Setter only for Jackson
        if(!"PipelineSecurityReportFindingConnection".equals(type)) {
            throw new IllegalArgumentException("Unexpected '__typename' value: " + type);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes, pageInfo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PipelineSecurityReportFindingConnection other = (PipelineSecurityReportFindingConnection) obj;
        return Objects.equals(nodes, other.nodes) && Objects.equals(pageInfo, other.pageInfo);
    }

    @Override
    public String toString() {
        return "PipelineSecurityReportFindingConnection [nodes=" + nodes + ", pageInfo=" + pageInfo + "]";
    }

}
