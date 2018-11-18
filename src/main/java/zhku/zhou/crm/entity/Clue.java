package zhku.zhou.crm.entity;

import java.util.Date;

public class Clue {
    private Integer id;

    private Integer userId;

    private Integer ownerId;

    private Integer source;

    private String contactName;

    private String companyName;

    private String position;

    private Integer sex;

    private String phone;

    private String email;

    private String address;

    private Integer status;

    private Integer isDeleted;

    private Integer deleteUserId;

    private Date deleteTime;

    private Integer isTransformed;

    private Integer transformUserId;

    private Integer contactId;

    private Integer customerId;

    private Date crtm;

    private Date mdtm;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getDeleteUserId() {
        return deleteUserId;
    }

    public void setDeleteUserId(Integer deleteUserId) {
        this.deleteUserId = deleteUserId;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getIsTransformed() {
        return isTransformed;
    }

    public void setIsTransformed(Integer isTransformed) {
        this.isTransformed = isTransformed;
    }

    public Integer getTransformUserId() {
        return transformUserId;
    }

    public void setTransformUserId(Integer transformUserId) {
        this.transformUserId = transformUserId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getCrtm() {
        return crtm;
    }

    public void setCrtm(Date crtm) {
        this.crtm = crtm;
    }

    public Date getMdtm() {
        return mdtm;
    }

    public void setMdtm(Date mdtm) {
        this.mdtm = mdtm;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", ownerId=").append(ownerId);
        sb.append(", source=").append(source);
        sb.append(", contactName=").append(contactName);
        sb.append(", companyName=").append(companyName);
        sb.append(", position=").append(position);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", deleteUserId=").append(deleteUserId);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", isTransformed=").append(isTransformed);
        sb.append(", transformUserId=").append(transformUserId);
        sb.append(", contactId=").append(contactId);
        sb.append(", customerId=").append(customerId);
        sb.append(", crtm=").append(crtm);
        sb.append(", mdtm=").append(mdtm);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}