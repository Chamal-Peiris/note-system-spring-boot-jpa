package lk.ijse.dep.note.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

@Configuration
@Import(JpaConfig.class)
public class WebRootConfig {

    public ModelMapper
    @Bean
    public static YamlPropertiesFactoryBean yamlPropertiesFactoryBean(ConfigurableEnvironment env ){
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources( new ClassPathResource("application.yml"));
        Properties yamlProps = yamlPropertiesFactoryBean.getObject();
        env.getPropertySources().addLast(new PropertiesPropertySource("yaml",yamlProps));
        return yamlPropertiesFactoryBean;


    }
}
