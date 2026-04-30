package com.example.demo.entity.jpa;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_aadhar",  columnList = "aadhar_no"),
        @Index(name = "idx_mobile",  columnList = "mobile_no"),
        @Index(name = "idx_email",   columnList = "email_address"),
        @Index(name = "idx_created", columnList = "created_at")
})
public class UserDipDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "aadhar_no", nullable = false, unique = true, length = 12)
    private String aadharNo;

    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;

    @Column(name = "mobile_no", nullable = false, length = 10)
    private String mobileNo;

    @Column(name = "email_address", nullable = false, length = 150)
    private String emailAddress;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // ── Lifecycle Callbacks ──────────────────────────────────
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ── Constructors ─────────────────────────────────────────
    public UserDipDetails() {}

    public UserDipDetails(String aadharNo, String userName, String mobileNo,
                String emailAddress) {
        this.aadharNo     = aadharNo;
        this.userName     = userName;
        this.mobileNo     = mobileNo;
        this.emailAddress = emailAddress;
    }

    // ── Getters & Setters ────────────────────────────────────
    public Integer getUserId()                    { return userId; }
    public void    setUserId(Integer userId)       { this.userId = userId; }

    public String  getAadharNo()                  { return aadharNo; }
    public void    setAadharNo(String aadharNo)   { this.aadharNo = aadharNo; }

    public String  getUserName()                  { return userName; }
    public void    setUserName(String userName)   { this.userName = userName; }

    public String  getMobileNo()                  { return mobileNo; }
    public void    setMobileNo(String mobileNo)   { this.mobileNo = mobileNo; }

    public String  getEmailAddress()                      { return emailAddress; }
    public void    setEmailAddress(String emailAddress)   { this.emailAddress = emailAddress; }

    public LocalDateTime getCreatedAt()                   { return createdAt; }
    public void          setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // ── toString ─────────────────────────────────────────────
    @Override
    public String toString() {
        return "User{" +
                "userId="       + userId       +
                ", aadharNo='"  + aadharNo     + '\'' +
                ", userName='"  + userName     + '\'' +
                ", mobileNo='"  + mobileNo     + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", createdAt="  + createdAt    +
                '}';
    }
}


