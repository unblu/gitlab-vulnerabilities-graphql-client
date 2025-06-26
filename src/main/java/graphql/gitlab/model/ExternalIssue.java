package graphql.gitlab.model;

import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an external issue
 */
@Name("ExternalIssue")
public class ExternalIssue {

    /**
     * Type of external tracker.
     */
    private String externalTracker;

    /**
     * Relative reference of the issue in the external tracker.
     */
    private String relativeReference;

    /**
     * Title of the issue in the external tracker.
     */
    private String title;

    /**
     * URL to the issue in the external tracker.
     */
    private String webUrl;

    public String getExternalTracker() {
        return externalTracker;
    }

    public ExternalIssue setExternalTracker(String externalTracker) {
        this.externalTracker = externalTracker;
        return this;
    }

    public String getRelativeReference() {
        return relativeReference;
    }

    public ExternalIssue setRelativeReference(String relativeReference) {
        this.relativeReference = relativeReference;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ExternalIssue setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public ExternalIssue setWebUrl(String webUrl) {
        this.webUrl = webUrl;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return "ExternalIssue";
    }

    @JsonProperty("__typename")
    public void setTypename(String type) {
        //Setter only for Jackson
        if(!"ExternalIssue".equals(type)) {
            throw new IllegalArgumentException("Unexpected '__typename' value: " + type);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalTracker, relativeReference, title, webUrl);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ExternalIssue other = (ExternalIssue) obj;
        return Objects.equals(externalTracker, other.externalTracker) && Objects.equals(relativeReference, other.relativeReference) && Objects.equals(title, other.title) && Objects.equals(webUrl, other.webUrl);
    }

    @Override
    public String toString() {
        return "ExternalIssue [externalTracker=" + externalTracker + ", relativeReference=" + relativeReference + ", title=" + title + ", webUrl=" + webUrl + "]";
    }

}
