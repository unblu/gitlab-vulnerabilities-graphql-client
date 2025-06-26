package graphql.gitlab.model;

import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonProperty;

@Name("Issue")
public class Issue {

    /**
     * ID of the issue.
     */
    private String id;

    /**
     * Internal ID of the issue.
     */
    private String iid;

    /**
     * State of the issue.
     */
    private IssueState state;

    /**
     * Title of the issue.
     */
    private String title;

    /**
     * Web path of the issue.
     */
    private String webPath;

    /**
     * Web URL of the issue.
     */
    private String webUrl;

    public String getId() {
        return id;
    }

    public Issue setId(String id) {
        this.id = id;
        return this;
    }

    public String getIid() {
        return iid;
    }

    public Issue setIid(String iid) {
        this.iid = iid;
        return this;
    }

    public IssueState getState() {
        return state;
    }

    public Issue setState(IssueState state) {
        this.state = state;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Issue setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getWebPath() {
        return webPath;
    }

    public Issue setWebPath(String webPath) {
        this.webPath = webPath;
        return this;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public Issue setWebUrl(String webUrl) {
        this.webUrl = webUrl;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return "Issue";
    }

    @JsonProperty("__typename")
    public void setTypename(String type) {
        //Setter only for Jackson
        if(!"Issue".equals(type)) {
            throw new IllegalArgumentException("Unexpected '__typename' value: " + type);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iid, state, title, webPath, webUrl);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Issue other = (Issue) obj;
        return Objects.equals(id, other.id) && Objects.equals(iid, other.iid) && Objects.equals(state, other.state) && Objects.equals(title, other.title) && Objects.equals(webPath, other.webPath) && Objects.equals(webUrl, other.webUrl);
    }

    @Override
    public String toString() {
        return "Issue [id=" + id + ", iid=" + iid + ", state=" + state + ", title=" + title + ", webPath=" + webPath + ", webUrl=" + webUrl + "]";
    }

}
