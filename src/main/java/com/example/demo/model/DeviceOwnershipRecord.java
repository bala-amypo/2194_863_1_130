@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "device_ownership_records")
public class DeviceOwnershipRecord {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    private String ownerName;
    private String ownerEmail;

    private LocalDate warrantyExpiration;

    private Boolean active = true;

    @PrePersist
    void onCreate() {
        if (active == null) active = true;
    }
}
