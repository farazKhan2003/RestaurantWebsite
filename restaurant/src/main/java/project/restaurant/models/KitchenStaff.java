package project.restaurant.models;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="KitchenStaff")
public class KitchenStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kitchenstaffid;

    @Column(name = "permissions", nullable = false)
    private Integer permissions;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private Users userid;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Orders> orders;
    
    public KitchenStaff() {}

    public KitchenStaff(Integer permissions, Users userid) {
        this.userid = userid;
        this.permissions = permissions;
    }

    public Integer getKitchenStaffId() {
        return kitchenstaffid;
    }

    public void setKitchenStaffId(Integer kitchenstaffid) {
        this.kitchenstaffid = kitchenstaffid;
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
