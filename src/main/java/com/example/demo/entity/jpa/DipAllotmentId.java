package com.example.demo.entity.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class DipAllotmentId implements Serializable {

    private Integer       allotmentId;
    private LocalDateTime createdAt;

    public DipAllotmentId() {}

    public DipAllotmentId(Integer allotmentId, LocalDateTime createdAt) {
        this.allotmentId = allotmentId;
        this.createdAt   = createdAt;
    }

    public Integer       getAllotmentId()                          { return allotmentId; }
    public void          setAllotmentId(Integer allotmentId)      { this.allotmentId = allotmentId; }
    public LocalDateTime getCreatedAt()                           { return createdAt; }
    public void          setCreatedAt(LocalDateTime createdAt)    { this.createdAt = createdAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DipAllotmentId)) return false;
        DipAllotmentId that = (DipAllotmentId) o;
        return Objects.equals(allotmentId, that.allotmentId) &&
                Objects.equals(createdAt,   that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allotmentId, createdAt);
    }
}

