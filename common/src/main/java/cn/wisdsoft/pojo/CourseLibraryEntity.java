package cn.wisdsoft.pojo;

import java.io.Serializable;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-06 11:59
 * @ Description：课程库表
 */
public class CourseLibraryEntity implements Serializable {
    //课程库编号
    private Long courseLibraryId;
    //课程名称
    private String courseLibraryName;
    //学时
    private Short classTime;
    //学分
    private Short credit;
    //学院ID
    private String collegeId;
    //课程组外键
    private Long courseGroupId;
    //备注
    private String remark;

    public Long getCourseLibraryId() {
        return courseLibraryId;
    }

    public CourseLibraryEntity setCourseLibraryId(Long courseLibraryId) {
        this.courseLibraryId = courseLibraryId;
        return this;
    }

    public String getCourseLibraryName() {
        return courseLibraryName;
    }

    public CourseLibraryEntity setCourseLibraryName(String courseLibraryName) {
        this.courseLibraryName = courseLibraryName;
        return this;
    }

    public Short getClassTime() {
        return classTime;
    }

    public CourseLibraryEntity setClassTime(Short classTime) {
        this.classTime = classTime;
        return this;
    }

    public Short getCredit() {
        return credit;
    }

    public CourseLibraryEntity setCredit(Short credit) {
        this.credit = credit;
        return this;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public CourseLibraryEntity setCollegeId(String collegeId) {
        this.collegeId = collegeId;
        return this;
    }

    public Long getCourseGroupId() {
        return courseGroupId;
    }

    public CourseLibraryEntity setCourseGroupId(Long courseGroupId) {
        this.courseGroupId = courseGroupId;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public CourseLibraryEntity setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
