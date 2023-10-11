package com.giaplh.libraryweb.queryfiler.query.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg) {
        super(msg);
    }


    public BadRequestException(String msg, Throwable e) {
        super(msg, e);
    }

}
