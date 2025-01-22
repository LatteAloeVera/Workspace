package com.example.library_management_system.Exceptions;

public class DuplicateEntryException  extends RuntimeException {
    public DuplicateEntryException(String message) {
        super(message);
    }    
}