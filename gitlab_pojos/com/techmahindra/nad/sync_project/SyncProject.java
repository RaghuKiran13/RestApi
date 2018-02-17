
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
    "project_id",
    "project_name",
    "project_description",
    "microservices",
    "git_location"
})
public class SyncProject {

    @JsonProperty("project_id")
    private String projectId;
    @JsonProperty("project_name")
    private String projectName;
    @JsonProperty("project_description")
    private String projectDescription;
    @JsonProperty("microservices")
    private List<Microservice> microservices = null;
    @JsonProperty("git_location")
    private GitLocation gitLocation;
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

    @JsonProperty("project_name")
    public String getProjectName() {
        return projectName;
    }

    @JsonProperty("project_name")
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @JsonProperty("project_description")
    public String getProjectDescription() {
        return projectDescription;
    }

    @JsonProperty("project_description")
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    @JsonProperty("microservices")
    public List<Microservice> getMicroservices() {
        return microservices;
    }

    @JsonProperty("microservices")
    public void setMicroservices(List<Microservice> microservices) {
        this.microservices = microservices;
    }

    @JsonProperty("git_location")
    public GitLocation getGitLocation() {
        return gitLocation;
    }

    @JsonProperty("git_location")
    public void setGitLocation(GitLocation gitLocation) {
        this.gitLocation = gitLocation;
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
