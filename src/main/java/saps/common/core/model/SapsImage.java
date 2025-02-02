/* (C)2020 */
package saps.common.core.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import saps.common.core.model.enums.ImageTaskState;

public class SapsImage implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy-MM-dd");

  public static final String NONE_FEDERATION_MEMBER = "None";
  public static final String NONE_ARREBOL_JOB_ID = "-1";
  public static final String AVAILABLE = "available";
  public static final String UNAVAILABLE = "unavailable";

  public static final String NON_EXISTENT_DATA = "NE";

  private String taskId;
  private String dataset;
  private String region;
  private Date imageDate;
  private ImageTaskState state;
  private String arrebolJobId;
  private String federationMember;
  private String user;
  private int priority;
  private String inputdownloadingTag;
  private String digestInputdownloading;
  private String preprocessingTag;
  private String digestPreprocessing;
  private String processingTag;
  private String digestProcessing;
  private Timestamp creationTime;
  private Timestamp updateTime;
  private String status;
  private String error;

  public SapsImage(
      String taskId,
      String dataset,
      String region,
      Date imageDate,
      ImageTaskState state,
      String arrebolJobId,
      String federationMember,
      int priority,
      String user,
      String inputdownloadingTag,
      String digestInputdownloading,
      String preprocessingTag,
      String digestPreprocessing,
      String processingTag,
      String digestProcessing,
      Timestamp creationTime,
      Timestamp updateTime,
      String status,
      String error) {
    this.taskId = taskId;
    this.dataset = dataset;
    this.region = region;
    this.imageDate = imageDate;
    this.state = state;
    this.arrebolJobId = arrebolJobId;
    this.federationMember = federationMember;
    this.priority = priority;
    this.inputdownloadingTag = inputdownloadingTag;
    this.digestInputdownloading = digestInputdownloading;
    this.preprocessingTag = preprocessingTag;
    this.digestPreprocessing = digestPreprocessing;
    this.processingTag = processingTag;
    this.digestProcessing = digestProcessing;
    this.creationTime = creationTime;
    this.updateTime = updateTime;
    this.status = status;
    this.error = error;
    this.user = user;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getDataset() {
    return dataset;
  }

  public void setDataset(String dataset) {
    this.dataset = dataset;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Date getImageDate() {
    return imageDate;
  }

  public void setImageDate(Date imageDate) {
    this.imageDate = imageDate;
  }

  public ImageTaskState getState() {
    return state;
  }

  public void setState(ImageTaskState state) {
    this.state = state;
  }

  public String getArrebolJobId() {
    return arrebolJobId;
  }

  public void setArrebolJobId(String arrebolJobId) {
    this.arrebolJobId = arrebolJobId;
  }

  public String getFederationMember() {
    return federationMember;
  }

  public void setFederationMember(String federationMember) {
    this.federationMember = federationMember;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getInputdownloadingTag() {
    return inputdownloadingTag;
  }

  public void setInputdownloadingTag(String inputdownloadingTag) {
    this.inputdownloadingTag = inputdownloadingTag;
  }

  public String getDigestInputdownloading() {
    return digestInputdownloading;
  }

  public void setDigestInputdownloading(String digestInputdownloading) {
    this.digestInputdownloading = digestInputdownloading;
  }

  public String getPreprocessingTag() {
    return preprocessingTag;
  }

  public void setPreprocessingTag(String preprocessingTag) {
    this.preprocessingTag = preprocessingTag;
  }

  public String getDigestPreprocessing() {
    return digestPreprocessing;
  }

  public void setDigestPreprocessing(String digestPreprocessing) {
    this.digestPreprocessing = digestPreprocessing;
  }

  public String getProcessingTag() {
    return processingTag;
  }

  public void setProcessingTag(String processingTag) {
    this.processingTag = processingTag;
  }

  public String getDigestProcessing() {
    return digestProcessing;
  }

  public void setDigestProcessing(String digestProcessing) {
    this.digestProcessing = digestProcessing;
  }

  public Timestamp getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Timestamp creationTime) {
    this.creationTime = creationTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  // TODO change to the correct format
  public String getName() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(imageDate);
    return dataset + cal.get(Calendar.DAY_OF_YEAR) + cal.get(Calendar.YEAR);
  }

  // TODO change to the correct format
  public String getCollectionTierName() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(imageDate);
    return dataset + "_" + cal.get(Calendar.DAY_OF_YEAR) + "_" + cal.get(Calendar.YEAR);
  }

  public JSONObject toJSON() throws JSONException {
    JSONObject json = new JSONObject();

    json.put("taskId", taskId);
    json.put("name", getName());
    json.put("collectionTierName", getCollectionTierName());
    json.put("dataset", dataset);
    json.put("region", region);
    json.put("imageDate", DATE_FORMATER.format(imageDate));
    json.put("state", state.getValue());
    json.put("federationMember", federationMember);
    json.put("priority", priority);
    json.put("user", user);
    json.put("inputGatheringTag", inputdownloadingTag);
    json.put("inputPreprocessingTag", preprocessingTag);
    json.put("algorithmExecutionTag", processingTag);
    json.put("creationTime", creationTime);
    json.put("updateTime", updateTime);
    json.put("status", status);
    json.put("error", error);

    return json;
  }

  @Override
  public String toString() {
    return "ImageTask{"
        + "taskId='"
        + taskId
        + "', dataset='"
        + dataset
        + "', region='"
        + region
        + "', imageDate="
        + DATE_FORMATER.format(imageDate)
        + ", state='"
        + state
        + ", federationMember='"
        + federationMember
        + "', priority="
        + priority
        + ", user='"
        + user
        + "', inputGatheringTag='"
        + inputdownloadingTag
        + "', inputPreprocessingTag='"
        + preprocessingTag
        + "', algorithmExecutionTag='"
        + processingTag
        + "', creationTime="
        + creationTime
        + ", updateTime="
        + updateTime
        + ", status='"
        + status
        + "', error='"
        + error
        + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SapsImage imageTask = (SapsImage) o;

    if (priority != imageTask.priority) return false;
    if (taskId != null ? !taskId.equals(imageTask.taskId) : imageTask.taskId != null) return false;
    if (dataset != null ? !dataset.equals(imageTask.dataset) : imageTask.dataset != null)
      return false;
    if (region != null ? !region.equals(imageTask.region) : imageTask.region != null) return false;
    if (user != null ? !user.equals(imageTask.user) : imageTask.user != null) return false;
    if (imageDate != null) {
      if (imageTask.imageDate == null) return false;
      Calendar it = Calendar.getInstance();
      it.setTime(imageDate);
      Calendar oit = Calendar.getInstance();
      oit.setTime(imageTask.imageDate);
      if (it.get(Calendar.DAY_OF_YEAR) != oit.get(Calendar.DAY_OF_YEAR)) return false;
      if (it.get(Calendar.YEAR) != oit.get(Calendar.YEAR)) return false;
    } else {
      if (imageTask.imageDate != null) return false;
    }
    if (state != imageTask.state) return false;
    if (federationMember != null
        ? !federationMember.equals(imageTask.federationMember)
        : imageTask.federationMember != null) return false;
    if (inputdownloadingTag != null
        ? !inputdownloadingTag.equals(imageTask.inputdownloadingTag)
        : imageTask.inputdownloadingTag != null) return false;
    if (preprocessingTag != null
        ? !preprocessingTag.equals(imageTask.preprocessingTag)
        : imageTask.preprocessingTag != null) return false;
    if (processingTag != null
        ? !processingTag.equals(imageTask.processingTag)
        : imageTask.processingTag != null) return false;
    if (creationTime != null
        ? !creationTime.equals(imageTask.creationTime)
        : imageTask.creationTime != null) return false;
    if (updateTime != null
        ? !updateTime.equals(imageTask.updateTime)
        : imageTask.updateTime != null) return false;
    if (status != null ? !status.equals(imageTask.status) : imageTask.status != null) return false;
    return error != null ? error.equals(imageTask.error) : imageTask.error == null;
  }

  @Override
  public int hashCode() {
    int result = taskId != null ? taskId.hashCode() : 0;
    result = 31 * result + (dataset != null ? dataset.hashCode() : 0);
    result = 31 * result + (region != null ? region.hashCode() : 0);
    result = 31 * result + (imageDate != null ? imageDate.hashCode() : 0);
    result = 31 * result + (state != null ? state.hashCode() : 0);
    result = 31 * result + (federationMember != null ? federationMember.hashCode() : 0);
    result = 31 * result + priority;
    result = 31 * result + (inputdownloadingTag != null ? inputdownloadingTag.hashCode() : 0);
    result = 31 * result + (preprocessingTag != null ? preprocessingTag.hashCode() : 0);
    result = 31 * result + (processingTag != null ? processingTag.hashCode() : 0);
    result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
    result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (error != null ? error.hashCode() : 0);
    return result;
  }
}
