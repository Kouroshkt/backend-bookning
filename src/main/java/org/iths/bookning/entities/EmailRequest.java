package org.iths.bookning.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailRequest {
    private String name;
    private String email;
    private String message;
}
