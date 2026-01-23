/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ReservedDomainResolvesToEntry} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedDomainResolvesToEntry {
    /**
     * Builder class for {@link ReservedDomainResolvesToEntry}.
     */
    public static class Builder {
        private Optional<String> value = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * accepts an ngrok point-of-presence shortcode, or &#34;global&#34;
         *
         * @param value the value of the <code>value</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder value(final String value) {
            this.value = Optional.of(Objects.requireNonNull(value, "value is required"));
            return this;
        }

        /**
         * accepts an ngrok point-of-presence shortcode, or &#34;global&#34;
         *
         * @param value the value of the <code>value</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder value(final Optional<String> value) {
            this.value = Objects.requireNonNull(value, "value is required");
            return this;
        }

        /**
         * Constructs the {@link ReservedDomainResolvesToEntry} instance.
         *
         * @return a new {@link ReservedDomainResolvesToEntry}
         */
        public ReservedDomainResolvesToEntry build() {
            return new ReservedDomainResolvesToEntry(
                this.value.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link ReservedDomainResolvesToEntry} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String value;

    /**
     * Creates a new instance of {@link ReservedDomainResolvesToEntry}.
     *
     * @param value accepts an ngrok point-of-presence shortcode, or &#34;global&#34;
     */
    @JsonCreator
    private ReservedDomainResolvesToEntry(
        @JsonProperty("value") final String value
    ) {
        this.value = Objects.requireNonNull(value, "value is required");
    }

    /**
     * accepts an ngrok point-of-presence shortcode, or &#34;global&#34;
     *
     * @return the value of the property as a {@link String}
     */
    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ReservedDomainResolvesToEntry other = (ReservedDomainResolvesToEntry) o;
        return
            this.value.equals(other.value);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.value
        );
    }

    @Override
    public String toString() {
        return "ReservedDomainResolvesToEntry{" +
            "value='" + this.value +
            "'}";
    }
}
