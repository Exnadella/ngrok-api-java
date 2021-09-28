package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IpPolicyRule} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpPolicyRule {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String metadata;
    @JsonProperty("cidr")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String cidr;
    @JsonProperty("ip_policy")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Ref ipPolicy;

    /**
     * Creates a new instance of {@link IpPolicyRule}.
     *
     * @param id unique identifier for this IP policy rule
     * @param uri URI of the IP policy rule API resource
     * @param createdAt timestamp when the IP policy rule was created, RFC 3339 format
     * @param description human-readable description of the source IPs of this IP rule. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this IP policy rule. optional, max 4096 bytes.
     * @param cidr an IP or IP range specified in CIDR notation. IPv4 and IPv6 are both supported.
     * @param ipPolicy object describing the IP policy this IP Policy Rule belongs to
     */
    @JsonCreator
    public IpPolicyRule(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("cidr") final String cidr,
        @JsonProperty("ip_policy") final Ref ipPolicy
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.cidr = Objects.requireNonNull(cidr, "cidr is required");
        this.ipPolicy = Objects.requireNonNull(ipPolicy, "ipPolicy is required");
    }

    /**
     * unique identifier for this IP policy rule
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the IP policy rule API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the IP policy rule was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of the source IPs of this IP rule. optional, max 255
     * bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this IP policy rule. optional,
     * max 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * an IP or IP range specified in CIDR notation. IPv4 and IPv6 are both supported.
     *
     * @return the value of the property as a {@link String}
     */
    public String getCidr() {
        return this.cidr;
    }

    /**
     * object describing the IP policy this IP Policy Rule belongs to
     *
     * @return the value of the property as a {@link Ref}
     */
    public Ref getIpPolicy() {
        return this.ipPolicy;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final IpPolicyRule other = (IpPolicyRule) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.cidr.equals(other.cidr)&&
            this.ipPolicy.equals(other.ipPolicy);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.cidr,
            this.ipPolicy
        );
    }

    @Override
    public String toString() {
        return "IpPolicyRule{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', cidr='" + this.cidr +
            "', ipPolicy='" + this.ipPolicy +
            "'}";
    }
}
