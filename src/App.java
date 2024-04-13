import java.io.FileOutputStream;

import java.io.IOException;

import com.itextpdf.text.Element;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class App {
    public static void main(String[] args) throws DocumentException,IOException {
        Document doc = new Document();
        try{
            String url = "C:\\Users\\W11\\JavaPDF\\src\\docs\\TESTE.pdf";
            PdfWriter.getInstance(doc,new FileOutputStream(url));
            doc.open();
            doc.setPageSize(PageSize.A4);
            //conteudo de texto
            String titulo = "Título estililizado";
            Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD,40F);

            Phrase txtEst = new Phrase(titulo,font1);
            doc.add( new Paragraph(txtEst));
            String lorem = "Lorem ipsum dolor sit amet. Rem minima aliquam vel galisum enim At dolorum vitae cum tempora voluptate? Qui dolorum nihil eos consectetur sunt aut aspernatur nihil id voluptatibus quisquam vel voluptatibus autem eum accusamus sequi. Ea quas nulla sit voluptas veniam aut saepe explicabo et accusantium distinctio vel provident fuga aut velit sequi. Ea iste sequi et internos ducimus ut doloremque quos et perspiciatis fugiat quo exercitationem odit hic Quis omnis aut expedita error.";
            doc.add(new Paragraph("Este texto está alinhado ao centro:"));
            Paragraph p = new Paragraph(lorem);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);

            //meta char também funcionam

            String paragrafo2 = "\nLorem ipsum dolor sit amet. Rem minima aliquam vel galisum enim At dolorum vitae cum tempora voluptate? Qui dolorum nihil eos consectetur sunt aut aspernatur nihil id voluptatibus quisquam vel voluptatibus autem eum accusamus sequi. Ea quas nulla sit voluptas veniam aut saepe explicabo et accusantium distinctio vel provident fuga aut velit sequi. Ea iste sequi et internos ducimus ut doloremque quos et perspiciatis fugiat quo exercitationem odit hic Quis omnis aut expedita error.";
            Paragraph p2 = new Paragraph(paragrafo2);
            doc.add(new Paragraph("\nEste está alinhado a esquerda"));
            p2.setAlignment(Element.ALIGN_LEFT);
            doc.add(p2);

            String paragrafo3 = "\nLorem ipsum dolor sit amet. Rem minima aliquam vel galisum enim At dolorum vitae cum tempora voluptate? Qui dolorum nihil eos consectetur sunt aut aspernatur nihil id voluptatibus quisquam vel voluptatibus autem eum accusamus sequi. Ea quas nulla sit voluptas veniam aut saepe explicabo et accusantium distinctio vel provident fuga aut velit sequi. Ea iste sequi et internos ducimus ut doloremque quos et perspiciatis fugiat quo exercitationem odit hic Quis omnis aut expedita error.";
            Paragraph p3 = new Paragraph(paragrafo3);
            p3.setAlignment(Element.ALIGN_RIGHT);
            doc.add(new Paragraph("\nEste está alinhado a Direita"));
            doc.add(p3);
            

            String paragrafo4 = paragrafo3;
            Paragraph p4 = new Paragraph(paragrafo4);
            p4.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(new Paragraph("\nEste está Justificado"));

            doc.add(p4);

            String paragrafo5= paragrafo2;
            Paragraph p5 = new Paragraph(paragrafo5);
            doc.add(p5);
            doc.add(p5);
            //nova pagina
            //doc.newPage();

            doc.add(new Paragraph("Novo paragrafo"));

            //add imagem
            Image img = Image.getInstance("https://th.bing.com/th/id/R.18d5fc26b91678ce86235cd7dc8c248b?rik=lE1K65Q6L3Qtag&riu=http%3a%2f%2fwww.dicasuteisbrasil.com.br%2fwp-content%2fuploads%2f2017%2f08%2fimagens-em-alta-resolu%c3%a7%c3%a3o.jpg&ehk=%2fMl03ZakAJZ3%2baVs7vvMgoPUClwYhT0Lv2UJtRCjSyk%3d&risl=&pid=ImgRaw&r=0");
            img.scaleToFit(400, 300);
            doc.add(img);
            doc.close();

        }catch(DocumentException e){
            System.out.println("Algum erro com o documento");
        }
        catch(IOException e){
            System.out.println("Algo deu errado");
        }finally{
            System.out.println("compiladio");
        }
    }
}
