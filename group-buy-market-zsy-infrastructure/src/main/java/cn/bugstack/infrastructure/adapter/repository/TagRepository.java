package cn.bugstack.infrastructure.adapter.repository;

import cn.bugstack.domain.tag.adapter.repository.ITagRepository;
import cn.bugstack.domain.tag.model.entity.CrowdTagsJobEntity;
import cn.bugstack.infrastructure.dao.ICrowdTagsDao;
import cn.bugstack.infrastructure.dao.ICrowdTagsDetailDao;
import cn.bugstack.infrastructure.dao.ICrowdTagsJobDao;
import cn.bugstack.infrastructure.dao.po.CrowdTags;
import cn.bugstack.infrastructure.dao.po.CrowdTagsDetail;
import cn.bugstack.infrastructure.dao.po.CrowdTagsJob;
import cn.bugstack.infrastructure.redis.IRedisService;
import org.redisson.api.RBitSet;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zhaoshunyi
 * @description 人群标签仓储
 * @create 2024-12-28 13:12
 */
@Repository
public class TagRepository implements ITagRepository {

    @Resource
    private ICrowdTagsDao crowdTagsDao;
    @Resource
    private ICrowdTagsDetailDao crowdTagsDetailDao;
    @Resource
    private ICrowdTagsJobDao crowdTagsJobDao;

    @Resource
    private IRedisService redisService;

    @Override
    public CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId) {
        CrowdTagsJob crowdTagsJobReq = new CrowdTagsJob();
        crowdTagsJobReq.setTagId(tagId);
        crowdTagsJobReq.setBatchId(batchId);

        CrowdTagsJob crowdTagsJobRes = crowdTagsJobDao.queryCrowdTagsJob(crowdTagsJobReq);
        if (null == crowdTagsJobRes) return null;

        return CrowdTagsJobEntity.builder()
                .tagType(crowdTagsJobRes.getTagType())
                .tagRule(crowdTagsJobRes.getTagRule())
                .statStartTime(crowdTagsJobRes.getStatStartTime())
                .statEndTime(crowdTagsJobRes.getStatEndTime())
                .build();
    }

    @Override
    public void addCrowdTagsUserId(String tagId, String userId) {
        CrowdTagsDetail crowdTagsDetailReq = new CrowdTagsDetail();
        crowdTagsDetailReq.setTagId(tagId);
        crowdTagsDetailReq.setUserId(userId);



        try {
            crowdTagsDetailDao.addCrowdTagsUserId(crowdTagsDetailReq);

            // 获取BitSet
            RBitSet bitSet = redisService.getBitSet(tagId);
            bitSet.set(redisService.getIndexFromUserId(userId), true);
        } catch (DuplicateKeyException ignore) {
            // 忽略唯一索引冲突
        }
    }

    @Override
    public void updateCrowdTagsStatistics(String tagId, int count) {
        CrowdTags crowdTagsReq = new CrowdTags();
        crowdTagsReq.setTagId(tagId);
        crowdTagsReq.setStatistics(count);

        crowdTagsDao.updateCrowdTagsStatistics(crowdTagsReq);
    }

}
