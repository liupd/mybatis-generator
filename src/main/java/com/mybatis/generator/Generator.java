package com.mybatis.generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 
 * @author Vincent
 *
 */
public class Generator {

    @Test
    public void generator() throws Exception {
        try {

            boolean overwrite = true;

            // InputStream stream = this.getClass().getResource("/generatorConfig-base.xml").openStream();
            InputStream stream = this.getClass().getResource("/generatorConfig-business.xml").openStream();

            List<String> warnings = new ArrayList<String>();
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(stream);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
            System.out.println("Generate success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
