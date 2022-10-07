package com.epic.invoicecheck.dto;

import com.epic.invoicecheck.entity.Differents;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiffDto {
    List<Differents> diff;
}
