package xyz.huanggy.minio.upload.controller;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xyz.huanggy.minio.upload.model.dto.Result;
import xyz.huanggy.minio.upload.model.dto.TaskInfoDTO;
import xyz.huanggy.minio.upload.model.entity.SysUploadTask;
import xyz.huanggy.minio.upload.model.param.InitTaskParam;
import xyz.huanggy.minio.upload.service.SysUploadTaskService;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * 分片上传-分片任务记录(SysUploadTask)表控制层
 *
 * @since 2022-08-22 17:47:31
 */
@RestController
@RequestMapping("/v1/minio/tasks")
public class MinioUploadTaskController {
    /**
     * 服务对象
     */
    @Resource
    private SysUploadTaskService sysUploadTaskService;


    /**
     * 获取上传进度
     * @param identifier 文件md5
     * @return
     */
    @GetMapping("/{identifier}")
    public Result<TaskInfoDTO> taskInfo (@PathVariable("identifier") String identifier) {
        return Result.ok(sysUploadTaskService.getTaskInfo(identifier));
    }

    /**
     * 创建一个上传任务
     * @return
     */
    @PostMapping
    public Result<TaskInfoDTO> initTask (@Valid @RequestBody InitTaskParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return Result.ok(sysUploadTaskService.initTask(param));
    }

    /**
     * 获取每个分片的预签名上传地址
     * @param identifier
     * @param partNumber
     * @return
     */
    @GetMapping("/{identifier}/{partNumber}")
    public Result preSignUploadUrl (@PathVariable("identifier") String identifier, @PathVariable("partNumber") Integer partNumber) {
        SysUploadTask task = sysUploadTaskService.getByIdentifier(identifier);
        if (task == null) {
            return Result.error("分片任务不存在");
        }
        Map<String, String> params = new HashMap<>();
        params.put("partNumber", partNumber.toString());
        params.put("uploadId", task.getUploadId());
        return Result.ok(sysUploadTaskService.genPreSignUploadUrl(task.getBucketName(), task.getObjectKey(), params));
    }

    /**
     * 合并分片
     * @param identifier
     * @return
     */
    @PostMapping("/merge/{identifier}")
    public Result merge (@PathVariable("identifier") String identifier) {
        sysUploadTaskService.merge(identifier);
        return Result.ok();
    }

    @GetMapping("/minioList")
    public Result minioList () {
        return Result.ok(sysUploadTaskService.minioList());
    }

}
