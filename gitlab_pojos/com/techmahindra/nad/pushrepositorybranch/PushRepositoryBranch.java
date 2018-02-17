
package com.techmahindra.nad.pushrepositorybranch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "id",
    "branch",
    "commit_message",
    "start_branch",
    "actions"
})
public class PushRepositoryBranch {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("branch")
    private String branch;
    @JsonProperty("commit_message")
    private String commitMessage;
    @JsonProperty("start_branch")
    private String startBranch;
    @JsonProperty("actions")
    private List<Action> actions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("branch")
    public String getBranch() {
        return branch;
    }

    @JsonProperty("branch")
    public void setBranch(String branch) {
        this.branch = branch;
    }

    @JsonProperty("commit_message")
    public String getCommitMessage() {
        return commitMessage;
    }

    @JsonProperty("commit_message")
    public void setCommitMessage(String commitMessage) {
        this.commitMessage = commitMessage;
    }

    @JsonProperty("start_branch")
    public String getStartBranch() {
        return startBranch;
    }

    @JsonProperty("start_branch")
    public void setStartBranch(String startBranch) {
        this.startBranch = startBranch;
    }

    @JsonProperty("actions")
    public List<Action> getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
