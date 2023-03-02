package project.restaurant.models;

import jakarta.persistence.*;

@Entity
@Table(name="KitchenStaff")
public class KitchenStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kitchenStaffId;

    @Column(name = "permissions", nullable = false)
    private Integer permissions;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "userid")
    private Users userid;

    public KitchenStaff() {}

    public KitchenStaff(Integer permissions, Users userid) {
        this.userid = userid;
        this.permissions = permissions;
    }

    public Integer getKitchenStaffId() {
        return kitchenStaffId;
    }

    public void setKitchenStaffId(Integer kitchenStaffId) {
        this.kitchenStaffId = kitchenStaffId;
    }

    public Integer getPermission() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }
}
