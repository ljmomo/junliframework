package com.junli.system.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@TableName("sys_task")
public class Task extends Model<Task> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * cron表达式
     */
    @TableField("cron_expression")
    private String cronExpression;
    /**
     * 任务调用的方法名
     */
    @TableField("method_name")
    private String methodName;
    /**
     * 任务是否有状态
     */
    @TableField("is_concurrent")
    private String isConcurrent;
    /**
     * 任务描述
     */
    private String description;
    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;
    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    @TableField("bean_class")
    private String beanClass;
    /**
     * 创建时间
     */
    @TableField("create_date")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;
    /**
     * 任务状态
     */
    @TableField("job_status")
    private String jobStatus;
    /**
     * 任务分组
     */
    @TableField("job_group")
    private String jobGroup;
    /**
     * 更新时间
     */
    @TableField("update_date")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;
    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;
    /**
     * Spring bean
     */
    @TableField("spring_bean")
    private String springBean;
    /**
     * 任务名
     */
    @TableField("job_name")
    private String jobName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getSpringBean() {
        return springBean;
    }

    public void setSpringBean(String springBean) {
        this.springBean = springBean;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Task{" +
                ", id=" + id +
                ", cronExpression=" + cronExpression +
                ", methodName=" + methodName +
                ", isConcurrent=" + isConcurrent +
                ", description=" + description +
                ", updateBy=" + updateBy +
                ", beanClass=" + beanClass +
                ", createDate=" + createDate +
                ", jobStatus=" + jobStatus +
                ", jobGroup=" + jobGroup +
                ", updateDate=" + updateDate +
                ", createBy=" + createBy +
                ", springBean=" + springBean +
                ", jobName=" + jobName +
                "}";
    }
}
