package graphql.gitlab.model;

import java.util.Objects;

import org.eclipse.microprofile.graphql.Name;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * A `VulnerabilitiesExternalIssueLinkID` is a global ID. It is encoded as a string.
 *
 * An example `VulnerabilitiesExternalIssueLinkID` is: `"gid://gitlab/Vulnerabilities::ExternalIssueLink/1"`.
 */
@Name("VulnerabilitiesExternalIssueLinkID")
public class VulnerabilitiesExternalIssueLinkID {

    private String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public VulnerabilitiesExternalIssueLinkID(@JsonProperty("value") String value) {
        this.value = value;
    }

    public static VulnerabilitiesExternalIssueLinkID valueOf(String value) {
        return new VulnerabilitiesExternalIssueLinkID(value);
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VulnerabilitiesExternalIssueLinkID other = (VulnerabilitiesExternalIssueLinkID) obj;
        return Objects.equals(value, other.value);
    }
}
