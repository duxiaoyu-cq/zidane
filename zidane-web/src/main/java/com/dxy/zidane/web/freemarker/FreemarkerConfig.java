package com.dxy.zidane.web.freemarker;

import com.dxy.zidane.common.utils.DateUtil;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Configuration
public class FreemarkerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(FreemarkerConfig.class);

    @Autowired
    protected FreeMarkerViewResolver freeMarkerViewResolver;

    @PostConstruct
    public void setStaticModels() {
        FreemarkerStaticModels staticModels = FreemarkerConfig.FreemarkerStaticModels.getInstance();
        staticModels.setStaticModels("DateUtil", DateUtil.class.getName());
        freeMarkerViewResolver.setAttributesMap(staticModels);
    }

    static class FreemarkerStaticModels extends HashMap<String, Object> {
        private static FreemarkerStaticModels FREEMARKER_STATIC_MODELS;

        private FreemarkerStaticModels() {

        }

        public static FreemarkerStaticModels getInstance() {
            if (FREEMARKER_STATIC_MODELS == null) {
                FREEMARKER_STATIC_MODELS = new FreemarkerStaticModels();
            }
            return FREEMARKER_STATIC_MODELS;
        }

        void setStaticModels(String key, String value) {
            FREEMARKER_STATIC_MODELS.put(key, useStaticPackage(value));
        }

        static TemplateHashModel useStaticPackage(String packageName) {
            try {
                BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
                TemplateHashModel staticModels = wrapper.getStaticModels();
                return (TemplateHashModel) staticModels.get(packageName);
            } catch (Exception e) {
                LOGGER.error("", e);
            }
            return null;
        }
    }

}
