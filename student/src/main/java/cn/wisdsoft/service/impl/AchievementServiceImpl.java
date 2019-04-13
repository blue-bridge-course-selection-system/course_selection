package cn.wisdsoft.service.impl;

import cn.wisdsoft.mapper.AchievementMapper;
import cn.wisdsoft.service.AchievementService;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-13 22:47
 * @ Description：
 */
@Service
public class AchievementServiceImpl implements AchievementService {
    protected final AchievementMapper achievementMapper;

    public AchievementServiceImpl(AchievementMapper achievementMapper) {
        this.achievementMapper = achievementMapper;
    }

    @Override
    public ElectiveResult selectAchievement(String studentId, Integer termId) {
        return ElectiveResult.ok(achievementMapper.selectAchievement(studentId, termId));
    }
}
