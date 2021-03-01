import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;

public class Parse {
    public static Book parse(String file) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        Book book = null;
        Author author = null;
        try(FileInputStream fis = new FileInputStream(file)) {

            XMLEventReader reader = xmlInputFactory.createXMLEventReader(fis);

            while (reader.hasNext()) {
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "title-info":
                            book = new Book();
                            break;
                        case "first-name":
                            author = new Author();
                            nextEvent = reader.nextEvent();
                            author.setFirstName(nextEvent.asCharacters().getData());
                            break;
                        case "last-name":
                            nextEvent = reader.nextEvent();
                            author.setLastName(nextEvent.asCharacters().getData());
                            break;
                        case "middle-name":
                            nextEvent = reader.nextEvent();
                            author.setMiddleName(nextEvent.asCharacters().getData());
                            break;
                        case "book-title":
                            nextEvent = reader.nextEvent();
                            book.setName(nextEvent.asCharacters().getData());
                            break;
                    }
                }
                if (nextEvent.isEndElement()) {
                    EndElement endElement = nextEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("title-info")) {
                        book.setAuthor(author);
                        break;
                    }
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
        return book;
    }
}
