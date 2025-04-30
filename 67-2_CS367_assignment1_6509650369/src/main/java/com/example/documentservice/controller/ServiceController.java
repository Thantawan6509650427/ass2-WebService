package com.example.documentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.documentservice.dto.EditRequestDto;
import com.example.documentservice.dto.RequestAccessDto;
import com.example.documentservice.dto.SearchDocumentDto;
import com.example.documentservice.dto.ServiceResponseDto;
import com.example.documentservice.dto.SignDocumentDto;
import com.example.documentservice.dto.SummarizeRequestDto;
import com.example.documentservice.service.AccessService;
import com.example.documentservice.service.EditService;
import com.example.documentservice.service.LLMService;
import com.example.documentservice.service.SearchService;
import com.example.documentservice.service.SignatureService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private AccessService accessService;

    @Autowired
    private SignatureService signatureService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private EditService editService;

    @Autowired
    private LLMService llmService;

    /**
     * บริการที่ 1: ขอเข้าถึงเอกสาร
     */
    @PostMapping("/access")
    public ServiceResponseDto requestAccess(@RequestBody RequestAccessDto dto) {
        return accessService.requestAccess(dto);
    }

    /**
     * บริการที่ 2: ลงนามเอกสาร
     */
    @PostMapping("/sign")
    public ServiceResponseDto signDocument(@RequestBody SignDocumentDto dto) {
        return signatureService.signDocument(dto);
    }

    /**
     * บริการที่ 3: ค้นหาเอกสาร
     */
    @PostMapping("/search")
    public ServiceResponseDto searchDocuments(@RequestBody SearchDocumentDto dto) {
        return searchService.searchDocuments(dto);
    }

    /**
     * บริการที่ 4: ร้องขอให้แก้ไขเอกสาร
     */
    @PostMapping("/edit")
    public ServiceResponseDto requestEdit(@RequestBody EditRequestDto dto) {
        return editService.requestEdit(dto);
    }

    /**
     * บริการที่ 5: สรุปเนื้อหาเอกสารด้วย LLM
     */
    @PostMapping("/summarize")
    public ServiceResponseDto summarize(@RequestBody SummarizeRequestDto dto) {
        return llmService.summarize(dto);
    }
}
