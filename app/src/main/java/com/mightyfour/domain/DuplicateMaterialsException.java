package com.mightyfour.domain;

public class DuplicateMaterialsException extends RuntimeException {
    public DuplicateMaterialsException(String message) {
        super(message);  
    }
}

