package xyz.huanggy.minio.upload.model.dto;

import com.amazonaws.services.s3.model.PartSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.huanggy.minio.upload.model.entity.SysUploadTask;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TaskInfoDTO {

    /**
     * 是否完成上传（是否已经合并分片）
     */
    private boolean finished;

    /**
     * 文件地址
     */
    private String path;

    /**
     * 上传记录
     */
    private TaskRecordDTO taskRecord;

}
