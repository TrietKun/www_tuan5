package com.tuan5.backend.id;

import java.io.Serializable;
import java.util.Objects;

public class JobSkillID implements Serializable {
    private long skillId;
    private long jobId;

    public JobSkillID() {
    }

    public JobSkillID(long skillId, long jobId) {
        this.skillId = skillId;
        this.jobId = jobId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkillID that = (JobSkillID) o;
        return skillId == that.skillId && jobId == that.jobId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, jobId);
    }
}
