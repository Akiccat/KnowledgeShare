package com.akicat.knowledgeshare.controller;

import com.akicat.knowledgeshare.eneity.NoteEntity;
import com.akicat.knowledgeshare.exception.BusinessFailureException;
import com.akicat.knowledgeshare.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/update")
@CrossOrigin(origins = "*", methods = {GET, POST}, allowedHeaders = "*", maxAge = 3600)
public class UpdateEditorController {

    private static final String IMAGE_URL_PREFIX = "http://localhost:8080/images/";

    private static final Logger logger = LoggerFactory.getLogger(UpdateEditorController.class);

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/image")
    public Map<String, String> uploadImage(MultipartFile file, HttpServletRequest request) {
        // 这个路径 path 就是工程下 /src/main/webapp/upload，这个路径是发布后才会存在
        // 本地运行会创建在其他目录下，如 C:\Users/userName\AppData\Local\Temp\tomcat-docbase.141614960009226192.9090/upload
        /*String path = request.getSession().getServletContext().getRealPath("upload");*/
        String path = "D:\\GraduationProject\\BackEnd\\KnowledgeShareBack\\src\\main\\resources\\images";
        logger.info("文件存储路径：{}", path);
        String imageUrl = fileUploadService.upload(file,path);
        //  TinyMCE 要求图片上传后，需要返回一个 json 对象，这个对象必须有 location 属性，此处硬编码
        Map<String, String> map = new HashMap<>();
        map.put("location", IMAGE_URL_PREFIX + imageUrl);
        System.out.println(map);
        return map;
    }

    @PostMapping("/upload-content")
    public NoteEntity uploadContent(@RequestBody NoteEntity note, Errors errors) {
        if (errors.hasErrors()) {
            // 当form中存在验证错误，则抛出业务错误，将验证信息输出。
            throw new BusinessFailureException(errors);
        }
        logger.info("method: uploadContent，上传内容：{}", note);
        // TODO 直接将这部分内容存储到数据库即可，此时 content里的图片已经不是 base64
        if (note != null){
            String html = note.toString();
            String pattern = "(?<=src=\")[^\"]+";
            Pattern compiledPattern = Pattern.compile(pattern);
            Matcher matcher = compiledPattern.matcher(html);
            if (matcher.find()) {
                String imageUrl = matcher.group();
                note.setNoteCover(imageUrl);
                System.out.println(imageUrl);
            } else {
                note.setNoteCover("http://localhost:8080/images/NoPicture.png");
            }

            if (note != null){
                if (fileUploadService.updateNote(note) != 1){
                    throw new BusinessFailureException(errors);
                }
            }else {
                throw new BusinessFailureException(errors);
            }

        }
        return note;
    }
}
