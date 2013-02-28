package nobs.library;

import nobs.book.Book;
import nobs.book.BookID;
import nobs.book.BookRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;

public class LibraryExcelMapper {

    private BookRepository bookRepository;

    public LibraryExcelMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public StreamingOutput toExcel(Library library) {
        final ByteArrayOutputStream fos = new ByteArrayOutputStream();

        try {
            Workbook workbook = new HSSFWorkbook();

            Sheet sheet = workbook.createSheet();

            addHeaders(sheet);

            int rowNumber = 1;
            for (BookID bookID : library.getBooks()) {
                Book book = this.bookRepository.getBook(bookID);

                addBookRows(sheet, rowNumber, book);

                rowNumber++;
            }

            workbook.write(fos);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                output.write(fos.toByteArray());
            }
        };
    }

    private void addBookRows(Sheet sheet, int rowNumber, Book book) {
        Row row = sheet.createRow(rowNumber);

        Cell authorCell = row.createCell(0);
        authorCell.setCellValue(book.getAuthor());

        Cell titleCell = row.createCell(1);
        titleCell.setCellValue(book.getTitle());
    }

    private void addHeaders(Sheet sheet) {
        Row headers = sheet.createRow(0);

        Cell authorHeader = headers.createCell(0);
        authorHeader.setCellValue("Author");

        Cell titleHeader = headers.createCell(1);
        titleHeader.setCellValue("Title");
    }
}
