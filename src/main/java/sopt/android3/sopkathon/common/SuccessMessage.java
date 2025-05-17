package sopt.android3.sopkathon.common;

import org.springframework.http.HttpStatus;

public enum SuccessMessage {
    OK(HttpStatus.OK, "OK"),
    CREATED(HttpStatus.CREATED, "CREATED");

    private final HttpStatus status;
    private final String message;

    SuccessMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getHttpStatusCode() {
        return status.value();
    }
}
