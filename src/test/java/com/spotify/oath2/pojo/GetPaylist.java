
package com.spotify.oath2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "error"
})

public class GetPaylist {

    @JsonProperty("error")
    private ErrorRoot errorRoot;

    @JsonProperty("error")
    public ErrorRoot getError() {
        return errorRoot;
    }

    @JsonProperty("error")
    public void setError(ErrorRoot errorRoot) {
        this.errorRoot = errorRoot;
    }

}
