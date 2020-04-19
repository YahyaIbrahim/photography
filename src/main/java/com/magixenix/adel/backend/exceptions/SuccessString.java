package com.magixenix.adel.backend.exceptions;

import com.magixenix.adel.backend.models.Gallery;
import lombok.Data;

@Data
public class SuccessString {
    private final int code;
    private final String message;
    private final String error;
}
