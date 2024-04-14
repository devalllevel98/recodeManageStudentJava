package org.example.recode.handle;

public class ErrorMessager {
    private int statusCode;
    private String messager;
    private Long timeStep;

    public ErrorMessager(int statusCode, String messager) {
        this.statusCode = statusCode;
        this.messager = messager;
        this.timeStep = System.currentTimeMillis();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessager() {
        return messager;
    }

    public void setMessager(String messager) {
        this.messager = messager;
    }

    public Long getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(Long timeStep) {
        this.timeStep = timeStep;
    }
}
