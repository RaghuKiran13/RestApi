
package com.techmahindra.nad.accept_mr;

import java.util.HashMap;
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
    "merge_request_iid",
    "merge_commit_message",
    "should_remove_source_branch",
    "merge_when_pipeline_succeeds",
    "sha"
})
public class AcceptMR {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("merge_request_iid")
    private Integer mergeRequestIid;
    @JsonProperty("merge_commit_message")
    private String mergeCommitMessage;
    @JsonProperty("should_remove_source_branch")
    private Boolean shouldRemoveSourceBranch;
    @JsonProperty("merge_when_pipeline_succeeds")
    private Boolean mergeWhenPipelineSucceeds;
    @JsonProperty("sha")
    private String sha;
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

    @JsonProperty("merge_request_iid")
    public Integer getMergeRequestIid() {
        return mergeRequestIid;
    }

    @JsonProperty("merge_request_iid")
    public void setMergeRequestIid(Integer mergeRequestIid) {
        this.mergeRequestIid = mergeRequestIid;
    }

    @JsonProperty("merge_commit_message")
    public String getMergeCommitMessage() {
        return mergeCommitMessage;
    }

    @JsonProperty("merge_commit_message")
    public void setMergeCommitMessage(String mergeCommitMessage) {
        this.mergeCommitMessage = mergeCommitMessage;
    }

    @JsonProperty("should_remove_source_branch")
    public Boolean getShouldRemoveSourceBranch() {
        return shouldRemoveSourceBranch;
    }

    @JsonProperty("should_remove_source_branch")
    public void setShouldRemoveSourceBranch(Boolean shouldRemoveSourceBranch) {
        this.shouldRemoveSourceBranch = shouldRemoveSourceBranch;
    }

    @JsonProperty("merge_when_pipeline_succeeds")
    public Boolean getMergeWhenPipelineSucceeds() {
        return mergeWhenPipelineSucceeds;
    }

    @JsonProperty("merge_when_pipeline_succeeds")
    public void setMergeWhenPipelineSucceeds(Boolean mergeWhenPipelineSucceeds) {
        this.mergeWhenPipelineSucceeds = mergeWhenPipelineSucceeds;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
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
