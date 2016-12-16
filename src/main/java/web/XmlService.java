package web;

import entity.Book;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import service.BookManagerBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class XmlService extends HttpServlet {
    @EJB
    BookManagerBean bookManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        List<Book> books = Main.queryBooks(req, bookManagerBean);
        try {
            Element booksElement = new Element("books");
            Document document = new Document(booksElement);

            for (Book book : books) {
                Element bookElement = new Element("book");
                bookElement.setAttribute(new Attribute("title", book.getTitle()));
                bookElement.setAttribute(new Attribute("author", book.getAuthor()));
                bookElement.setAttribute(new Attribute("genre", book.getGenre()));
                document.getRootElement().addContent(bookElement);
            }

            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.setFormat(Format.getPrettyFormat());
            xmlOutputter.output(document, resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
