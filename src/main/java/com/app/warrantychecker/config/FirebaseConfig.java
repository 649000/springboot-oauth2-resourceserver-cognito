
@Configuration
public class FirebaseConfig {

	@Primary
	@Bean
	public FirebaseApp getfirebaseApp() throws IOException {
		FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.getApplicationDefault())
				.setDatabaseUrl(secProps.getFirebaseProps().getDatabaseUrl()).build();
		if (FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
		}
		return FirebaseApp.getInstance();
	}
    
}