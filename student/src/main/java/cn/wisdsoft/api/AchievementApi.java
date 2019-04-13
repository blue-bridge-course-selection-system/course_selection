package cn.wisdsoft.api;

import cn.wisdsoft.pojo.StudentVo;
import cn.wisdsoft.service.AchievementService;
import cn.wisdsoft.util.ElectiveResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-13 22:46
 * @ Description：
 */
@RestController
@RequestMapping("/achievement")
public class AchievementApi {
    private final AchievementService achievementService;

    public AchievementApi(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    /**
     * 查询成绩
     *
     * @param token   用户另怕爱
     * @param session session
     * @return 成绩信息
     */
    @GetMapping("/grade")
    public ElectiveResult grade(String token, HttpSession session) {
        StudentVo studentVo = (StudentVo) session.getAttribute(token);
        if (studentVo == null) {
            return ElectiveResult.build(410, "token失效");
        }
        return achievementService.selectAchievement(studentVo.getUsername(), studentVo.getTermId());
    }
}
