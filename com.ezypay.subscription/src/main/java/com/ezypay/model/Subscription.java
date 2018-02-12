
package com.ezypay.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "amount",
    "subscription_type",
    "invoice_dates"
})
/**
 * Object representation of Request body
 */
public class Subscription {

    @JsonProperty("id")
    private String id;
    @JsonProperty("amount")
    @Valid
    private Amount amount;
    @JsonProperty("subscription_type")
    private String subscriptionType;
    @JsonProperty("invoice_dates")
    @Valid
    private List<String> invoiceDates = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Subscription withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Subscription withAmount(Amount amount) {
        this.amount = amount;
        return this;
    }

    @JsonProperty("subscription_type")
    public String getSubscriptionType() {
        return subscriptionType;
    }

    @JsonProperty("subscription_type")
    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Subscription withSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
        return this;
    }

    @JsonProperty("invoice_dates")
    public List<String> getInvoiceDates() {
        return invoiceDates;
    }

    @JsonProperty("invoice_dates")
    public void setInvoiceDates(List<String> invoiceDates) {
        this.invoiceDates = invoiceDates;
    }

    public Subscription withInvoiceDates(List<String> invoiceDates) {
        this.invoiceDates = invoiceDates;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Subscription withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
