package nobs.library;

import nobs.book.Book;
import nobs.book.BookID;
import nobs.book.BookRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LibraryExcelMapper {

    private BookRepository bookRepository;

    public LibraryExcelMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public File toExcel(Library library) {
        File excelFile = null;

        try {
            excelFile = new File("file.xls");

            FileOutputStream fos = new FileOutputStream(excelFile);

            Workbook workbook = new HSSFWorkbook();

            Sheet sheet = workbook.createSheet();

            int rowNumber = 0;
            for (BookID bookID : library.getBooks()) {
                Book book = this.bookRepository.getBook(bookID);

                Row row = sheet.createRow(rowNumber);

                Cell authorCell = row.createCell(0);
                authorCell.setCellValue(book.getAuthor());

                Cell titleCell = row.createCell(1);
                titleCell.setCellValue(book.getTitle());

                rowNumber++;
            }

            workbook.write(fos);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return excelFile;
    }
}
