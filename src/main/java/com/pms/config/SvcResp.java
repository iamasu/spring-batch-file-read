package com.pms.config;

/**
 *
 * @author Asu
 */
public class SvcResp {

    private String id;

    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SvcResp{" + "id=" + id + ", message=" + message + '}';
    }

}
