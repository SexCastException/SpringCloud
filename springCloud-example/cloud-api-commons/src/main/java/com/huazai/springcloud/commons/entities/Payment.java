package com.huazai.springcloud.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pyh
 * @date 2020/7/15 20:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
    private String serverPort;

    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }
}
