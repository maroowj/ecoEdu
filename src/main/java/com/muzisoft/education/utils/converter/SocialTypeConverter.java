package com.muzisoft.education.utils.converter;

import com.muzisoft.education.utils.enums.SocialType;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
class SocialTypeConverter implements Converter<String, SocialType> {
    @Override
    public SocialType convert(String s) {
        return SocialType.valueOf(s.toUpperCase());
    }
}