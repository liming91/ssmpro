package com.annotations;
/**
 * 注解类
 */
@Table("job")
public class Filter {
    @Column("id")
    private String id;

    @Column("phone")
    private String phone;

    @Column("email")
    private String email;

    @Column("address")
    private String address;

    @Column("job_name")
    private String jobName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
