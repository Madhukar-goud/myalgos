package config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by madhukar on 25/05/19.
 */
@Data
@Component
public class AppConfig {

    @Value("${bravo.host.url}")
    private String bravoHostUrl;
    @Value("${bravo.host.port}")
    private String bravoHostPort;
}
