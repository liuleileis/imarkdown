package com.bjfu.imarkdown.dto;

public class FileInfo {
    private int success = 1;
    private String message = "上传成功";
    private String url;

    public FileInfo() {

    }

    public FileInfo(int success, String message, String url) {
        this.success = success;
        this.message = message;
        this.url = url;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
