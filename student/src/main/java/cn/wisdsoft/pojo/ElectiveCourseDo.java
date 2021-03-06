package cn.wisdsoft.pojo;

import java.io.Serializable;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-13 09:53
 * @ Description：学生查看选课实体类
 */
public class ElectiveCourseDo implements Serializable {
    //选课ID
    private Long electiveCourseId;
    //课程ID
    private Long courseLibraryId;
    //课程名称
    private String courseLibraryName;
    //课组名称
    private String courseGroupName;
    //教师名称
    private String teacherName;
    //上课时间和地点JSON数据
    private String timeAndPlace;
    //最大人数
    private Integer maxNumber;
    //最小人数
    private Integer minNumber;
    //学时
    private Integer classHour;
    //学分
    private Integer credit;
    //课程简介
    private String courseLibraryIntroduction;
    //当前人数
    private Integer currentNumber;

    public Long getElectiveCourseId() {
        return electiveCourseId;
    }

    public ElectiveCourseDo setElectiveCourseId(Long electiveCourseId) {
        this.electiveCourseId = electiveCourseId;
        return this;
    }

    public Long getCourseLibraryId() {
        return courseLibraryId;
    }

    public ElectiveCourseDo setCourseLibraryId(Long courseLibraryId) {
        this.courseLibraryId = courseLibraryId;
        return this;
    }

    public String getCourseLibraryName() {
        return courseLibraryName;
    }

    public ElectiveCourseDo setCourseLibraryName(String courseLibraryName) {
        this.courseLibraryName = courseLibraryName;
        return this;
    }

    public String getCourseGroupName() {
        return courseGroupName;
    }

    public ElectiveCourseDo setCourseGroupName(String courseGroupName) {
        this.courseGroupName = courseGroupName;
        return this;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public ElectiveCourseDo setTeacherName(String teacherName) {
        this.teacherName = teacherName;
        return this;
    }

    public String getTimeAndPlace() {
        return timeAndPlace;
    }

    public ElectiveCourseDo setTimeAndPlace(String timeAndPlace) {
        this.timeAndPlace = timeAndPlace;
        return this;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public ElectiveCourseDo setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
        return this;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public ElectiveCourseDo setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
        return this;
    }

    public Integer getClassHour() {
        return classHour;
    }

    public ElectiveCourseDo setClassHour(Integer classHour) {
        this.classHour = classHour;
        return this;
    }

    public Integer getCredit() {
        return credit;
    }

    public ElectiveCourseDo setCredit(Integer credit) {
        this.credit = credit;
        return this;
    }

    public String getCourseLibraryIntroduction() {
        return courseLibraryIntroduction;
    }

    public ElectiveCourseDo setCourseLibraryIntroduction(String courseLibraryIntroduction) {
        this.courseLibraryIntroduction = courseLibraryIntroduction;
        return this;
    }

    public Integer getCurrentNumber() {
        return currentNumber;
    }

    public ElectiveCourseDo setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
        return this;
    }
}
