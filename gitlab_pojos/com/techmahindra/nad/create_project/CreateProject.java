
package com.techmahindra.nad.create_project;

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
    "api_token",
    "user_id",
    "name",
    "path",
    "default_branch",
    "namespace_id",
    "description",
    "issues_enabled",
    "merge_requests_enabled",
    "jobs_enabled",
    "wiki_enabled",
    "snippets_enabled",
    "resolve_outdated_diff_discussions",
    "container_registry_enabled",
    "shared_runners_enabled",
    "visibility",
    "import_url",
    "public_jobs",
    "only_allow_merge_if_pipeline_succeeds",
    "only_allow_merge_if_all_discussions_are_resolved",
    "lfs_enabled",
    "request_access_enabled",
    "tag_list",
    "printing_merge_request_link_enabled",
    "ci_config_path",
    "repository_storage",
    "approvals_before_merge"
})
public class CreateProject {

    @JsonProperty("project_id")
    private String projectId;
    @JsonProperty("api_token")
    private String apiToken;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("path")
    private String path;
    @JsonProperty("default_branch")
    private String defaultBranch;
    @JsonProperty("namespace_id")
    private Integer namespaceId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("issues_enabled")
    private Boolean issuesEnabled;
    @JsonProperty("merge_requests_enabled")
    private Boolean mergeRequestsEnabled;
    @JsonProperty("jobs_enabled")
    private Boolean jobsEnabled;
    @JsonProperty("wiki_enabled")
    private Boolean wikiEnabled;
    @JsonProperty("snippets_enabled")
    private Boolean snippetsEnabled;
    @JsonProperty("resolve_outdated_diff_discussions")
    private Boolean resolveOutdatedDiffDiscussions;
    @JsonProperty("container_registry_enabled")
    private Boolean containerRegistryEnabled;
    @JsonProperty("shared_runners_enabled")
    private Boolean sharedRunnersEnabled;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("import_url")
    private String importUrl;
    @JsonProperty("public_jobs")
    private Boolean publicJobs;
    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    private Boolean onlyAllowMergeIfPipelineSucceeds;
    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    private Boolean onlyAllowMergeIfAllDiscussionsAreResolved;
    @JsonProperty("lfs_enabled")
    private Boolean lfsEnabled;
    @JsonProperty("request_access_enabled")
    private Boolean requestAccessEnabled;
    @JsonProperty("tag_list")
    private List<String> tagList = null;
    @JsonProperty("printing_merge_request_link_enabled")
    private Integer printingMergeRequestLinkEnabled;
    @JsonProperty("ci_config_path")
    private String ciConfigPath;
    @JsonProperty("repository_storage")
    private String repositoryStorage;
    @JsonProperty("approvals_before_merge")
    private Integer approvalsBeforeMerge;
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

    @JsonProperty("api_token")
    public String getApiToken() {
        return apiToken;
    }

    @JsonProperty("api_token")
    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("default_branch")
    public String getDefaultBranch() {
        return defaultBranch;
    }

    @JsonProperty("default_branch")
    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    @JsonProperty("namespace_id")
    public Integer getNamespaceId() {
        return namespaceId;
    }

    @JsonProperty("namespace_id")
    public void setNamespaceId(Integer namespaceId) {
        this.namespaceId = namespaceId;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("issues_enabled")
    public Boolean getIssuesEnabled() {
        return issuesEnabled;
    }

    @JsonProperty("issues_enabled")
    public void setIssuesEnabled(Boolean issuesEnabled) {
        this.issuesEnabled = issuesEnabled;
    }

    @JsonProperty("merge_requests_enabled")
    public Boolean getMergeRequestsEnabled() {
        return mergeRequestsEnabled;
    }

    @JsonProperty("merge_requests_enabled")
    public void setMergeRequestsEnabled(Boolean mergeRequestsEnabled) {
        this.mergeRequestsEnabled = mergeRequestsEnabled;
    }

    @JsonProperty("jobs_enabled")
    public Boolean getJobsEnabled() {
        return jobsEnabled;
    }

    @JsonProperty("jobs_enabled")
    public void setJobsEnabled(Boolean jobsEnabled) {
        this.jobsEnabled = jobsEnabled;
    }

    @JsonProperty("wiki_enabled")
    public Boolean getWikiEnabled() {
        return wikiEnabled;
    }

    @JsonProperty("wiki_enabled")
    public void setWikiEnabled(Boolean wikiEnabled) {
        this.wikiEnabled = wikiEnabled;
    }

    @JsonProperty("snippets_enabled")
    public Boolean getSnippetsEnabled() {
        return snippetsEnabled;
    }

    @JsonProperty("snippets_enabled")
    public void setSnippetsEnabled(Boolean snippetsEnabled) {
        this.snippetsEnabled = snippetsEnabled;
    }

    @JsonProperty("resolve_outdated_diff_discussions")
    public Boolean getResolveOutdatedDiffDiscussions() {
        return resolveOutdatedDiffDiscussions;
    }

    @JsonProperty("resolve_outdated_diff_discussions")
    public void setResolveOutdatedDiffDiscussions(Boolean resolveOutdatedDiffDiscussions) {
        this.resolveOutdatedDiffDiscussions = resolveOutdatedDiffDiscussions;
    }

    @JsonProperty("container_registry_enabled")
    public Boolean getContainerRegistryEnabled() {
        return containerRegistryEnabled;
    }

    @JsonProperty("container_registry_enabled")
    public void setContainerRegistryEnabled(Boolean containerRegistryEnabled) {
        this.containerRegistryEnabled = containerRegistryEnabled;
    }

    @JsonProperty("shared_runners_enabled")
    public Boolean getSharedRunnersEnabled() {
        return sharedRunnersEnabled;
    }

    @JsonProperty("shared_runners_enabled")
    public void setSharedRunnersEnabled(Boolean sharedRunnersEnabled) {
        this.sharedRunnersEnabled = sharedRunnersEnabled;
    }

    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("import_url")
    public String getImportUrl() {
        return importUrl;
    }

    @JsonProperty("import_url")
    public void setImportUrl(String importUrl) {
        this.importUrl = importUrl;
    }

    @JsonProperty("public_jobs")
    public Boolean getPublicJobs() {
        return publicJobs;
    }

    @JsonProperty("public_jobs")
    public void setPublicJobs(Boolean publicJobs) {
        this.publicJobs = publicJobs;
    }

    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    public Boolean getOnlyAllowMergeIfPipelineSucceeds() {
        return onlyAllowMergeIfPipelineSucceeds;
    }

    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    public void setOnlyAllowMergeIfPipelineSucceeds(Boolean onlyAllowMergeIfPipelineSucceeds) {
        this.onlyAllowMergeIfPipelineSucceeds = onlyAllowMergeIfPipelineSucceeds;
    }

    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    public Boolean getOnlyAllowMergeIfAllDiscussionsAreResolved() {
        return onlyAllowMergeIfAllDiscussionsAreResolved;
    }

    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    public void setOnlyAllowMergeIfAllDiscussionsAreResolved(Boolean onlyAllowMergeIfAllDiscussionsAreResolved) {
        this.onlyAllowMergeIfAllDiscussionsAreResolved = onlyAllowMergeIfAllDiscussionsAreResolved;
    }

    @JsonProperty("lfs_enabled")
    public Boolean getLfsEnabled() {
        return lfsEnabled;
    }

    @JsonProperty("lfs_enabled")
    public void setLfsEnabled(Boolean lfsEnabled) {
        this.lfsEnabled = lfsEnabled;
    }

    @JsonProperty("request_access_enabled")
    public Boolean getRequestAccessEnabled() {
        return requestAccessEnabled;
    }

    @JsonProperty("request_access_enabled")
    public void setRequestAccessEnabled(Boolean requestAccessEnabled) {
        this.requestAccessEnabled = requestAccessEnabled;
    }

    @JsonProperty("tag_list")
    public List<String> getTagList() {
        return tagList;
    }

    @JsonProperty("tag_list")
    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    @JsonProperty("printing_merge_request_link_enabled")
    public Integer getPrintingMergeRequestLinkEnabled() {
        return printingMergeRequestLinkEnabled;
    }

    @JsonProperty("printing_merge_request_link_enabled")
    public void setPrintingMergeRequestLinkEnabled(Integer printingMergeRequestLinkEnabled) {
        this.printingMergeRequestLinkEnabled = printingMergeRequestLinkEnabled;
    }

    @JsonProperty("ci_config_path")
    public String getCiConfigPath() {
        return ciConfigPath;
    }

    @JsonProperty("ci_config_path")
    public void setCiConfigPath(String ciConfigPath) {
        this.ciConfigPath = ciConfigPath;
    }

    @JsonProperty("repository_storage")
    public String getRepositoryStorage() {
        return repositoryStorage;
    }

    @JsonProperty("repository_storage")
    public void setRepositoryStorage(String repositoryStorage) {
        this.repositoryStorage = repositoryStorage;
    }

    @JsonProperty("approvals_before_merge")
    public Integer getApprovalsBeforeMerge() {
        return approvalsBeforeMerge;
    }

    @JsonProperty("approvals_before_merge")
    public void setApprovalsBeforeMerge(Integer approvalsBeforeMerge) {
        this.approvalsBeforeMerge = approvalsBeforeMerge;
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
