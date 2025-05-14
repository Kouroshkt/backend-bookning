package org.iths.bookning.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    private String name;
    private String email;
    private String message;
}
