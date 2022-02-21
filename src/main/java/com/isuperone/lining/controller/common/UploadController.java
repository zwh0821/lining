package com.isuperone.lining.controller.common;

import com.isuperone.lining.common.ReturnResult;
import com.isuperone.lining.common.helper.UploadHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @program: Lining
 * @description: 上传文件控制器
 * @author: Joe
 * @create: 2020-05-18 16:54
 **/
@RestController
@RequestMapping("/upload")
@Api(value = "/upload", tags = "upload", description = "文件上传相关接口")
@CrossOrigin
public class UploadController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${file.uploadFolder}")
    private String uploadFolder;


    @Value("${file.staticAccessPath}")
    private String staticAccessPath;

    @Value("${file.baseUrl}")
    private String baseUrl;

    /**
     * 上传图片接口
     */
    @ResponseBody
    @RequestMapping(value = "/singleFileUpload", method = RequestMethod.POST)
    @ApiOperation(notes = "singleFileUpload", httpMethod = "POST", value = "文件上传", response = ReturnResult.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            byte[] bytes = file.getBytes();
            String imageFileName = file.getOriginalFilename();
            String fileName = UploadHelper.getPhotoName("img", imageFileName);
            Path path = Paths.get(uploadFolder + fileName);
            Files.write(path, bytes);
            logger.info("fileName:"+fileName);
            logger.info("baseUrl"+baseUrl);
            logger.info("staticAccessPath"+staticAccessPath);
            logger.info("path:"+path.toString());
            System.out.println(fileName + "\n");
            map.put("status", "done");
            map.put("name", fileName);
            map.put("thumbUrl", baseUrl + staticAccessPath + fileName);
            map.put("url", baseUrl + staticAccessPath + fileName);
        } catch (IOException e) {
            logger.info(e.getMessage());
            map.put("status", "error");
        }
        return map;
    }

    //使用流将图片输出
    @GetMapping("/getImage/{name}")
    public void getImage(HttpServletResponse response, @PathVariable("name") String name) throws IOException {
        response.setContentType("image/jpeg;charset=utf-8");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(Files.readAllBytes(Paths.get(uploadFolder).resolve(name)));
        outputStream.flush();
        outputStream.close();
    }
}
