package com.admin.admin_service.dto;

public class VerifyRequest {
    private boolean isVerified;

    public boolean isIsVerified() {   // <-- Notice: isIsVerified
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {  // <-- Correct setter
        this.isVerified = isVerified;
    }
}
