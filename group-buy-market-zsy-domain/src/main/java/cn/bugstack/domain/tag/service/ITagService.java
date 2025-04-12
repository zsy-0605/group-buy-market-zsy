package cn.bugstack.domain.tag.service;

import org.springframework.stereotype.Service;

/**
 * @author Fuzhengwei bugstack.cn @zhaoshunyi
 * @description 人群标签服务接口
 * @create 2024-12-28 11:26
 */
@Service
public interface ITagService {

    /**
     * 执行人群标签批次任务
     *
     * @param tagId   人群ID
     * @param batchId 批次ID
     */
    void execTagBatchJob(String tagId, String batchId);

}
