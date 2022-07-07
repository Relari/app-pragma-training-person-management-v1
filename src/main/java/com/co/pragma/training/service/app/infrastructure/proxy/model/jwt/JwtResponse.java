package com.co.pragma.training.service.app.infrastructure.proxy.model.jwt;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046815L;

    @SerializedName(value = "token_type")
    private String tokenType;

    @SerializedName(value = "access_token")
    private String accessToken;

    @SerializedName(value = "expires_in")
    private String expiresIn;

    @SerializedName(value = "issued_at")
    private String issuedAt;

    @SerializedName(value = "profile")
    private ProfileResponse profile;

}