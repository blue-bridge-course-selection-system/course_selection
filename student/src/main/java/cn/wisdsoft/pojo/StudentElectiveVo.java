package cn.wisdsoft.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ Author     ：高伟萌.
 * @ Date       ：Created in 2019-04-06 21:01
 * @ Description：学生已选课程实体类
 */
public class StudentElectiveVo implements Serializable {
    //学院
    private String collegeName;
    //选课ID
    private Long electiveCourseId;
    //课程ID
    private Long courseLibraryId;
    //课程名称
    private String courseLibraryName;
    //教师名称
    private String teacherName;
    //上课时间
    private String classTime;
    //上课地点
    private String classLocations;
    //学时
    private Short classHour;
    //学分
    private Short credit;
    //时间戳，选课24小时后才能退课
    private Date timeStamp;
    //是否正在学习
    private String courseFlag;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Long getElectiveCourseId() {
        return electiveCourseId;
    }

    public void setElectiveCourseId(Long electiveCourseId) {
        this.electiveCourseId = electiveCourseId;
    }

    public Long getCourseLibraryId() {
        return courseLibraryId;
    }

    public void setCourseLibraryId(Long courseLibraryId) {
        this.courseLibraryId = courseLibraryId;
    }

    public String getCourseLibraryName() {
        return courseLibraryName;
    }

    public void setCourseLibraryName(String courseLibraryName) {
        this.courseLibraryName = courseLibraryName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getClassLocations() {
        return classLocations;
    }

    public void setClassLocations(String classLocations) {
        this.classLocations = classLocations;
    }

    public Short getClassHour() {
        return classHour;
    }

    public void setClassHour(Short classHour) {
        this.classHour = classHour;
    }

    public Short getCredit() {
        return credit;
    }

    public void setCredit(Short credit) {
        this.credit = credit;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCourseFlag() {
        return courseFlag;
    }

    public void setCourseFlag(String courseFlag) {
        this.courseFlag = courseFlag;
    }
}
