package graphql.gitlab.model;

import org.eclipse.microprofile.graphql.Name;

/**
 * State of a GitLab issue
 */
@Name("IssueState")
public enum IssueState {

    /**
     * In open state.
     */
    opened,
    /**
     * In closed state.
     */
    closed,
    /**
     * Discussion has been locked.
     */
    locked,
    /**
     * All available.
     */
    all;

}
