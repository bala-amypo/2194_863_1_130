@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(409).build();
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(request.getRoles() == null ? Set.of("USER") : request.getRoles())
                .build();

        user = userRepository.save(user);

        String token = jwtTokenProvider.createToken(
                user.getId(), user.getEmail(), user.getRoles());

        return ResponseEntity.ok(
                new AuthResponse(token, user.getId(), user.getEmail(), user.getRoles()));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        Optional<User> opt = userRepository.findByEmail(request.getEmail());
        if (opt.isEmpty()) {
            return ResponseEntity.status(401).build();
        }

        User user = opt.get();
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).build();
        }

        String token = jwtTokenProvider.createToken(
                user.getId(), user.getEmail(), user.getRoles());

        return ResponseEntity.ok(
                new AuthResponse(token, user.getId(), user.getEmail(), user.getRoles()));
    }
}
