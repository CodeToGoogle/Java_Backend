package com.Teams.TeamsApiDemo.Model;



import lombok.*;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Employee {

    private int id;
    private String name;


}
