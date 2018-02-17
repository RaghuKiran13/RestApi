package com.techmahindra.nad.add_worklog_to_issue_req;

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
"comment",
"started",
"timeSpentSeconds"
})
public class AddWorklogToIssue {

@JsonProperty("comment")
private String comment;
@JsonProperty("started")
private String started;
@JsonProperty("timeSpentSeconds")
private Integer timeSpentSeconds;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("comment")
public String getComment() {
return comment;
}

@JsonProperty("comment")
public void setComment(String comment) {
this.comment = comment;
}

@JsonProperty("started")
public String getStarted() {
return started;
}

@JsonProperty("started")
public void setStarted(String started) {
this.started = started;
}

@JsonProperty("timeSpentSeconds")
public Integer getTimeSpentSeconds() {
return timeSpentSeconds;
}

@JsonProperty("timeSpentSeconds")
public void setTimeSpentSeconds(Integer timeSpentSeconds) {
this.timeSpentSeconds = timeSpentSeconds;
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