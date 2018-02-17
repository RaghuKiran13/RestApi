
package com.techmahindra.nad.create_mr;

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
    "project_id",
    "gitlab_project_id",
    "microservice_key",
    "source_branch",
    "target_branch",
    "title",
    "approvers",
    "approvers_jira_tickets",
    "description"
})
public class CreateMR {

    @JsonProperty("project_id")
    private String projectId;
    @JsonProperty("gitlab_project_id")
    private Integer gitlabProjectId;
    @JsonProperty("microservice_key")
    private String microserviceKey;
    @JsonProperty("source_branch")
    private String sourceBranch;
    @JsonProperty("target_branch")
    private String targetBranch;
    @JsonProperty("title")
    private String title;
    @JsonProperty("approvers")
    private List<String> approvers = null;
    @JsonProperty("approvers_jira_tickets")
    private List<String> approversJiraTickets = null;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("project_id")
    public String getProjectId() {
        return projectId;
    }

    @JsonProperty("project_id")
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("gitlab_project_id")
    public Integer getGitlabProjectId() {
        return gitlabProjectId;
    }

    @JsonProperty("gitlab_project_id")
    public void setGitlabProjectId(Integer gitlabProjectId) {
        this.gitlabProjectId = gitlabProjectId;
    }

    @JsonProperty("microservice_key")
    public String getMicroserviceKey() {
        return microserviceKey;
    }

    @JsonProperty("microservice_key")
    public void setMicroserviceKey(String microserviceKey) {
        this.microserviceKey = microserviceKey;
    }

    @JsonProperty("source_branch")
    public String getSourceBranch() {
        return sourceBranch;
    }

    @JsonProperty("source_branch")
    public void setSourceBranch(String sourceBranch) {
        this.sourceBranch = sourceBranch;
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

    @JsonProperty("approvers")
    public List<String> getApprovers() {
        return approvers;
    }

    @JsonProperty("approvers")
    public void setApprovers(List<String> approvers) {
        this.approvers = approvers;
    }

    @JsonProperty("approvers_jira_tickets")
    public List<String> getApproversJiraTickets() {
        return approversJiraTickets;
    }

    @JsonProperty("approvers_jira_tickets")
    public void setApproversJiraTickets(List<String> approversJiraTickets) {
        this.approversJiraTickets = approversJiraTickets;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
