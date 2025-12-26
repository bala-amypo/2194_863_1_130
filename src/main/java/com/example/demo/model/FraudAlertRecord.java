@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "fraud_alert_records")
public class FraudAlertRecord {

    @Id @GeneratedValue
    private Long id;

    private Long claimId;
    private String serialNumber;

    private Boolean resolved = false;

    @PrePersist
    void onCreate() {
        if (resolved == null) resolved = false;
    }
}
