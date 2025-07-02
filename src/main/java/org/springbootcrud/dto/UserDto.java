package org.springbootcrud.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private long id;
    private String name;
    private String email;

}
