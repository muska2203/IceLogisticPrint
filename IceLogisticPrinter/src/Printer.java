import java.awt.*;
import java.awt.print.*;

public class Printer implements Printable{
	private static float xShift;
        private static float yShift;
        private static Info info;
        
        public Printer() {
            
        }
        public Printer(float xShift,float yShift, Info info) {
            Printer.xShift = xShift;
            Printer.yShift = yShift;
            Printer.info = info;
        }
        
	public void printAll(){
            System.out.println(xShift+"||"+yShift);
            Paper paper = new Paper();
            paper.setImageableArea(0, 0, 8.5*72,11*72);
            PageFormat format = new PageFormat();
            format.setOrientation(PageFormat.LANDSCAPE);
            format.setPaper(paper);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            PrinterJob printerJob=PrinterJob.getPrinterJob();
            printerJob.setPrintable(new Printer(), format);
            try{
                printerJob.print();
            }catch(PrinterException e){
                System.err.println(e.getMessage());
            }
	}
        
        @Override
	public int print(Graphics g, PageFormat pf, int pageNumber) throws PrinterException {     
            if(pageNumber>0){
                return(Printable.NO_SUCH_PAGE);
            }else{
                float xShift = Printer.xShift;
                float yShift = Printer.yShift;
                System.out.println(xShift+"||"+yShift);
                Graphics2D g2=(Graphics2D)g;
                //Печать
                g2.setFont(new Font("Cambria",Font.BOLD,14));
                g2.drawString("OOO \"АйсЛогистик\"", 20f, 30f);
                g2.setFont(new Font("Cambria",Font.PLAIN,10));
                g2.drawString("РБ, 212030, г. Могилёв,", 55f, 45f);
                g2.drawString("ул. Дзержинского, д.19, п.74", 45f, 57f);
                g2.drawString("р/с BY82PJCB30123026311000000933", 20f, 69f);
                g2.drawString("в \"Приорбанк\" ОАО ЦБУ 300 г.Могилёв", 15f, 81f);
                g2.drawString("код PJCBBY2X", 70f, 93f);
                g2.drawString("УНП 790820636 ОКПО 300642047000", 20f, 105f);
                g2.drawLine(10,15,10,120);
                g2.drawLine(10, 120, 200, 120);
                g2.drawLine(200, 120, 200, 15);
                g2.drawLine(200, 15, 10, 15);
                //Печать (конец)
                g2.setFont(new Font("Cambria",Font.PLAIN,14));
                if(Printer.info!=null) {
                    g2.drawString(""+Printer.info.getNumber(), (320f+xShift), (55f+yShift));
                    g2.drawString(Printer.info.getCar(), (60f+xShift), (170f+yShift));
                    g2.drawString(Printer.info.getCarNumber(), (180f+xShift), (170f+yShift));
                    g2.drawString(Printer.info.getName(), (60f+xShift), (285f+yShift));
                } else {
                    g2.drawString("Номер", (320f+xShift), (55f+yShift));
                    g2.drawString("Марка машины", (60f+xShift), (170f+yShift));
                    g2.drawString("Номер машины", (180f+xShift), (170f+yShift));
                    g2.drawString("Фамилия И. О.", (60f+xShift), (285f+yShift));
                }
                return(Printable.PAGE_EXISTS);   
            }
	} 
}