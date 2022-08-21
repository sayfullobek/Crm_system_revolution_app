package app_mini_crm.minicrm.controller;

import app_mini_crm.minicrm.entity.Attachment;
import app_mini_crm.minicrm.repository.AttachmentRepository;
import app_mini_crm.minicrm.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @Autowired
    AttachmentRepository attachmentRepository;

    @PostMapping("/upload")
    public HttpEntity<?> upload(MultipartHttpServletRequest request){
        UUID upload = attachmentService.upload(request);
        return ResponseEntity.ok(upload);
    }

    @GetMapping("/download")
    public HttpEntity<?> getFile(@RequestParam(name = "id", required = false) UUID id){
        return attachmentService.getFile(id);
    }

    @GetMapping("/getAttachment")
    public HttpEntity<?> getAttachment(){
        List<Attachment> all = attachmentRepository.findAll();
        return ResponseEntity.ok(all);
    }
}