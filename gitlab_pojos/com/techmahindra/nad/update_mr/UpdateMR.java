
package com.techmahindra.nad.update_mr;

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
    "target_branch",
    "title",
    "assignee_id",
    "description",
    "state_event",
    "labels",
    "milestone_id",
    "remove_source_branch",
    "merge_request_iid",
    "squash",
    "discussion_locked"
})
public class UpdateMR {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("target_branch")
    private String targetBranch;
    @JsonProperty("title")
    private String title;
    @JsonProperty("assignee_id")
    private Integer assigneeId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("state_event")
    private String stateEvent;
    @JsonProperty("labels")
    private String labels;
    @JsonProperty("milestone_id")
    private Integer milestoneId;
    @JsonProperty("remove_source_branch")
    private Boolean removeSourceBranch;
    @JsonProperty("merge_request_iid")
    private Integer mergeRequestIid;
    @JsonProperty("squash")
    private Boolean squash;
    @JsonProperty("discussion_locked")
    private Boolean discussionLocked;
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

    @JsonProperty("target_branch")
    public String getTargetBranch() {
        return targetBranch;
    }

    @JsonProperty("target_branch")
    public void setTargetBranch(String targetBranch) {
        this.targetBranch = targetBranch;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("assignee_id")
    public Integer getAssigneeId() {
        return assigneeId;
    }

    @JsonProperty("assignee_id")
    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("state_event")
    public String getStateEvent() {
        return stateEvent;
    }

    @JsonProperty("state_event")
    public void setStateEvent(String stateEvent) {
        this.stateEvent = stateEvent;
    }

    @JsonProperty("labels")
    public String getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(String labels) {
        this.labels = labels;
    }

    @JsonProperty("milestone_id")
    public Integer getMilestoneId() {
        return milestoneId;
    }

    @JsonProperty("milestone_id")
    public void setMilestoneId(Integer milestoneId) {
        this.milestoneId = milestoneId;
    }

    @JsonProperty("remove_source_branch")
    public Boolean getRemoveSourceBranch() {
        return removeSourceBranch;
    }

    @JsonProperty("remove_source_branch")
    public void setRemoveSourceBranch(Boolean removeSourceBranch) {
        this.removeSourceBranch = removeSourceBranch;
    }

    @JsonProperty("merge_request_iid")
    public Integer getMergeRequestIid() {
        return mergeRequestIid;
    }

    @JsonProperty("merge_request_iid")
    public void setMergeRequestIid(Integer mergeRequestIid) {
        this.mergeRequestIid = mergeRequestIid;
    }

    @JsonProperty("squash")
    public Boolean getSquash() {
        return squash;
    }

    @JsonProperty("squash")
    public void setSquash(Boolean squash) {
        this.squash = squash;
    }

    @JsonProperty("discussion_locked")
    public Boolean getDiscussionLocked() {
        return discussionLocked;
    }

    @JsonProperty("discussion_locked")
    public void setDiscussionLocked(Boolean discussionLocked) {
        this.discussionLocked = discussionLocked;
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
