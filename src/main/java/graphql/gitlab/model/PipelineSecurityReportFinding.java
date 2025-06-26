package graphql.gitlab.model;

import java.util.List;
import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents vulnerability finding of a security report on the pipeline.
 */
@Name("PipelineSecurityReportFinding")
public class PipelineSecurityReportFinding {

    /**
     * Description of the vulnerability finding.
     */
    private String description;

    /**
     * Reason for the dismissal of the security report finding.
     */
    private VulnerabilityDismissalReason dismissalReason;

    /**
     * Indicates whether the vulnerability is a false positive.
     */
    private Boolean falsePositive;

    /**
     * Identifiers of the vulnerability finding.
     */
    private List<VulnerabilityIdentifier> identifiers;

    /**
     * List of issue links related to the vulnerability.
     */
    private VulnerabilityIssueLinkConnection issueLinks;

    /**
     * Location metadata for the vulnerability. Its fields depend on the type of security scan that found the vulnerability.
     */
    private VulnerabilityLocation location;

    /**
     * Type of the security report that found the vulnerability finding.
     */
    private VulnerabilityReportType reportType;

    /**
     * Scanner metadata for the vulnerability.
     */
    private VulnerabilityScanner scanner;

    /**
     * Severity of the vulnerability finding.
     */
    private VulnerabilitySeverity severity;

    /**
     * Solution for resolving the security report finding.
     */
    private String solution;

    /**
     * Finding status.
     */
    private VulnerabilityState state;

    /**
     * Title of the vulnerability finding.
     */
    private String title;

    /**
     * UUIDv5 digest based on the vulnerability's report type, primary identifier, location, fingerprint, project identifier.
     */
    private String uuid;

    /**
     * Vulnerability related to the security report finding.
     */
    private Vulnerability vulnerability;

    public String getDescription() {
        return description;
    }

    public PipelineSecurityReportFinding setDescription(String description) {
        this.description = description;
        return this;
    }

    public VulnerabilityDismissalReason getDismissalReason() {
        return dismissalReason;
    }

    public PipelineSecurityReportFinding setDismissalReason(VulnerabilityDismissalReason dismissalReason) {
        this.dismissalReason = dismissalReason;
        return this;
    }

    public Boolean getFalsePositive() {
        return falsePositive;
    }

    public PipelineSecurityReportFinding setFalsePositive(Boolean falsePositive) {
        this.falsePositive = falsePositive;
        return this;
    }

    public List<VulnerabilityIdentifier> getIdentifiers() {
        return identifiers;
    }

    public PipelineSecurityReportFinding setIdentifiers(List<VulnerabilityIdentifier> identifiers) {
        this.identifiers = identifiers;
        return this;
    }

    public VulnerabilityIssueLinkConnection getIssueLinks() {
        return issueLinks;
    }

    public PipelineSecurityReportFinding setIssueLinks(VulnerabilityIssueLinkConnection issueLinks) {
        this.issueLinks = issueLinks;
        return this;
    }

    public VulnerabilityLocation getLocation() {
        return location;
    }

    public PipelineSecurityReportFinding setLocation(VulnerabilityLocation location) {
        this.location = location;
        return this;
    }

    public VulnerabilityReportType getReportType() {
        return reportType;
    }

    public PipelineSecurityReportFinding setReportType(VulnerabilityReportType reportType) {
        this.reportType = reportType;
        return this;
    }

    public VulnerabilityScanner getScanner() {
        return scanner;
    }

    public PipelineSecurityReportFinding setScanner(VulnerabilityScanner scanner) {
        this.scanner = scanner;
        return this;
    }

    public VulnerabilitySeverity getSeverity() {
        return severity;
    }

    public PipelineSecurityReportFinding setSeverity(VulnerabilitySeverity severity) {
        this.severity = severity;
        return this;
    }

    public String getSolution() {
        return solution;
    }

    public PipelineSecurityReportFinding setSolution(String solution) {
        this.solution = solution;
        return this;
    }

    public VulnerabilityState getState() {
        return state;
    }

    public PipelineSecurityReportFinding setState(VulnerabilityState state) {
        this.state = state;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PipelineSecurityReportFinding setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public PipelineSecurityReportFinding setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public Vulnerability getVulnerability() {
        return vulnerability;
    }

    public PipelineSecurityReportFinding setVulnerability(Vulnerability vulnerability) {
        this.vulnerability = vulnerability;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return "PipelineSecurityReportFinding";
    }

    @JsonProperty("__typename")
    public void setTypename(String type) {
        //Setter only for Jackson
        if(!"PipelineSecurityReportFinding".equals(type)) {
            throw new IllegalArgumentException("Unexpected '__typename' value: " + type);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, dismissalReason, falsePositive, identifiers, issueLinks, location, reportType, scanner, severity, solution, state, title, uuid, vulnerability);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PipelineSecurityReportFinding other = (PipelineSecurityReportFinding) obj;
        return Objects.equals(description, other.description) && Objects.equals(dismissalReason, other.dismissalReason) && Objects.equals(falsePositive, other.falsePositive) && Objects.equals(identifiers, other.identifiers) && Objects.equals(issueLinks, other.issueLinks) && Objects.equals(location, other.location) && Objects.equals(reportType, other.reportType) && Objects.equals(scanner, other.scanner) && Objects.equals(severity, other.severity) && Objects.equals(solution, other.solution) && Objects.equals(state, other.state) && Objects.equals(title, other.title) && Objects.equals(uuid, other.uuid) && Objects.equals(vulnerability, other.vulnerability);
    }

    @Override
    public String toString() {
        return "PipelineSecurityReportFinding [description=" + description + ", dismissalReason=" + dismissalReason + ", falsePositive=" + falsePositive + ", identifiers=" + identifiers + ", issueLinks=" + issueLinks + ", location=" + location + ", reportType=" + reportType + ", scanner=" + scanner + ", severity=" + severity + ", solution=" + solution + ", state=" + state + ", title=" + title + ", uuid=" + uuid + ", vulnerability=" + vulnerability + "]";
    }

}
