
package com.techmahindra.nad.create_subtask_req;

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
    "originalEstimate",
    "remainingEstimate"
})
public class Timetracking {

    @JsonProperty("originalEstimate")
    private String originalEstimate;
    @JsonProperty("remainingEstimate")
    private String remainingEstimate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("originalEstimate")
    public String getOriginalEstimate() {
        return originalEstimate;
    }

    @JsonProperty("originalEstimate")
    public void setOriginalEstimate(String originalEstimate) {
        this.originalEstimate = originalEstimate;
    }

    @JsonProperty("remainingEstimate")
    public String getRemainingEstimate() {
        return remainingEstimate;
    }

    @JsonProperty("remainingEstimate")
    public void setRemainingEstimate(String remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
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
