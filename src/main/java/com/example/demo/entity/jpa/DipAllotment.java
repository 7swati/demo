package com.example.demo.entity.jpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@IdClass(DipAllotmentId.class)
@Table(name = "DipAllotment", indexes = {
        @Index(name = "idx_allot_userid", columnList = "UserId"),
        @Index(name = "idx_allot_aadhar", columnList = "AadharCard"),
        @Index(name = "idx_allot_mobile", columnList = "MobileNo"),
        @Index(name = "idx_allot_email", columnList = "EmailAddress"),
        @Index(name = "idx_allot_slotstatus", columnList = "SlotStatus"),
        @Index(name = "idx_allot_paymentstatus", columnList = "PaymentStatus"),
        @Index(name = "idx_allot_created", columnList = "CreatedAt")
})
public class DipAllotment {

    // ── Enums ────────────────────────────────────────────────
    public enum SlotStatus {
        PENDING, CONFIRMED, CANCELLED, COMPLETED, WAITLISTED
    }

    public enum PaymentStatus {
        UNPAID, PARTIAL, PAID, REFUNDED, FAILED
    }

    // ── Composite Primary Key Fields ─────────────────────────
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AllotmentId", nullable = false)
    private Integer allotmentId;

    @Id
    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // ── Regular Columns ──────────────────────────────────────
    @Column(name = "UserId", nullable = false)
    private Integer userId;

    @Column(name = "AadharCard", nullable = false, length = 12)
    private String aadharCard;

    @Enumerated(EnumType.STRING)
    @Column(name = "SlotStatus", nullable = false, length = 20)
    private SlotStatus slotStatus = SlotStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentStatus", nullable = false, length = 20)
    private PaymentStatus paymentStatus = PaymentStatus.UNPAID;

    @Column(name = "MobileNo", nullable = false, length = 10)
    private String mobileNo;

    @Column(name = "EmailAddress", nullable = false, length = 150)
    private String emailAddress;

    @Column(name = "UpdatedAt", nullable = false)
    private LocalDateTime updatedAt;

    // ── Lifecycle Callbacks ──────────────────────────────────
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        if (this.slotStatus == null) this.slotStatus = SlotStatus.PENDING;
        if (this.paymentStatus == null) this.paymentStatus = PaymentStatus.UNPAID;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ── Constructors ─────────────────────────────────────────
    public DipAllotment() {
    }

    public DipAllotment(Integer userId, String aadharCard, SlotStatus slotStatus,
                        PaymentStatus paymentStatus, String mobileNo, String emailAddress) {
        this.userId = userId;
        this.aadharCard = aadharCard;
        this.slotStatus = slotStatus;
        this.paymentStatus = paymentStatus;
        this.mobileNo = mobileNo;
        this.emailAddress = emailAddress;
    }

    // ── Getters & Setters ────────────────────────────────────
    public Integer getAllotmentId() {
        return allotmentId;
    }

    public void setAllotmentId(Integer allotmentId) {
        this.allotmentId = allotmentId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ── toString ─────────────────────────────────────────────
    @Override
    public String toString() {
        return "DipAllotment{" +
                "allotmentId=" + allotmentId +
                ", userId=" + userId +
                ", aadharCard='" + aadharCard + '\'' +
                ", slotStatus=" + slotStatus +
                ", paymentStatus=" + paymentStatus +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}