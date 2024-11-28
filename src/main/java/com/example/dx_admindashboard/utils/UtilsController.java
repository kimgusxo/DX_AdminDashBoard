package com.example.dx_admindashboard.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/input")
@RequiredArgsConstructor
public class UtilsController {

    private final DataInputUtils dataInputUtils;

    @GetMapping("/data")
    public ResponseEntity<Void> inputData() {
        dataInputUtils.loadDbToFirestore();
        return ResponseEntity.ok().build();
    }

}
