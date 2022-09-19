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
import java.util.logging.Level;
import java.util.logging.Logger;
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
            PdfWriter.getInstance(documentopdf, new FileOutputStream("C:\\Users\\edu\\Desktop\\"+View.Screen_GUI.nomeArquivo_txt.getText()+".pdf"));
            
            documentopdf.open();
            Paragraph preface = new Paragraph(View.Screen_GUI.nomeArquivo_txt.getText(), titulo); 
            preface.setAlignment(Element.ALIGN_CENTER);
            documentopdf.add(preface);
            documentopdf.setPageSize(PageSize.A4);
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Está entrega foi feitas às "+(View.Screen_GUI.Horario_tx.getText()), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Nome do cliente: "+(View.Screen_GUI.Cliente_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Número do cliente: "+(View.Screen_GUI.numCliente_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Local de entrega: "+(View.Screen_GUI.Local_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Observação: "+(View.Screen_GUI.observacao_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            if(View.Screen_GUI.Princ_options.getSelectedItem().equals("Meia-Meia")){
                 documentopdf.add(new Paragraph("Pedido: Pizza "+(View.Screen_GUI.Princ_options).getSelectedItem()+" de "+(View.Screen_GUI.Meia1_cb).getSelectedItem()+" e "+(View.Screen_GUI.Meia2_cb).getSelectedItem()+", "+View.Screen_GUI.qtdPizzas_txt.getText()+" Unidade(s)", texto));
                 documentopdf.add(new Paragraph(" "));
            }else{
                documentopdf.add(new Paragraph("Pedido: Pizza de "+(View.Screen_GUI.Princ_options).getSelectedItem()+", "+View.Screen_GUI.qtdPizzas_txt.getText()+" Unidade(s)", texto));
                documentopdf.add(new Paragraph(" "));
            }
            documentopdf.add(new Paragraph("Observação: "+(View.Screen_GUI.observacao_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Acompanhamento: "+(View.Screen_GUI.Acompanhamentos).getSelectedItem()+" de Marca "+(View.Screen_GUI.Marca_txt1).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Valor pago: "+(View.Screen_GUI.Preco_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Entregue por: "+(View.Screen_GUI.Entregador_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Estabelecimento: "+(View.Screen_GUI.Estabelecimento_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            documentopdf.add(new Paragraph("Operador: "+(View.Screen_GUI.Operador_txt).getText(), texto));
            documentopdf.add(new Paragraph(" "));
            
        }catch(DocumentException de){
            de.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            documentopdf.close();
        }    
    }
    public static void acompanhamentos(String acomp){
        if(acomp.equals("Nenhum")){
         View.Screen_GUI.Marca_txt1.setVisible(true);
         View.Screen_GUI.Marca_txt1.setEnabled(false);
         View.Screen_GUI.Marca_txt1.setText("Nenhum");
     }else{
         View.Screen_GUI.Marca_txt1.setVisible(true);
         View.Screen_GUI.Marca_txt1.setEnabled(true);
         View.Screen_GUI.Marca_txt1.setText("");
     }
    }
    public static void pedido(){
        String teste = View.Screen_GUI.nomePedido_txt.getText();
        View.Screen_GUI.Pedidos.addItem(teste);  
    }
    public static void pizza(String pizza){
        View.Screen_GUI.Princ_options.addItem(pizza);
        View.Screen_GUI.Meia1_cb.addItem(pizza);
        View.Screen_GUI.Meia2_cb.addItem(pizza);
    }
    
    public static void calc(){
        try {
            Runtime.getRuntime().exec("calc.exe");
        } catch (IOException ex) {
            Logger.getLogger(Screen_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void notepad(){
        try {
            Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException ex) {
            Logger.getLogger(Screen_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void acompanhamento(String acomp){
        View.Screen_GUI.Acompanhamentos.addItem(acomp);
    }
}

