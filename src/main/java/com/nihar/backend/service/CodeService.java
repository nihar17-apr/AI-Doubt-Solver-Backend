package com.nihar.backend.service;

import com.nihar.backend.dto.CodeRequest;
import com.nihar.backend.dto.CodeResponse;

public interface CodeService {

    CodeResponse generateCode(CodeRequest request);

}