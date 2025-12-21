@RestController
@RequestMapping("/api/fraud-alerts")
@Tag(name = "Alert", description = "Fraud alert management")
public class FraudAlertController {

    private final FraudAlertService fraudAlertService;

    public FraudAlertController(FraudAlertService fraudAlertService) {
        this.fraudAlertService = fraudAlertService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FraudAlertRecord> createAlert(@RequestBody FraudAlertRecord alert) {
        FraudAlertRecord savedAlert = fraudAlertService.createAlert(alert);
        return ResponseEntity.ok(savedAlert);
    }

    @GetMapping
    public ResponseEntity<List<FraudAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(fraudAlertService.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudAlertRecord> getAlertById(@PathVariable Long id) {
        return fraudAlertService.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(fraudAlertService.getAlertsBySerial(serialNumber));
    }

    @GetMapping("/claim/{claimId}")
    public ResponseEntity<List<FraudAlertRecord>> getAlertsByClaim(@PathVariable Long claimId) {
        return ResponseEntity.ok(fraudAlertService.getAlertsByClaim(claimId));
    }

    @PutMapping("/{id}/resolve")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FraudAlertRecord> resolveAlert(@PathVariable Long id) {
        return ResponseEntity.ok(fraudAlertService.resolveAlert(id));
    }
}
