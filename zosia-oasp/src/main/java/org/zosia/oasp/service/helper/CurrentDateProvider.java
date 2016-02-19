package org.zosia.oasp.service.helper;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CurrentDateProvider {

    public Date getCurrentDate() {
        return new Date();
    }
}
