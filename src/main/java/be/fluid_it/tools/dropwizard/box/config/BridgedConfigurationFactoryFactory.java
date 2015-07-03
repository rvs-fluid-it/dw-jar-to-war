package be.fluid_it.tools.dropwizard.box.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.Configuration;
import io.dropwizard.configuration.ConfigurationFactory;
import io.dropwizard.configuration.ConfigurationFactoryFactory;

import javax.validation.Validator;

public class BridgedConfigurationFactoryFactory<T extends Configuration> implements ConfigurationFactoryFactory<T> {
    private final ConfigurationBridge configurationBridge;

    public BridgedConfigurationFactoryFactory(ConfigurationBridge configurationBridge) {
        this.configurationBridge = configurationBridge;
    }

    @Override
    public ConfigurationFactory<T> create(Class<T> klass, Validator validator, ObjectMapper objectMapper, String propertyPrefix) {
        return new BridgedConfigurationFactory<T>(configurationBridge, klass, validator, objectMapper, propertyPrefix);
    }
}
