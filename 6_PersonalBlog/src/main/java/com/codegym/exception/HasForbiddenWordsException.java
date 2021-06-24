package com.codegym.exception;

public class HasForbiddenWordsException extends Exception {
    @Override
    public String toString() {
        return "content contains forbidden word(s)";
    }
}
