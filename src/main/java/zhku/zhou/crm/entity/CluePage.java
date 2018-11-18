package zhku.zhou.crm.entity;

import java.util.Date;

public class CluePage {
    private Integer id;

    private String companyName;

    private String contactName;

    private String phone;

    private Integer sex;

    private Date nxtm;

    private String content;

    private Date crtm;

    private String userName;

    private String ownerName;

    private Integer status;

    private Integer ownerId;

    private Integer isDeleted;

    private Integer isTransformed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getNxtm() {
        return nxtm;
    }

    public void setNxtm(Date nxtm) {
        this.nxtm = nxtm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCrtm() {
        return crtm;
    }

    public void setCrtm(Date crtm) {
        this.crtm = crtm;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsTransformed() {
        return isTransformed;
    }

    public void setIsTransformed(Integer isTransformed) {
        this.isTransformed = isTransformed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyName=").append(companyName);
        sb.append(", contactName=").append(contactName);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", nxtm=").append(nxtm);
        sb.append(", content=").append(content);
        sb.append(", crtm=").append(crtm);
        sb.append(", userName=").append(userName);
        sb.append(", ownerName=").append(ownerName);
        sb.append(", status=").append(status);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", isTransformed=").append(isTransformed);
        sb.append("]");
        return sb.toString();
    }
}