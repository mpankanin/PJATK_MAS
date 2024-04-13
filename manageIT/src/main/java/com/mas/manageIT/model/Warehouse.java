package com.mas.manageIT.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Size(max = 200)
    private String address;

    @NonNull
    private List<Resource> storedResources;

    @NonNull
    private Employer warehouseManager;

}
