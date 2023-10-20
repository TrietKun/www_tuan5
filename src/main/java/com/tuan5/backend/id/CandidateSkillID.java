package com.tuan5.backend.id;
import java.io.Serializable;
import java.util.Objects;

public class CandidateSkillID implements Serializable {
    private long canId;
    private long skillId;

    public CandidateSkillID() {
    }

    public CandidateSkillID(long canId, long skillId) {
        this.canId = canId;
        this.skillId = skillId;
    }

    public long getCanId() {
        return canId;
    }

    public void setCanId(long canId) {
        this.canId = canId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkillID that = (CandidateSkillID) o;
        return canId == that.canId && skillId == that.skillId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(canId, skillId);
    }
}
