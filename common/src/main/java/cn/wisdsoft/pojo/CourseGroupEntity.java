package cn.wisdsoft.pojo;

import java.io.Serializable;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-06 11:56
 * @ Description：课程组表
 */
public class CourseGroupEntity implements Serializable {
    //课程组编号
    private Long courseGroupId;
    //课程组名称
    private String courseGroupName;
    //备注
    private String remark;

    public Long getCourseGroupId() {
        return courseGroupId;
    }

    public CourseGroupEntity setCourseGroupId(Long courseGroupId) {
        this.courseGroupId = courseGroupId;
        return this;
    }

    public String getCourseGroupName() {
        return courseGroupName;
    }

    public CourseGroupEntity setCourseGroupName(String courseGroupName) {
        this.courseGroupName = courseGroupName;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public CourseGroupEntity setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
