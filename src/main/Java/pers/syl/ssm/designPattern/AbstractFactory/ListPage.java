package pers.syl.ssm.designPattern.AbstractFactory;

public class ListPage extends Page {
    public ListPage(String title, String author){
        super(title, author);
    }
    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>"+title+"</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("")
        return null;
    }
}
