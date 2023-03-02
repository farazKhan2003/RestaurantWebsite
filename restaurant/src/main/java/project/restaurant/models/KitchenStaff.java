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
}
