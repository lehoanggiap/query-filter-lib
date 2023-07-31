package com.giaplh.libraryweb.queryfiler.server.controller;

import com.giaplh.libraryweb.queryfiler.query.exception.BadRequestException;
import com.giaplh.libraryweb.queryfiler.server.dto.ErrorResponse;
import com.giaplh.libraryweb.queryfiler.server.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping
    public ResponseEntity<StudentDTO> getStudents(@RequestBody StudentDTO studentDTO){
        return null;
    }

    @ExceptionHandler({ BadRequestException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(BadRequestException badRequestException){
        return ErrorResponse.builder()
                .message(badRequestException.getMessage())
                .build();
    }

}
