package Model;

import View.Screen_GUI;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
public class Functions_DAO {
    
    public static final Font texto =
    new Font(FontFamily.HELVETICA, 15);
    
    public static final Font titulo =
    new Font(FontFamily.HELVETICA, 24, Font.BOLD);
    
    public static void meia(String seletor){
     if(seletor.equals("Meia-Meia")){
         View.Screen_GUI.Meia1_cb.setVisible(true);
         View.Screen_GUI.Meia2_cb.setVisible(true);
     }else{
         View.Screen_GUI.Meia1_cb.setVisible(false);
         View.Screen_GUI.Meia2_cb.setVisible(false);
     }
    }
    
    public static void pdf(){
        Document documentopdf = new Document();
        
        
        try{
            PdfWriter.getInstance(documentopdf, new FileOutputStream("C:\\Users\\edu\\Desktop\\trabalho.pdf"));
            
            documentopdf.open();
            Paragraph preface = new Paragraph("Titulo",titulo); 
            preface.setAlignment(Element.ALIGN_CENTER);
            documentopdf.add(preface);
            documentopdf.setPageSize(PageSize.A4);
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Está entrega foi feitas às "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Nome do cliente: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Número do cliente: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Local de entrega: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Observação: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Pedido: Pizza "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Observação: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Acompanhamento: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Valor pago: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Entregue por: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Estabelecimento: "));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Operador: "));
            documentopdf.add(new Paragraph(" "));
            
        }catch(DocumentException de){
            de.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            documentopdf.close();
        }    
    }
}

