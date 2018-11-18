package zhku.zhou.crm.entity;

import java.util.Date;

public class Role {
    private Integer id;

    private String name;

    private String remark;

    private Date crtm;

    private Date mdtm;

    private Integer sysPower;

    private Integer cusPower;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Integer getSysPower() {
        return sysPower;
    }

    public void setSysPower(Integer sysPower) {
        this.sysPower = sysPower;
    }

    public Integer getCusPower() {
        return cusPower;
    }

    public void setCusPower(Integer cusPower) {
        this.cusPower = cusPower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", remark=").append(remark);
        sb.append(", crtm=").append(crtm);
        sb.append(", mdtm=").append(mdtm);
        sb.append(", sysPower=").append(sysPower);
        sb.append(", cusPower=").append(cusPower);
        sb.append("]");
        return sb.toString();
    }
}