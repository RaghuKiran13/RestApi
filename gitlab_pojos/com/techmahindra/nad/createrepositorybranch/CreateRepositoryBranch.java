
package com.techmahindra.nad.createrepositorybranch;

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
    "project_id",
    "gitlab_project_id",
    "branch",
    "ref_branch"
})
public class CreateRepositoryBranch {

    @JsonProperty("project_id")
    private String projectId;
    @JsonProperty("gitlab_project_id")
    private Integer gitlabProjectId;
    @JsonProperty("branch")
    private String branch;
    @JsonProperty("ref_branch")
    private String refBranch;
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

    @JsonProperty("branch")
    public String getBranch() {
        return branch;
    }

    @JsonProperty("branch")
    public void setBranch(String branch) {
        this.branch = branch;
    }

    @JsonProperty("ref_branch")
    public String getRefBranch() {
        return refBranch;
    }

    @JsonProperty("ref_branch")
    public void setRefBranch(String refBranch) {
        this.refBranch = refBranch;
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
