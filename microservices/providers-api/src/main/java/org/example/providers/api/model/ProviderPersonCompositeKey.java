package org.example.providers.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderPersonCompositeKey implements Serializable {
    private Long providerId;
    private Long personId;
}
