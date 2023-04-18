package com.epic.invoicecheck.models;

import com.epic.invoicecheck.entity.DiffReport;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
public class PdfModel extends AbstractPdfModel {
    public static final String FONT = "fonts/FreeSans.ttf";

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

            List<DiffReport> cars = (List<DiffReport>) model.get("cars");

            DiffReport diffReport = null;
            for (int i = 0; i < 1; i++) {
                diffReport = cars.get(i);
            }

            Paragraph paragraph1 = new Paragraph("    ");


            BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 7, Font.NORMAL);
            Font boldFont = new Font(bf, 12, Font.BOLD);

            Paragraph paragraph = new Paragraph("Акт про нестачу (надлишки) поставки товару №_____", boldFont);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            Paragraph paragraph2 = new Paragraph("від \"___\" __________ 20___ року", font);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph2);


            Paragraph paragraph3 = new Paragraph("Місце складання акту:Логістичний центр \"Калинівка\" ТОВ \"Епіцентр К\" (смт.Калинівка Київська обл.)", font);
            paragraph2.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph3);

            Paragraph paragraph4 = new Paragraph("Комісія у складі:1)______________________________ 2)__________________________ 3)__________________________", font);
            paragraph4.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph4);


            Paragraph paragraph5 = new Paragraph("(П.І.Б, посада)", font);
            paragraph5.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph5);


            Paragraph paragraph6 = new Paragraph("Одержувач вантажу: Логістичний центр \"Калинівка\" ТОВ \"Епіцентр К\" (смт.Калинівка)", font);
            paragraph6.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph6);


            Paragraph paragraph7 = new Paragraph("Відправник вантажу: " + diffReport.getFName() + ", Видаткова накл.№" + diffReport.getInvoiceNr() + " від " + diffReport.getInvoiceDate() + " " +
                    diffReport.getTtn() + " від " + diffReport.getOrderDate() + " р.", font);
            paragraph7.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph7);


            Paragraph paragraph8 = new Paragraph("Спосіб визначення кількості ТМЦ : Підрахунок", font);
            paragraph8.setPaddingTop(1);
            paragraph8.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph8);


            Paragraph paragraph9 = new Paragraph("Прийом товару розпочато:________________________20___року. Виявлені наступні розходження при прийомі товару:", font);
            paragraph9.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph9);

            document.add(paragraph1);


            PdfPTable table = new PdfPTable(14);
            table.setWidthPercentage(100);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("№ п/п", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setRowspan(2);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Артикул", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setRowspan(2);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Найменування", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setColspan(2);
            hcell.setRowspan(2);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Од. виміру", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setRowspan(2);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Кількість", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setColspan(4);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Нестача", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Лишки", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Товар не в замовленні", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Брак", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Примітки", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setRowspan(2);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("По Зкз/Кзз", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("За накладною", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Привезено (по підрахунку комірника прийому товару)", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Прийнято", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Кількість (мінусовий результат колонок 7 - 5)", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Кількість (плюсовий результат колонок 6 - 5)", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Кількість (плюсовий результат колонок 5 - 4)", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Кількість", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("1", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("2", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setColspan(2);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("3", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("4", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("5", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("6", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("7", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("8", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("9", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("10", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("11", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("12", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(hcell);
            int i = 0;
            for (DiffReport car : cars) {
                i++;
                PdfPCell cell;


                cell = new PdfPCell(new Phrase(String.valueOf(i), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getProductNr().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getName().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setColspan(2);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getAbbrev().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getZakaz().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getInvoiceqty().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getFakt().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getPrin().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getNedost().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getIzlish().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getNotinorder().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getBrak().toString(), font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(car.getPosComment(),font));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);


            }
            document.add(table);

            document.add(paragraph1);

            Paragraph paragraph10 = new Paragraph("Прийом товару закінчено: _____________20___ року", font);
            document.add(paragraph10);

            document.add(paragraph1);

            Paragraph paragraph11 = new Paragraph("Підпис членів комісії: \t\t1.__________________/_____________________ \t\t2.__________________/_____________________ \t\t3.__________________/_____________________ \n" +
                    "                                        (Підпис)                     (Прізвище)                                    (Підпис)                     (Прізвище)                            (Підпис)                     (Прізвище)" + "\n" +
                    "Особи які підписали даний акт несуть відповідальність за достовірність фактів наведених у акті",font);

            /*Paragraph paragraph11 = new Paragraph("Підпис членів комісії: \t\t1.__________________/_____________________\n" + "\n" +
                    "                                   \t\t 2.__________________/_____________________\n" + "\n" +
                    "                                   \t\t 3.__________________/_____________________\n" +
                    "                                        \t\t (Підпис)                      (Прізвище)\n", font);*/
            document.add(paragraph11);

//            document.add(paragraph1);

//            document.add(new Paragraph("Особи які підписали даний акт несуть відповідальність за достовірність фактів наведених у акті", font));

    }
}