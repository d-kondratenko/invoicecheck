package com.epic.invoicecheck.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadForm {

    private String orderNr;
    private String supplireNr;
    private String invoiceNr;
    private String invoiceDate;
}
