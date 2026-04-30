-- ============================================================
-- MySQL Script: DipAllotment Table with Monthly Partitioning
-- ============================================================
DROP TABLE IF EXISTS DipAllotment;

-- Step 3: Create the DipAllotment Table with Monthly Partitioning
CREATE TABLE DipAllotment (
    AllotmentId     INT             NOT NULL AUTO_INCREMENT,
    UserId          INT             NOT NULL,
    AadharCard      CHAR(12)        NOT NULL,
    SlotStatus      ENUM(
                        'PENDING',
                        'CONFIRMED',
                        'CANCELLED',
                        'COMPLETED',
                        'WAITLISTED'
                    )               NOT NULL DEFAULT 'PENDING',
    PaymentStatus   ENUM(
                        'UNPAID',
                        'PAID',
                        'REFUNDED',
                        'FAILED'
                    )               NOT NULL DEFAULT 'UNPAID',
    MobileNo        CHAR(10)        NOT NULL,
    EmailAddress    VARCHAR(150)    NOT NULL,
    CreatedAt       DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt       DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP
                                    ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (AllotmentId, CreatedAt)   -- CreatedAt must be in PK for partitioning
)
PARTITION BY RANGE (YEAR(CreatedAt) * 100 + MONTH(CreatedAt)) (

    -- ── 2024 ──
    PARTITION p_2024_01 VALUES LESS THAN (202402),
    PARTITION p_2024_02 VALUES LESS THAN (202403),
    PARTITION p_2024_03 VALUES LESS THAN (202404),
    PARTITION p_2024_04 VALUES LESS THAN (202405),
    PARTITION p_2024_05 VALUES LESS THAN (202406),
    PARTITION p_2024_06 VALUES LESS THAN (202407),
    PARTITION p_2024_07 VALUES LESS THAN (202408),
    PARTITION p_2024_08 VALUES LESS THAN (202409),
    PARTITION p_2024_09 VALUES LESS THAN (202410),
    PARTITION p_2024_10 VALUES LESS THAN (202411),
    PARTITION p_2024_11 VALUES LESS THAN (202412),
    PARTITION p_2024_12 VALUES LESS THAN (202501),

    -- ── 2025 ──
    PARTITION p_2025_01 VALUES LESS THAN (202502),
    PARTITION p_2025_02 VALUES LESS THAN (202503),
    PARTITION p_2025_03 VALUES LESS THAN (202504),
    PARTITION p_2025_04 VALUES LESS THAN (202505),
    PARTITION p_2025_05 VALUES LESS THAN (202506),
    PARTITION p_2025_06 VALUES LESS THAN (202507),
    PARTITION p_2025_07 VALUES LESS THAN (202508),
    PARTITION p_2025_08 VALUES LESS THAN (202509),
    PARTITION p_2025_09 VALUES LESS THAN (202510),
    PARTITION p_2025_10 VALUES LESS THAN (202511),
    PARTITION p_2025_11 VALUES LESS THAN (202512),
    PARTITION p_2025_12 VALUES LESS THAN (202601),

    -- ── 2026 ──
    PARTITION p_2026_01 VALUES LESS THAN (202602),
    PARTITION p_2026_02 VALUES LESS THAN (202603),
    PARTITION p_2026_03 VALUES LESS THAN (202604),
    PARTITION p_2026_04 VALUES LESS THAN (202605),
    PARTITION p_2026_05 VALUES LESS THAN (202606),
    PARTITION p_2026_06 VALUES LESS THAN (202607),
    PARTITION p_2026_07 VALUES LESS THAN (202608),
    PARTITION p_2026_08 VALUES LESS THAN (202609),
    PARTITION p_2026_09 VALUES LESS THAN (202610),
    PARTITION p_2026_10 VALUES LESS THAN (202611),
    PARTITION p_2026_11 VALUES LESS THAN (202612),
    PARTITION p_2026_12 VALUES LESS THAN (202701),

    -- ── 2027 ──
    PARTITION p_2027_01 VALUES LESS THAN (202702),
    PARTITION p_2027_02 VALUES LESS THAN (202703),
    PARTITION p_2027_03 VALUES LESS THAN (202704),
    PARTITION p_2027_04 VALUES LESS THAN (202705),
    PARTITION p_2027_05 VALUES LESS THAN (202706),
    PARTITION p_2027_06 VALUES LESS THAN (202707),
    PARTITION p_2027_07 VALUES LESS THAN (202708),
    PARTITION p_2027_08 VALUES LESS THAN (202709),
    PARTITION p_2027_09 VALUES LESS THAN (202710),
    PARTITION p_2027_10 VALUES LESS THAN (202711),
    PARTITION p_2027_11 VALUES LESS THAN (202712),
    PARTITION p_2027_12 VALUES LESS THAN (202801),

    -- Catch-all for future data
    PARTITION p_future  VALUES LESS THAN MAXVALUE
);


-- ============================================================
-- Step 4: Add Indexes for fast lookups
-- ============================================================
CREATE INDEX idx_allot_userid      ON DipAllotment (UserId);
CREATE INDEX idx_allot_aadhar      ON DipAllotment (AadharCard);
CREATE INDEX idx_allot_mobile      ON DipAllotment (MobileNo);
CREATE INDEX idx_allot_email       ON DipAllotment (EmailAddress);
CREATE INDEX idx_allot_slotstatus  ON DipAllotment (SlotStatus);
CREATE INDEX idx_allot_paymentstatus ON DipAllotment (PaymentStatus);
CREATE INDEX idx_allot_created     ON DipAllotment (CreatedAt);
