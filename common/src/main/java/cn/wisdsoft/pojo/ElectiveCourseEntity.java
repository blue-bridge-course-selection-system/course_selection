package cn.wisdsoft.pojo;

import java.io.Serializable;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-06 12:02
 * @ Description：选课表
 */
public class ElectiveCourseEntity implements Serializable {
    //选课表编号
    private Long electiveCourseId;
    //课程库编号
    private Long courseLibraryId;
    //课程名称
    private String courseLibraryName;
    //课组编号
    private Long courseGroupId;
    //教师编号
    private String teacherId;
    //教师名称
    private String teacherName;
    //上课时间
    private String classTime;
    //上课地点
    private String classLocations;
    //限选年级
    private String restrictedGrade;
    //最大人数
    private Integer maxNumber;
    //最小人数
    private Integer minNumber;
    //课时
    private Integer classHour;
    //学分
    private Integer credit;
    //简介
    private String courseLibraryIntroduction;
    //当前人数
    private Integer currentNumber;
    //学期编号
    private Integer termId;
    //学院名称
    private String collegeName;
    //0未删除、1已删除
    private String deleteFlag;
    //备注
    private String remark;

    public Long getElectiveCourseId() {
        return electiveCourseId;
    }

    public ElectiveCourseEntity setElectiveCourseId(Long electiveCourseId) {
        this.electiveCourseId = electiveCourseId;
        return this;
    }

    public Long getCourseLibraryId() {
        return courseLibraryId;
    }

    public ElectiveCourseEntity setCourseLibraryId(Long courseLibraryId) {
        this.courseLibraryId = courseLibraryId;
        return this;
    }

    public String getCourseLibraryName() {
        return courseLibraryName;
    }

    public ElectiveCourseEntity setCourseLibraryName(String courseLibraryName) {
        this.courseLibraryName = courseLibraryName;
        return this;
    }

    public Long getCourseGroupId() {
        return courseGroupId;
    }

    public ElectiveCourseEntity setCourseGroupId(Long courseGroupId) {
        this.courseGroupId = courseGroupId;
        return this;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public ElectiveCourseEntity setTeacherId(String teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public ElectiveCourseEntity setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public String getClassTime() {
        return classTime;
    }

    public ElectiveCourseEntity setClassTime(String classTime) {
        this.classTime = classTime;
        return this;
    }

    public String getClassLocations() {
        return classLocations;
    }

    public ElectiveCourseEntity setClassLocations(String classLocations) {
        this.classLocations = classLocations;
        return this;
    }

    public String getRestrictedGrade() {
        return restrictedGrade;
    }

    public ElectiveCourseEntity setRestrictedGrade(String restrictedGrade) {
        this.restrictedGrade = restrictedGrade;
        return this;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public ElectiveCourseEntity setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
        return this;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public ElectiveCourseEntity setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
        return this;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public ElectiveCourseEntity setClassHour(Integer classHour) {
        this.classHour = classHour;
        return this;
    }

    public Integer getCredit() {
        return credit;
    }

    public ElectiveCourseEntity setCredit(Integer credit) {
        this.credit = credit;
        return this;
    }

    public String getCourseLibraryIntroduction() {
        return courseLibraryIntroduction;
    }

    public ElectiveCourseEntity setCourseLibraryIntroduction(String courseLibraryIntroduction) {
        this.courseLibraryIntroduction = courseLibraryIntroduction;
        return this;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public ElectiveCourseEntity setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
        return this;
    }

    public Integer getTermId() {
        return termId;
    }

    public ElectiveCourseEntity setTermId(Integer termId) {
        this.termId = termId;
        return this;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public ElectiveCourseEntity setCollegeName(String collegeName) {
        this.collegeName = collegeName;
        return this;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public ElectiveCourseEntity setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public ElectiveCourseEntity setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
