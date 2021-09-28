package com.ngrok.services;

import com.ngrok.NgrokApiClient;
import com.ngrok.definitions.*;

import java.util.AbstractMap;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * An API client for {@link EventStreams}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-event-streams">https://ngrok.com/docs/api#api-event-streams</a>.
 */
public class EventStreams {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EventStreams.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EventStreams(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private String metadata = "";
        private String description = "";
        private java.util.List<String> fields = java.util.Collections.emptyList();
        private String eventType = "";
        private java.util.List<String> destinationIds = java.util.Collections.emptyList();
        private double samplingRate = 0.0d;

        private CreateCallBuilder(
        ) {
        }
        
        /**
         * Arbitrary user-defined machine-readable data of this Event Stream. Optional, max
         * 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * Arbitrary user-defined machine-readable data of this Event Stream. Optional, max
         * 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * Human-readable description of the Event Stream. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * Human-readable description of the Event Stream. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * A list of protocol-specific fields you want to collect on each event.
         *
         * @param fields the value of the fields parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public CreateCallBuilder fields(final java.util.List<String> fields) {
            this.fields = Objects.requireNonNull(fields, "fields is required");
            return this;
        }

        /**
         * A list of protocol-specific fields you want to collect on each event.
         *
         * @param fields the value of the fields parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public CreateCallBuilder fields(final Optional<java.util.List<String>> fields) {
            this.fields = Objects.requireNonNull(fields, "fields is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * The protocol that determines which events will be collected. Supported values
         * are <code>tcp_connection_closed</code> and <code>http_request_complete</code>.
         *
         * @param eventType the value of the event_type parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder eventType(final String eventType) {
            this.eventType = Objects.requireNonNull(eventType, "eventType is required");
            return this;
        }

        /**
         * The protocol that determines which events will be collected. Supported values
         * are <code>tcp_connection_closed</code> and <code>http_request_complete</code>.
         *
         * @param eventType the value of the event_type parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder eventType(final Optional<String> eventType) {
            this.eventType = Objects.requireNonNull(eventType, "eventType is required").orElse("");
            return this;
        }
        
        /**
         * A list of Event Destination IDs which should be used for this Event Stream.
         * Event Streams are required to have at least one Event Destination.
         *
         * @param destinationIds the value of the destination_ids parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public CreateCallBuilder destinationIds(final java.util.List<String> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required");
            return this;
        }

        /**
         * A list of Event Destination IDs which should be used for this Event Stream.
         * Event Streams are required to have at least one Event Destination.
         *
         * @param destinationIds the value of the destination_ids parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public CreateCallBuilder destinationIds(final Optional<java.util.List<String>> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * The percentage of all events you would like to capture. Valid values range from
         * 0.01, representing 1% of all events to 1.00, representing 100% of all events.
         *
         * @param samplingRate the value of the sampling_rate parameter as a {@link double}
         * @return the call builder instance
         */
        public CreateCallBuilder samplingRate(final double samplingRate) {
            this.samplingRate = Objects.requireNonNull(samplingRate, "samplingRate is required");
            return this;
        }

        /**
         * The percentage of all events you would like to capture. Valid values range from
         * 0.01, representing 1% of all events to 1.00, representing 100% of all events.
         *
         * @param samplingRate the value of the sampling_rate parameter as an {@link Optional} of {@link double}
         * @return the call builder instance
         */
        public CreateCallBuilder samplingRate(final Optional<Double> samplingRate) {
            this.samplingRate = Objects.requireNonNull(samplingRate, "samplingRate is required").orElse(0.0d);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventStream}
         */
        public CompletionStage<EventStream> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/event_streams",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("fields", Optional.of(this.fields)),
                    new AbstractMap.SimpleEntry<>("event_type", Optional.of(this.eventType)),
                    new AbstractMap.SimpleEntry<>("destination_ids", Optional.of(this.destinationIds)),
                    new AbstractMap.SimpleEntry<>("sampling_rate", Optional.of(this.samplingRate))
                ),
                Optional.of(EventStream.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventStream}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventStream blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new Event Stream. It will not apply to anything until you associate it
     * with one or more Endpoint Configs.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-streams-create">https://ngrok.com/docs/api#api-event-streams-create</a>.
     *
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
    ) {
        return new CreateCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class DeleteCallBuilder {
        private final String id;

        private DeleteCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link Void}
         */
        public CompletionStage<Void> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.DELETE,
                "/event_streams/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.empty()
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public void blockingCall() throws InterruptedException {
            try {
                call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Delete an Event Stream. Associated Event Destinations will be preserved.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-streams-delete">https://ngrok.com/docs/api#api-event-streams-delete</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public DeleteCallBuilder delete(
        final String id
    ) {
        return new DeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class GetCallBuilder {
        private final String id;

        private GetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventStream}
         */
        public CompletionStage<EventStream> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/event_streams/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(EventStream.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventStream}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventStream blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an Event Stream by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-streams-get">https://ngrok.com/docs/api#api-event-streams-get</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public GetCallBuilder get(
        final String id
    ) {
        return new GetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class ListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private ListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link EventStreamList}
         */
        public CompletionStage<Page<EventStreamList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/event_streams",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(EventStreamList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link EventStreamList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<EventStreamList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all Event Streams available on this account.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-streams-list">https://ngrok.com/docs/api#api-event-streams-list</a>.
     *
     * @return a call builder for this API call
     */
    public ListCallBuilder list(
    ) {
        return new ListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String id;
        private Optional<String> metadata = Optional.empty();
        private Optional<String> description = Optional.empty();
        private Optional<java.util.List<String>> fields = Optional.empty();
        private Optional<java.util.List<String>> destinationIds = Optional.empty();
        private Optional<Double> samplingRate = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Arbitrary user-defined machine-readable data of this Event Stream. Optional, max
         * 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * Arbitrary user-defined machine-readable data of this Event Stream. Optional, max
         * 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * Human-readable description of the Event Stream. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * Human-readable description of the Event Stream. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * A list of protocol-specific fields you want to collect on each event.
         *
         * @param fields the value of the fields parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public UpdateCallBuilder fields(final java.util.List<String> fields) {
            this.fields = Optional.ofNullable(fields);
            return this;
        }

        /**
         * A list of protocol-specific fields you want to collect on each event.
         *
         * @param fields the value of the fields parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public UpdateCallBuilder fields(final Optional<java.util.List<String>> fields) {
            this.fields = Objects.requireNonNull(fields, "fields is required");
            return this;
        }
        
        /**
         * A list of Event Destination IDs which should be used for this Event Stream.
         * Event Streams are required to have at least one Event Destination.
         *
         * @param destinationIds the value of the destination_ids parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public UpdateCallBuilder destinationIds(final java.util.List<String> destinationIds) {
            this.destinationIds = Optional.ofNullable(destinationIds);
            return this;
        }

        /**
         * A list of Event Destination IDs which should be used for this Event Stream.
         * Event Streams are required to have at least one Event Destination.
         *
         * @param destinationIds the value of the destination_ids parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public UpdateCallBuilder destinationIds(final Optional<java.util.List<String>> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required");
            return this;
        }
        
        /**
         * The percentage of all events you would like to capture. Valid values range from
         * 0.01, representing 1% of all events to 1.00, representing 100% of all events.
         *
         * @param samplingRate the value of the sampling_rate parameter as a {@link double}
         * @return the call builder instance
         */
        public UpdateCallBuilder samplingRate(final double samplingRate) {
            this.samplingRate = Optional.ofNullable(samplingRate);
            return this;
        }

        /**
         * The percentage of all events you would like to capture. Valid values range from
         * 0.01, representing 1% of all events to 1.00, representing 100% of all events.
         *
         * @param samplingRate the value of the sampling_rate parameter as an {@link Optional} of {@link double}
         * @return the call builder instance
         */
        public UpdateCallBuilder samplingRate(final Optional<Double> samplingRate) {
            this.samplingRate = Objects.requireNonNull(samplingRate, "samplingRate is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventStream}
         */
        public CompletionStage<EventStream> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/event_streams/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("fields", this.fields.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("destination_ids", this.destinationIds.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("sampling_rate", this.samplingRate.map(Function.identity()))
                ),
                Optional.of(EventStream.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventStream}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventStream blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of an Event Stream by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-streams-update">https://ngrok.com/docs/api#api-event-streams-update</a>.
     *
     * @param id Unique identifier for this Event Stream.
     * @return a call builder for this API call
     */
    public UpdateCallBuilder update(
        final String id
    ) {
        return new UpdateCallBuilder(
            id
        );
    }
}
