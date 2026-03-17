package com.busanit501.springboot0226.controller;

import com.busanit501.springboot0226.dto.ReplyDTO;
import com.busanit501.springboot0226.dto.upload.UploadFileDTO;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class UpDownController {

    // 이미지 파일이 저장되는 위치를 , application.properties 에 등록 했음.
    //
    @Value("${com.busanit501.upload.path}")
    private String uploadPath;

    @Tag(name = "이미지 파일 업로드 테스트",
            description = "post 방식으로 멀티파트 폼에 이미지를 첨부해서 서버에 전달하기. ")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(
            // 화면에서 전달된 이미지 파일들을 받기. files
           UploadFileDTO uploadFileDTO
    )  {
        log.info(" UpDownController 이미지 첨부 테스트 확인 : "  );

        // 첨부된 이미지들의 파일명 확인 해보기.
         if(uploadFileDTO.getFiles() != null) {
             uploadFileDTO.getFiles().forEach(file -> {
                 log.info(file.getOriginalFilename());
             });
         }

        return null;
    }
}
