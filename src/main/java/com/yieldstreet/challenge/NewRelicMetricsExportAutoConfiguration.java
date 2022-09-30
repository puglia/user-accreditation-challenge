package com.yieldstreet.challenge;

import com.newrelic.telemetry.Attributes;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.util.NamedThreadFactory;
import com.newrelic.telemetry.micrometer.NewRelicRegistry;
import com.newrelic.telemetry.micrometer.NewRelicRegistryConfig;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@AutoConfigureBefore({ CompositeMeterRegistryAutoConfiguration.class, SimpleMetricsExportAutoConfiguration.class })
@AutoConfigureAfter(MetricsAutoConfiguration.class)
@ConditionalOnClass(NewRelicRegistry.class)
public class NewRelicMetricsExportAutoConfiguration {
	
	public static final String API_KEY_PROPERTY = "application.new-relic.api-key";
	public static final String SERVICE_NAME_PROPERTY = "application.new-relic.service-name";
	public static final String STEP_DURATION_PROPERTY = "application.new-relic.step-duration";
	
	@Autowired
	private Environment env;

	@Bean
	public NewRelicRegistryConfig newRelicConfig() {
		return new NewRelicRegistryConfig() {
			@Override
			public String get(String key) {
				return null;
			}

			@Override
			public String apiKey() {
				return env.getProperty(API_KEY_PROPERTY);
			}

			@Override
			public Duration step() {
				int duration = Integer.parseInt(env.getProperty(STEP_DURATION_PROPERTY));
				return Duration.ofSeconds(duration);
			}

			@Override
			public String serviceName() {
				return env.getProperty(SERVICE_NAME_PROPERTY);
			}

		};
	}

	@Bean
	public NewRelicRegistry newRelicMeterRegistry(NewRelicRegistryConfig config) throws UnknownHostException {
		NewRelicRegistry newRelicRegistry = NewRelicRegistry.builder(config)
				.commonAttributes(new Attributes().put("host", InetAddress.getLocalHost().getHostName())).build();
		newRelicRegistry.config().meterFilter(MeterFilter.denyNameStartsWith("jvm.threads"));
		newRelicRegistry.start(new NamedThreadFactory("newrelic.micrometer.registry"));
		return newRelicRegistry;
	}
}