package net.openfrp.tencentcdn;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: 🥕 zhou
 * @Date: 2022/5/16 8:43
 */
@Data
@Component
public class ConfigEntity {
    @Value("${config.domain}")
    private String domain;
    @Value("${config.signKey}")
    private String signKey;
    @Value("${config.signName}")
    private String signName;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSignKey() {
        return signKey;
    }

    public void setSignKey(String signKey) {
        this.signKey = signKey;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }
}
