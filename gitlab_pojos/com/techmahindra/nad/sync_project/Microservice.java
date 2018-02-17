
package com.techmahindra.nad.sync_project;

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
    "project_name",
    "project_type",
    "repository_name",
    "key",
    "git_source",
    "description",
    "project_branches",
    "project_members",
    "jira"
})
public class Microservice {

    @JsonProperty("project_name")
    private String projectName;
    @JsonProperty("project_type")
    private String projectType;
    @JsonProperty("repository_name")
    private String repositoryName;
    @JsonProperty("key")
    private String key;
    @JsonProperty("git_source")
    private GitSource gitSource;
    @JsonProperty("description")
    private String description;
    @JsonProperty("project_branches")
    private List<ProjectBranch> projectBranches = null;
    @JsonProperty("project_members")
    private List<ProjectMember> projectMembers = null;
    @JsonProperty("jira")
    private Jira jira;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("project_name")
    public String getProjectName() {
        return projectName;
    }

    @JsonProperty("project_name")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @JsonProperty("project_type")
    public String getProjectType() {
        return projectType;
    }

    @JsonProperty("project_type")
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @JsonProperty("repository_name")
    public String getRepositoryName() {
        return repositoryName;
    }

    @JsonProperty("repository_name")
    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("git_source")
    public GitSource getGitSource() {
        return gitSource;
    }

    @JsonProperty("git_source")
    public void setGitSource(GitSource gitSource) {
        this.gitSource = gitSource;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("project_branches")
    public List<ProjectBranch> getProjectBranches() {
        return projectBranches;
    }

    @JsonProperty("project_branches")
    public void setProjectBranches(List<ProjectBranch> projectBranches) {
        this.projectBranches = projectBranches;
    }

    @JsonProperty("project_members")
    public List<ProjectMember> getProjectMembers() {
        return projectMembers;
    }

    @JsonProperty("project_members")
    public void setProjectMembers(List<ProjectMember> projectMembers) {
        this.projectMembers = projectMembers;
    }

    @JsonProperty("jira")
    public Jira getJira() {
        return jira;
    }

    @JsonProperty("jira")
    public void setJira(Jira jira) {
        this.jira = jira;
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
