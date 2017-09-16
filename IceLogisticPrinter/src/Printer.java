import java.awt.*;
import java.awt.print.*;

public class Printer implements Printable{
	private float xShift;
        private float yShift;
        Info info;
        
        public Printer() {
            
        }
        public Printer(float xShift,float yShift, Info info) {
            this.xShift = xShift;
            this.yShift = yShift;
            this.info = info;
        }
        
	public void printAll(){
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
                Graphics2D g2=(Graphics2D)g;
                //Печать
                g2.setFont(new Font("Cambria",Font.BOLD,14));
                g2.drawString("OOO \"АйсЛогистик\"", 20f+xShift, 30f+yShift);
                g2.setFont(new Font("Cambria",Font.PLAIN,10));
                g2.drawString("РБ, 212030, г. Могилёв,", 55f+xShift, 20f+yShift);
                g2.drawString("ул. Дзержинского, д.19, п.74", 45f+xShift, 35f+yShift);
                g2.drawString("р/с BY82PJCB30123026311000000933", 20f+xShift, 50f+yShift);
                g2.drawString("в \"Приорбанк\" ОАО ЦБУ 300 г.Могилёв", 15f+xShift, 65f+yShift);
                g2.drawString("код PJCBBY2X", 70f+xShift, 80f+yShift);
                g2.drawString("УНП 790820636 ОКПО 300642047000", 20f+xShift, 95f+yShift);
                g2.drawLine(10+(int)xShift,15+(int)yShift,10+(int)xShift,100+(int)yShift);
                g2.drawLine(10+(int)xShift, 100+(int)yShift, 300+(int)xShift, 100+(int)yShift);
                g2.drawLine(300+(int)xShift, 100+(int)yShift, 300+(int)xShift, 15+(int)yShift);
                g2.drawLine(300+(int)xShift, 15+(int)yShift, 10+(int)xShift, 15+(int)yShift);
                //Печать (конец)
                g2.setFont(new Font("Cambria",Font.BOLD,14));
                if(info!=null) {
                    g2.drawString(""+info.getNumber(), 320f+xShift, 55f+yShift);
                    g2.drawString("Марка машины", 60f+xShift, 170f+yShift);
                    g2.drawString(info.getCarNumber(), 180f+xShift, 170f+yShift);
                    g2.drawString(info.getName(), 60f+xShift, 285f+yShift);
                } else {
                    g2.drawString("Номер", 320f+xShift, 55f+yShift);
                    g2.drawString("Марка машины", 60f+xShift, 170f+yShift);
                    g2.drawString("Номер машины", 180f+xShift, 170f+yShift);
                    g2.drawString("Фамилия И. О.", 60f+xShift, 285f+yShift);
                }
                return(Printable.PAGE_EXISTS);   
            }
	} 
        
}