package xyz.huanggy.minio.upload.model.dto;

import cn.hutool.core.bean.BeanUtil;
import com.amazonaws.services.s3.model.PartSummary;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import xyz.huanggy.minio.upload.model.entity.SysUploadTask;

import java.util.List;

@Data
@ToString
@Accessors(chain = true)
public class TaskRecordDTO extends SysUploadTask {

    /**
     * 已上传完的分片
     */
    private List<PartSummary> exitPartList;

    public static TaskRecordDTO convertFromEntity (SysUploadTask task) {
        TaskRecordDTO dto = new TaskRecordDTO();
        BeanUtil.copyProperties(task, dto);
        return dto;
    }
}
