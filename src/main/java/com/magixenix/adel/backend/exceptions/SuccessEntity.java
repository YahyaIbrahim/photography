package com.magixenix.adel.backend.exceptions;

import com.magixenix.adel.backend.models.User;
import lombok.Data;

@Data
public class SuccessEntity {
    private final int code;
    private final User message;
    private final String error;
}
