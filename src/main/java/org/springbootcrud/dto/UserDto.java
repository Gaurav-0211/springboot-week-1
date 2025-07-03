package org.springbootcrud.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {

    private long id;
    private String name;
    private String email;

}
