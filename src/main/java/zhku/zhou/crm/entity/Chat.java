package zhku.zhou.crm.entity;

import java.util.Date;

public class Chat {
    private Integer id;

    private Integer type;

    private Date nxtm;

    private Date crtm;

    private String content;

    private Integer clueId;

    private Integer contactId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getNxtm() {
        return nxtm;
    }

    public void setNxtm(Date nxtm) {
        this.nxtm = nxtm;
    }

    public Date getCrtm() {
        return crtm;
    }

    public void setCrtm(Date crtm) {
        this.crtm = crtm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", nxtm=").append(nxtm);
        sb.append(", crtm=").append(crtm);
        sb.append(", content=").append(content);
        sb.append(", clueId=").append(clueId);
        sb.append(", contactId=").append(contactId);
        sb.append("]");
        return sb.toString();
    }
}