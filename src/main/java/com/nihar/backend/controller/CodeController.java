package com.nihar.backend.controller;

import com.nihar.backend.dto.CodeRequest;
import com.nihar.backend.dto.CodeResponse;
import com.nihar.backend.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
@CrossOrigin("*")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @PostMapping("/generate")
    public CodeResponse generateCode(@RequestBody CodeRequest request) {

        return codeService.generateCode(request);

    }
}