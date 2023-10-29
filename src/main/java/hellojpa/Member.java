package hellojpa;

import jakarta.persistence.*;

import java.util.Date;


public class Member {
    @Id
    private long id;
    //@Column(unique = true, length = 10) // 컬럼 명, 제약 조건 추가(JPA 실행에는 영향을 주지 않음.)
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) // ORDINAL 사용X 필수로 string으로 사용하자
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) //LocalDate, LocalDateTime을 사용할 때는 생략 가능
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Lob
    private String description;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Member(){}

}
