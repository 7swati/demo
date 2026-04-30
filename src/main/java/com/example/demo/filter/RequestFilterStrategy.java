package com.example.demo.filter;

import org.springframework.stereotype.Component;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RequestFilterStrategy {

    private final Random random = new Random();
    private final AtomicInteger totalCount   = new AtomicInteger(0);
    private final AtomicInteger savedCount   = new AtomicInteger(0);
    private final AtomicInteger ignoredCount = new AtomicInteger(0);

    // ── Save 60% of requests, ignore 40% ─────────────────────
    private static final double SAVE_PROBABILITY = 0.6;

    public FilterDecision decide() {
        totalCount.incrementAndGet();
        boolean shouldSave = random.nextDouble() < SAVE_PROBABILITY;

        if (shouldSave) {
            savedCount.incrementAndGet();
            return FilterDecision.SAVE;
        } else {
            ignoredCount.incrementAndGet();
            return FilterDecision.IGNORE;
        }
    }

    // ── Stats ─────────────────────────────────────────────────
    public int getTotalCount()   { return totalCount.get(); }
    public int getSavedCount()   { return savedCount.get(); }
    public int getIgnoredCount() { return ignoredCount.get(); }

    public enum FilterDecision {
        SAVE, IGNORE
    }
}