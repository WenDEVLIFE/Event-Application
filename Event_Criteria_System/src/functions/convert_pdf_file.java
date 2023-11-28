/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;


import UI.dashboard;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class convert_pdf_file {
    private final String eventname;

    public convert_pdf_file(String eventname) {
        this.eventname = eventname;
    }

    public void pdf() throws IOException {
        DefaultTableModel model2 = dashboard.model2;

        // Your event name
        String eventName = eventname;

        // Set up PDF document
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                PDType0Font font = PDType0Font.load(document, new File("src/font/arialbd.ttf"));

               
                // Your school name and logo
                String schoolName = "Philippine Women's College of Davao";
                String logoPath = "src/pictures/pwclogo.jpg";

                // Adjust the Y-coordinate for the school name
                float schoolNameY = 700; // Adjust this value based on your desired position
               float schoolNameX = 220; // Adjust this value based on your desired position
                contentStream.beginText();
                contentStream.newLineAtOffset(schoolNameX, schoolNameY);
                contentStream.setFont(font, 14);
                contentStream.showText( schoolName);
                contentStream.endText();

                // Add logo
                PDImageXObject logo = PDImageXObject.createFromFile(logoPath, document);
                contentStream.drawImage(logo, 50, 650, logo.getWidth() / 4, logo.getHeight() / 4);

                // Add event name
                contentStream.beginText();
                contentStream.newLineAtOffset(50, 600);
                contentStream.setFont(font, 12);
                contentStream.showText("Event Name: " + eventName);
                contentStream.endText();
                
                contentStream.beginText();
                contentStream.newLineAtOffset(50, 620);
                contentStream.setFont(font, 12);
                contentStream.showText("Participant Table");
                contentStream.endText();


                // Add table headers
                int xStart = 30;
                int yStart = 500;
                int tableWidth = 640;
                int tableHeight = 30;
                int rowHeight = 30;

                // Dynamically calculate header cell width based on content
                float[] columnWidths = calculateColumnWidths(model2, font);
                int headerCellWidth;
                for (int col = 0; col < model2.getColumnCount(); col++) {
                    // Skip the "Delete" column
                    if (col == 7) {
                        continue;
                    }

                    headerCellWidth = (int) columnWidths[col];

                    // Draw rectangle
                    contentStream.setLineWidth(0.5f);
                    contentStream.addRect(xStart, yStart, headerCellWidth, tableHeight);
                    contentStream.stroke();

                    // Add text
                    contentStream.beginText();
                    contentStream.setFont(font, 12);
                    contentStream.newLineAtOffset(xStart + 5, yStart + 5); // Adjust text position within cell
                    contentStream.showText(model2.getColumnName(col));
                    contentStream.endText();

                    xStart += headerCellWidth;
                }

                // Add table data
                yStart -= rowHeight;
                for (int row = 0; row < model2.getRowCount(); row++) {
                    xStart = 30; // Reset xStart for each row

                    for (int col = 0; col < model2.getColumnCount(); col++) {
                        // Skip the "Delete" column
                        if (col == 7) {
                            continue;
                        }

                        headerCellWidth = (int) columnWidths[col];

                        // Draw rectangle
                        contentStream.setLineWidth(0.5f);
                        contentStream.addRect(xStart, yStart, headerCellWidth, tableHeight);
                        contentStream.stroke();

                        // Add text
                        contentStream.beginText();
                        contentStream.setFont(font, 8);
                        contentStream.newLineAtOffset(xStart + 5, yStart + 5); // Adjust text position within cell
                        contentStream.showText(String.valueOf(model2.getValueAt(row, col)));
                        contentStream.endText();

                        xStart += headerCellWidth;
                    }
                    yStart -= rowHeight;
                }
            }

             JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        // Set file filter to show only PDF files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF files", "pdf");
        fileChooser.setFileFilter(filter);

        // Show the file chooser dialog
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileToSave = fileChooser.getSelectedFile();

            // Save the PDF file to the selected location
            document.save(fileToSave.getAbsolutePath() + ".pdf");
            System.out.println("PDF created successfully at: " + fileToSave.getAbsolutePath() + ".pdf");
        } else {
            System.out.println("PDF creation canceled by the user.");
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private float[] calculateColumnWidths(DefaultTableModel model, PDType0Font font) throws IOException {
        int numColumns = model.getColumnCount();
        float[] columnWidths = new float[numColumns];

        for (int col = 0; col < numColumns; col++) {
            float maxWidth = font.getStringWidth(model.getColumnName(col)) / 1000 * 12; // Adjust font size if needed

            for (int row = 0; row < model.getRowCount(); row++) {
                String value = String.valueOf(model.getValueAt(row, col));
                float width = font.getStringWidth(value) / 1000 * 8; // Adjust font size if needed

                if (width > maxWidth) {
                    maxWidth = width;
                }
            }

            columnWidths[col] = maxWidth + 10; // Add padding
        }

        return columnWidths;
    }


      
    
}