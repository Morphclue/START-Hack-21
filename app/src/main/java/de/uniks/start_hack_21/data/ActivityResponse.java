package de.uniks.start_hack_21.data;

public class ActivityResponse {
    private String id;
    private String activityTime;
    private String userId;
    private String gender;
    private Integer age;
    private String labelsJson;
    private String basicActivity;
    private String screenshotFindingsJson;
    private String screenshotFindingsDetailsJson;
    private String imageClass;
    private String recognizedActivity;
    private String activityDetails;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLabelsJson() {
        return labelsJson;
    }

    public void setLabelsJson(String labelsJson) {
        this.labelsJson = labelsJson;
    }

    public String getBasicActivity() {
        return basicActivity;
    }

    public void setBasicActivity(String basicActivity) {
        this.basicActivity = basicActivity;
    }

    public String getScreenshotFindingsJson() {
        return screenshotFindingsJson;
    }

    public void setScreenshotFindingsJson(String screenshotFindingsJson) {
        this.screenshotFindingsJson = screenshotFindingsJson;
    }

    public String getScreenshotFindingsDetailsJson() {
        return screenshotFindingsDetailsJson;
    }

    public void setScreenshotFindingsDetailsJson(String screenshotFindingsDetailsJson) {
        this.screenshotFindingsDetailsJson = screenshotFindingsDetailsJson;
    }

    public String getImageClass() {
        return imageClass;
    }

    public void setImageClass(String imageClass) {
        this.imageClass = imageClass;
    }

    public String getRecognizedActivity() {
        return recognizedActivity;
    }

    public void setRecognizedActivity(String recognizedActivity) {
        this.recognizedActivity = recognizedActivity;
    }

    public String getActivityDetails() {
        return activityDetails;
    }

    public void setActivityDetails(String activityDetails) {
        this.activityDetails = activityDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
