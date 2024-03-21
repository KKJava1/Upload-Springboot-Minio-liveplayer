package xyz.huanggy.minio.upload.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.net.URL;

@Data
@Accessors(chain = true)
@TableName("sys_upload_task")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SysUploadTask implements Serializable {

    private Long id;
    //分片上传的uploadId
    private String uploadId;
    //文件唯一标识（md5）
    private String fileIdentifier;
    //文件名
    private String fileName;
    //所属桶名
    private String bucketName;
    //文件的key
    private String objectKey;
    //文件大小（byte）
    private Long totalSize;
    //每个分片大小（byte）
    private Long chunkSize;
    //分片数量
    private Integer chunkNum;

    @TableField(exist = false)
    private URL url;
}
