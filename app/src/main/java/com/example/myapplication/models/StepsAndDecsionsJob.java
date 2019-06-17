package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StepsAndDecsionsJob {

    @SerializedName("jobPath")
    @Expose
    private JobPath jobPath;
    @SerializedName("decisionsJob")
    @Expose
    private DecisionsJob decisionsJob;
    @SerializedName("attachmentServiceEmployee")
    @Expose
    private List<AttachmentServiceEmployee> attachmentServiceEmployee;

    public JobPath getJobPath() {
        return jobPath;
    }

    public void setJobPath(JobPath jobPath) {
        this.jobPath = jobPath;
    }

    public DecisionsJob getDecisionsJob() {
        return decisionsJob;
    }

    public void setDecisionsJob(DecisionsJob decisionsJob) {
        this.decisionsJob = decisionsJob;
    }

    public List<AttachmentServiceEmployee> getAttachmentServiceEmployee() {
        return attachmentServiceEmployee;
    }

    public void setAttachmentServiceEmployee(List<AttachmentServiceEmployee> attachmentServiceEmployee) {
        this.attachmentServiceEmployee = attachmentServiceEmployee;
    }

}
