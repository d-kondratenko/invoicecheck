package com.epic.invoicecheck.services;

import com.epic.invoicecheck.dto.Differents;
import com.epic.invoicecheck.dto.InvoiceData;
import com.epic.invoicecheck.entity.DeliveryInfo;
import com.epic.invoicecheck.entity.OrderInfo;
import com.epic.invoicecheck.models.UploadForm;
import com.epic.invoicecheck.repository.DeliveryInfoRepository;
import com.epic.invoicecheck.repository.DifferentsRepository;
import com.epic.invoicecheck.repository.OrderInfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class CheckService {

    private final OrderInfoRepository orderInfoRepository;
    private final DifferentsRepository differentsRepository;

    private final DeliveryInfoRepository deliveryInfoRepository;



    public List<Differents> startChecking(MultipartFile file, UploadForm uploadForm) throws IOException {
        ArrayList<InvoiceData> invoiceDataList = xlsxToArray(file);
        log.info(uploadForm.toString());
        List<OrderInfo> orderInfoList = orderInfoRepository.findByCOrderNrAndFirmNr(uploadForm.getOrderNr(), uploadForm.getSupplireNr());
        DeliveryInfo deliveryInfo = deliveryInfoRepository.findByOrderNrAndSupplireNr(uploadForm.getOrderNr(), uploadForm.getSupplireNr());
        differentsRepository.deleteByDeliveryId(deliveryInfo.getDeliveryId());
        log.info(deliveryInfo.toString());
        List<Differents> differentsList = getDiff(invoiceDataList, orderInfoList, deliveryInfo, uploadForm);
        return differentsList;
    }

    public ArrayList<InvoiceData> xlsxToArray(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        ArrayList<InvoiceData> invoiceDataList = new ArrayList<>();
        for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++){
            Row row = sheet.getRow(i);
            InvoiceData invoiceData = new InvoiceData();
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++){
                DataFormatter formatter = new DataFormatter();
                if(j == 0){
                    invoiceData.setProductNr(formatter.formatCellValue(row.getCell(j)));
                }
                else if (j == 1) {
                    invoiceData.setQuantity(Double.parseDouble(formatter.formatCellValue(row.getCell(j))));
                } else {
                    if(formatter.formatCellValue(row.getCell(j)).isEmpty()){
                        invoiceData.setBrack(0.0);
                    } else {
                        invoiceData.setBrack(Double.parseDouble(formatter.formatCellValue(row.getCell(j))));
                    }
                }
            }

            invoiceDataList.add(invoiceData);
        }
        return invoiceDataList;
    }

    public ArrayList<Differents> getDiff(ArrayList<InvoiceData> dataList, List<OrderInfo> infoList, DeliveryInfo deliveryInfo, UploadForm uploadForm) {
        ArrayList<Differents> differentsList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            InvoiceData dat = dataList.get(i);
            for (int j = 0; j < infoList.size(); j++) {
                OrderInfo inf = infoList.get(j);
                if (dat.getProductNr().equals(inf.getProductNr())) {
                    if (dat.getQuantity() != inf.getQuantity()) {
                        Differents differents = Differents.builder().productNr(dat.getProductNr())
                                        .quantityInvoice(dat.getQuantity())
                                                .quantityOrder(inf.getQuantity())
                                .deliveryId(deliveryInfo.getDeliveryId())
                                .invoiceNr(uploadForm.getInvoiceNr())
                                .invoiceDate(uploadForm.getInvoiceDate())
                                .brack(dat.getBrack())
                                .build();
                        log.info(differents.toString());
                        differentsRepository.save(differents);
                        differentsList.add(differents);
                    }
                }
            }
        }
        return differentsList;
    }
}
