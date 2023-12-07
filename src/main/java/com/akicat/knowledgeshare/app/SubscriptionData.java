package com.akicat.knowledgeshare.app;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SubscriptionData {

    /**
     * 金额：美元
     */
    @JsonProperty("hard_limit_usd")
    private BigDecimal hard_limit_usd;
}
