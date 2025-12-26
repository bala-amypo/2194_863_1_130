@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    @Id @GeneratedValue
    private Long id;

    private String serialNumber;
    private String claimReason;

    private String status = "PENDING";

    @PrePersist
    void onCreate() {
        if (status == null) status = "PENDING";
    }
}
